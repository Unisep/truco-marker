package com.unisep.truco_marker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    static final int NEW_GAME = 296;
    TextView lblScoreWe;
    TextView lblScoreThey;
    TextView lblWe;
    TextView lblThey;
    Button comeBack;
    Button plusOneWe;
    Button plusThreeWe;
    Button plusOneThey;
    Button plusThreeThey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        addFont();
    }

    public void createNewGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        this.startActivityForResult(intent, NEW_GAME);
    }

    public void addFont() {
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/please1.ttf");

        lblScoreWe = (TextView) findViewById(R.id.label_score_we);
        lblScoreThey = (TextView) findViewById(R.id.label_score_they);
        lblWe = (TextView) findViewById(R.id.label_we);
        lblThey = (TextView) findViewById(R.id.label_they);

        comeBack = (Button) findViewById(R.id.button_come_back);
        plusOneWe = (Button) findViewById(R.id.button_plus_one_we);
        plusThreeWe = (Button) findViewById(R.id.button_plus_three_we);
        plusOneThey = (Button) findViewById(R.id.button_plus_one_they);
        plusThreeThey = (Button) findViewById(R.id.button_plus_three_they);

        lblScoreWe.setTypeface(face);
        lblScoreThey.setTypeface(face);
        lblWe.setTypeface(face);
        lblThey.setTypeface(face);

        comeBack.setTypeface(face);
        plusOneWe.setTypeface(face);
        plusThreeWe.setTypeface(face);
        plusOneThey.setTypeface(face);
        plusThreeThey.setTypeface(face);

    }
}

