package com.dubber.pattern.test;

import com.dubber.pattern.seriable.Seriable;

import java.io.*;

/**
 * Created by dubber on 2018/4/30.
 */
public class SeriableTest {

    public static void main(String[] args) {


        Seriable seriable1 = Seriable.getInstance();
        Seriable seriable2 = null;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/Seriavle.obj"));
            oos.writeObject(seriable1);
            oos.flush();
            oos.close();

            Thread.sleep(3*1000);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/Seriavle.obj"));
            seriable2 = (Seriable) ois.readObject();
            ois.close();


            System.out.println(seriable1);
            System.out.println(seriable2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
