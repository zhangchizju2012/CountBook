package com.example.zhangchi.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void onChangeButtonClick(View view) {
        TextView outputText = (TextView) findViewById(R.id.textView);
        outputText.setText("Changed Text");
        finish();
    }

    public void onGoBackButtonClick(View view) {
        Intent newActivity = new Intent(AddActivity.this,MainActivity.class);
        startActivity(newActivity);
    }
}

