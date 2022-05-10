package com.example.bujiandonghua;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv=findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过加载xml文件来设置动画
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                Animation animation = AnimationUtils.loadAnimation(MainActivity1.this, R.anim.scale);

                iv.startAnimation(animation);
            }
        });
    }
}