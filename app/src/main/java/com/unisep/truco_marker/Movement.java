package com.unisep.truco_marker;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bruno on 3/1/15.
 */
public class Movement {
    private int quantity;
    private Team team;

    public Movement(int amount, Team team){
        this.quantity = amount;
        this.team = team;
    }

    public void move(){
        getNextValue();
        updateTeamValues();
    }

    private void getNextValue(){
        int last = 0;
        ArrayList list = this.team.getMovements();

        if (list.size() > 0)
            last = Integer.parseInt(list.get(list.size() - 1).toString());

        this.quantity += last;
    }

    private void updateTeamValues(){
        this.team.getScoreLabel().setText(toString());
        this.team.getMovements().add(this);

        this.team.getAdapter().notifyDataSetChanged();
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
