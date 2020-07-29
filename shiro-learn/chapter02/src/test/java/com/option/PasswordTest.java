package com.option;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;

public class PasswordTest extends BaseTest {
    @Test
    public void testPasswordWithRealm(){
        login("classpath:shiro-passwordservice.ini", "wu", "123");
    }

    @Test
    public void testPasswordWithJdbc(){
        login("classpath:shiro-jdbc-passwordservice.ini", "wu", "123");
    }

    @Test
    public void testHashCredentialsMatcherWithMyRealm2(){
        login("classpath:shiro-hashedCredentialsMatcher.ini", "liu", "123");
    }

    @Test
    public void testHashedCredentialsMatcher(){
        BeanUtilsBean.getInstance().getConvertUtils().register(new EnumConverter(), JdbcRealm.SaltStyle.class);
        login("classpath:shiro-jdbc-hashedCredentialsMatcher.ini", "liu", "123");
    }

    @Test
    public void testGeneratedWithSalt(){
        String algorithmName = "md5";
        String username = "liu";
        String password = "123";
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;

        SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt2 + username, hashIterations);
        String s = simpleHash.toHex();
        System.out.println(s);
        System.out.println(salt2);
    }

    @Test(expected = ExcessiveAttemptsException.class)
    public void testExcessiveAttempt(){
        for (int i = 0; i < 5; i++) {
            try{
                login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "1234");
            } catch (Exception e){
            }
        }
        try{
            login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "1234");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private class EnumConverter extends AbstractConverter{

        @Override
        protected String convertToString(final Object value) throws Throwable{
            return ((Enum) value).name();
        }

        @Override
        protected Object convertToType(final Class type, final Object value) throws Throwable {
            return Enum.valueOf(type, value.toString());
        }

        protected Class getDefaultType() {
            return null;
        }
    }
}
