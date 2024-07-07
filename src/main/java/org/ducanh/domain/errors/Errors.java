package org.ducanh.domain.errors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Errors {

    FILE_IS_NOT_FOUND("FILE", "001", "File is not found"),
    FILE_PATH_IS_ALREADY_EXISTED("FILE", "002", "File is already existed"),
    FILE_IS_A_FOLDER("FILE", "003", "File need to not be a folder");

    public final String errorGroup;
    public final String errorCode;
    public final String errorDesc;
}
