package com.example.zhangchi.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void onChangeButtonClick(View view) {
        EditText outputText = (EditText) findViewById(R.id.editText);
        // outputText.setText("Changed Text");

        // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",outputText.getText().toString());
        setResult(RESULT_OK,returnIntent);
        finish();
    }

    public void onGoBackButtonClick(View view) {
        finish();
        //Intent newActivity = new Intent(AddActivity.this,MainActivity.class);
        //startActivity(newActivity);
    }
}

