package com.unisep.truco_marker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.printservice.PrintService;
import android.widget.Button;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // We Objects
    private Button addOneButtonToWe;
    private Button addThreeButtonToWe;
    private TextView labelScoreWe;

    // They Objects
    private Button addOneButtonToThey;
    private Button addThreeButtonToThey;
    private TextView labelScoreThey;

    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;

    private Integer controllerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addOneButtonToWe = (Button) findViewById(R.id.button_plus_one_we);
        addThreeButtonToWe = (Button) findViewById(R.id.button_plus_three_we);
        labelScoreWe = (TextView) findViewById(R.id.label_score_we);

        addOneButtonToThey = (Button) findViewById(R.id.button_plus_one_they);
        addThreeButtonToThey = (Button) findViewById(R.id.button_plus_three_they);
        labelScoreThey = (TextView) findViewById(R.id.label_score_they);

        linearLayout = (LinearLayout) findViewById(R.id.mylayout1);
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        controllerID = 0;
    }

    public void testView(View view){
        View customView = layoutInflater.inflate(R.layout.custom_layout, null);
        TextView tv = (TextView) customView.findViewById(R.id.label_score_item);

        tv.setId(controllerID ++);
        tv.setText("Location:" + 4);

        linearLayout.addView(view);
    }
}
