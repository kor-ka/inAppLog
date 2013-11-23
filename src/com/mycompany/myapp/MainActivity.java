package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener
{


Button btn;
inAppLog ial;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btn);
		ial = new inAppLog(this);
		btn.setOnClickListener(this);
    }
	
	@Override
	public void onClick(View p1)
	{
	ial.writeLog("smth 2 log");
	
	}
}
