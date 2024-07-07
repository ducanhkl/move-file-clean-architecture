package org.ducanh.domain.usecase.checkfileexist;

import org.ducanh.domain.errors.DomainExceptions;
import org.ducanh.domain.errors.Errors;

import java.text.MessageFormat;

public interface CheckFileExistInputPort {
    boolean checkFileExisted(String path);

    default void fileFileIsExistedOrThrowError(String path) {
        if (!checkFileExisted(path)) {
            throw new DomainExceptions(Errors.FILE_IS_NOT_FOUND,
                    MessageFormat.format("File {0} is not existed", path));
        }
    }

    default void checkFileIsNotExistedOrThrowError(String path) {
        if (checkFileExisted(path)) {
            throw new DomainExceptions(Errors.FILE_PATH_IS_ALREADY_EXISTED,
                    MessageFormat.format("File {0} is already existed", path));
        }
    }
}
