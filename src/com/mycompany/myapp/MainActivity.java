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
Thread one;
Context ctx;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		runOnUiThread(new Runnable(){

				public void run()
				{
        setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btn);
		
		}
		});
		ctx = getBaseContext();
		ial = new inAppLog(this);
		btn.setOnClickListener(this);
    }
	
	@Override
	public void onClick(View p1)
	{
	ial.writeLog("smth 2 log");
		new Thread(new Runnable() {
				public void run() {
					
					do  {

						try
						{
							//Toast.makeText(ctxx, "service running...", Toast.LENGTH_LONG).show();
							ial.writeLog("fr th");
							Thread.sleep(1000);
							
						}
						catch (InterruptedException e)
						{}

					}while(true);

				}
			}).start();
	}
}
