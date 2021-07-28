package com.designpatterns;

import com.designpatterns.singleton.lazyholder.AClazz;
import com.designpatterns.singleton.lazyholder.BClazz;
import com.designpatterns.singleton.lazyholder.Singleton;

public class Main {

    public static void main(String[] args) {

        /*

        TestAClazz testAClazz = new TestAClazz();
        TestBClazz testBClazz = new TestBClazz();

        SocketClient aClient = testAClazz.getSocketClient();
        SocketClient bClient = testBClazz.getSocketClient();

        */

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        Singleton aClient = aClazz.getSingleton();
        Singleton bClient = bClazz.getSingleton();


        System.out.println(aClient.equals(bClient));
    }
}
