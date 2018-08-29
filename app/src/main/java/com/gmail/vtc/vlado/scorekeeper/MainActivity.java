package com.gmail.vtc.vlado.scorekeeper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textViewScoreA)
    TextView textViewScoreA;
    @BindView(R.id.textViewFoulsA)
    TextView textViewFoulsA;

    @BindView(R.id.textViewScoreB)
    TextView textViewScoreB;

    @BindView(R.id.textViewFoulsB)
    TextView textViewFoulsB;

    @BindView(R.id.textViewWinner)
    TextView textViewWinner;

    @OnClick(R.id.buttonAddScoreA)
    public void addScoreA() {
        buttonAddScoreA();
    }

    @OnClick(R.id.buttonSubtractScoreA)
    public void subtractScoreA() {
        buttonSubtractScoreA();
    }

    @OnClick(R.id.buttonSubtractFoulsA)
    public void subtractFoulsA() {
        buttonSubtractFoulsA();
    }

    @OnClick(R.id.buttonAddFoulsA)
    public void addFoulsA() {
        buttonAddFoulsA();
    }

    @OnClick(R.id.buttonSubtractScoreB)
    public void subtractScoreB() {
        buttonSubtractScoreB();
    }

    @OnClick(R.id.buttonAddScoreB)
    public void addScoreB() {
        buttonAddScoreB();
    }

    @OnClick(R.id.buttonSubtractFoulsB)
    public void subtractFoulsB() {
        buttonSubtractFoulsB();
    }

    @OnClick(R.id.buttonAddFoulsB)
    public void addFoulsB() {
        buttonAddFoulsB();
    }

    @BindView(R.id.buttonResult)
    Button buttonResult;

    @OnClick(R.id.buttonResult)
    public void result() {
        buttonResult();
    }

    private int scoreA = 0;
    private int scoreB = 0;
    private int foulsA = 0;
    private int foulsB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void buttonAddScoreA() {
        scoreA += 1;
        displayScoreA(scoreA);
    }

    public void buttonSubtractScoreA() {
        if (scoreA != 0) {
            scoreA -= 1;
            displayScoreA(scoreA);
        }
    }

    public void buttonAddScoreB() {
        scoreB += 1;
        displayScoreB(scoreB);
    }

    public void buttonSubtractScoreB() {
        if (scoreB != 0) {
            scoreB -= 1;
            displayScoreB(scoreB);
        }
    }

    public void buttonAddFoulsA() {
        foulsA += 1;
        displayFoulsA(foulsA);
    }

    public void buttonSubtractFoulsB() {
        if (foulsB != 0) {
            foulsB -= 1;
            displayFoulsB(foulsB);
        }
    }

    public void buttonAddFoulsB() {
        foulsB += 1;
        displayFoulsB(foulsB);
    }

    public void buttonSubtractFoulsA() {
        if (foulsA != 0) {
            foulsA -= 1;
            displayFoulsA(foulsA);
        }
    }

    public void buttonResult() {
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