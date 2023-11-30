package groot.workflow.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/3/22
 */
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static double byteSize = 0;
    private static double size = 0;
    private static int num = 0;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        if (args == null || args.length < 2) {
            System.out.println("请输入文件路径和目标文件路径，空格隔开");
            return;
        }
        String sourceFilePath = args[0];
        String targetFilePath = args[1];
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        if (!sourceFile.exists()) {
            System.out.println("源文件或目录不存在。");
            return;
        }
        if (!sourceFile.canRead()) {
            System.out.println("源文件或目录不可读。");
            return;
        }
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                System.out.println("目标文件或目录创建失败:" + e.getMessage());
            }
        }
        if (!targetFile.canWrite()) {
            System.out.println("目标文件或目录不可写入。");
        }
        targetFile.delete();
        System.out.println("----------------开始复制----------------");
        long startTime = System.currentTimeMillis();
        if (sourceFile.isDirectory()) {
            copy(targetFilePath, sourceFile.listFiles());
        } else {
            copy(targetFilePath, sourceFile);
        }

        size += byteSize / 1024 / 1024;
        byteSize = 0;
        System.out.println("----------------复制结束----------------");
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("共复制文件: " + num + "份");
        System.out.println("数据量: " + new DecimalFormat("######0.00").format(size) + " Mb");

    }

    public static File[] copy(String targetPath, File... souceFiles) {
        if (souceFiles != null && souceFiles.length > 0) {
            for (File souceFile : souceFiles) {
                String targetFilePath = targetPath + File.separator + souceFile.getName();
                if (souceFile.isDirectory()) {
                    System.out.println("源文件是目录，开始递归----------------------");
                    copy(targetFilePath, souceFile.listFiles());
                } else {
                    File targetFile = new File(targetFilePath);
                    if (!targetFile.exists()) {
                        System.out.println("正在创建文件 " + targetFilePath);
                        try {
                            targetFile.createNewFile();
                        } catch (IOException e) {
                            System.out.println("文件创建失败：" + e.getMessage());
                        }
                    }
                    System.out.println("正在将 " + souceFile.getName() + " 复制到 " + targetFile.getName());
                    byte[] bytes = FileUtil.readLocalFile(souceFile);
//                    FileUtils.writeLocalFile(targetFile, AESUtils.encrypt(bytes));
                    FileUtil.writeLocalFile(targetFile, bytes);
                    System.out.println(souceFile.getPath() + " 文件复制完成。");
                    if (byteSize > Double.MAX_VALUE * 0.7) {
                        size += byteSize / 1024 / 1024;
                        byteSize = 0;
                    }
                    byteSize += souceFile.length();
                    num++;
                }
            }
        }
        return null;
    }

    public static byte[] readLocalFile(FileInputStream fileInputStream) {
        FileChannel fileReadableChannel = null;
        try {
            fileReadableChannel = (FileChannel) Channels.newChannel(fileInputStream);
            ByteBuffer buff = ByteBuffer.allocate((int) fileReadableChannel.size());
            fileReadableChannel.read(buff);
            buff.rewind();
            return buff.array();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("faild read file to local" + e.getMessage());
        } finally {
            if (fileReadableChannel != null) {
                if (fileReadableChannel.isOpen()) {
                    try {
                        fileReadableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("faild close fileChannel!" + e.getMessage());
                    }
                }
            }
        }
        return null;
    }

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
            logger.error("faild read file to local:" + e.getMessage());
        } finally {
            if (fileReadableChannel != null) {
                if (fileReadableChannel.isOpen()) {
                    try {
                        fileReadableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("faild close fileChannel!" + e.getMessage());
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
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWritableChannel = (FileChannel) fileSystemResource.writableChannel();
            ByteBuffer buff = ByteBuffer.wrap(bytes);
            fileWritableChannel.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error("faild upload file to local" + e.getMessage());
        } finally {
            if (fileWritableChannel != null) {
                if (fileWritableChannel.isOpen()) {
                    try {
                        fileWritableChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error(e.getMessage());
                        logger.error("faild close fileChannel!" + e.getMessage());
                    }
                }
            }
        }
    }


}
