package main.java.core.concurrency;

import java.util.concurrent.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 13:17:17
 * @Modified By:
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {


    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }
}
