package com.tiron.dmitriitiron.a4minus1celine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initMain();
        initHistory();
    }

    public Button button_history;
    public Button button_main;

    public void initHistory(){
        button_history = (Button)findViewById(R.id.button_history);
        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(QuizActivity.this, HistoryActivity.class );
                startActivity(toy);
            }
        });
    }

    public void initMain() {
        button_main = (Button) findViewById(R.id.button_main);
        button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(toy);
            }
        });
    }
}
