package main.java.core.interfaces.filters;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:51:51
 * @Modified By:
 */
public class HighPass extends Filter {
    private double cutoff;
    HighPass(double c){
        cutoff = c;
    }
    public Waveform process(Waveform input){
        return input;
    }
}
