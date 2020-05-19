package main.java.core.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 18:44:44
 * @Modified By:
 */
public class FileLock {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream out = new FileOutputStream("file.txt");
        java.nio.channels.FileLock lock = out.getChannel().tryLock();
        if (lock != null){
            System.out.println("file locked!");
            TimeUnit.MILLISECONDS.sleep(2000);
            lock.release();
            System.out.println("lock released!");
        }
        out.close();
    }
}
