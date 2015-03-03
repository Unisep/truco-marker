package com.unisep.truco_marker;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bruno on 3/1/15.
 */
public class Team {
    private Button plusOne;
    private Button plusThree;
    private TextView scoreLabel;
    private GridView gridMovements;
    private ArrayAdapter<Movement> adapter;
    private ArrayList<Movement> movements;

    public Team(View buttonPlusOne, View buttonPlusThree, View labelScore, View grid,
                ArrayAdapter<Movement> adapter) {
        this.plusOne = (Button) buttonPlusOne;
        this.plusThree = (Button) buttonPlusThree;
        this.scoreLabel = (TextView) labelScore;
        this.gridMovements = (GridView) grid;
        this.scoreLabel = (TextView) labelScore;
        this.movements = new ArrayList<>();
        this.adapter = adapter;

        this.adapter.addAll(this.movements);
        this.gridMovements.setAdapter(this.adapter);
    }

    public void doMovement(Button button){
        if(isTeamButton(button)){
            Movement movement = new Movement(getButtonValue(button), this);
            movement.move();
        }
    }

    public boolean isTeamButton(Button button){
        if(button.getId() == this.plusOne.getId() || button.getId() == this.plusThree.getId())
            return true;
        else
            return false;
    }

    public int getButtonValue(Button button){
        if(button.getId() == this.plusOne.getId())
            return 1;
        else
            return 3;
    }

    // Accessor Methods!

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public TextView getScoreLabel() {
        return scoreLabel;
    }

    public ArrayAdapter<Movement> getAdapter() {
        return adapter;
    }
}
