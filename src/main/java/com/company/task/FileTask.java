package com.company.task;

import java.io.File;
import java.io.IOException;

/**
 * Created by Veronica on 2/11/2016.
 */
public class FileTask {
    public void createFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }
    //public void writeCommand(String path, int )
}
