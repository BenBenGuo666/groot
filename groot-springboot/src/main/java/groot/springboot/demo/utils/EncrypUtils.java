package groot.springboot.demo.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/5/14
 */
public class EncrypUtils {

    private static String ALGORITHM = "RSA";
    private static String strSeed = "2021";
    private static String STRING_MODULUS = "109709917524556390084124200252837763511250268860683935922463550925271122803385622912886205731345513872754570095660199938489594595420413474773842905970760993292245293695377672422927581105950266736910642670999539050128522216660062365259296481028320185411681201383744576437345143188933863213123691046899733094109";
    private static String STRING_PUBLIC_KEY = "65537";
    private static String STRING_PRIVATE_KEY = "71338146929352435470573154001170045806673027564552022969250716735285852240204439025781553278930818830392541688306749170372981272927368055106082296076170389576776590051638968784876011516110798932342060358486718134066117236225652779887080257162882493641471179609011687324805456120296896465445338600097918992293";
    private static final BigInteger MODULUS = new BigInteger(STRING_MODULUS);
    private static final BigInteger PUBLIC_KEY = new BigInteger(STRING_PUBLIC_KEY);
    private static final BigInteger PRIVATE_KEY = new BigInteger(STRING_PRIVATE_KEY);

    /**
     * @param key
     * @param bytes
     * @param algorithm
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static byte[] cipher(Key key, byte[] bytes, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (key == null) {
            return null;
        }
        int cryptMode;
        if (key instanceof PublicKey) {
            cryptMode = Cipher.ENCRYPT_MODE;
        } else if (key instanceof PrivateKey) {
            cryptMode = Cipher.DECRYPT_MODE;
        } else {
            return null;
        }
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(cryptMode, key);
        return cipher.doFinal(bytes);
    }

    /**
     * String转公钥PublicKey
     *
     * @return
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(MODULUS, PUBLIC_KEY);
        return (RSAPublicKey) keyFactory.generatePublic(rsaPublicKeySpec);
    }

    /**
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        KeySpec keySpec = new RSAPrivateKeySpec(MODULUS, PRIVATE_KEY);
        return keyFactory.generatePrivate(keySpec);
    }


    /**
     * 主函数
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        String msg = "You are not alone.";
        //初始化密钥对生成器，密钥大小为1024位
        //生成一个密钥对，保存在keyPair中
/*        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024, new SecureRandom(strSeed.getBytes(StandardCharsets.UTF_8)));
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey1 = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey1 = (RSAPublicKey) keyPair.getPublic();*/

        PrivateKey privateKey = getPrivateKey();
        RSAPublicKey publicKey = getPublicKey();

        //用公钥加密
        byte[] srcBytes = msg.getBytes();
        byte[] encryptBytes = cipher(publicKey, srcBytes, ALGORITHM);
        System.out.println("加密后是:" + new String(encryptBytes, StandardCharsets.UTF_8));
        FileUtils.writeLocalFile(new File("D:\\pic\\data"), encryptBytes);
        //用私钥解密
        byte[] decryptBytes = cipher(privateKey, FileUtils.readLocalFile(new File("D:\\pic\\data")), ALGORITHM);
        System.out.println("公钥:" + publicKey.toString());
        System.out.println("私钥:" + privateKey.toString());
        System.out.println("明文是:" + msg);
        System.out.println("解密后是:" + new String(decryptBytes, StandardCharsets.UTF_8));
    }

}
