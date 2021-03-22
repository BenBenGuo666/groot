package groot.springboot.demo.utils;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/22
 */
@Component
public class FileUtils {

    void saveFile(File file) {

    }

    public void writerFile(byte[] bytes, File file) throws IOException {
        if (file.exists()) {

        } else {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    public byte[] readFile(File file) throws IOException {
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] result = new byte[1024 * 1024 * 5];
            ;
            while (fileInputStream.read() != -1) {
                fileInputStream.read(result, 0, result.length);
            }
            fileInputStream.close();
            return result;
        } else {
            return null;
        }


    }

}
