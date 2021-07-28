package com.designpatterns.singleton.lazyholder;


public class BClazz {

    private Singleton singleton;

    public BClazz() {
        this.singleton = Singleton.getInstance();
    }

    public Singleton getSingleton() {
        return this.singleton;
    }

}
