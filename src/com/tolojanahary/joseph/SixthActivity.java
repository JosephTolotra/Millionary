package com.tolojanahary.joseph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SixthActivity extends Activity {
    private SharedPreferences pref;
    private String themeName;

    private Question mQuestions = new Question();

    private TextView mScoreMarina;
    private TextView mScoreDiso;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;

    private int mScore = 0;
    private int mMarina = 0;
    private int mDiso = 0;
    private int mQuestionLength = mQuestions.mQuestions.length;
    private int numQuest = 1;

    //pour stocker le nombre des questions
    private int t[] = new int[10];
    private int j = 0;
    private int na;

    String names, isa, marinav, disov;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = getSharedPreferences("data", Context.MODE_PRIVATE);

        themeName = pref.getString("theme", "ThemeBlue");
        setTheme(themeName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth);

        r = new Random();

        initializeViews();

        na = norepeate();
        updateQuestion(na);
        updateScore(numQuest);

        setButtonClickListeners();
    }

    private void initializeViews() {
        mScoreMarina = findViewById(R.id.marina);
        mScoreDiso = findViewById(R.id.diso);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
    }

    private void setButtonClickListeners() {
        mButtonChoice1.setOnClickListener(v -> handleButtonClick(mButtonChoice1));
        mButtonChoice2.setOnClickListener(v -> handleButtonClick(mButtonChoice2));
        mButtonChoice3.setOnClickListener(v -> handleButtonClick(mButtonChoice3));
        mButtonChoice4.setOnClickListener(v -> handleButtonClick(mButtonChoice4));
    }

    private void handleButtonClick(Button button) {
        if (numQuest != 10) {
            if (button.getText().equals(mAnswer)) {
                mScore++;
                mMarina++;
                updateMarina(mMarina);
                na = norepeate();
                updateQuestion(na);
                toastMarina();
            } else {
                toastDiso();
                mDiso++;
                updateDiso(mDiso);
                na = norepeate();
                updateQuestion(na);
            }
            numQuest++;
            updateScore(numQuest);
        } else {
            if (button.getText().equals(mAnswer)) {
                mScore++;
                mMarina++;
                toastMarina();
            } else {
                toastDiso();
                mDiso++;
            }
            gameOver();
        }
    }

    private void updateQuestion(int num) {
        mQuestionView.setText(mQuestions.getQuestion(num));
        mButtonChoice1.setText(mQuestions.getChoice1(num));
        mButtonChoice2.setText(mQuestions.getChoice2(num));
        mButtonChoice3.setText(mQuestions.getChoice3(num));
        mButtonChoice4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnsewrs(num);
    }

    private void updateScore(int point) {
        mScoreView.setText("" + numQuest + "/10");
    }

    private void updateMarina(int point) {
        mScoreMarina.setText("" + mMarina);
    }

    private void updateDiso(int point) {
        mScoreDiso.setText("" + mDiso);
    }

    private void gameOver() {
        isa = String.valueOf(mScore);
        marinav = String.valueOf(mMarina);
        disov = String.valueOf(mDiso);
        Intent i = new Intent(SixthActivity.this, SeventhActivity.class);
        i.putExtra("feno", names);
        i.putExtra("isa", isa);
        i.putExtra("marinav", marinav);
        i.putExtra("disov", disov);
        startActivity(i);
        finish();
    }

    private void toastMarina() {
        showToast("Marina", R.drawable.strike);
    }

    private void toastDiso() {
        showToast("Diso", R.drawable.strike2);
    }

    private void showToast(String text, int imageResource) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.ctoast, findViewById(R.id.customToast));

        TextView textView = layout.findViewById(R.id.textCustom);
        ImageView imageView = layout.findViewById(R.id.cIV);

        textView.setText(text);
        setImageResource(imageView, imageResource);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    private void setImageResource(ImageView imageView, int imageResource) {
        if (themeName.equals("ThemeBlue")) {
            imageView.setImageResource(imageResource);
        } else if (themeName.equals("ThemeRed")) {
            imageView.setImageResource(imageResource + 1);
        } else if (themeName.equals("ThemeGreen")) {
            imageView.setImageResource(imageResource + 2);
        }
    }

    private void setTheme(String themeName) {
        if (themeName.equals("ThemeBlue")) {
            setTheme(R.style.ThemeBlue);
        } else if (themeName.equals("ThemeRed")) {
            setTheme(R.style.ThemeRed);
        } else if (themeName.equals("ThemeGreen")) {
            setTheme(R.style.ThemeGreen);
        }
    }

    private int norepeate() {
        int a;
        int b;
        b = 1;
        a = 0;

        while (b > 0) {
            b = 0;
            a = r.nextInt(mQuestionLength);
            for (int i = 0; i < 10; i++) {
                if (t[i] == a) {
                    b++;
                }
            }
            if (b == 0) {
                t[j] = a;
                j++;
            }
        }
        return a;
    }
}
