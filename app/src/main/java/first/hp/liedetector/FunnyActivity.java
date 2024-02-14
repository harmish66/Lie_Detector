package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class FunnyActivity extends AppCompatActivity {

    ImageView back;
    ConstraintLayout air, laugh, claps, fart, whistle, punch, omg, police, remote;
    MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny);

        back = findViewById(R.id.back);
        air = findViewById(R.id.air);
        laugh = findViewById(R.id.laugh);
        claps = findViewById(R.id.claps);
        fart = findViewById(R.id.fart);
        whistle = findViewById(R.id.whistle);
        punch = findViewById(R.id.punch);
        omg = findViewById(R.id.omg);
        police = findViewById(R.id.police);
        remote = findViewById(R.id.remote);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                mMediaPlayer.stop();

            }
        });

        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_air_horn);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
        laugh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_laugh);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });

        claps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_claps);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });

        fart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.fart);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });

        whistle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_whistle);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
        punch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_punch);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
        omg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_omg);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_police);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
        remote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(FunnyActivity.this, R.raw.funny_car_remote);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
    }


}