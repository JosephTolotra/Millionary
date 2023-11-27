package com.tolojanahary.joseph;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import android.content.SharedPreferences;
import android.content.Context;

public class SecondActivity extends Activity {
	
SharedPreferences pref;
String themeName;



Button btd;
EditText et;
String name;

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
        setContentView(R.layout.second);
btd=(Button)findViewById(R.id.mainButton);
		et=(EditText)findViewById(R.id.et);

    }
    public void btd (View view){
		 name= et.getText().toString();
		if(name.length()==0){
			
			et.setError("Azafady!!! tsy maintsy manome anarana ianao");
			
		}
		
		else{
  Intent i= new Intent(SecondActivity.this,SixthActivity.class);
i.putExtra("name",name);
startActivity(i);
finish();

}
}
}