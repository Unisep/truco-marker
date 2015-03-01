package com.unisep.truco_marker;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // We Objects
    private Button addOneButtonToWe;
    private Button addThreeButtonToWe;
    private TextView labelScoreWe;
    int scoreWe = 0;

    // They Objects
    private Button addOneButtonToThey;
    private Button addThreeButtonToThey;
    private TextView labelScoreThey;
    int scoreThey = 0;

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
        if(v.equals(addOneButtonToWe))
            setText(1, listWe);
        else if(v.equals(addThreeButtonToWe))
            setText(3, listWe);
        else if(v.equals(addOneButtonToThey))
            setText(1, listThey);
        else
            setText(3, listThey);

        adapterWe.notifyDataSetChanged();
        adapterThey.notifyDataSetChanged();
    }

    private void setText(int quantity, ArrayList<String> list){
        list.add(String.valueOf(quantity));
    }
}