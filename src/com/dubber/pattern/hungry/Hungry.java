package com.dubber.pattern.hungry;

/**
 * Created by dubber on 2018/4/29.
 */


//优点：  线程安全，

//缺点：运行时分配内存空间，一直占用内存，造成内存浪费

public class Hungry {

    private Hungry() {
    }

    private static final Hungry hungry = new Hungry();

    // static 保证单例空间共享
    // final 方法不能被重写，重载。
    public final static Hungry getInstance() {
        return hungry;
    }
}
