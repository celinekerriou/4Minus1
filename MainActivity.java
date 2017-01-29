package com.tiron.dmitriitiron.a4minus1celine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/* thoughts & status:
* When we press translate it changes the value at history but stays at the history page
* When you click on Main, the information is lost
*
* WE NEED:
* keep track of the information/ array
* */
public class MainActivity extends AppCompatActivity {
    public ArrayList<String> items;
    public ArrayAdapter<String> itemsAdapter;
    public ListView lvItems;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public Button button_quiz;
    public Button button_history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        initQuiz();
        initHistory();
        setupListViewListener();
    }


    public void initQuiz(){
        button_quiz = (Button)findViewById(R.id.button_quiz);
        button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, QuizActivity.class );
                startActivity(toy);
            }
        });
    }

    public void initHistory(){
        button_history = (Button)findViewById(R.id.button_history);
        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, HistoryActivity.class );
                if(items.size() != 0){
                    toy.putExtra("Message", items);
                }
                else{
                    ArrayList<String> empty = new ArrayList<String>();
                    toy.putExtra("Message",empty);
                }

                startActivity(toy);
            }
        });
    }


    public void sendMessage(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.insert(itemText, 0);
        etNewItem.setText("");
    }

    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }



}
