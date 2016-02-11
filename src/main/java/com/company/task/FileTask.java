package com.company.task;

import java.io.*;

/**
 * Created by Veronica on 2/11/2016.
 */
public class FileTask {
    public void createFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }
    public void writeCommand(String path, String string) throws IOException {
        FileWriter fw = null;
        try {
            File file = new File(path);
            fw = new FileWriter(file);
            fw.write(string);
            fw.flush();
        } finally {
            if(fw != null) {
                fw.close();
            }
        }
    }
}
