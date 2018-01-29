package com.example.manik.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //exits the app
    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }

    //This creates a intent for the game activity (PlayScreen.java)
    public void start(View v) {
        EditText ed1 = findViewById(R.id.editText1);
        EditText ed2 = findViewById(R.id.editText2);
        String p1 = ed1.getText().toString();
        String p2 = ed2.getText().toString();

        Intent intent = new Intent(MainActivity.this, PlayScreen.class);
        intent.putExtra("p1", p1);
        intent.putExtra("p2", p2);
        finish();
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "All the Best!!! \n" + p1 + " and " + p2, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent a = new Intent(Intent.ACTION_MAIN);
                    a.addCategory(Intent.CATEGORY_HOME);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(a);
                }
            }, 1000);
        }
    }
}



