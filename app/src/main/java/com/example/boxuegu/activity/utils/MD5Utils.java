package com.example.boxuegu.activity.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * 创建MD5加密方法md5()
     * @param text 需要加密的原文
     * @return 加密后的MD5字符串
     */
    public static String md5(String text) {
        MessageDigest digest = null;
        try {
            // 获取MD5摘要算法实例
            digest = MessageDigest.getInstance("md5");
            // 将字符串转换为字节数组并进行摘要计算
            byte[] result = digest.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();

            // 遍历字节数组，将每个字节转换为十六进制字符串
            for (byte b : result) {
                // 与 0xff 运算，将byte转换为int类型数据
                int number = b & 0xff;
                // 将int类型的数据转换为十六进制的字符串数据
                String hex = Integer.toHexString(number);

                // 保证十六进制字符串为2位，不足则在前面补0
                if (hex.length() == 1) {
                    sb.append("0" + hex);
                } else {
                    sb.append(hex);
                }
            }
            // 返回拼接好的MD5字符串
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // 出现异常时返回空字符串
            return "";
        }
    }
}