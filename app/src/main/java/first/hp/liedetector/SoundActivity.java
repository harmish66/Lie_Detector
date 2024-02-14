package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SoundActivity extends AppCompatActivity {

    ImageView back;
    ImageView hair, funny, fort, hil;
    private AdView mAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sound);
        mAdview = findViewById(R.id.adView);

        MobileAds.initialize(SoundActivity.this);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);


        back = findViewById(R.id.back);

        hair = findViewById(R.id.hair);
        funny = findViewById(R.id.funny);
        fort = findViewById(R.id.fort);
        hil = findViewById(R.id.hil);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        hair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SoundActivity.this, HairActivity.class);
                startActivity(i);
            }
        });
        funny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SoundActivity.this, FunnyActivity.class);
                startActivity(i);

            }
        });
        fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SoundActivity.this, FortActivity.class);
                startActivity(i);
            }
        });
        hil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SoundActivity.this, HilActivity.class);
                startActivity(i);
            }
        });
    }
}