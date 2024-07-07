package org.ducanh.domain.port;

public interface FilePersistenceOperationOutputPort {
    boolean checkFileExisted(String path);
    boolean checkFileIsNotAFolder(String path);
}
