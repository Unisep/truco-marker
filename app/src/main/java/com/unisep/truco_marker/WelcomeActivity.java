package com.unisep.truco_marker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends Activity {

    static final int NEW_GAME = 296;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void createNewGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        this.startActivityForResult(intent, NEW_GAME);
    }
}
