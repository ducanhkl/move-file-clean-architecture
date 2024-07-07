package org.ducanh.domain.usecase.checkfileisnotfolder;

import org.ducanh.domain.errors.DomainExceptions;
import org.ducanh.domain.errors.Errors;

import java.text.MessageFormat;

public interface CheckFileIsNotFolderInputPort {
     boolean checkFileIsAFolder(String source);

     default void checkFileIsAFolderOrThrowError(String path) {
          if (checkFileIsAFolder(path)) {
               throw new DomainExceptions(Errors.FILE_IS_A_FOLDER,
                       MessageFormat.format("File {0} need to not be a folder", path));
          }
     }
}
