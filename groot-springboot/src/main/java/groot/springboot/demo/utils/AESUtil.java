package groot.springboot.demo.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {
    private static String ALGORITHM = "AES";
    private static String SECURE_RANDOM = "SHA1PRNG";
    //128 192 256
    private static int KEY_SIZE = 256;

    public static byte[] encrypt(byte[] bytes, String password) {
        try {
            final KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            final SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM);
            secureRandom.setSeed(password.getBytes());
            kgen.init(KEY_SIZE, secureRandom);
            SecretKeySpec key = new SecretKeySpec(kgen.generateKey().getEncoded(), ALGORITHM);
            return cipher(key, bytes, ALGORITHM, Cipher.ENCRYPT_MODE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] cipher(Key key, byte[] bytes, String algorithm, int cryptMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(cryptMode, key);
        return cipher.doFinal(bytes);
    }

    public static byte[] decrypt(final byte[] bytes, final String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM);
            secureRandom.setSeed(password.getBytes());
            kgen.init(KEY_SIZE, secureRandom);
            SecretKeySpec key = new SecretKeySpec(kgen.generateKey().getEncoded(), ALGORITHM);
            return cipher(key, bytes, ALGORITHM, Cipher.DECRYPT_MODE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(final String[] args) {
        String content = "username=mmaccount&packageid=20001&phoneno=111&busicode=codevalue";
        String password = "cplatform_hyl";
        byte[] en_bytes = encrypt(FileUtils.readLocalFile(new File("D:\\pic\\微信图片_20210309214004.png")), password);
        FileUtils.writeLocalFile(new File("D:\\pic\\asc_data_pic"), en_bytes);
        byte[] de_bytes = decrypt(FileUtils.readLocalFile(new File("D:\\pic\\asc_data_pic")), password);
        FileUtils.writeLocalFile(new File("D:\\pic\\asc_decrypt_pic.jpg"), de_bytes);
        System.out.println(new String(en_bytes));
        System.out.println(new String(de_bytes));
        System.out.println(content.equals(new String(de_bytes)));
    }
}
