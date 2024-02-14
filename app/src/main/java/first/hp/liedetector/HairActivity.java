package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;



public class HairActivity extends AppCompatActivity {

    ImageView back, off, on;
    int[] resID = {R.raw.shaving};
    MediaPlayer mediaPlayer;
    Vibrator vibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hair);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        back = findViewById(R.id.back);
        off = findViewById(R.id.off);
        on = findViewById(R.id.on);
        mediaPlayer = MediaPlayer.create(this, resID[0]);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                mediaPlayer.stop();
                vibe.cancel();
            }
        });


        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on.setVisibility(View.VISIBLE);

                vibe.vibrate(100000);
                mediaPlayer.start();
            }
        });
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.cancel();
                off.setVisibility(View.VISIBLE);
                on.setVisibility(View.GONE);
                mediaPlayer.pause();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        vibe.cancel();
    }


}