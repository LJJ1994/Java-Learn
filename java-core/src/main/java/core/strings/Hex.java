package main.java.core.strings;

import net.mindview.util.BinaryFile;

import java.io.IOException;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-15 23:59:59
 * @Modified By:
 */
public class Hex {
    public static String format(byte[] data){
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data){
            if(n % 16 == 0){
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X", b));
            n++;
            if(n % 16 == 0){
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(format(BinaryFile.read("E:\\program\\java\\Java-Learn\\java-core\\out\\production\\java-thinking\\main\\java\\core\\strings\\HEX.class")));
    }
}
