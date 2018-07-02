package com.issac.homework;

import java.lang.reflect.Proxy;

/**
 *
 * author:  ywy
 * date:  2018-07-02
 * desc:
 *
 */
public class SqlSession {
    public <T> T getMapper(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MapperProxy());
    }
}