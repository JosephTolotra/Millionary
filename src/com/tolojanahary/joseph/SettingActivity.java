package com.tolojanahary.joseph;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.graphics.Color;

public class SettingActivity extends Activity {
RadioButton rdb,rdr,rdv;
RadioGroup rd;
TextView tvg;

SharedPreferences pref;
String themeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
		
		rdb=(RadioButton)findViewById(R.id.rdb);
		rdr=(RadioButton)findViewById(R.id.rdr);
		rdv=(RadioButton)findViewById(R.id.rdv);
		rd=(RadioGroup)findViewById(R.id.rd);
   tvg=(TextView)findViewById(R.id.barse);
	
	pref =getSharedPreferences("data",Context.MODE_PRIVATE);
themeName=pref.getString("theme","ThemeBlue");

if(themeName.equals("ThemeBlue")){
tvg.setBackgroundColor(Color.parseColor("#008fed"));
}
else if(themeName.equals("ThemeRed")){
tvg.setBackgroundColor(Color.parseColor("#ff4950"));
}

else if(themeName.equals("ThemeGreen")){
tvg.setBackgroundColor(Color.parseColor("#43c372"));
}



		rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

				@Override
				public void onCheckedChanged(RadioGroup p1, int p2)
				{
					switch (p2){
						case R.id.rdb:
							themeName="ThemeBlue";
		SharedPreferences.Editor editor=pref.edit();
		editor.putString("theme",themeName);
		editor.apply();

tvg.setBackgroundColor(Color.parseColor("#008fed"));

//return value for result
							Intent ret = new Intent();
							setResult(Activity.RESULT_OK,ret);
							//finish();

							break;
						case R.id.rdr:
							themeName="ThemeRed";
		SharedPreferences.Editor editorR=pref.edit();
		editorR.putString("theme",themeName);
		editorR.apply();
  tvg.setBackgroundColor(Color.parseColor("#ff4950"));

//return value for result
							Intent retr = new Intent();
							setResult(Activity.RESULT_OK,retr);
							//finish();

							break;
						case R.id.rdv:
						themeName="ThemeGreen";
		SharedPreferences.Editor editorv=pref.edit();
		editorv.putString("theme",themeName);
		editorv.apply();	


tvg.setBackgroundColor(Color.parseColor("#43c372"));

//return value for result
							Intent retv = new Intent();
							setResult(Activity.RESULT_OK,retv);
							//finish();


							break;
						default:
							break;
				}
			}	
			
		});
}   
}