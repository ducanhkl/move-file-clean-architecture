package org.ducanh.domain.usecase.copyfile;

import java.util.List;

public interface CopyFileInputPort {
    void copy(String source, String... targetsArr);
}
