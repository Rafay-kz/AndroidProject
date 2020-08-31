package com.codewithkumar.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private FlyingFishView gameview;
private Handler handler= new Handler();
private final static long interval =30;

private CommonMethod player=new CommonMethod();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player.CommonMethod(this,R.raw.sound);



      gameview = new FlyingFishView(this);
      setContentView(gameview);
      Timer timer =new Timer();
      timer.schedule(new TimerTask() {
          @Override
          public void run() {

              handler.post(new Runnable() {
                  @Override
                  public void run() {
                      gameview.invalidate();
                  }
              });
          }
      }, 0 ,interval);

    }

}