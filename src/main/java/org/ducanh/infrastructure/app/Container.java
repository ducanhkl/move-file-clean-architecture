package org.ducanh.infrastructure.app;

import lombok.Getter;
import org.ducanh.domain.usecase.checkfileexist.CheckFileExistUseCase;
import org.ducanh.domain.usecase.checkfileisnotfolder.CheckFileIsNotFolderUseCase;
import org.ducanh.domain.usecase.copyfile.CopyFilePresenterOutputPort;
import org.ducanh.domain.usecase.copyfile.CopyFileUseCase;
import org.ducanh.infrastructure.adapter.FilePersistenceOperation;
import org.ducanh.infrastructure.app.copyfile.CopyFilePersistence;
import org.ducanh.infrastructure.app.copyfile.CopyFilePresenter;

@Getter
public class Container {

    private final CheckFileExistUseCase checkFileExistUseCase;
    private final CheckFileIsNotFolderUseCase checkFileIsNotFolderUseCase;
    private final CopyFileUseCase copyFileUseCase;

    public Container() {
        FilePersistenceOperation filePersistenceOperation
                = new FilePersistenceOperation();
        CopyFilePersistence copyFilePersistence
                = new CopyFilePersistence();
        checkFileExistUseCase
                = new CheckFileExistUseCase(filePersistenceOperation);
        checkFileIsNotFolderUseCase
                = new CheckFileIsNotFolderUseCase(filePersistenceOperation);
        CopyFilePresenter copyFilePresenter
                = new CopyFilePresenter();
        copyFileUseCase
                = new CopyFileUseCase(copyFilePersistence, copyFilePresenter,
                checkFileExistUseCase, checkFileIsNotFolderUseCase);
    }
}
