package groot.springboot.demo.http5.util;

import cn.hutool.core.io.IoUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


/**
 * 该类用于解密音频文件.解密并播放音频文件的总体流程为:
 * 1.当用户点击播放按钮时,调用track_url接口.该接口会返回单曲url,以及解密该单曲所需的securityKey和intVector.
 * 2.调用main方法可以解密track
 * 3.根据具体的播放器,结合解密方法,对码流做进一步处理.需要说明的是:本例子只是一个针对完整音频文件的解密.而播放器需要边下载边解密,也可以拖动播放进度条从某一处开始下载并播放.
 *
 * @author sonyselect
 * @Description
 * @date 2023-7-7
 */
public class TrackDecryptUtil {

    //bufferSize 必须为2048,因为加密的时候也是每2048个字节进行加密一次
    public static int bufferSize = 2048;
    public static String AesOfbNoPaddingTransformation = "AES/OFB/NoPadding";
    public static String key4DecryptSecurity = "DCBBEC53951E2E72D6BC708604EA705200CD829B6CB18F48A29A5A0E67E44D87";
    private static final String CIPHER_ALGORITHM4_SECURITY_KEY = "AES/GCM/NoPadding";
    private static final String CHARSET = "UTF-8";


    public static void decryptTrackStreaming(String trackUrl, String encryptedSecurityKey, String initVector, String trackOutputPath) throws DecoderException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String decryptedSecurityKey = decryptSecurityKey(encryptedSecurityKey);
        System.out.println("decodedSecurityKey is:" + decryptedSecurityKey);
        URL url = new URL(trackUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();
        int code = httpURLConnection.getResponseCode();
        byte[] buf = new byte[bufferSize];
        int size = 0;
        if (code == HttpURLConnection.HTTP_OK) {
            InputStream in = httpURLConnection.getInputStream();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(trackOutputPath), 1024 * 1024 * 8);
            byte[] keyValue = decryptedSecurityKey.getBytes();
            SecretKeySpec encryKey = new SecretKeySpec(keyValue, "AES");
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
            Cipher cipher = Cipher.getInstance(AesOfbNoPaddingTransformation);

            int i = 0;
            cipher.init(Cipher.DECRYPT_MODE, encryKey, iv);
            int totalSize = 0;
            while ((size = in.read(buf, i * bufferSize, bufferSize)) != 0) {
                byte[] encryptedInput = cipher.doFinal(buf);
                out.write(encryptedInput, 0, size);
                totalSize = totalSize + size;
                if (i % 1000 == 0) System.out.println("totalSize:" + totalSize);
                i++;
            }
            out.close();
            in.close();
            httpURLConnection.disconnect();
            System.out.println("download and decrypted done!");
        }
    }

    public static void main(String[] args) throws Exception {
        //以下三个参数从track_url接口中获取,其中trackUrl有效期为数小时,因此trackUrl不要持久化.
        String trackUrl = "http://cdn-test.sonyselect.cn/shared/20230707113703/2ffcff8f0b3c15fd289fe2c853cebcdf/Hi-Res-3/flacs_20191009/Audio/48kHz_24bit_900327_01_01.flac";
        String encryptedSecurityKey = "security:07800DE9C19CB964FD4FCC15:55E215556C092E1F75803CA7480F6432C107BAF146B223DF80D089B987DD78D6";
        String initVector = "MiQ-3NPiOPDnl_gb";
        //存放解密后的音频文件地址.
        String trackOutputPath = "C:\\Users\\5109i10108\\Downloads\\decryptedTrack3.flac";
        decryptTrackStreaming(trackUrl, encryptedSecurityKey, initVector, trackOutputPath);
    }


    public static String decryptSecurityKey(String encrypedSecurityKey) throws DecoderException {
        try {
            int index = encrypedSecurityKey.indexOf("security:");
            String subEncryptText = index == -1 ? null : encrypedSecurityKey.substring("security:".length());
            index = subEncryptText.indexOf(':');
            byte[] salt = Hex.decodeHex(subEncryptText.substring(0, index).toCharArray());
            byte[] cipherKey = Hex.decodeHex(subEncryptText.substring(index + 1).toCharArray());
            GCMParameterSpec params = new GCMParameterSpec(128, Arrays.copyOf(salt, 12));
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM4_SECURITY_KEY);
            byte bb[] = Hex.decodeHex(key4DecryptSecurity.toCharArray());
            SecretKeySpec skey = new SecretKeySpec(Arrays.copyOf(bb, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, skey, params);
            byte[] decryptData = cipher.doFinal(cipherKey);
            return new String(decryptData, CHARSET);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

