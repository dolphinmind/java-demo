package com.dolphinmind.generics;

import java.lang.reflect.Array;

public class GenericsArray<T> {
    private T[] arr;

    public GenericsArray(Class<T> clz, int length) {
       arr = (T[]) Array.newInstance(clz, length); //通过java.lang.reflect.Array.newInstance方法创建泛型数组
    }

    /**
     * 设置数组元素
     * @param index
     * @param item
     */
    public void put(int index, T item) {
        arr[index] = item;
    }

    /**
     * 获取数组元素
     * @param index
     * @return
     */
    public T get(int index) {
        return arr[index];
    }

    /**
     * 获取数组
     * @return
     */
    public T[] getArr() {
        return arr;
    }
}
