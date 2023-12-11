package com.light.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
public class SaltMD5Util {
    public static String MD5(String input) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "NoSuchAlgorithmException";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        char[] charArray = input.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    public static String generateSaltPassword(String password) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = stringBuilder.length();

        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                stringBuilder.append("0");
            }
        }

        String salt = stringBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];

        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }

        return new String(cs);
    }
    public static boolean verifySaltPassword(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];

        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }

        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String args[]) {
        // 原密码
        String password = "123456";
        System.out.println("明文(原生)密码：" + password);
        // MD5加密后的密码
        String MD5Password = MD5(password);
        System.out.println("普通MD5加密密码：" + MD5Password);
        // 获取加盐后的MD5值
        String SaltPassword = generateSaltPassword(password);
        System.out.println("加盐后的MD密码：" + SaltPassword);
        System.out.println("加盐后的密码和原生密码是否是同一字符串:" + verifySaltPassword(password, SaltPassword));
    }

}