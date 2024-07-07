package org.ducanh.domain.usecase.copyfile;

import lombok.AllArgsConstructor;
import org.ducanh.domain.errors.DomainExceptions;
import org.ducanh.domain.usecase.checkfileexist.CheckFileExistInputPort;
import org.ducanh.domain.usecase.checkfileisnotfolder.CheckFileIsNotFolderInputPort;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class CopyFileUseCase implements CopyFileInputPort {

    private CopyFilePersistenceOutputPort copyFilePersistenceOutputPort;
    private CopyFilePresenterOutputPort copyFilePresenterOutputPort;
    private CheckFileExistInputPort checkFileExistInputPort;
    private CheckFileIsNotFolderInputPort checkFileIsNotFolderInputPort;

    @Override
    public void copy(String source, String... targetsArr) {
        List<String> targets = Arrays.asList(targetsArr);
        try {
            checkFileExistInputPort.fileFileIsExistedOrThrowError(source);
            targets.forEach((target) ->
                    checkFileExistInputPort.checkFileIsNotExistedOrThrowError(target));
            checkFileIsNotFolderInputPort.checkFileIsAFolderOrThrowError(source);
            copyFilePresenterOutputPort.showMessage(
                    MessageFormat.format("Check done, start copy file from {0} to {1}", source, targets));
            copyFilePersistenceOutputPort.copy(source, targets);
            copyFilePresenterOutputPort.showMessage(
                    MessageFormat.format("Done copy file from {0} to {1}", source, targets));
        } catch (DomainExceptions domainExceptions) {
            copyFilePresenterOutputPort.showError(domainExceptions);
        }
    }
}
