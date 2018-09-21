package net.htmlonline.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.http.Cookie;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Utils {
    public static Cookie findCookie(String aName, Cookie[] cookies) {
        if(cookies == null) return null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(aName)) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static class UUID {
        /**
         * 随机生成id
         * @return
         */
        public static String getId(){
            return java.util.UUID.randomUUID().toString().replace("-", "").toUpperCase();
        }


        public static String getUUID64(){
            return getId()+getId();
        }

        /**
         * 生成随机码
         * @return
         */
        public static String getCode(){
            return getId();
        }
    }

//    public static<T> T  populate(Class<T> clazz, Map<String, String[]> map) {
//        try {
//            T t = clazz.newInstance();
//            BeanUtils.populate(t, map);
//            return t;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    public static<T> T  populate(Class<T> clazz, Map<String, String[]> map) {
        try {

            T obj=clazz.newInstance();

            // 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
            // 1_创建时间类型的转换器
            DateConverter dt = new DateConverter();
            // 2_设置转换的格式
            dt.setPattern("yyyy-MM-dd");
            // 3_注册转换器
            ConvertUtils.register(dt, java.util.Date.class);

            BeanUtils.populate(obj, map);

            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
