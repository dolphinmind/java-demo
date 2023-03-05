package com.dolphinmind.generics;

import java.util.List;

class Eater {
    public void eat(List<? extends Food> foodList) {
        for(Food food: foodList) {
            food.taste();
        }
    }
}
