package com.option;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private short areaCode;
    private short prefix;
    private short lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = randomCheck(areaCode, 99, "areaCode");
        this.prefix = randomCheck(prefix, 999, "prefix");
        this.lineNum = randomCheck(lineNum, 999, "lineNum");
    }

    private short randomCheck(int val, int max, String args) {
        if (val < 0 || val > max) {
            throw new RuntimeException("Invalid args: " + args);
        }
        return (short) val;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber obj = (PhoneNumber) o;
        return obj.areaCode == areaCode && obj.lineNum == lineNum && obj.prefix == prefix;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.areaCode, this.lineNum, this.prefix);
    }

    public static void main(String[] args) {
        short areaCode01 = 10;
        short prefix01 = 20;
        short lineNum01 = 30;
        PhoneNumber phoneNumber01 = new PhoneNumber(areaCode01, prefix01, lineNum01);

        short areaCode02 = 10;
        short prefix02 = 20;
        short lineNum02 = 30;
        PhoneNumber phoneNumber02 = new PhoneNumber(areaCode02, prefix02, lineNum02);

        System.out.println(phoneNumber01.equals(phoneNumber02));

        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumbers.add(phoneNumber01);
        phoneNumbers.add(phoneNumber02);

        System.out.println(phoneNumbers.size());

        System.out.println("phoneNumber01 hashCode: " + phoneNumber01.hashCode());
        System.out.println("phoneNumber02 hashCode: " + phoneNumber02.hashCode());

    }

    @Override
    public int compareTo(PhoneNumber o) {
        int result = Short.compare(o.areaCode, areaCode);
        if (result == 0) {
            result = Short.compare(o.prefix, prefix);
            if (result == 0) {
                result = Short.compare(o.lineNum, lineNum);
            }
        }
        return result;
    }
}
