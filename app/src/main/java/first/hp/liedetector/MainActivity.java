package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    TextView privacy1;

    private AdView mAdview;

     ImageButton start_btn,enjoy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mAdview = findViewById(R.id.adView);

        MobileAds.initialize(MainActivity.this);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);


       /* MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

                mAdview = findViewById(R.id.adView);


            }
        });*/

        start_btn = findViewById(R.id.start_btn);
        enjoy =  findViewById(R.id.enjoy);

        privacy1 = findViewById(R.id.privacy1);
        privacy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theurl = "https://harmish123.blogspot.com/2023/12/privacy-policy-for-lie-detector.html";
                Uri urlstr = Uri.parse(theurl);
                Intent urlintent = new Intent();
                urlintent.setData(urlstr);
                urlintent.setAction(Intent.ACTION_VIEW);
                startActivity(urlintent);
            }
        });
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ScanActivity.class);
                startActivity(i);
            }
        });

        enjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SoundActivity.class);
                startActivity(i);
            }
        });

    }
}