package com.codewithkumar.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class Splash2 extends AppCompatActivity {
Animation top, bottom;
ImageView fish;
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        final MediaPlayer player = MediaPlayer.create(this, R.raw.fsplash);
        player.start();
        top= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        fish=findViewById(R.id.imageView);
        t=findViewById(R.id.textview1);
      fish.setAnimation(top);
      t.setAnimation(bottom);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent mainI = new Intent(Splash2.this, SplashActivity .class);
                    startActivity(mainI);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}