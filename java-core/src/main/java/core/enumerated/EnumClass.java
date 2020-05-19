package main.java.core.enumerated;
import static net.mindview.util.Print.*;

enum Letters{
    A,
    B,
    C
}
public class EnumClass {
    public static void main(String[] args) {
        for (Letters value : Letters.values()) {
//            System.out.print(value + ", ");
            System.out.print(value.ordinal());
        }
    }
}
