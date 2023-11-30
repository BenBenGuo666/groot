package groot.springboot.demo.utils.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: GuoBen~
 * @date: 2023/7/19 17:10
 * @description:
 */
public class PhoneScreen {

    public static void main(String[] args) {
        try {
            String adbPackagePath = "/Users/guobenben/project/groot/code/groot/groot-springboot/src/main/resources/platform-tools";
            // 执行 adb 命令
            Process process = Runtime.getRuntime().exec(adbPackagePath + "/adb exec-out screencap -p");

            // 获取命令输出流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // 读取命令输出并打印
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭输入流
            bufferedReader.close();

            // 等待命令执行完成
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
