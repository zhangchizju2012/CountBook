package com.example.zhangchi.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;
    private ArrayList<String> counts = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
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
                    //startActivity(newActivity);
                    // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
                    startActivityForResult(newActivity, 1);
                    //startActivityForResult(addIntent,1);
            }
        });

        Button changeButton = (Button) findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                titleText.setText(Integer.toString(count));
                counts.add(Integer.toString(count));
                adapter.notifyDataSetChanged();
                count += 1;
            }
        });

        countList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity = new Intent(MainActivity.this,UpdateActivity.class);
                // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
                String wordClicked = ((TextView) view).getText().toString();
                newActivity.putExtra("data",wordClicked);
                newActivity.putExtra("position",Integer.toString(position));
                startActivityForResult(newActivity, 2);
            }
        });

    }

    // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                counts.add(result);
                adapter.notifyDataSetChanged();
            }
        }
        else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                int position = Integer.parseInt(data.getStringExtra("position"));
                counts.set(position,result);
                //counts.add(result);
                adapter.notifyDataSetChanged();
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, counts);
        countList.setAdapter(adapter);
    }

//    public void onBtnClick(View view){
//        AddActivity addActivity = new AddActivity();
//
//        setContentView(R.layout.activity_add);
//    }

}
