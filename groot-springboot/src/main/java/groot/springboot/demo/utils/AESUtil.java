package groot.springboot.demo.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

	public static String encrypt(final String content, final String password) {
		final byte[] encryptResult = encryptToBytes(content, password);
		return parseByte2HexStr(encryptResult);
	}

	private static byte[] encryptToBytes(final String content, final String password) {
		try {
			final KeyGenerator kgen = KeyGenerator.getInstance("AES");
			final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			final SecretKey secretKey = kgen.generateKey();
			final byte[] enCodeFormat = secretKey.getEncoded();
			final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			final Cipher cipher = Cipher.getInstance("AES");
			final byte[] byteContent = content.getBytes("utf-8");
			cipher.init(1, key);
			final byte[] result = cipher.doFinal(byteContent);
			return result;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e2) {
			e2.printStackTrace();
		}
		catch (InvalidKeyException e3) {
			e3.printStackTrace();
		}
		catch (UnsupportedEncodingException e4) {
			e4.printStackTrace();
		}
		catch (IllegalBlockSizeException e5) {
			e5.printStackTrace();
		}
		catch (BadPaddingException e6) {
			e6.printStackTrace();
		}
		return null;
	}

	/*private static byte[] encrypt(final byte[] bytes, final String password) {
		try {
			final KeyGenerator kgen = KeyGenerator.getInstance("AES");
			final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			final SecretKey secretKey = kgen.generateKey();
			final byte[] enCodeFormat = secretKey.getEncoded();
			final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			final Cipher cipher = Cipher.getInstance("AES");
			cipher.init(1, key);
			final byte[] result = cipher.doFinal(bytes);
			return result;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e2) {
			e2.printStackTrace();
		}
		catch (InvalidKeyException e3) {
			e3.printStackTrace();
		}
		catch (UnsupportedEncodingException e4) {
			e4.printStackTrace();
		}
		catch (IllegalBlockSizeException e5) {
			e5.printStackTrace();
		}
		catch (BadPaddingException e6) {
			e6.printStackTrace();
		}
		return null;
	}*/

	public static String decrypt(final String encryptResultStr, final String password) {
		final byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
		final byte[] decryptResult = decryptToBytes(decryptFrom, password);
		try {
			return new String(decryptResult, "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static byte[] decryptToBytes(final byte[] content, final String password) {
		try {
			final KeyGenerator kgen = KeyGenerator.getInstance("AES");
			final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			final SecretKey secretKey = kgen.generateKey();
			final byte[] enCodeFormat = secretKey.getEncoded();
			final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			final Cipher cipher = Cipher.getInstance("AES");
			cipher.init(2, key);
			final byte[] result = cipher.doFinal(content);
			return result;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e2) {
			e2.printStackTrace();
		}
		catch (InvalidKeyException e3) {
			e3.printStackTrace();
		}
		catch (IllegalBlockSizeException e4) {
			e4.printStackTrace();
		}
		catch (BadPaddingException e5) {
			e5.printStackTrace();
		}
		return null;
	}

	public static String encryptForStr(final String strSrc, String encName) {
		MessageDigest md = null;
		String strDes = null;
		try {
			final byte[] bt = strSrc.getBytes("UTF-8");
			if (encName == null || encName.equals("")) {
				encName = "SHA-256";
			}
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = Byte2HexStr(md.digest());
		}
		catch (NoSuchAlgorithmException e2) {
			return null;
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		return strDes;
	}

	private static String Byte2HexStr(final byte[] buf) {
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; ++i) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = String.valueOf('0') + hex;
			}
			sb.append(hex.toLowerCase());
		}
		return sb.toString();
	}

	private static String parseByte2HexStr(final byte[] buf) {
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; ++i) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = String.valueOf('0') + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	private static byte[] parseHexStr2Byte(final String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		}
		final byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; ++i) {
			final int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			final int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(final String[] args) {
		final String content = "username=mmaccount&packageid=20001&phoneno=111&busicode=codevalue";
		final String password = "cplatform_hyl";
		System.out.println("\u52a0\u5bc6\u524d\uff1a" + content);
		final String encryptResultStr = encrypt(content, password);
		System.out.println("\u52a0\u5bc6\u540e\uff1a" + encryptResultStr);
		final String decryptResult = decrypt(encryptResultStr, password);
		System.out.println("\u89e3\u5bc6\u540e\uff1a" + decryptResult);
	}
}
