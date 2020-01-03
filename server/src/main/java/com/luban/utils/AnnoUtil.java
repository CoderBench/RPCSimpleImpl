package com.luban.utils;

import com.luban.anno.RpcClazz;
import com.luban.anno.RpcMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnoUtil {

    public static Map<String,List<Map<String,List<String>>>> paraseAnno(String packageName) throws Exception {
        Map<String,List<Map<String,List<String>>>> map = new HashMap<String, List<Map<String, List<String>>>>();
        String basePath = AnnoUtil.class.getResource("/").getPath();
        basePath = basePath.replace("%"," ");
        String packagePath = packageName.replace(".", "/");
        File file = new File("D:\\IDEA\\IntelliJ IDEA 2017.3.7\\project\\server\\target\\classes\\com\\luban\\dao");
        String[] names = file.list();
        for (String name : names){
            name = name.replaceAll(".class","");
            Class clazz = Class.forName(packageName + "." + name);
            if (clazz.isAnnotationPresent(RpcClazz.class)) {
                Method[] methods = clazz.getDeclaredMethods();
                List<Map<String,List<String>>> methodsInfo = new ArrayList<Map<String, List<String>>>();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(RpcMethod.class)) {
                        Map<String,List<String>> methodInfo = new HashMap<String, List<String>>();
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        List<String> paramesInfo = new ArrayList<String>();
                        for (Class<?> parameterType : parameterTypes) {
                            paramesInfo.add(parameterType.getSimpleName());
                        }
                        methodInfo.put(method.getName(),paramesInfo);
                        methodsInfo.add(methodInfo);
                    }
                }
                map.put(packageName+"."+name,methodsInfo);
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(AnnoUtil.paraseAnno("com.luban.dao"));
    }

}
