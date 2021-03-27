package com.geek.a1_hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        checkOrientation();
        checkData();
    }

    private void checkOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
    }

    private void checkData() {
        UserContactModel model = (UserContactModel) getIntent().getSerializableExtra("EXTRA_MODEL");
        if (model!=null){
            TextFragment textFragment = TextFragment.newInstance(model.getName(),model.getTitle(),model.getImage());
            getSupportFragmentManager().beginTransaction().replace(R.id.details_frame_layout,textFragment).commit();
            //getSupportFragmentManager().beginTransaction().add(R.id.details_frame_layout,textFragment).commit();
        }
    }
}