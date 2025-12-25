package cn.stylefeng.1466951331.shiro;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Base64Test {

    /**
     * Shiro 记住密码采用的是AES加密，AES key length 需要是16位，该方法生�?6位的key
     */
    public static void main(String[] args) {

        String keyStr = "1466951331";

        byte[] keys;
        try {
            keys = keyStr.getBytes("UTF-8");
            System.out.println(Base64Utils.encodeToString(Arrays.copyOf(keys, 16)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
