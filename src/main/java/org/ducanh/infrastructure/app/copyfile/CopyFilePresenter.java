package org.ducanh.infrastructure.app.copyfile;

import org.ducanh.domain.errors.DomainExceptions;
import org.ducanh.domain.usecase.copyfile.CopyFilePresenterOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyFilePresenter implements CopyFilePresenterOutputPort {

    final static Logger logger = LoggerFactory.getLogger(CopyFilePersistence.class);

    @Override
    public void showError(DomainExceptions domainExceptions) {
        logger.error("Got error", domainExceptions);
    }

    @Override
    public void showMessage(String message) {
        logger.info(message);
    }
}
