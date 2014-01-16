package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.text.*;
import java.util.*;
import android.view.ViewGroup.*;
import android.util.*;


public class inAppLog extends Thread implements OnClickListener
{


	
	TextView inAppLog;
	TextView inAppLogSL;
	ScrollView scroll;
	FrameLayout inapploglay;
	public Activity activity; 
	String time;
	SimpleDateFormat sdf;
	ImageButton play;
	ImageButton pause;
	ImageButton collapse;
	ImageButton expand;
	Boolean playPause;
	Context ctx;
	LayoutParams params;
	private static final String TAG = "inAppLog";

	
	public inAppLog(Activity act){
		this.activity=act;
		ctx = this.activity.getBaseContext();
		sdf = new SimpleDateFormat("HH:mm:ss");	
		inAppLog = (TextView) this.activity.findViewById(R.id.inAppLogTV);
		inAppLogSL = (TextView) this.activity.findViewById(R.id.inAppLogTVSL);
		scroll = (ScrollView) this.activity.findViewById(R.id.scroll);
		inapploglay = (FrameLayout) this.activity.findViewById(R.id.inapploglay);
		play = (ImageButton) this.activity.findViewById(R.id.playButton);
		pause = (ImageButton) this.activity.findViewById(R.id.pauseButton);
		collapse = (ImageButton) this.activity.findViewById(R.id.collapse);
		expand = (ImageButton) this.activity.findViewById(R.id.expand);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		collapse.setOnClickListener(this);
		expand.setOnClickListener(this);
		play.setVisibility(play.GONE);
		expand.setVisibility(expand.GONE);
		inAppLogSL.setVisibility(inAppLogSL.GONE);
		playPause = true;
		params = scroll.getLayoutParams();

		
	}

	public void writeLog(final String str)
	{
		this.activity.runOnUiThread(new Runnable(){
				@Override
				public void run()
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
						inAppLogSL.setText(time + " | " + str);	
					}
					
					Log.d(TAG, str);
				}});
	}
	
	@Override
	public void onClick(View p1)
	{
		switch (p1.getId()){
			case R.id.playButton:
				Toast.makeText(ctx, "play", Toast.LENGTH_SHORT).show();
				play.setVisibility(play.GONE);
				pause.setVisibility(pause.VISIBLE);
				playPause = true;
			break;

			case R.id.pauseButton:
				Toast.makeText(ctx, "pause", Toast.LENGTH_SHORT).show();
				pause.setVisibility(pause.GONE);
				play.setVisibility(play.VISIBLE);
				playPause = false;
			break;
			
			case R.id.collapse:
			//	params.height=40;
				scroll.setVisibility(scroll.GONE);
				collapse.setVisibility(collapse.GONE);
				play.setVisibility(play.GONE);
				pause.setVisibility(pause.GONE);
				expand.setVisibility(expand.VISIBLE);
				inAppLogSL.setVisibility(inAppLogSL.VISIBLE);
			break;
			
			case R.id.expand:
			//	params.height= 100;
				scroll.setVisibility(scroll.VISIBLE);
				collapse.setVisibility(collapse.VISIBLE);
				if(playPause){
					pause.setVisibility(pause.VISIBLE);
				}else{
					play.setVisibility(play.VISIBLE);
				}
				
				expand.setVisibility(expand.GONE);
				inAppLogSL.setVisibility(inAppLogSL.GONE);
			break;
		}
	}
}
