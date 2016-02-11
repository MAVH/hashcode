package com.company.task;

import java.io.*;

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
    public void writeAtBeginning(String path, String number) throws IOException {
        RandomAccessFile f = new RandomAccessFile(new File(path),"rw");
        f.seek(0); // to the beginning
        f.write(number.getBytes());
        f.close();
    }
}
