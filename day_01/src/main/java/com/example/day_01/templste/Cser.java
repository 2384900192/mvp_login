package com.example.day_01.templste;

import android.util.Log;

public class Cser extends Game{
    @Override
    void initialize() {
        Log.e("TAG", "initialize()");
    }

    @Override
    void startGame() {
        Log.e("TAG", "startGame()");
    }

    @Override
    void endGame() {
        Log.e("TAG", "endGame()");
    }
}
