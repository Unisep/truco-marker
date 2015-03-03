package com.unisep.truco_marker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Team teamWe;
    private Team teamThey;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareTeams();
//        gridWe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void prepareTeams() {
        int layout = android.R.layout.simple_list_item_1;

        teamWe = new Team("We",
                          findViewById(R.id.button_plus_one_we),
                          findViewById(R.id.label_score_we),
                          findViewById(R.id.button_plus_three_we),
                          findViewById(R.id.grid_view_we),
                          new ArrayAdapter<Movement>(this, layout)
        );

        teamThey = new Team("They",
                            findViewById(R.id.button_plus_one_they),
                            findViewById(R.id.label_score_they),
                            findViewById(R.id.button_plus_three_they),
                            findViewById(R.id.grid_view_they),
                            new ArrayAdapter<Movement>(this, layout)
        );
    }

    public void addItems(View view) {
        Button button = (Button) view;

        teamThey.doMovement(button);
        teamWe.doMovement(button);


//      resultado = setScore(3, listThey);
//      labelScoreThey.setText(String.valueOf(resultado));

//      adapterWe.notifyDataSetChanged();
//      adapterThey.notifyDataSetChanged();

    }

    private int setScore(int quantity, ArrayList<String> list){
        int last = 0;
        if (list.size() > 0)
            last = Integer.parseInt(list.get(list.size() - 1));

        int amount = last + quantity;

        list.add(String.valueOf(amount));

        return amount;
    }
}