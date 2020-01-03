package com.luban.info;

import java.io.Serializable;

public class RpcInfo implements Serializable{
    private static final long serialVersionUID = 2502303765264266278L;
    private String packagename;
    private String className;
    private String methodName;
    private Object[] parame;

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParame() {
        return parame;
    }

    public void setParame(Object[] parame) {
        this.parame = parame;
    }
}
