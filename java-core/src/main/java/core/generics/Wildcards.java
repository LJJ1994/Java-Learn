package main.java.core.generics;

import java.util.Objects;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 07:53:53
 * @Modified By:
 */
public class Wildcards {
    static void rawArgs(Holder holder, Objects args){
        holder.set(args);
        holder.set(new Wildcards());
        Object o = holder.get();// 类型信息缺失
    }

    static void unboundingArgs(Holder<?> holder, Objects args){
//        holder.set(args);
//        T t = holder.get();
        Object o = holder.get();
    }

    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }

    static <T> T excact2(Holder<T> holder, T args){
        holder.set(args);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubcards(Holder<? extends T> holder, T args){
//        holder.set(args);
        T t = holder.get();
        return t;
    }

    static <T> void wildSupercards(Holder<? super T> holder, T args){
        holder.set(args);
//        T t = holder.get();
        Object object = holder.get();

    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounding = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();

        Long lng = 1L;
//        rawArgs(raw, lng);
//        rawArgs(qualified, lng);
//        rawArgs(unbounding, lng);
//        rawArgs(bounded, lng);
//
//        unboundingArgs(raw, lng);
//        unboundingArgs(qualified, lng);
//        unboundingArgs(bounded, lng);
//        unboundingArgs(unbounding, lng);

        exact1(raw);
        Long aLong = exact1(qualified);
        Object o = exact1(unbounding);
        Long aLong1 = exact1(bounded);

        Long aLong2 = excact2(raw, lng);
        Long aLong3 = excact2(qualified, lng);
//        excact2(unbounding, lng);
//        excact2(bounded, lng);
        wildSubcards(raw, lng);
        Long aLong4 = wildSubcards(qualified, lng);
        Object o1 = wildSubcards(unbounding, lng);
        Long aLong5 = wildSubcards(bounded, lng);

        wildSupercards(raw, lng);
        wildSupercards(qualified, lng);
//        wildSupercards(unbounding, lng); error
//        wildSupercards(bounded, lng);
    }
}
