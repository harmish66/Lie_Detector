package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class HilActivity extends AppCompatActivity {

    ImageView back;

    ConstraintLayout air, laugh, claps, fart, whistle, punch, omg, police;
    MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hil);

        back = findViewById(R.id.back);
        air = findViewById(R.id.air);
        laugh = findViewById(R.id.laugh);
        claps = findViewById(R.id.claps);
        fart = findViewById(R.id.fart);
        whistle = findViewById(R.id.whistle);
        punch = findViewById(R.id.punch);
        omg = findViewById(R.id.omg);
        police = findViewById(R.id.police);


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
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_cat);
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                } else {
                    mMediaPlayer.start();
                }

            }
        });
        laugh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_glass);
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                } else {
                    mMediaPlayer.start();
                }
            }
        });

        claps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_mouse);
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
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_dog);
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
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_bomb);
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
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.fart);
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
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_knock);
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
                mMediaPlayer = MediaPlayer.create(HilActivity.this, R.raw.sound_ghost);
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }else {
                    mMediaPlayer.start();
                }
            }
        });
    }
}