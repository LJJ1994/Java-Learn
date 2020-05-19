package main.java.core.innerclasses;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 15:32:32
 * @Modified By:
 */
public class Parcel9 {
    public Destination destination(final String des){
        return new Destination() {
            private String label = des;
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination home = parcel9.destination("home");
        System.out.println(home.readLabel());
    }
}
