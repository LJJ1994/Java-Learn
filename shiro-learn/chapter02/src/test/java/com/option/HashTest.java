package com.option;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

public class HashTest {
    @Test
    public void testMd5(){
        String str = "abc123";
        String salt = "110";
        Md5Hash md5Hash = new Md5Hash(str, salt);
        String string = md5Hash.toString();
        System.out.println("hash: " + string);
    }

    @Test
    public void testSha(){
        String str = "abc123";
        String salt = "110";
        Sha256Hash sha256Hash = new Sha256Hash(str, salt);
        String string = sha256Hash.toString();
        System.out.println(string);
        System.out.println(string.length());
    }

    @Test
    public void testSimpleHash(){
        String str = "abc123";
        String salt = "110";
        SimpleHash simpleHash = new SimpleHash("SHA-256", str, salt);
        String string = simpleHash.toString();
        System.out.println(string);
    }

    @Test
    public void testHashService(){
        DefaultHashService defaultHashService = new DefaultHashService();
        defaultHashService.setHashAlgorithmName("SHA-256"); //设置算法
        defaultHashService.setPrivateSalt(new SimpleByteSource("110"));//私盐
        defaultHashService.setGeneratePublicSalt(true);//设置生产公盐
        defaultHashService.setHashIterations(1);//hash迭代次数
        defaultHashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//公盐生成器

        HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5")
                .setIterations(2)
                .setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123"))
                .build();
        Hash hash = defaultHashService.computeHash(request);
        System.out.println(hash.toHex());
    }

    @Test
    public void testSecurityRandomGenerator(){
        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        generator.setSeed("123".getBytes());
        for (int i = 0; i < 5; i++) {
            String s = generator.nextBytes().toHex();
            System.out.println("hex: " + "[" + i + "]" + s);
        }
    }

    @Test
    public void testAES(){
        String text = "abc123";
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);
        Key key = aesCipherService.generateNewKey();
        String hex = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        System.out.println(hex);

        ByteSource decrypt = aesCipherService.decrypt(Hex.decode(hex), key.getEncoded());
        String s = new String(decrypt.getBytes());
        Assert.assertEquals(s, text);

    }
}
