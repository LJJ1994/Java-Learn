package main.java.core.generics;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 23:33:33
 * @Modified By:
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    private int fic(int n){
        if(n < 2){
            return 1;
        }
        return fic(n-2) + fic(n - 1);
    }

    @Override
    public Integer next() {
        return fic(count++);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.println(fibonacci.next() + " ");
        }
    }
}
