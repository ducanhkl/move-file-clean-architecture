package org.ducanh.domain.usecase.copyfile;

import org.ducanh.domain.errors.DomainExceptions;

public interface CopyFilePresenterOutputPort {
    void showError(DomainExceptions domainExceptions);
    void showMessage(String string);
}
