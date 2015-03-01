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

    // We Objects
    private Button addOneButtonToWe;
    private Button addThreeButtonToWe;
    private TextView labelScoreWe;

    // They Objects
    private Button addOneButtonToThey;
    private Button addThreeButtonToThey;
    private TextView labelScoreThey;

    GridView gridWe;
    GridView gridThey;

    ArrayAdapter<String> adapterWe;
    ArrayAdapter<String> adapterThey;

    ArrayList<String> listWe = new ArrayList<>();
    ArrayList<String> listThey = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridWe = (GridView) findViewById(R.id.grid_view_we);
        gridThey = (GridView) findViewById(R.id.grid_view_they);

        addOneButtonToWe = (Button) findViewById(R.id.button_plus_one_we);
        addThreeButtonToWe = (Button) findViewById(R.id.button_plus_three_we);
        labelScoreWe = (TextView) findViewById(R.id.label_score_we);

        addOneButtonToThey = (Button) findViewById(R.id.button_plus_one_they);
        addThreeButtonToThey = (Button) findViewById(R.id.button_plus_three_they);
        labelScoreThey = (TextView) findViewById(R.id.label_score_they);

        int layout = android.R.layout.simple_list_item_1;

        adapterWe = new ArrayAdapter<>(this, layout, listWe);
        adapterThey = new ArrayAdapter<>(this, layout, listThey);

        gridWe.setAdapter(adapterWe);
        gridThey.setAdapter(adapterThey);

//        gridWe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void addItems(View v) {
        int resultado = 0;
        if (v.equals(addOneButtonToWe)){
            resultado = setScore(1, listWe);
            labelScoreWe.setText(String.valueOf(resultado));
        }else if (v.equals(addThreeButtonToWe)){
            resultado = setScore(3, listWe);
            labelScoreWe.setText(String.valueOf(resultado));
        }else if(v.equals(addOneButtonToThey)) {
            resultado = setScore(1, listThey);
            labelScoreThey.setText(String.valueOf(resultado));
        } else {
            resultado = setScore(3, listThey);
            labelScoreThey.setText(String.valueOf(resultado));
        }

        adapterWe.notifyDataSetChanged();
        adapterThey.notifyDataSetChanged();
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