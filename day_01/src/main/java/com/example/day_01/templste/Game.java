package com.example.day_01.templste;

public abstract class Game {
    abstract void initialize();

    abstract void startGame();

    abstract void endGame();

    //执行方式-模板
    public void play() {
        initialize();

        startGame();

        endGame();
    }
}
