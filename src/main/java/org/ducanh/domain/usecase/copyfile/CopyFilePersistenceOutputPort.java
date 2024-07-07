package org.ducanh.domain.usecase.copyfile;

import java.util.List;

public interface CopyFilePersistenceOutputPort {
    void copy(String source, List<String> target);
}
