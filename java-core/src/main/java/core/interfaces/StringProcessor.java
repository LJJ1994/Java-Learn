package main.java.core.interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:57:57
 * @Modified By:
 */
public abstract class StringProcessor implements Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    private final static String s = "Hello world! Everybody will be good!";
    public static void main(String[] args) {
        Apply.process(new UpCase(), s);
        Apply.process(new LowCase(), s);
        Apply.process(new SplitCase(), s);
    }
}

class UpCase extends StringProcessor{

    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LowCase extends StringProcessor{

    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class SplitCase extends StringProcessor{

    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
