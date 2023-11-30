package groot.springboot.demo.utils;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
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
            int s = (int) (fileSystemResource.contentLength() * 0.1);
            int l = (int) (fileSystemResource.contentLength() - s);
            fileReadableChannel.read(buff);
            buff.rewind();
            byte[] bytes = new byte[l];
            System.arraycopy(buff.array(), s, bytes, 0, l);
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("failed read file to local");
        } finally {
            if (fileReadableChannel != null) {
                if (fileReadableChannel.isOpen()) {
                    try {
                        fileReadableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("failed close fileChannel!");
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
            System.out.println(bytes.length);
            System.out.println("fileWritableChannel->write:" + fileWritableChannel.write(buff));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error("failed upload file to local");
        } finally {
            if (fileWritableChannel != null) {
                if (fileWritableChannel.isOpen()) {
                    try {
                        fileWritableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error(e.getMessage());
                        logger.error("failed close fileChannel!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(v -> v * v)
                .filter(v -> v % 2 == 0);
        flow.subscribe(System.out::println).dispose();

        Observable.create(emitter -> {
                    while (!emitter.isDisposed()) {
                        long time = System.currentTimeMillis();
                        emitter.onNext(time);
                        if (time % 2 != 0) {
                            emitter.onError(new IllegalStateException("Odd millisecond!"));
                            break;
                        }
                    }
                })
                .subscribe(System.out::println, Throwable::printStackTrace)
                .dispose();

        Flowable.just("Hello world").subscribe(System.out::println).dispose();
    }

}
