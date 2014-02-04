package com.example.irblaster;

import com.example.ir.R;

import android.hardware.ConsumerIrManager;
import android.hardware.ConsumerIrManager.CarrierFrequencyRange;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG = "ir";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView textView = (TextView)findViewById(R.id.textview);
		
		ConsumerIrManager manager = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ConsumerIrManager.hasIrEmitter()=");
		builder.append(manager.hasIrEmitter());
		Log.d(TAG, "----------------");
		Log.d(TAG, builder.toString());
		Log.d(TAG, "----------------");	
		
		if( manager.hasIrEmitter() == true){
			CarrierFrequencyRange[] ranges = manager.getCarrierFrequencies();
			for(CarrierFrequencyRange range : ranges){
				builder.append(range.getMinFrequency());
				builder.append("/");
				builder.append(range.getMaxFrequency());
				builder.append(" : ");
			}
		}
		textView.setText(builder.toString());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
