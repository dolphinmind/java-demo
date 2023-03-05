package com.dolphinmind.generics;

/**
 * This class can be used to work with any type of data.
 * @param <T>
 *     T : Type Parameter
 */
public class GenericsClass<T>{
    private T data;

    public GenericsClass(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
