package com.codewithkumar.flyingfish;

import android.content.Context;
import android.media.MediaPlayer;

public class CommonMethod {
    public static MediaPlayer player;
    public void CommonMethod(Context ctx, int raw_id){
        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();
    }
}
