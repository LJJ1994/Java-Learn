package main.java.core.interfaces.filters;

import main.java.core.interfaces.Apply;
import main.java.core.interfaces.Processor;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description: 适配器模式
 * @Create: 2020-04-12 19:08:08
 * @Modified By:
 */
class FilterAdapter implements Processor {
    private Filter filter;

    public FilterAdapter(Filter f){
        filter = f;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input); // 代理
    }
}

public class FilterProcessor{
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 10.0)), w);
    }
}