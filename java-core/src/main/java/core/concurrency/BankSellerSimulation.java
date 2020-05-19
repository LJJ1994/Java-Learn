package main.java.core.concurrency;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-07 10:51:51
 * @Modified By:
 */

/**
 * 顾客
 */
class Customer{
    private final int serviceTime;
    public Customer(int sm){
        serviceTime = sm;
    }

    public int getServiceTime(){
        return serviceTime;
    }

    public String toString(){
        return "[" + serviceTime + "]";
    }
}

/**
 * 讲顾客排成一行
 */
class CustomerLine extends ArrayBlockingQueue<Customer>{

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString(){
        if(this.size() == 0) {
            return "[empty]";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : this) {
            result.append(customer);
        }
        return result.toString();
    }
}

/**
 * 顾客生成器
 */
class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine customerLine){
        customers = customerLine;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(300);
                customers.add(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e){
            System.out.println("CustomerGenerator Interrupted.");
        }
        System.out.println("CustomerGenerator terminated.");
    }
}

/**
 * 银行出纳员
 */
class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    private final int id = counter++;
    private int customersServed = 0; // 服务人数
    private CustomerLine customers;
    private boolean servingCustomerLine = true; // 正在服务顾客

    public Teller(CustomerLine cl){
        customers = cl;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Customer customer = null;
                try {
                    customer = customers.take();
                    TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(this + " interrupted!");
                }
                synchronized (this){
                    customersServed++;
                    while (!servingCustomerLine){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(this + " interrupted!");
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this + " terminated!");
    }

    public synchronized void doSomeThingElse(){
        customersServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine(){
        assert !servingCustomerLine: "already serving " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    public synchronized int compareTo(Teller other){
        return customersServed < other.customersServed ? -1 :
                (customersServed == other.customersServed ? 0 : 1);
    }

    public String toString(){
        return "Teller" + id + " ";
    }

    public String shortString(){
        return "T " + id;
    }
}

/**
 * 银行经理
 */
class TellerManager implements Runnable{
    private ExecutorService exc;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);

    public TellerManager(ExecutorService e, CustomerLine c, int ad){
        exc = e;
        customers = c;
        adjustmentPeriod = ad;
        // 开始一个出纳员
        Teller teller = new Teller(customers);
        exc.execute(teller);
        workingTellers.add(teller);
    }

    /**
     * 调整出纳员数量
     */
    public void adjustTellerNumber(){
        //1. 如果排队人数过多，添加出纳员
        if(customers.size() / workingTellers.size() > 2){
            //如果出纳员正在休息或者做其他的事儿
            if(tellersDoingOtherThings.size() > 0){
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
            }
            //否则创建一个新的出纳员
            Teller teller = new Teller(customers);
            exc.execute(teller);
            workingTellers.add(teller);
        }
        //2.如果排队人数过少，则移除出纳员
        if(workingTellers.size() > 1 && (customers.size() / workingTellers.size() < 2)){
            this.reassignOneTeller();
        }
        //3.如果没有人排队，则只需要一个出纳员负责工作即可
        if(customers.size() == 0){
            while (workingTellers.size() > 1){
                this.reassignOneTeller();
            }
        }
    }

    /**
     * 给出纳员不同的工作或者休息
     */
    private void reassignOneTeller(){
        Teller teller = workingTellers.poll();
        assert teller != null;
        teller.doSomeThingElse();
        tellersDoingOtherThings.offer(teller);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            adjustTellerNumber();
            System.out.println(customers + " { ");
            for (Teller teller : workingTellers) {
                System.out.println(teller.shortString());
            }
            System.out.println(" } ");
            System.out.println(this + "terminating");
        }
    }

    public String toString(){
        return "TellerManager: ";
    }
}

public class BankSellerSimulation {
    static final int MAX_SIZE = 10;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_SIZE);
        executorService.execute(new CustomerGenerator(customers));
        executorService.execute(new TellerManager(executorService, customers, ADJUSTMENT_PERIOD));
//        executorService.shutdownNow();
    }
}
