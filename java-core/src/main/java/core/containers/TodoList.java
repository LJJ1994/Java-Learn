package main.java.core.containers;

import java.nio.charset.Charset;
import java.util.PriorityQueue;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 22:51:51
 * @Modified By:
 */
public class TodoList extends PriorityQueue<TodoList.TodoItem> {
    static class TodoItem implements Comparable<TodoItem>{
        private char primary;
        private int secondary;
        private String item;
        public TodoItem(String item, char primary, int secondary){
            this.item = item;
            this.primary = primary;
            this.secondary = secondary;
        }

        @Override
        public int compareTo(TodoItem arg) {
            if(primary > arg.primary){
                return +1;
            }
            if (primary == arg.primary){
                if (secondary > arg.secondary){
                    return +1;
                }else if (secondary == arg.secondary){
                    return 0;
                } else{
                    return -1;
                }
            }
            return -1;
        }

        public String toString(){
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public void add(String td, char pri, int sec){
        add(new TodoItem(td, pri, sec));
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.add("Empty", 'C', 4);
        todoList.add("Feed dog", 'A', 2);
        todoList.add("Feed bird", 'B', 7);
        todoList.add("Mom lawn", 'C', 3);
        todoList.add("Water lawn", 'A', 1);
        todoList.add("Feed cat", 'B', 1);
        while (!todoList.isEmpty()){
            System.out.println(todoList.remove());
        }
    }
}
