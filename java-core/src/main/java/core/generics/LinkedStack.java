package main.java.core.generics;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 22:49:49
 * @Modified By:
 */
public class LinkedStack<T> {
    private static class Node<U>{
        private U item;
        private Node<U> next;
        Node(){
            item = null;
            next = null;
        }
        Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){
            return item == null && next == null;
        }
    }
    // 栈顶哨兵
    private Node<T> top = new Node<>();
    public void push(T item){
        top = new Node<>(item, top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        for(String s : "go home my sun".split(" ")){
            stack.push(s);
        }
        String s;
        while ((s = stack.pop()) != null){
            System.out.println(s);
        }
    }

}
