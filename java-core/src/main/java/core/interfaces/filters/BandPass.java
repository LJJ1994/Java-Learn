package main.java.core.interfaces.filters;

import com.sun.media.sound.WaveFileReader;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:52:52
 * @Modified By:
 */
public class BandPass extends Filter {
    private double lowOff;
    private double highOff;
    BandPass(double l, double h){
        lowOff = l;
        highOff = h;
    }
    public Waveform process(Waveform input){
        return input;
    }
}
