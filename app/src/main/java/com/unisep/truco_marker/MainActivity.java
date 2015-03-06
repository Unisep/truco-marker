package com.unisep.truco_marker;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;

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

//

    }

    private void prepareTeams() {
        int layout = android.R.layout.simple_list_item_1;

        teamWe = new Team(findViewById(R.id.button_plus_one_we),
                          findViewById(R.id.button_plus_three_we),
                          findViewById(R.id.label_score_we),
                          findViewById(R.id.grid_view_we),
                          new ArrayAdapter<Movement>(this, layout),
                          "Nós"
        );

        teamThey = new Team(findViewById(R.id.button_plus_one_they),
                            findViewById(R.id.button_plus_three_they),
                            findViewById(R.id.label_score_they),
                            findViewById(R.id.grid_view_they),
                            new ArrayAdapter<Movement>(this, layout),
                            "Eles"
        );
    }

    public void addItems(View view) {
        Button button = (Button) view;

        teamWe.doMovement(button);
        teamThey.doMovement(button);

        existsChampion();
    }

    private void existsChampion(){
        if(teamWe.isChampion() || teamThey.isChampion()) {
            resetScore(teamWe);
            resetScore(teamThey);

            if (teamWe.isChampion())
                notifyScreen(teamWe);
            else
                notifyScreen(teamThey);
        }
    }

    private void resetScore(Team team){
        team.getScoreLabel().setText("00");
        team.getMovements().clear();
    }

    private void notifyScreen(Team team){
        String message = team.getName() + " foi o vencedor!";

        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("Seus poca fôia");
        alert.setMessage(message);

        alert.show();
    }
}