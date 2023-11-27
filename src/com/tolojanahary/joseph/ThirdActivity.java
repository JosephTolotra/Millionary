package com.tolojanahary.joseph;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.DialogInterface;
import android.app.AlertDialog;

public class ThirdActivity extends Activity {

SharedPreferences pref;
String themeName;


 TextView bst1,bst2,bst3,bs2;
 
Button reset;
int best1,best2,best3;
String b1,b2,b3;

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
        setContentView(R.layout.third);

bst1=(TextView)findViewById(R.id.bst1);
bst2=(TextView)findViewById(R.id.bst2);
bst3=(TextView)findViewById(R.id.bst3);
bs2=(TextView)findViewById(R.id.bs2);

reset=(Button)findViewById(R.id.reset);

pref=getSharedPreferences("data",Context.MODE_PRIVATE);

best1=pref.getInt("best1",0);
b1=pref.getString("b1","N/A");
best2=pref.getInt("best2",0);
b2=pref.getString("b2","N/A");
best3=pref.getInt("best3",0);
b3=pref.getString("b3","N/A");

showScore();

reset.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
       AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
//title ni alert dialogue
 builder.setTitle("Tena hanavao ve ianao??");
//message ni alert
 builder.setMessage("Marihina fa voafafa ni isa taloha");
//bouton eny
 builder.setPositiveButton("Eny", new DialogInterface.OnClickListener() { 
 @Override
public void onClick(DialogInterface arg0, int arg1) {
   reseter();
} 
}); 
builder.setNegativeButton("Tsia", new DialogInterface.OnClickListener() { 
@Override
public void onClick(DialogInterface dialog, int which) { 
Toast.makeText(getApplicationContext(),"Tsy navaozina ni isa", Toast.LENGTH_SHORT).show();
} 
});
 builder.setCancelable(false); 
 builder.show();
				}

    });
}
 
private void reseter(){
b1="N/A";
       b2="N/A";
       b3="N/A";
					best1=0;
					best2=0;
					best3=0;
					
					SharedPreferences.Editor editor =pref.edit();
					editor.putInt("best3",best3);
					editor.putInt("best2",best2);
					editor.putInt("best1",best1);
       editor.putString("b3",b3);
					editor.putString("b2",b2);
					editor.putString("b1",b1);
					editor.apply();
					
					showScore();

}
   
private void showScore()
	{
		// TODO: Implement this method
   bs2.setText("Anarana : "+b1+"\n Isa  =  "+best1+"/10   ");      
		bst1.setText("1. "+b1+"  :  "+best1+"/10");
   bst2.setText("2. "+b2+"  :  "+best2+"/10");
   bst3.setText("3. "+b3+"  :  "+best3+"/10");
		
	}
}