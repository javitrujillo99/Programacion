package com.example.multimedia;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.IOException;

public class ReproductorMusica extends Activity {

    ImageView btnPlay;
    ImageView btnPausa;
    ImageView btnStop;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproductor_musica);
        play(this);
        pausa();
        stop();
    }

    /**
     *
     */
    public void play(final Context context) {
        btnPlay = findViewById(R.id.play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(context, R.raw.farsante);
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });
    }

    /**
     *
     */
    public void pausa() {
        btnPausa = findViewById(R.id.pausa);
        btnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });
    }

    /**
     *
     */
    public void stop() {
        btnStop = findViewById(R.id.stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            }
        });
    }
}
