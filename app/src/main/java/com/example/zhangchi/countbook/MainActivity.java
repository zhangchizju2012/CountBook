package com.example.zhangchi.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;
    private ArrayList<Integer> counts = new ArrayList<Integer>();
    private ArrayAdapter<Integer> adapter;
    private ListView countList;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = (TextView) findViewById(R.id.textView);
        countList = (ListView) findViewById(R.id.listView);

        titleText.setText("Hello");

        Button addButton = (Button) findViewById(R.id.AddButton);
        addButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Intent newActivity = new Intent(MainActivity.this,AddActivity.class);
                    startActivity(newActivity);
                    //startActivityForResult(addIntent,1);
            }
        });

        Button changeButton = (Button) findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                titleText.setText(Integer.toString(count));
                counts.add(count);
                adapter.notifyDataSetChanged();
                count += 1;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter = new ArrayAdapter<Integer>(this, R.layout.list_item, counts);
        countList.setAdapter(adapter);
    }

//    public void onBtnClick(View view){
//        AddActivity addActivity = new AddActivity();
//
//        setContentView(R.layout.activity_add);
//    }

}
