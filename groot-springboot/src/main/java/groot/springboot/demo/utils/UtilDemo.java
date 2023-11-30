package groot.springboot.demo.utils;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: GuoBen~
 * @date: 2023/5/15 16:17
 * @description:
 */
public class UtilDemo {

    public static void main(String[] args) throws JSchException, IOException {
        /*String host = "sftp01.th-music.com";
        String username = "dynaudio";
        int port = 22220;
        String privateKeyPath = "/Users/guobenben/project/groot/code/groot/groot-springboot/src/main/resources/dynaudio.rsa";
        JSch jSch = new JSch();
        jSch.addIdentity(privateKeyPath);
        Sftp sftp = JschUtil.createSftp(JschUtil.createSession(jSch, host, port, username));
        //进入远程目录
//        sftp.cd("/DAILY");
        //上传本地文件
        sftp.put("/Users/guobenben/project/groot/code/groot/groot-springboot/src/main/resources/demo.json"
                , "/DAILY");
        //关闭连接
        sftp.close();*/
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("demo", "1");
        map.put("demo2", "2");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("demo3", "3");
        map2.put("demo4", "4");
        list.add(map);
        list.add(map2);
        String jsonFilePath = "/Users/guobenben/project/groot/code/groot/groot-springboot/src/main/resources/demo.text";
        File file = new File(jsonFilePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        list.stream().forEach(e -> {
            try {
                bufferedWriter.write(JsonUtils.toGson(e));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedWriter.flush();
        bufferedWriter.close();


    }

}
