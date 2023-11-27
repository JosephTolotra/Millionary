package com.tolojanahary.joseph;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
//import de alert dialogue
import android.app.AlertDialog;
import android.widget.Toast;
//import de intent dialogue
import android.content.DialogInterface;

import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends Activity {
SharedPreferences pref;
String themeName;
int SETTINGS_ACTION=1;

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
        setContentView(R.layout.main);
Button btn=(Button)findViewById(R.id.btn);
Button btn1=(Button)findViewById(R.id.btn1);
Button btn2=(Button)findViewById(R.id.btn2);
Button btn3=(Button)findViewById(R.id.btn3);
Button btn4=(Button)findViewById(R.id.btn4);
Button btn5=(Button)findViewById(R.id.btn5);

    }
public void btn (View view){
  Intent i= new Intent(MainActivity.this,SecondActivity.class);
startActivity(i);
finish();
}

public void btn1 (View view){
  Intent i= new Intent(MainActivity.this,ThirdActivity.class);
startActivity(i);


}


public void btn2 (View view){
  Intent i= new Intent(MainActivity.this,FourthActivity.class);
startActivity(i);

}

public void btn3 (View view){
  Intent i= new Intent(MainActivity.this,FifthActivity.class);
startActivity(i);

}

public void btn5 (View view){
startActivityForResult(new Intent(MainActivity.this,
					SettingActivity.class), SETTINGS_ACTION);


}

protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO: Implement this method
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==1){
			if(resultCode==Activity.RESULT_OK){
				finish();
				startActivity(getIntent());
				return;
			}
		}
	}


public void btn4 (View view){
  AlertDialog.Builder builder = new AlertDialog.Builder(this);
//title de alert dialogue
 builder.setTitle("Confirmation ny fialana");
//message de alert
 builder.setMessage("Tena hiala ve ianao??");
//bouton Oui
 builder.setPositiveButton("Eny", new DialogInterface.OnClickListener() { 
 @Override
public void onClick(DialogInterface arg0, int arg1) {
   finish () ;
} 
}); 
builder.setNegativeButton("Tsia", new DialogInterface.OnClickListener() { 
@Override
public void onClick(DialogInterface dialog, int which) { 
Toast.makeText(getApplicationContext(),"misaotra tsy niala", Toast.LENGTH_SHORT).show();
} 
});
 builder.setCancelable(false); 
 builder.show();

} 
}