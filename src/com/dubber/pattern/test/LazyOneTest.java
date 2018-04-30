package com.dubber.pattern.test;

import com.dubber.pattern.lazy.LazyOne;

import java.lang.reflect.Constructor;

/**
 * Created by dubber on 2018/4/30.
 */
public class LazyOneTest {

    public static void main(String[] args) {
        try {
            Class clazz = LazyOne.class;

            // 通过反射得到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o = c.newInstance();
            Object o1 = c.newInstance();

            System.out.println(o);
            System.out.println(o1);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
