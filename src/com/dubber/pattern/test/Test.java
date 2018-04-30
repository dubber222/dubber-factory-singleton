package com.dubber.pattern.test;

import com.dubber.pattern.Register.ColorEnum;

/**
 * Created by dubber on 2018/4/30.
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(ColorEnum.Instance1.getInstance());
            System.out.println(ColorEnum.Instance2.getInstance());
        }
    }
}
