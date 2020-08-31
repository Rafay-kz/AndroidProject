package com.codewithkumar.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
private TextView instruct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpactivity);
        instruct= (TextView)  findViewById(R.id.instruction);
        instruct.setText("Tap On Screen for Fly a Fish...! \n You have 3 balls:  \n Yellow \n Green \n Red \n You have 3 Chances \n 1) If Fish hits a yellow Ball score will increased by 10. \n 2) If Fish hits a Green Ball score will increased by 20. \n 3) If Fish hits a Red Ball, it cause to destroy your life and if fish hits 3 times on Red ball \n          !...Your Game is Over...! .");

    }
}