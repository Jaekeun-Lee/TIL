package com.designpatterns.singleton.eager;

public class TestBClazz {

    private SocketClient socketClient;

    public TestBClazz() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
