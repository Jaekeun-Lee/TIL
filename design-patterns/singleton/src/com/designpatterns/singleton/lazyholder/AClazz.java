package com.designpatterns.singleton.lazyholder;


public class AClazz {

    private Singleton singleton;

    public AClazz() {
        this.singleton = Singleton.getInstance();
    }

    public Singleton getSingleton() {
        return this.singleton;
    }
}
