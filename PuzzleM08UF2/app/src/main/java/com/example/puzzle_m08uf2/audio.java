package com.example.puzzle_m08uf2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class audio extends MainActivity {

    public MediaPlayer ring;
    public MediaPlayer ring2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ring = MediaPlayer.create(audio.this, R.raw.audio);
        ring2 = MediaPlayer.create(audio.this, R.raw.audio);


        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(android.R.drawable.ic_media_pause);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;
                if (ring.isPlaying()) {
                    //text = "Pausa";
                    fab.setImageResource(android.R.drawable.ic_media_play);
                    ring.pause();

                } else {
                    //text = "Reproduciendo";
                    fab.setImageResource(android.R.drawable.ic_media_pause);
                    ring.start();
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        ring.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ring.pause();


    }

    @Override
    protected void onResume() {
        super.onResume();
        ring.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        ring.release();

    }

    @Override
    protected void onRestart() {
        ring = MediaPlayer.create(audio.this, R.raw.audio);
        super.onRestart();

    }

   /* public void iniciar (View view) {
        //ring = MediaPlayer.create(MainActivity.this, R.raw.audio);
        ring.start();
    }*/

    public void pausar (View view){
        //ring = MediaPlayer.create(MainActivity.this, R.raw.audio);
        if (ring.isPlaying()) {
            ring.pause();
        }else{
            ring.start();
        }

    }

}
