package com.geek.a1_hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayDetails(UserContactModel model) {
      if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
           TextFragment textFragment = TextFragment.newInstance(model.getName(),model.getTitle(),model.getImage());
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_text,textFragment).commit();
      }else {
          Intent i = new Intent(MainActivity.this,DetailsActivity.class);
          i.putExtra("EXTRA_MODEL",model);
          startActivity(i);
      }
    }
}