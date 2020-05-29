package com.example.day_01.templste;

import android.util.Log;

public class Foodball extends Game {
    @Override
    void startGame() {
        Log.e("TAG", "startGame()");
    }

    @Override
    void endGame() {
        Log.e("TAG", "endGame()");
    }

    @Override
    void initialize() {
        Log.e("TAG", "initialize()");
    }
}
