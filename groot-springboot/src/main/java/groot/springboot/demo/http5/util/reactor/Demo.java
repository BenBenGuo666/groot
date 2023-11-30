package groot.springboot.demo.http5.util.reactor;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.HexUtil;
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
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author: GuoBen~
 * @date: 2023/9/12 14:43
 * @description:
 */
public class Demo {

    private static final String CIPHER_ALGORITHM4_SECURITY_KEY = "AES/GCM/NoPadding";

    public static String key4DecryptSecurity = "DCBBEC53951E2E72D6BC708604EA705200CD829B6CB18F48A29A5A0E67E44D87";

    public static int bufferSize = 2048;

    public static String AesOfbNoPaddingTransformation = "AES/OFB/NoPadding";

    public static void main(String[] args) throws DecoderException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        //以下三个参数从track_url接口中获取,其中trackUrl有效期为数小时,因此trackUrl不要持久化.
        String trackUrl = "http://cdn-test.sonyselect.cn/shared/20230912111052/a10d24d2f26b4e7b417c66f334546d4f/Hi-Res/flacs_20160224/Audio/96kHz_24bit_7318599919478_01_01.flac";
        String encryptedSecurityKey = "security:17C22FB6C8F5F2FF5AD3FE9E:F463BF92E66E211DC9CB7C7B71FECCB6C8D73069BB2DC963F93B67C77F967E45";
        String initVector = "HWZzWJgNPokA-NIS";
        //存放解密后的音频文件地址.
        String trackOutputPath = "/Users/guobenben/Downloads/decryptedTrack8.flac";
        decryptTrackStreaming(trackUrl, encryptedSecurityKey, initVector, trackOutputPath);
    }


    public static void decryptTrackStreaming(String trackUrl, String encryptedSecurityKey, String initVector, String trackOutputPath) throws DecoderException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String decryptedSecurityKey = generateKey(encryptedSecurityKey);
        URL url = new URL(trackUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();
        int code = httpURLConnection.getResponseCode();
        int size = 0;
        if (code == HttpURLConnection.HTTP_OK) {
            InputStream in = httpURLConnection.getInputStream();
            BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get(trackOutputPath)), 1024 * 1024 * 8);
            byte[] keyValue = decryptedSecurityKey.getBytes();
            SecretKeySpec encryKey = new SecretKeySpec(keyValue, "AES");
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
            Cipher cipher = Cipher.getInstance(AesOfbNoPaddingTransformation);

            int i = 0;
            cipher.init(Cipher.DECRYPT_MODE, encryKey, iv);
            int totalSize = 0;
            byte[] bytes = IoUtil.readBytes(in);
            boolean loop = true;
            while (loop) {
                int offset = i * bufferSize;
                int len = (offset + bufferSize < bytes.length) ? bufferSize : bytes.length - offset;
                byte[] encryptedInput = cipher.doFinal(bytes, offset, len);
                out.write(encryptedInput, 0, len);
                totalSize = totalSize + size;
                if (offset + bufferSize >= bytes.length) {
                    System.out.println("totalSize:" + bytes.length);
                    loop = false;
                }
                i++;
            }
            out.close();
            in.close();
            httpURLConnection.disconnect();
            System.out.println("download and decrypted done!");
        }
    }

    private static String generateKey(String encryptedSecurityKey) {
        int index = encryptedSecurityKey.indexOf("security:");
        String subEncryptText = index == -1 ? null : encryptedSecurityKey.substring("security:".length());
        index = subEncryptText.indexOf(':');
        try {
            byte[] salt = HexUtil.decodeHex(subEncryptText.substring(0, index).toCharArray());
            byte[] cipherKey = HexUtil.decodeHex(subEncryptText.substring(index + 1).toCharArray());
            byte bb[] = Hex.decodeHex(key4DecryptSecurity.toCharArray());
            GCMParameterSpec params = new GCMParameterSpec(128, Arrays.copyOf(salt, 12));
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM4_SECURITY_KEY);
            SecretKeySpec skey = new SecretKeySpec(Arrays.copyOf(bb, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, skey, params);
            byte[] decryptData = cipher.doFinal(cipherKey);
            return new String(decryptData, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException | NoSuchPaddingException | InvalidKeyException | DecoderException e) {
            throw new RuntimeException(e);
        }
    }
}
