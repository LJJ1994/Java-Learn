package main.java.core.enumerated;

import net.mindview.util.Enums;

import java.util.EnumSet;

public enum SecurityCategory {
    STOCK(Security.STOCK.class), BOND(Security.BOND.class);
    private Security[] values;
    private SecurityCategory(Class<? extends Security> kind){
        values = kind.getEnumConstants();
    }

    interface Security{
        enum STOCK implements Security{SHORT, LONG, MARGE}
        enum BOND implements Security{MUNICIPAL, JUNK}
    }

    public Security randomSelector(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory random = Enums.random(SecurityCategory.class);
            System.out.println(random + ": " + random.randomSelector());
        }
    }
}
