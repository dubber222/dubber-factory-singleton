package com.dubber.pattern.Register;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dubber on 2018/4/30.
 */

/**
 * spring 中使用到的单例模式
 */


public class FactoryBean {

    //线程安全？ 然而并不是安全的。 fuck!!

    //其实，还是使用饿汉模式，初始化把实例对象放进map,通过入参类路径名，判断map中是否有此类对象。

    //下面都是老师胡扯……
    private static ConcurrentHashMap ioc = new ConcurrentHashMap();

    public static Object getBean(String className) {
        Object obj = null;
        if(ioc.contains(className)){
            obj = ioc.get(className);
        }else{
            try {
                obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return obj;
    }

}
