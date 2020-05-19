package main.java.core.concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-07 13:24:24
 * @Modified By:
 */
class Car{
    private final int id;
    private boolean engine = false;
    private boolean driveTrain = false;
    private boolean wheels = false;

    public int Car(){
        return -1;
    }

    public Car(int idx){
        id = idx;
    }

    public synchronized int getId(){
        return id;
    }

    public synchronized void addEngine(){
        engine = true;
    }

    public synchronized void addDriveTrain(){
        driveTrain = true;
    }

    public synchronized void addWheels(){
        wheels = true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", engine=" + engine +
                ", driveTrain=" + driveTrain +
                ", wheels=" + wheels +
                '}';
    }
}

class CarQueue extends LinkedBlockingQueue<Car>{}

/**
 * 底盘构建
 */
class ChassisBuilder implements Runnable{
    private int counter = 0;
    private CarQueue carQueue;

    public ChassisBuilder(CarQueue carQueue){
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                Car car = new Car(counter++);
                System.out.println("create chassis...");
                carQueue.put(car);
            }
        } catch (InterruptedException e){
            System.out.println("ChassisBuilder interrupted.");
        }
    }
}

/**
 * 组装汽车
 */
class Assembler implements Runnable{
    private CarQueue chassisQueue;
    private CarQueue finishedQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool pool;

    public Car car(){
        return car;
    }

    public CyclicBarrier barrier(){
        return barrier;
    }

    public Assembler(CarQueue cq, CarQueue fq, RobotPool p){
        chassisQueue = cq;
        finishedQueue = fq;
        pool = p;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                // 阻塞直到组装底盘可用
                car = chassisQueue.take();
                // 雇佣机器干活
                pool.hire(EngineRobot.class, this);
                pool.hire(DriveTrainRobot.class, this);
                pool.hire(WheelsRobot.class, this);
                barrier.await(); // 等待所有任务完成
                finishedQueue.put(car); // 完成队列
            }
        } catch (InterruptedException e){
            System.out.println("Existing Assembler via interrupted.");
        } catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off!");
    }
}

class Reporter implements Runnable{
    private CarQueue carQueue;

    public Reporter(CarQueue c){
        carQueue = c;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Car take = carQueue.take();
                System.out.println(take);
            }
        } catch (InterruptedException e){
            System.out.println("Existing Reporter via Interrupted!");
        }
    }
}

abstract class Robot implements Runnable{
    private RobotPool pool;
    protected Assembler assembler;
    private boolean engage = false;

    public synchronized void engage(){
        engage = true;
        notifyAll();
    }

    public Robot assignAssembler(Assembler a){
        assembler = a;
        return this;
    }

    public Robot(RobotPool p){
        pool = p;
    }

    //停止机器人
    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null;
        pool.release(this);
        while (engage == false){
            wait();
        }
    }

    public void run(){
        try{
            powerDown(); // 等待直到有需要
            while (!Thread.interrupted()){
                performService();
                assembler.barrier().await(); //同步
                // 完成工作
                powerDown();
            }
        } catch (InterruptedException e){
            System.out.println("Exiting " + this + " via interrupted!");
        } catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        System.out.println(this + " off!");
    }

    abstract protected void performService();

    public String toString(){
        return getClass().getName();
    }
}

class EngineRobot extends Robot{
    public EngineRobot(RobotPool p){
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing.....");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot{
    public DriveTrainRobot(RobotPool p){
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing.....");
        assembler.car().addDriveTrain();
    }
}

class WheelsRobot extends Robot{
    public WheelsRobot(RobotPool p){
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing.....");
        assembler.car().addWheels();
    }
}

class RobotPool{
    private Set<Robot> pool = new HashSet<>();
    public synchronized void add(Robot r){
        pool.add(r);
        notifyAll();
    }
    public synchronized void release(Robot r){
        add(r);
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException{
        for (Robot robot : pool) {
            //如果对象池有该机器，则启动，并链接到相应的组装机
            if(robot.getClass().equals(robotType)){
                pool.remove(robot);
                robot.assignAssembler(d);
                robot.engage();
                return;
            }
        }
        wait();//没有则等待
        hire(robotType, d); // 递归查询
    }
}

public class CarBuilder {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        CarQueue chassisQueue = new CarQueue();
        CarQueue finishedQueue = new CarQueue();
        executorService.execute(new EngineRobot(robotPool));
        executorService.execute(new DriveTrainRobot(robotPool));
        executorService.execute(new WheelsRobot(robotPool));
        executorService.execute(new Assembler(chassisQueue, finishedQueue, robotPool));
        executorService.execute(new Reporter(finishedQueue));
        executorService.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.MILLISECONDS.sleep(7000);
        executorService.shutdownNow();
    }
}
