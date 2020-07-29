package com.option.princical;

import com.option.BaseTest;
import org.apache.shiro.subject.PrincipalCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

public class PrincialCollectionTest extends BaseTest {
    @Test
    public void test(){
        login("classpath:shiro-multirealm.ini", "zhang", "123");
        Object principal = subject().getPrincipal();
        PrincipalCollection principals = subject().getPrincipals();
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        Assert.assertEquals(principal, primaryPrincipal);

        Set<String> realmNames = principals.getRealmNames();
        System.out.println(realmNames);

        Set set = principals.asSet();
        System.out.println(set);

        Collection c = principals.fromRealm("c");
        System.out.println(c);
    }
}
