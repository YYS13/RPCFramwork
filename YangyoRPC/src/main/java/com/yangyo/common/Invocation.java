package com.yangyo.common;

import java.io.Serializable;

//訊息傳遞內容 class
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Class[] parametersTypes;
    private Object[] parameters;

    public Invocation(String interfaceName, String methodName, Class[] parametersTypes, Object[] parameters){
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parametersTypes = parametersTypes;
        this.parameters = parameters;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParametersTypes() {
        return parametersTypes;
    }

    public void setParametersTypes(Class[] parametersTypes) {
        this.parametersTypes = parametersTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
