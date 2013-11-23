package com.mycompany.myapp;

import android.app.*;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;


public class inAppLog
{
	TextView inAppLog;
	ScrollView scroll;
	public Activity activity; 
	String time;
	SimpleDateFormat sdf;
	Button play;
	Button pause;
	Boolean playPause = true;
	
	public inAppLog(Activity act){
		this.activity=act;
		sdf = new SimpleDateFormat("HH:mm:ss");	
	//	Toast.makeText(act.getBaseContext(), "", Toast.LENGTH_SHORT).show();
		inAppLog = (TextView) this.activity.findViewById(R.id.inAppLogTV);
		scroll = (ScrollView) this.activity.findViewById(R.id.scroll);
	}

	public void writeLog(String str)
	{
		if (playPause)
		{
			time = sdf.format(new Date(System.currentTimeMillis()));
			
			inAppLog.setText(inAppLog.getText().toString() + "\n" + time + " | " + str);
			scroll.post(new Runnable() {            
					@Override
					public void run()
					{
						scroll.fullScroll(View.FOCUS_DOWN);              
					}
				});	
		}
	}
	
	
}
