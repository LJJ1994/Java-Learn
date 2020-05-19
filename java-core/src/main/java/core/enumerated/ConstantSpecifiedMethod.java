package main.java.core.enumerated;

import java.text.DateFormat;
import java.util.Date;

public enum  ConstantSpecifiedMethod {
    DATE_TIME{
      String getInfo(){
          return DateFormat.getDateInstance().format(new Date());
      }
    },
    CLASSPATH{
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecifiedMethod value : values()) {
            System.out.println(value.getInfo());
        }
    }
}
