package com.example.christkp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout ;
    HashMap<String, Integer> christ_pics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderLayout = (SliderLayout)findViewById(R.id.slider);

        AddImageUrlFormLocalRes();
        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for(String name : christ_pics.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);

            textSliderView
                    .description(name)
                    .image(christ_pics.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(MainActivity.this);
    }

    @Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    public void AddImageUrlFormLocalRes(){

        christ_pics = new HashMap<String, Integer>();

        christ_pics.put("Christ University", R.drawable.ch1);
        christ_pics.put("Bannerghatta Campus", R.drawable.ch2);
        christ_pics.put("Central Campus", R.drawable.ch3);
        christ_pics.put("Kengeri Campus", R.drawable.ch4);
        christ_pics.put("Delhi Campus", R.drawable.ch5);

    }
}