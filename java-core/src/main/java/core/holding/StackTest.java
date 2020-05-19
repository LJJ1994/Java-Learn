package main.java.core.holding;

import net.mindview.util.Stack;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 16:18:18
 * @Modified By:
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "my dog has gone!".split(" ")) {
            stack.push(s);
        }
        while (!stack.empty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
