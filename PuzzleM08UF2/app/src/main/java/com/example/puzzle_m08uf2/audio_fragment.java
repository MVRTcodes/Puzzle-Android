package com.example.puzzle_m08uf2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/*
public class audio_fragment extends Fragment {

    public MediaPlayer ring;
    public MediaPlayer ring2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.audio_fragment, container);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ring = MediaPlayer.create(audio_fragment.this, R.raw.audio);
        ring2 = MediaPlayer.create(audio_fragment.this, R.raw.audio);


        FloatingActionButton fab = null;
        fab = fab.findViewById(R.id.fab);
        fab.setImageResource(android.R.drawable.ic_media_pause);
        final FloatingActionButton finalFab = fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;
                if (ring.isPlaying()) {
                    //text = "Pausa";
                    finalFab.setImageResource(android.R.drawable.ic_media_play);
                    ring.pause();

                } else {
                    //text = "Reproduciendo";
                    finalFab.setImageResource(android.R.drawable.ic_media_pause);
                    ring.start();
                }
                /*Snackbar.make(view, text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
           /* }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        ring.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        ring.pause();


    }

    @Override
    public void onResume() {
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
        ring = MediaPlayer.create(audio_fragment.this, R.raw.audio);
        super.onRestart();

    }

   /* public void iniciar (View view) {
        //ring = MediaPlayer.create(MainActivity.this, R.raw.audio);
        ring.start();
    }*/
/*
    public void pausar (View view){
        //ring = MediaPlayer.create(MainActivity.this, R.raw.audio);
        if (ring.isPlaying()) {
            ring.pause();
        }else{
            ring.start();
        }

    }
}*/
