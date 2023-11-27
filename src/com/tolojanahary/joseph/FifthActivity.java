package com.tolojanahary.joseph;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.Context;

public class FifthActivity extends Activity {

SharedPreferences pref;
String themeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

pref =getSharedPreferences("data",Context.MODE_PRIVATE);

themeName=pref.getString("theme","ThemeBlue");

if (themeName.equals("ThemeBlue")) { 
			setTheme(R.style.ThemeBlue);
		} else if (themeName.equals("ThemeRed")) {
			
			setTheme(R.style.ThemeRed);
		} 
     else if (themeName.equals("ThemeGreen")) {
			
			setTheme(R.style.ThemeGreen);
		} 


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);


    }
    
}