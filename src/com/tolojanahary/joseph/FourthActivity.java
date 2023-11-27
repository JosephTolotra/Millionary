package com.tolojanahary.joseph;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.content.Context;

public class FourthActivity extends Activity {
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
        setContentView(R.layout.fourth);

Button bts=(Button)findViewById(R.id.bts);
    }
	public void bts (View view){
	
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://m.facebook.com/valentin.nomenjanahry"));
		startActivity(intent);
	}
	
}

//enfin un jeux où tout le monde peut gagner beaucoup d'argent alors "Ne ratez pas". Ce sont les personnes qui jouent seulement qui ont le droit de gagner, Alors n'arretez jamais de jouer avant de gagner le 5000 ar... Bonne Chance!!!