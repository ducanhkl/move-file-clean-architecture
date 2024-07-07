package org.ducanh.domain.usecase.checkfileexist;

import lombok.AllArgsConstructor;
import org.ducanh.domain.port.FilePersistenceOperationOutputPort;

@AllArgsConstructor
public class CheckFileExistUseCase implements CheckFileExistInputPort {

    public FilePersistenceOperationOutputPort filePersistenceOperationOutputPort;

    @Override
    public boolean checkFileExisted(String path) {
        return filePersistenceOperationOutputPort.checkFileExisted(path);
    }
}
