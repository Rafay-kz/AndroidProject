package com.codewithkumar.flyingfish;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static com.codewithkumar.flyingfish.R.raw.sound;


public class FlyingFishView extends View {
    private Bitmap fish[] = new Bitmap[2];
    private int fishx = 10;
    private int fishy;
    private int fishspeed;
    private int canvasWidth, canvasHeight;
    private Bitmap backgroundimage;
    private Paint scorepaint = new Paint();
    private Bitmap Life[] = new Bitmap[2];
    private boolean touch = false;
    private int yellowx,yellowy,yellowspeed=16;
    private Paint yellowPaint=new Paint();
    private int greenx,greeny,greenspeed=20;
    private Paint greenPaint=new Paint();
    private int redx,redy,redspeed=25;
    private Paint redPaint=new Paint();
    private int score,lifecounter;


    public FlyingFishView(Context context) {

        super(context);
        fish[0] = BitmapFactory.decodeResource(getResources(), R.drawable.fish1);
        fish[1] = BitmapFactory.decodeResource(getResources(), R.drawable.fish2);
        backgroundimage = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setAntiAlias(false);

        greenPaint.setColor(Color.GREEN);
        greenPaint.setAntiAlias(false);

         redPaint.setColor(Color.RED);
         redPaint.setAntiAlias(false);

        scorepaint.setColor(Color.WHITE);
        scorepaint.setTextSize(70);
        scorepaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorepaint.setAntiAlias(true);
        Life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
        Life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heartgrey);
        fishy=550;
        score=0;
        lifecounter=3;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backgroundimage, 0, 0, null);
        int minfishy = fish[0].getWidth();
        int maxfishy = canvasHeight - fish[0].getHeight() * 3;
        fishy = fishy + fishspeed;
        if (fishy < minfishy) {
            fishy = minfishy;
        }
        if (fishy > maxfishy) {
            fishy = maxfishy;
        }
        fishspeed=fishspeed+2;

        if  (touch) {
             canvas.drawBitmap(fish[1],fishx,fishy,null);
             touch=false;
        }
        else
        {
            canvas.drawBitmap(fish[0],fishx,fishy,null);
        touch=false;}

        yellowx=yellowx-yellowspeed;
        if(hitballchecker(yellowx,yellowy)){
            score=score+10;
            yellowx=-100;
        }
        if(yellowx<0){
            yellowx=canvasWidth+21;
            yellowy=(int)Math.floor(Math.random()*(maxfishy-minfishy))+minfishy;
        }
        canvas.drawCircle(yellowx,yellowy,25,yellowPaint);

        greenx=greenx-greenspeed;
        if(hitballchecker(greenx,greeny)){
            score=score+20;
            greenx=-100;
        }
        if(greenx<0){
            greenx=canvasWidth+21;
            greeny=(int)Math.floor(Math.random()*(maxfishy-minfishy))+minfishy;
        }
        canvas.drawCircle(greenx,greeny,30,greenPaint);

        redx=redx-redspeed;
        if(hitballchecker(redx,redy)){
            redx=-100;
            lifecounter--;
            if(lifecounter==0){
                //CommonMethod.player.stop();
                Toast.makeText(getContext(), "Game over",Toast.LENGTH_SHORT).show();
                Intent gointent= new Intent(getContext(),GameOver.class);
                gointent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gointent.putExtra("score",score);
                getContext().startActivity(gointent);

            }

        }
        if(redx<0){
            redx=canvasWidth+21;
            redy=(int)Math.floor(Math.random()*(maxfishy-minfishy))+minfishy;
        }
        canvas.drawCircle(redx,redy,40,redPaint);
        canvas.drawText("Score:"+score, 20, 60, scorepaint);
        for(int i=0;i<3;i++){

            int x= (int)(580+Life[0].getWidth()*1.5*i);
            int y= 30;
            if(i<lifecounter){

                canvas.drawBitmap(Life[0], x, y, null);

            }
            else
                canvas.drawBitmap(Life[1], x, y, null);

        }


        //canvas.drawBitmap(fish[0], 0, 0, null);


    }
public boolean hitballchecker(int x , int y){
        if(fishx<x && x<(fishx+fish[0].getWidth()) && fishy<y && y<(fishy+fish[0].getHeight()) ){

            return true;
        }
        return false;
}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touch = true;
            fishspeed = -30;
        }
return true;
    }

}