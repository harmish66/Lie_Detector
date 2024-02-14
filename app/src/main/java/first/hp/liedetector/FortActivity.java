package first.hp.liedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.chengtao.pianoview.entity.AutoPlayEntity;
import com.chengtao.pianoview.entity.Piano;
import com.chengtao.pianoview.listener.OnLoadAudioListener;
import com.chengtao.pianoview.listener.OnPianoAutoPlayListener;
import com.chengtao.pianoview.listener.OnPianoListener;
import com.chengtao.pianoview.utils.AutoPlayUtils;
import com.chengtao.pianoview.view.PianoView;


import java.io.IOException;
import java.util.ArrayList;

public class FortActivity extends AppCompatActivity implements OnPianoListener, OnLoadAudioListener,
        OnPianoAutoPlayListener {

    PianoView pianoView;
    SeekBar seekbar_piano, seekbar_volume;

    ImageView play_btn,stop_btn,volume,menu,file;
    private ArrayList<AutoPlayEntity> litterStarList = null;
    private static final long LITTER_STAR_BREAK_SHORT_TIME = 500;
    private static final long LITTER_STAR_BREAK_LONG_TIME = 1000;
    private final static float SEEKBAR_OFFSET_SIZE = -12;
    private static final boolean USE_CONFIG_FILE = true;
    private static final String CONFIG_FILE_NAME = "simple_little_star_config";
    private int scrollProgress = 0;
    private int width = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fort);

        pianoView = findViewById(R.id.piano);
        seekbar_piano = findViewById(R.id.seekbar_piano);

        play_btn = findViewById(R.id.play_btn);
        stop_btn = findViewById(R.id.stop_btn);
        volume = findViewById(R.id.volume);
        seekbar_volume = findViewById(R.id.seekbar);
        menu = findViewById(R.id.menu);
        file = findViewById(R.id.file);

        pianoView.setSoundPollMaxStream(10);
        seekbar_piano.setThumbOffset((int) convertDpToPixel(SEEKBAR_OFFSET_SIZE));
        pianoView.setPianoListener(this);
        pianoView.setAutoPlayListener(this);
        pianoView.setLoadAudioListener(this);


        if (USE_CONFIG_FILE) {
            AssetManager assetManager = getAssets();
            try {
                litterStarList = AutoPlayUtils.getAutoPlayEntityListByCustomConfigInputStream(
                        assetManager.open(CONFIG_FILE_NAME));
            } catch (IOException e) {

                Log.d("TAG1010", "onCreate: " + e.getMessage());
            }
        } else {
            initLitterStarList();
        }
        seekbar_piano.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                pianoView.scroll(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initLitterStarList() {
        litterStarList = new ArrayList<>();
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 0, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 0, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 5, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 5, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_LONG_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 1, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 1, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 0, LITTER_STAR_BREAK_LONG_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 1, LITTER_STAR_BREAK_LONG_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 1, LITTER_STAR_BREAK_LONG_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 0, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 0, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 5, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 5, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 4, LITTER_STAR_BREAK_LONG_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 3, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 2, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 1, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 1, LITTER_STAR_BREAK_SHORT_TIME));
        litterStarList.add(
                new AutoPlayEntity(Piano.PianoKeyType.WHITE, 4, 0, LITTER_STAR_BREAK_LONG_TIME));
    }

    private float convertDpToPixel(float dp) {
        Resources resources = this.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public void onPianoAutoPlayStart() {
        Toast.makeText(this, "onPianoAutoPlayStart", Toast.LENGTH_SHORT).show();
    }

    public void onPianoAutoPlayEnd() {
        Toast.makeText(this, "onPianoAutoPlayEnd", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void loadPianoAudioStart() {
    }

    @Override
    public void loadPianoAudioFinish() {

    }

    @Override
    public void loadPianoAudioError(Exception e) {

    }

    @Override
    public void loadPianoAudioProgress(int progress) {

    }

    @Override
    public void onPianoInitFinish() {

    }

    @Override
    public void onPianoClick(Piano.PianoKeyType type, Piano.PianoVoice voice, int group, int positionOfGroup) {

    }

    @Override
    protected void onResume() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        if (pianoView != null) {
            pianoView.releaseAutoPlay();
        }}*/


}