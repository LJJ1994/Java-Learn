package main.java.core.containers;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 19:40:40
 * @Modified By:
 */
public class Unsupported {
    static void test(String msg, List<String> list){
        System.out.println("-----" + msg + "------------");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1,8);
        Collection<String> c2 = new ArrayList<>(subList);

        try{
            c.retainAll(c2);
        } catch (Exception e){
            System.out.println("retainAll(): " + e);
        }
        try{
            c.removeAll(c2);
        } catch (Exception e){
            System.out.println("removeAll(): " +e);
        }

        try{
            c.clear();
        } catch (Exception e){
            System.out.println("clear(): " + e);
        }

        try{
            c.addAll(c2);
        } catch(Exception e){
            System.out.println("addAll(): " + e);
        }
        try{
            c.remove("C");
        }catch (Exception e){
            System.out.println("remove(): " + e);
        }
        try{
            list.set(0, "X");
        } catch (Exception e){
            System.out.println("set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));

        test("Modifiable copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("unmodifiedList()", Collections.unmodifiableList(list));
    }
}
