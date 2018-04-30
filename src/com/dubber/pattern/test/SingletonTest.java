package com.dubber.pattern.test;

import com.dubber.pattern.Register.FactoryBean;
import com.dubber.pattern.hungry.Hungry;
import com.dubber.pattern.lazy.LazyOne;
import com.dubber.pattern.lazy.LazyThree;
import com.dubber.pattern.lazy.LazyTwo;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dubber on 2018/4/29.
 */
public class SingletonTest {

    public static void main(String[] args) {

       /* long startt =  System.currentTimeMillis();
        for (int i = 0; i<=1000000;i++){
            LazyOne lazyOne = LazyOne.getInstance();
        }
        long endt =  System.currentTimeMillis();
        System.out.println("耗时：" + Long.toString(endt-startt));*/

        tetCountDownLatch();
    }


    //使用发令枪  CountDownLatch  万箭齐发
    public static void tetCountDownLatch() {

        final int count = 200;
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        long startt = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {

            new Thread(){
                @Override
                public void run(){

                    try {
                        //阻塞，
                        // countDownLatch == 0 就释放共享锁
                        countDownLatch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Object obj = Hungry.getInstance();
                    //Object obj = LazyOne.getInstance();
                    //Object obj = LazyTwo.getInstance();
                    //Object obj = LazyThree.getInstance();
                    Object obj = FactoryBean.getBean("com.dubber.pattern.lazy.Pojo");

                    System.out.println(System.currentTimeMillis() + ":" + obj);
                }
            }.start();
            //每循环一次，就启动一个线程

            //没启动一个线程 countDownlatch --
            countDownLatch.countDown();
        }
        long endt = System.currentTimeMillis();
        System.out.println("耗时：" + Long.toString(endt - startt));
    }
}
