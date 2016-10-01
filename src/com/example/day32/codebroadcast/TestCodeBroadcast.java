package com.example.day32.codebroadcast;

import com.example.day32.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestCodeBroadcast extends Activity implements OnClickListener {
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b3_codebroadcast);
		findViewById(R.id.b3_start).setOnClickListener(this);

		intent = new Intent(TestCodeBroadcast.this, RegisterService.class);
		
	}

	public void start() {
		startService(intent);
	}

	public void stop() {
		stopService(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b3_start:
			start();
			break;
		case R.id.b3_stop:
			stop();
			break;
		default:
			break;
		}
	}
}
