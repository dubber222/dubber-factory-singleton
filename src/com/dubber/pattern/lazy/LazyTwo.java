package com.dubber.pattern.lazy;

/**
 * Created by dubber on 2018/4/29.
 */
public class LazyTwo {

    private LazyTwo() {
    }

    /**
     * 静态块，公共内存区域
     */
    private static LazyTwo lazyTwo = null;

    /**
     * @return static 保证单例空间共享
     * final 方法不能被重写，重载。
     * synchronized 可以保证线程安全，但耗时比较多
     */
    public static final synchronized LazyTwo getInstance() {
        if (lazyTwo == null) {
            lazyTwo = new LazyTwo();
        }
        return lazyTwo;
    }
}
