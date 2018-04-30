package com.dubber.pattern.lazy;

/**
 * Created by dubber on 2018/4/29.
 */

/**
 * 内部类单例模式
 * 这种形式兼顾了恶汉模式的内存浪费，也兼顾了懒汉模式synchronized性能问题。
 * 完美的屏蔽了这两个缺点。
 */
public class LazyThree {

    private LazyThree() {
    }

    public final static LazyThree getInstance(){

        //再返回结果以前一定会先加载内部类
        return LazyHolder.LAZY;
    }


    // 默认不加载
    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();
    }
}

