package com.gmail.vtc.vlado.scorekeeper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewScoreA, textViewFoulsA, textViewScoreB, textViewFoulsB, textViewWinner;
    Button buttonSubtractScoreA, buttonAddScoreA, buttonSubtractFoulsA, buttonAddFoulsA, buttonSubtractScoreB, buttonAddScoreB, buttonSubtractFoulsB, buttonAddFoulsB, buttonResult;

    int scoreA = 0;
    int scoreB = 0;
    int foulsA = 0;
    int foulsB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Team A

        textViewScoreA = findViewById(R.id.textViewScoreA);
        textViewFoulsA = findViewById(R.id.textViewFoulsA);

        buttonSubtractScoreA = findViewById(R.id.buttonSubtractScoreA);
        buttonAddScoreA = findViewById(R.id.buttonAddScoreA);
        buttonSubtractFoulsA = findViewById(R.id.buttonSubtractFoulsA);
        buttonAddFoulsA = findViewById(R.id.buttonAddFoulsA);

        // Team B

        textViewScoreB = findViewById(R.id.textViewScoreB);
        textViewFoulsB = findViewById(R.id.textViewFoulsB);

        buttonSubtractScoreB = findViewById(R.id.buttonSubtractScoreB);
        buttonAddScoreB = findViewById(R.id.buttonAddScoreB);
        buttonSubtractFoulsB = findViewById(R.id.buttonSubtractFoulsB);
        buttonAddFoulsB = findViewById(R.id.buttonAddFoulsB);


        buttonResult = findViewById(R.id.buttonResult);
        textViewWinner = findViewById(R.id.textViewWinner);

        onClickButtons();
    }

    public void onClickButtons() {

        buttonSubtractScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (scoreA != 0) {

                    scoreA -= 1;
                    displayScoreA(scoreA);

                }
            }
        });

        buttonSubtractScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (scoreB != 0) {

                    scoreB -= 1;
                    displayScoreB(scoreB);

                }
            }
        });

        buttonAddScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA += 1;
                displayScoreA(scoreA);
            }
        });

        buttonAddScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB += 1;
                displayScoreB(scoreB);
            }
        });

        buttonSubtractFoulsA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (foulsA != 0) {
                    foulsA -= 1;
                    displayFoulsA(foulsA);
                }
            }
        });

        buttonSubtractFoulsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (foulsB != 0) {
                    foulsB -= 1;
                    displayFoulsB(foulsB);
                }
            }
        });

        buttonAddFoulsA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foulsA += 1;
                displayFoulsA(foulsA);
            }
        });

        buttonAddFoulsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foulsB += 1;
                displayFoulsB(foulsB);
            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String buttonText = buttonResult.getText().toString();

                if (buttonText.equals("Winner")) {

                    buttonResult.setText(R.string.reset);

                    if (scoreA > scoreB) {

                        textViewWinner.setText(R.string.winner_team_a);
                        textViewWinner.setTextColor(Color.RED);

                    } else if (scoreA < scoreB) {

                        textViewWinner.setText(R.string.winner_team_b);
                        textViewWinner.setTextColor(Color.BLUE);

                    } else {

                        textViewWinner.setText(R.string.score_is_equal);
                        textViewWinner.setTextColor(Color.GREEN);
                    }

                }
                if (buttonText.equals(getString(R.string.reset))) {
                    buttonResult.setText(R.string.winner);
                    textViewScoreA.setText(R.string._0);
                    textViewScoreB.setText(R.string._0);
                    textViewFoulsA.setText(R.string._0);
                    textViewFoulsB.setText(R.string._0);
                    textViewWinner.setText(R.string.empty_brackets);
                    scoreA = 0;
                    scoreB = 0;
                    foulsA = 0;
                    foulsB = 0;
                }
            }
        });
    }

    public void displayScoreA(int score) {
        textViewScoreA.setText(String.valueOf(score));
    }

    private void displayScoreB(int score) {
        textViewScoreB.setText(String.valueOf(score));
    }

    public void displayFoulsA(int fouls) {
        textViewFoulsA.setText(String.valueOf(fouls));
    }

    public void displayFoulsB(int fouls) {
        textViewFoulsB.setText(String.valueOf(fouls));
    }
}
