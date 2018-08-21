package com.huhan.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 * @author huhan
 * @data 2018/8/20
 */
public class MD5Utils {

    /**
     * 加密
     * @param str 要加密的字符串
     * @author  huhan
     * @data  2018/8/20
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();

            // 16位加密
//            return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*e10adc3949ba59abbe56e057f20f883e
    public static void main(String[] args) {
        System.out.println(MD5Utils.code("123456"));
    }*/
}
