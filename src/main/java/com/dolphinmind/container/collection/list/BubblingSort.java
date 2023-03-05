package com.dolphinmind.container.collection.list;

import java.util.Random;

/**
 * 冒泡排序的实现
 */
public class BubblingSort {
    public static void main(String[] args) {


    }

    /**
     * 普通数组的冒泡排序实现
     */
    public static void demo1() {
        Random random = new Random();

        //1. 普通Array
        int[] x = {1,3,54654,354,43546,6876,5465};
        int temp;
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if(x[i] < x[j]) {
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
        for (int obj : x) {
            System.out.println(obj);
        }

    }}
