package org.ducanh.infrastructure.adapter;

import org.ducanh.domain.port.FilePersistenceOperationOutputPort;

import java.io.File;

public class FilePersistenceOperation implements FilePersistenceOperationOutputPort {

    @Override
    public boolean checkFileExisted(String path) {
        File f = new File(path);
        return f.exists();
    }

    @Override
    public boolean checkFileIsNotAFolder(String path) {
        File f = new File(path);
        return f.isDirectory();
    }
}
