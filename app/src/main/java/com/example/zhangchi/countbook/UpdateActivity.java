package com.example.zhangchi.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText updateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateText = (EditText) findViewById(R.id.updateEditText); // 必须在这里，挪到11行会报错
        String s = getIntent().getStringExtra("data");
        updateText.setText(s);
    }

    public void onUpdateButtonClick(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",updateText.getText().toString());
        returnIntent.putExtra("position",getIntent().getStringExtra("position"));
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
