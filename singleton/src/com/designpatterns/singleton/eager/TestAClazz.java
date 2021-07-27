package com.designpatterns.singleton.eager;

public class TestAClazz {

    private SocketClient socketClient;

    public TestAClazz() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
