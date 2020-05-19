package main.java.core.enumerated;

enum Test{
    A("yes a"),
    B("is b"),
    c("is c");
    private String desc;
    private Test(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return desc;
    }
}

public class EnumCons {
    public static void main(String[] args) {
        for (Test value : Test.values()) {
            System.out.println(value.getDesc());
        }
    }
}
