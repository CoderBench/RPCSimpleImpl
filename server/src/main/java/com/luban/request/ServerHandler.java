package com.luban.request;

import com.luban.info.RpcInfo;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ServerHandler implements Runnable{

    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcInfo rpcInfo = (RpcInfo) objectInputStream.readObject();
            Class clazz = Class.forName(rpcInfo.getPackagename() + "." + rpcInfo.getClassName());
            Class[] classes = new Class[rpcInfo.getParame().length];
            for (int i = 0; i < classes.length; i++) {
                 classes[i] = rpcInfo.getParame()[i].getClass();
            }
            Method method = clazz.getMethod(rpcInfo.getMethodName(),classes);
            method.invoke(clazz.newInstance(),rpcInfo.getParame());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
