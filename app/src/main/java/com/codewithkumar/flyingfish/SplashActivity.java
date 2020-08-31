package com.codewithkumar.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {
    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final MediaPlayer player = MediaPlayer.create(this, R.raw.bmusic);
        player.setLooping(true);
        player.start();
        button=(Button) findViewById(R.id.startbtn);
         button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
           player.pause();
            OpenActivity();

        }
    });
        button2=(Button) findViewById(R.id.helpbtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenActivity2();

            }
        });
}
public void OpenActivity() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);

}
    public void OpenActivity2() {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);

    }
}