package com.tiron.dmitriitiron.a4minus1celine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    public ArrayAdapter<String> itemsAdapter;
    public ListView listView;
    public Button button_quiz;
    public Button button_main;
    public ArrayList<String> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Bundle extra = getIntent().getExtras();
        ls = extra.getStringArrayList("Message");
        TextView tv = (TextView)findViewById(R.id.textView_history);

        if (ls.size() > 0) {
            listView = (ListView) findViewById(R.id.listView);
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ls);
            listView.setAdapter(itemsAdapter);
        } else {
            //put case that listview is empty list
            tv.setText("No translation");
            
        }


        /*
        * try to keep translation record
        * */


        initQuiz();
        initMain();
    }


    public void initQuiz(){
        button_quiz = (Button)findViewById(R.id.button_quiz);
        button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(HistoryActivity.this, QuizActivity.class );
                startActivity(toy);
            }
        });
    }

    public void initMain(){
        button_main = (Button)findViewById(R.id.button_main);
        button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(HistoryActivity.this, MainActivity.class );
                startActivity(toy);
            }
        });
    }
}
