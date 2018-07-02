package com.issac.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * author:  ywy
 * date:  2018-07-02
 * desc:
 *
 */
public class MapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getName());

        return null;
    }
}