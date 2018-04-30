package com.dubber.pattern.Register;

/**
 * Created by dubber on 2018/4/30.
 */

import com.dubber.pattern.lazy.LazyTwo;

/**
 * 枚举 常量：常量就是为了让大家可以共用；  单例模式是让实例共享，so  嘿嘿嘿，，
 */
public enum ColorEnum {

    Instance1,Instance2;

    private A instance;

    ColorEnum(){
        instance = new A();
    }

    public A getInstance(){
        return instance;
    }

}

class A{

}
