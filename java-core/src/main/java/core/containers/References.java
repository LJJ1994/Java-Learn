package main.java.core.containers;

import java.lang.ref.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-27 09:28:28
 * @Modified By:
 */
class VeryBig{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id){
        ident = id;
    }
    public String toString(){return ident;}
    protected void finalize(){
        System.out.println("Finalizing " + ident);;
    }
}

public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
    public static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null){
            System.out.println("In queue" + inq.get());
        }
    }

    public static void main(String[] args) {
        int size = 10;
//        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));
//            System.out.println("Just created " + sa.getLast());
//            checkQueue();
//        }
//
//        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));
//            System.out.println("Just created " + wa.getLast());
//            checkQueue();
//        }

        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak"));
        System.gc();
        LinkedList<PhantomReference<VeryBig>> ph = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            ph.add(new PhantomReference<>(new VeryBig("Phantom " + i), rq));
            System.out.println("Just created " + ph.getLast());
            checkQueue();
        }
    }
}
