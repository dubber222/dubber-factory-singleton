package com.dubber.pattern.seriable;

import java.io.Serializable;

/**
 * Created by dubber on 2018/4/30.
 *
 *
 *
 */
public class Seriable implements Serializable {
    private Seriable() {
    }

    private static final Seriable INSTANCE = new Seriable();


    public static final Seriable getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
