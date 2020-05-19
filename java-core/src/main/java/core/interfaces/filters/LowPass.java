package main.java.core.interfaces.filters;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:50:50
 * @Modified By:
 */
public class LowPass extends Filter {
    private double cutoff;
    LowPass(double c){
        cutoff = c;
    }
    public Waveform process(Waveform input){
        return input;
    }
}
