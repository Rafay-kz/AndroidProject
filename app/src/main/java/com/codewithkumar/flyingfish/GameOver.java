package com.codewithkumar.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameOver extends AppCompatActivity {
    private Button startagain;
    private TextView tscore,hscore;
    private String  score;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
   DatabaseHelper db1;
   MainActivity f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover_avtivity);

        MediaPlayer player =MediaPlayer.create(this, R.raw.gameoversound);
        player.start();
        startagain = (Button) findViewById(R.id.play_again_btn);
        tscore= (TextView)  findViewById(R.id.totalscore);
        hscore= (TextView)  findViewById(R.id.highestscore);
        openHelper=new DatabaseHelper(this);
         db1=new DatabaseHelper(this);
score=getIntent().getExtras().get("score").toString();


        startagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mainI = new Intent(GameOver.this, MainActivity.class);
                startActivity(mainI);
            }
        });
        tscore.setText("YOUR SCORE:  "+score);

        int hhscore=Integer.parseInt(score);
        db=openHelper.getWritableDatabase();
        insertData(hhscore);
        Cursor cursor=db1.alldata();
        StringBuilder stringBuilder= new StringBuilder();
        while(cursor.moveToNext()){
            stringBuilder.append("HIGHEST SCORE:  "+cursor.getInt(0));
        }
        hscore.setText(stringBuilder);

    }
    public void insertData(int ss){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME,ss);
        Long id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

    }




}
