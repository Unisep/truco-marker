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
    private String name;
    private Button plusOne;
    private Button plusThree;
    private TextView scoreLabel;
    private GridView gridMovements;
    private ArrayAdapter<Movement> adapter;
    private ArrayList<Movement> movements;

    public Team(String name, View buttonPlusOne, View buttonPlusThree, View labelScore, View grid,
                ArrayAdapter<Movement> adapter) {
        this.name = name;
        this.plusOne = (Button) buttonPlusOne;
        this.plusThree = (Button) buttonPlusThree;
        this.scoreLabel = (TextView) labelScore;
        this.gridMovements = (GridView) grid;
        this.scoreLabel = (TextView) labelScore;
        this.movements = new ArrayList<>();
        this.adapter = adapter;

        adapter.addAll(this.movements);
        gridMovements.setAdapter(this.adapter);
    }

    public boolean isTeamObject(Object o){
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(Button plusOne) {
        this.plusOne = plusOne;
    }

    public Button getPlusThree() {
        return plusThree;
    }

    public void setPlusThree(Button plusThree) {
        this.plusThree = plusThree;
    }

    public TextView getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(TextView scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public GridView getGridMovements() {
        return gridMovements;
    }

    public void setGridMovements(GridView gridMovements) {
        this.gridMovements = gridMovements;
    }

    public ArrayAdapter<Movement> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<Movement> adapter) {
        this.adapter = adapter;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }
}
