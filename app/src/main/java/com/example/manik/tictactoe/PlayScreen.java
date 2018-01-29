package com.example.manik.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by manik on 29-01-2018.
 */

public class PlayScreen extends MainActivity {

    TextView tvp1;
    TextView tvp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b= getIntent().getExtras();
        String p1 = b.getString("p1");
        String p2 = b.getString("p2");

        tvp1 = findViewById(R.id.tvp1);
        tvp1.setText(p1);
        tvp2 = findViewById(R.id.tvp2);
        tvp2.setText(p2);
    }





    public void bunClick(View view) {
        Button bunSelected = (Button) view;
        int cellID = 0;
        switch ((bunSelected.getId())) {

            case R.id.button:
                cellID = 1;
                break;

            case R.id.button2:
                cellID = 2;
                break;

            case R.id.button3:
                cellID = 3;
                break;

            case R.id.button4:
                cellID = 4;
                break;

            case R.id.button5:
                cellID = 5;
                break;

            case R.id.button6:
                cellID = 6;
                break;

            case R.id.button7:
                cellID = 7;
                break;

            case R.id.button8:
                cellID = 8;
                break;

            case R.id.button9:
                cellID = 9;
                break;
        }
        Play(cellID, bunSelected);
    }

    int ActivePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();

    void Play(int cellID, Button bunSelected) {

        if (ActivePlayer == 1) {
            bunSelected.setBackgroundColor(Color.RED);
            bunSelected.setBackgroundResource(R.drawable.o);
            Player1.add(cellID);
            ActivePlayer = 2;
        } else if (ActivePlayer == 2) {
            bunSelected.setBackgroundResource(R.drawable.x);
            Player2.add(cellID);
            ActivePlayer = 1;
        }
        bunSelected.setEnabled(false);
        CheckWinner();
    }


    void CheckWinner() {
        int winner = -1;

        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2;
        }

        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2;
        }

        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2;
        }

        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2;
        }

        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2;
        }

        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2;
        }

        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)) {
            winner = 2;
        }

        if (Player1.contains(7) && Player1.contains(5) && Player1.contains(3)) {
            winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(5) && Player2.contains(3)) {
            winner = 2;
        }

        Bundle b = getIntent().getExtras();
        String p1 = b.getString("p1");
        String p2 = b.getString("p2");

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, p1 + " Won!!!", Toast.LENGTH_SHORT).show();

            }
            if (winner == 2) {
                Toast.makeText(this, p2 + " Won!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void reset(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent = new Intent(PlayScreen.this, MainActivity.class);
        finish();
        startActivity(intent);
    }

}
