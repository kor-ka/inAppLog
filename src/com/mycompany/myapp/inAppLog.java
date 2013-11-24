package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.text.*;
import java.util.*;


public class inAppLog implements OnClickListener
{


	
	TextView inAppLog;
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
	
	public inAppLog(Activity act){
		this.activity=act;
		ctx = this.activity.getBaseContext();
		sdf = new SimpleDateFormat("HH:mm:ss");	
		inAppLog = (TextView) this.activity.findViewById(R.id.inAppLogTV);
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
		playPause = true;
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
				scroll.setVisibility(scroll.GONE);
				collapse.setVisibility(collapse.GONE);
				play.setVisibility(play.GONE);
				pause.setVisibility(pause.GONE);
				expand.setVisibility(expand.VISIBLE);
			break;
			
			case R.id.expand:
				scroll.setVisibility(scroll.VISIBLE);
				collapse.setVisibility(collapse.VISIBLE);
				if(playPause){
					pause.setVisibility(pause.VISIBLE);
				}else{
					play.setVisibility(play.VISIBLE);
				}
				
				expand.setVisibility(expand.GONE);
			break;
		}
	}
}
