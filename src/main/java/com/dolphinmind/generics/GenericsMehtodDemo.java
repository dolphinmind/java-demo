package com.dolphinmind.generics;

public class GenericsMehtodDemo {
    /**
     * The type parameter T is inserted after the modifier public and before the return type void
     * @param data
     * @param <T>
     */
    public <T> void genericMethod(T data) {
        System.out.println("Generics Method: ");
        System.out.println(data);
    }
}
