package com.luban.test;

import com.luban.dao.UserDaolmpl;
import com.luban.info.RpcInfo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {
        UserDaolmpl userDao = new UserDaolmpl();
        userDao.login("歪歪");

        RpcInfo rpcInfo = new RpcInfo();
        rpcInfo.setPackagename("com.luban.dao");
        rpcInfo.setClassName("OrderDaolmpl");
        rpcInfo.setMethodName("queryOrder");
        Object[] parame = new Object[]{"歪歪"};
        rpcInfo.setParame(parame);

        Socket socket = new Socket("127.0.0.1",6666);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(rpcInfo);
        objectOutputStream.flush();
        objectOutputStream.close();

    }
}
