package com.luban.dao;

import com.luban.anno.RpcClazz;
import com.luban.anno.RpcMethod;

@RpcClazz
public class OrderDaolmpl {
    @RpcMethod
    public void queryOrder(String name){
        System.out.println("query success name =" + name);
    }

    public void queryOrder2(String name){
        System.out.println("query success name =" + name);
    }
}
