package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.CountDownTimer;


import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.airbnb.lottie.LottieAnimationView;



import java.util.Random;

public class ScanActivity extends AppCompatActivity {
    ImageView normal, fingerscanner, green_btn, red_btn, scanning_bar;
    LottieAnimationView lottieAnimationView;
    TextView textview;
    int i;
    CountDownTimer count;

    AudioManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        normal = findViewById(R.id.normal);
        fingerscanner = findViewById(R.id.fingerscanner);
        textview = findViewById(R.id.textview);
        green_btn = findViewById(R.id.green_btn);
        red_btn = findViewById(R.id.red_btn);
        scanning_bar = findViewById(R.id.scanning_bar);
        lottieAnimationView = findViewById(R.id.lottie_animation);
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.dowon_animation);
        manager = (AudioManager) ScanActivity.this.getSystemService(Context.AUDIO_SERVICE);


        fingerscanner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                int action = event.getActionMasked();
                if (action == MotionEvent.ACTION_DOWN) {
//                    scanning_bar.setVisibility(View.VISIBLE);
                    green_btn.setImageResource(R.drawable.light_black);
                    red_btn.setImageResource(R.drawable.light_black);
                    scanning_bar.setAnimation(slide_down);
                    lottieAnimationView.setVisibility(View.VISIBLE);
                    lottieAnimationView.playAnimation();
                    textview.setVisibility(View.GONE);

                    checktime();
                    return true;
                } else if (action == MotionEvent.ACTION_UP) {
                    textview.setVisibility(View.VISIBLE);
//                    textview.setTextColor(getResources().getColor(R.color.white));
//                    textview.setText("Wait 4 Seconds to scan");
//                    normal.setImageResource(R.drawable.normal_bg);
                    scanning_bar.clearAnimation();
                    lottieAnimationView.setVisibility(View.GONE);
                    count.cancel();
                    return true;
                } /*else if (action == MotionEvent.ACTION_CANCEL) {

                    textview.setVisibility(View.VISIBLE);
                    scanning_bar.clearAnimation();
                    textview.setText("Wait 4 Seconds to scan");
                    textview.setTextColor(getResources().getColor(R.color.white));
                    lottieAnimationView.setVisibility(View.GONE);
                    count.cancel();
                    return true;
                }*/ else {

                    return true;
                }
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            i = 2;
            manager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_RAISE,
                    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);

            return true;

        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            i = 1;
            manager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_LOWER,
                    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public boolean checktime() {
        count = new CountDownTimer(3000, 3000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
//                Toast.makeText(ScanActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                textview.setVisibility(View.GONE);
                lottieAnimationView.setVisibility(View.GONE);
                scanning_bar.clearAnimation();
                textview.setTextColor(getResources().getColor(R.color.white));
                green_btn.setImageResource(R.drawable.light_black);
                red_btn.setImageResource(R.drawable.light_black);
                normal.setImageResource(R.drawable.normal_bg);
                scanning_bar.setVisibility(View.GONE);

                Random random = new Random();
                int j = random.nextInt(2);





                if (i == 1) {
                    green_btn.setImageResource(R.drawable.light_green);
                    textview.setVisibility(View.VISIBLE);
                    scanning_bar.clearAnimation();
                    textview.setText("You tell the truth");
                    textview.setTextColor(getResources().getColor(R.color.green));
                    scanning_bar.setVisibility(View.GONE);
                    lottieAnimationView.setVisibility(View.GONE);
                    i = -1;

                } else if (i == 2) {
                    red_btn.setImageResource(R.drawable.light_red);
                    textview.setVisibility(View.VISIBLE);
                    scanning_bar.clearAnimation();
                    textview.setText("You lied");
                    normal.setImageResource(R.drawable.lie_bg);
                    textview.setTextColor(getResources().getColor(R.color.red));
                    scanning_bar.setVisibility(View.GONE);
                    lottieAnimationView.setVisibility(View.GONE);
                    i = 0;
                } else if (j == 0) {
                    red_btn.setImageResource(R.drawable.light_red);
                    textview.setVisibility(View.VISIBLE);
                    scanning_bar.clearAnimation();
                    textview.setText("You lied");
                    normal.setImageResource(R.drawable.lie_bg);
                    textview.setTextColor(getResources().getColor(R.color.red));
                    scanning_bar.setVisibility(View.GONE);
                    lottieAnimationView.setVisibility(View.GONE);
                } else if (j == 1) {
                    green_btn.setImageResource(R.drawable.light_green);
                    textview.setVisibility(View.VISIBLE);
                    scanning_bar.clearAnimation();
                    textview.setText("You tell the truth");
                    textview.setTextColor(getResources().getColor(R.color.green));
                    scanning_bar.setVisibility(View.GONE);
                    lottieAnimationView.setVisibility(View.GONE);
                }
            }
        }.start();
        return true;
    }
}