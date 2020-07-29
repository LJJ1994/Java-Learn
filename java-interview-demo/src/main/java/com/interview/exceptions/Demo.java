package com.interview.exceptions;

public class Demo {
    public static void main(String[] args) {
        System.out.println(getInt());
    }
    public static int getInt(){
        int a = 10;
        try{
            System.out.println(a/0);
            a  = 20;
        } catch (Exception e){
            e.printStackTrace();
            a = 30;
            return a;
        } finally {
            a = 40;
            return a;
        }
    }
}
