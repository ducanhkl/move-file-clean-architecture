package org.ducanh.domain.usecase.checkfileisnotfolder;

import lombok.AllArgsConstructor;
import org.ducanh.domain.port.FilePersistenceOperationOutputPort;

@AllArgsConstructor
public class CheckFileIsNotFolderUseCase implements CheckFileIsNotFolderInputPort{

    private final FilePersistenceOperationOutputPort filePersistenceOperationOutputPort;

    /**
     *
     * @param path Input path
     * @return Return true is path is folder and opposite
     */
    @Override
    public boolean checkFileIsAFolder(String path) {
        return filePersistenceOperationOutputPort.checkFileIsNotAFolder(path);
    }
}
