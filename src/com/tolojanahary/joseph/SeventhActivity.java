package com.tolojanahary.joseph;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SeventhActivity extends Activity {
    private SharedPreferences pref;
    private String themeName;

    private TextView tv1, tv2, tv4, tv6, tv7, tv8, tvf, hsca;
    private Button btf1, btf2, btf3;
    private ImageView img;

    private String na, ne, marinaf, disof, b1, b2, b3;
    private double a;
    private int isaf, best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seven);

        initializeViews();

        pref = getSharedPreferences("data", Context.MODE_PRIVATE);
        themeName = pref.getString("theme", "ThemeBlue");
        setTheme(themeName);

        retrieveExtras();
        displayResults();
        updateHighScore();

        btf1.setOnClickListener(view -> navigateToMainActivity());
        btf2.setOnClickListener(view -> navigateToSixthActivity());
        btf3.setOnClickListener(view -> showConfirmationDialog());
    }

    private void initializeViews() {
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv4 = findViewById(R.id.tv4);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tvf = findViewById(R.id.tvf);
        hsca = findViewById(R.id.hsca);
        btf1 = findViewById(R.id.btf1);
        btf2 = findViewById(R.id.btf2);
        btf3 = findViewById(R.id.btf3);
        img = findViewById(R.id.img);
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

    private void retrieveExtras() {
        na = getIntent().getExtras().getString("feno");
        ne = getIntent().getExtras().getString("isa");
        marinaf = getIntent().getExtras().getString("marinav");
        disof = getIntent().getExtras().getString("disov");
    }

    private void displayResults() {
        // Affichage de resultat
        tv6.setText("     Ny fanotaniana marina dia  : " + marinaf);
        tv7.setText("     Ny fanotaniana diso dia      : " + disof);

        a = Double.parseDouble(ne);
        int c = (int) (a * 10);
        tv8.setText("     Ny taha-pahamarinana dia : " + c + "%");

        if (a >= 5 && a != 10) {
            tv2.setText("Ry  " + na);
            strikesOne();
            tv4.setText(ne + "/10");
            tv1.setText("BRAVO !!!!!");
        } else if (a == 10) {
            handlePerfectScore();
        } else {
            tv2.setText("Ry  " + na);
            tv4.setText(ne + "/10");
            tv1.setText("RATSY !!!!!");
            strikesTwo();
        }
    }

    private void handlePerfectScore() {
        if (na.equals("Fenoskr")) {
            handlePerfectScoreForFenoskr();
        } else {
            a = a - 1;
            int d = (int) a;
            tv2.setText("Ry  " + na);
            tv4.setText(d + "/10");
            tvf.setText("(AZAFADY!!! tsy misy mpianatra mahazo 10/10 izany an-dakilasy noho izany tsy azo nao ny lela-vola 5000 ar)");
            tv1.setText("TENA MAHAY !!!!!");
            strikes();
        }
    }

    private void handlePerfectScoreForFenoskr() {
        na = "Feno";
        img.setImageResource(R.drawable.dollar);
        tv2.setText("Ry  Feno");
        tv4.setText("10/10");
        tvf.setText("(Arabaina fa azonao ni lela vola 5000 ar.. Misaotra anao nandray anjara)");
        tv1.setText("VITANAO IHANY !!!!!");
    }

    private void updateHighScore() {
        // Mis à jour de score
        isaf = (int) a;
        if (isaf >= best3) {
            updateSharedPreferences(best3, b3);
        }
        if (isaf >= best2) {
            int tmp = best2;
            String tmps = b2;
            updateSharedPreferences(best3, b3);
            updateSharedPreferences(tmp, tmps);
        }
        if (isaf >= best1) {
            int tmp = best1;
            String tmps = b1;
            updateSharedPreferences(best2, b2);
            updateSharedPreferences(tmp, tmps);
        }

        hsca.setText(b1 + " : " + best1 + "/10");
    }

    private void updateSharedPreferences(int best, String b) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("best3", best);
        editor.putString("b3", b);
        editor.apply();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(SeventhActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToSixthActivity() {
        Intent intent = new Intent(SeventhActivity.this, SixthActivity.class);
        intent.putExtra("name", na);
        startActivity(intent);
        finish();
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation ny fialana");
        builder.setMessage("Tena hiala ve ianao??");
        builder.setPositiveButton("Eny", (dialog, which) -> finish());
        builder.setNegativeButton("Tsia", (dialog, which) ->
                Toast.makeText(getApplicationContext(), "misaotra tsy niala", Toast.LENGTH_SHORT).show());
        builder.setCancelable(false);
        builder.show();
    }

    private void strikes() {
        setImageResource("strike");
    }

    private void strikesOne() {
        setImageResource("strike1");
    }

    private void strikesTwo() {
        setImageResource("strike2");
    }

    private void setImageResource(String resourceName) {
        int resourceId = getResourceId(resourceName);
        img.setImageResource(resourceId);
    }

    private int getResourceId(String resourceName) {
        if (themeName.equals("ThemeBlue")) {
            return getResources().getIdentifier(resourceName, "drawable", getPackageName());
        } else if (themeName.equals("ThemeRed")) {
            return getResources().getIdentifier(resourceName + "red", "drawable", getPackageName());
        } else if (themeName.equals("ThemeGreen")) {
            return getResources().getIdentifier(resourceName + "green", "drawable", getPackageName());
        }
        return 0;
    }
}
