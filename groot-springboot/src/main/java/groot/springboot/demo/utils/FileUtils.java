package groot.springboot.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/22
 */
public class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static byte[] readLocalFile(File file) {
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        FileChannel fileReadableChannel = null;
        try {
            fileReadableChannel = (FileChannel) fileSystemResource.readableChannel();
            ByteBuffer buff = ByteBuffer.allocate((int) fileSystemResource.contentLength());
            fileReadableChannel.read(buff);
            buff.rewind();
            return buff.array();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("faild read file to local");
        } finally {
            if (fileReadableChannel != null) {
                if (fileReadableChannel.isOpen()) {
                    try {
                        fileReadableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("faild close fileChannel!");
                    }
                }
            }
        }
        return null;
    }

    public static void writeLocalFile(File file, byte[] bytes) {
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        FileChannel fileWritableChannel = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWritableChannel = (FileChannel) fileSystemResource.writableChannel();
            ByteBuffer buff = ByteBuffer.wrap(bytes);
            fileWritableChannel.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error("faild upload file to local");
        } finally {
            if (fileWritableChannel != null) {
                if (fileWritableChannel.isOpen()) {
                    try {
                        fileWritableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error(e.getMessage());
                        logger.error("faild close fileChannel!");
                    }
                }
            }
        }
    }

}
