package com.example.day_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.day_01.shape.Constants;
import com.example.day_01.shape.Shape;
import com.example.day_01.shape.ShapeFactory;
import com.example.day_01.templste.Cser;
import com.example.day_01.templste.Foodball;
import com.example.day_01.templste.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //单例使用
//        SingleInstance.getInstance().fun();

        //工厂模式
//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape shape1 = shapeFactory.getShape(Constants.CIRCLE);
//        shape1.draw();
//
//        Shape shape2 = shapeFactory.getShape(Constants.RECTANGLE);
//        shape2.draw();
//
//        Shape shape3 = shapeFactory.getShape(Constants.SQUARE);
//        shape3.draw();

        //模板模式
//        Game game = new Foodball();
//        game.play();
//
//        game = new Cser();
//        game.play();
        //创建
        Computer computerr = new Computer.Builder()
                .setColor(11)
                .setName("联想")
                .setPrice(9000)
                .setOs("红色")
                .build();

        Log.e("TAG", computerr.toString());
    }
}
