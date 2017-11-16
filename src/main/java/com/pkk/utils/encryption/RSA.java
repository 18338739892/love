
package com.pkk.utils.encryption;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;


public class RSA {

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA签名
     *
     * @param content       待签名数据
     * @param privateKey    商户私钥
     * @param input_charset 编码格式
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String input_charset) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(input_charset));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * RSA验签名检查
     *
     * @param content        待签名数据
     * @param sign           签名值
     * @param ali_public_key 和包公钥
     * @param input_charset  编码格式
     * @return 布尔值
     */
    public static boolean verify(String content, String sign, String ali_public_key, String input_charset) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(ali_public_key);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(input_charset));

            boolean bverify = signature.verify(Base64.decode(sign));
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 解密
     *
     * @param content       密文
     * @param private_key   商户私钥
     * @param input_charset 编码格式
     * @return 解密后的字符串
     */
    public static String decrypt(String content, String private_key, String input_charset) throws Exception {
        PrivateKey prikey = getPrivateKey(private_key);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, prikey);

        InputStream ins = new ByteArrayInputStream(Base64.decode(content));
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        //rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
        byte[] buf = new byte[128];
        int bufl;

        while ((bufl = ins.read(buf)) != -1) {
            byte[] block = null;

            if (buf.length == bufl) {
                block = buf;
            } else {
                block = new byte[bufl];
                for (int i = 0; i < bufl; i++) {
                    block[i] = buf[i];
                }
            }

            writer.write(cipher.doFinal(block));
        }

        return new String(writer.toByteArray(), input_charset);
    }


    /**
     * 得到私钥
     *
     * @param key 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {

        byte[] keyBytes;

        keyBytes = Base64.decode(key);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        return privateKey;
    }

    public static void main(String[] args) {


        String content = "_input_charset=\"utf-8\"&body=\"一卡通充值，收款方账号，2088421370255180\"&notify_url=\"http://pay.newcapec.net/PayGateway/gateway/alipay/Notify.aspx\"&out_context=\"{\"ccode\":\"2088021352783696\"}\"&out_trade_no=\"2016083004790039\"&partner=\"2088021352783696\"&payment_type=\"1\"&seller_id=\"2088421370255180\"&service=\"mobile.securitypay.pay\"&subject=\"一卡通充值\"&total_fee=\"50\"";
        String sign = "zVWBNqhA38XLvwjstB2Fq2ratO8Ah3uEPG4Q1ofns+pg92KsvvYTUkU6X5OW+PO/nihrn1dGOb4qUN8shBvgM+ASsttFC4CHuZGZ1AWzKaJjvsFXGTYFPAavRz3Jqrb2MlkAIwdm0nqxVPb4pCFdCYVV3BhfUM/UY8poJbf8VrU=";
//        String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTPV+eAnfVeK3RebEeXGWpUn1raoOu+MSZTP8zkzXfAtServCILakgxo+fFuxKUwykHy3VUxN4J1dCQTn/BtcgCDYQNQrrMgv32Q7XeswzAfx0NjG+DswxfLAm5n+s8ge8JK5hfIH9egNcPnL6EMpKZyld5Exnxb59wZ7aP1PsywIDAQAB";
//        String privatekey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ/lYYafK/oNY2zAO1LO/u00v7Z8TVdoRLb3UnEfw4bbJtlShZjhu2k16JFarDwcNmkv9gm+JnDqKZ+eB1QoGm8Idr0rbcRdIqGrYAgutCei1p7FwzmpSV9XYuAaKBJqkZ25xmZKpvBk/WzrkctCs3t7npChywWBN16HCg0w9vfLAgMBAAECgYAr4cXsLk7hZz88H12okkqASxO6P07yiBkjpaiohzEgF5EH34/urzTB4RucmKfgL1X3dEQv1FG0d29I8RPN0tu94iWTaJSZMuiDi3+z7YjzzDjWZwfGcLsloaPHi3Rrt0Hqk9UcOiQvr+nyJpZbkkdBjEP51IskJ6GFnsoQZqkf4QJBAMrE060NfaiXT4ishaCacQngHCNvQwgYDsGnErUJYeMa+vlb+U1nu+D16ByXKUidkEcaqffxUnQe2Lr3+xI9RnkCQQDJ30QD4l8i+F6wayf08Aw1UiKliswtxDnFn27IcLauuV0gPRsokTD8BXCW8xY5slhaU104K2N53wfikE2a2K9jAkAKIS8Z9BSU+Yoln8jFLzH6dlGxi3tjyh/imMAcfy1+tPhYwLmBnm8KW/6Ofxa24/gzNSfMlSezWV8maAEI9jqxAkBPpZAPPEQu5vFtB4onQIKAkxxqVf3C3NWyW/n4iUf6XdYZPyK0+bvq4zaNx/Dv6KalVJjF7ZB85/sTb72+p1ljAkEAqVfdXh2XH4ac1E9gO5PeR9OHCot2NHOs6h40acgGH4AUxSgL1oOPA69MZ9RxwplRJpTGOLEgI4gxoskLrpyr3g==";
        String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTPV+eAnfVeK3RebEeXGWpUn1raoOu+MSZTP8zkzXfAtServCILakgxo+fFuxKUwykHy3VUxN4J1dCQTn/BtcgCDYQNQrrMgv32Q7XeswzAfx0NjG+DswxfLAm5n+s8ge8JK5hfIH9egNcPnL6EMpKZyld5Exnxb59wZ7aP1PsywIDAQAB";
        String privatekey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ/lYYafK/oNY2zAO1LO/u00v7Z8TVdoRLb3UnEfw4bbJtlShZjhu2k16JFarDwcNmkv9gm+JnDqKZ+eB1QoGm8Idr0rbcRdIqGrYAgutCei1p7FwzmpSV9XYuAaKBJqkZ25xmZKpvBk/WzrkctCs3t7npChywWBN16HCg0w9vfLAgMBAAECgYAr4cXsLk7hZz88H12okkqASxO6P07yiBkjpaiohzEgF5EH34/urzTB4RucmKfgL1X3dEQv1FG0d29I8RPN0tu94iWTaJSZMuiDi3+z7YjzzDjWZwfGcLsloaPHi3Rrt0Hqk9UcOiQvr+nyJpZbkkdBjEP51IskJ6GFnsoQZqkf4QJBAMrE060NfaiXT4ishaCacQngHCNvQwgYDsGnErUJYeMa+vlb+U1nu+D16ByXKUidkEcaqffxUnQe2Lr3+xI9RnkCQQDJ30QD4l8i+F6wayf08Aw1UiKliswtxDnFn27IcLauuV0gPRsokTD8BXCW8xY5slhaU104K2N53wfikE2a2K9jAkAKIS8Z9BSU+Yoln8jFLzH6dlGxi3tjyh/imMAcfy1+tPhYwLmBnm8KW/6Ofxa24/gzNSfMlSezWV8maAEI9jqxAkBPpZAPPEQu5vFtB4onQIKAkxxqVf3C3NWyW/n4iUf6XdYZPyK0+bvq4zaNx/Dv6KalVJjF7ZB85/sTb72+p1ljAkEAqVfdXh2XH4ac1E9gO5PeR9OHCot2NHOs6h40acgGH4AUxSgL1oOPA69MZ9RxwplRJpTGOLEgI4gxoskLrpyr3g==";

        System.out.println(java.net.URLEncoder.encode(RSA.sign(content, privatekey, "UTF-8")));

        System.out.println(RSA.verify(content, RSA.sign(content, privatekey, "UTF-8"), public_key, "utf-8"));

    }
}
