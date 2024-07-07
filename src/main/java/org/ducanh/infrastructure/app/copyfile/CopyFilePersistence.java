package org.ducanh.infrastructure.app.copyfile;

import org.ducanh.domain.usecase.copyfile.CopyFilePersistenceOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyFilePersistence implements CopyFilePersistenceOutputPort {

    public static final Scheduler readfileScheduler = Schedulers.boundedElastic();
    public static final Logger logger = LoggerFactory.getLogger(CopyFilePersistence.class);

    @Override
    public void copy(String source, List<String> targets) {
        List<Closeable> willBeClose = new ArrayList<>();
        try {
            BufferedInputStream sourceStream = new BufferedInputStream(new FileInputStream(source));
            willBeClose.add(sourceStream);
            ConnectableFlux<byte[]> connectableFlux = Flux.<byte[]>generate((sink) -> {
                byte[] bytes = new byte[100];
                try {
                    int length = sourceStream.read(bytes);
                    if (length == -1) {
                        sink.complete();
                        return;
                    }
                    if (length != bytes.length) {
                        sink.next(Arrays.copyOfRange(bytes, 0, length));
                        return ;
                    }
                    sink.next(bytes);
                } catch (IOException e) {
                    sink.error(e);
                }
            }).subscribeOn(readfileScheduler).publish();

            for (String target : targets) {
                BufferedOutputStream bufferedOutputStream =
                        new BufferedOutputStream(new FileOutputStream(target));
                willBeClose.add(bufferedOutputStream);
                connectableFlux.subscribe((data) -> {
                            try {
                                bufferedOutputStream.write(data);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }, (e) -> logger.error(MessageFormat.format("Write file {0} got error", target), e),
                        () -> {});
            }
            connectableFlux.connect();
            connectableFlux.blockLast();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            for (Closeable closeable: willBeClose) {
                close(closeable);
            }
        }
    }

    private void close(Closeable closeable){
        try {
            closeable.close();
            System.out.println("Closed the resource");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
