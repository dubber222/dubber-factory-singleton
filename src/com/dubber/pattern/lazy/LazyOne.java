package com.dubber.pattern.lazy;

import com.dubber.pattern.hungry.Hungry;

/**
 * Created by dubber on 2018/4/29.
 */


// 懒汉式
// 动态加载，需要才加载，存在线程安全
public class LazyOne {

    /*private LazyOne() {
    }*/

    private static boolean initalized = false;
    private LazyOne(){
        synchronized (LazyOne.class){
            if(initalized == false){
                initalized = !initalized;
            }else{
                throw new RuntimeException("单例已被入侵！");
            }
        }
    }

    //静态块，公共内存区域
    private static LazyOne lazyOne = null;

    // static 保证单例空间共享
    // final 方法不能被重写，重载。

    // synchronized 可以保证线程安全，但耗时比较多
    public static final LazyOne getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }
        return lazyOne;
    }
}
