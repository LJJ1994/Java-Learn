package main.java.core.concurrency;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 03:25:25
 * @Modified By:
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    public void canceled(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }
}
