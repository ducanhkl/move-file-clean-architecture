package org.ducanh;

import org.ducanh.domain.usecase.copyfile.CopyFileUseCase;
import org.ducanh.infrastructure.app.Container;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        CopyFileUseCase copyFileUseCase = container.getCopyFileUseCase();
        copyFileUseCase.copy("/home/chuducanh/Downloads/test/Resume.pdf",
                "/home/chuducanh/Downloads/test/Resume2.pdf", "/home/chuducanh/Downloads/test/Resume3.pdf");
    }
}