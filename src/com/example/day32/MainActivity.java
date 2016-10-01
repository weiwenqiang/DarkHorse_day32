package com.example.day32;

import com.example.day32.codebroadcast.TestCodeBroadcast;
import com.example.day32.music.TestMusicService;
import com.example.day32.remotepay.TestRemotePayService;
import com.example.day32.remoteservice.TestRemoteService;
import com.example.day32.startservice.TestStartService;
import com.example.day32.styles.TestStyles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		findViewById(R.id.day32_b1).setOnClickListener(this);
		findViewById(R.id.day32_b2).setOnClickListener(this);
		findViewById(R.id.day32_b3).setOnClickListener(this);
		findViewById(R.id.day32_b4).setOnClickListener(this);
		findViewById(R.id.day32_b5).setOnClickListener(this);
		findViewById(R.id.day32_b6).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.day32_b1:
			startActivity(new Intent(MainActivity.this, TestStartService.class));
			break;
		case R.id.day32_b2:
			startActivity(new Intent(MainActivity.this, TestMusicService.class));
			break;
		case R.id.day32_b3:
			startActivity(new Intent(MainActivity.this, TestCodeBroadcast.class));
			break;
		case R.id.day32_b4:
			startActivity(new Intent(MainActivity.this, TestRemoteService.class));
			break;
		case R.id.day32_b5:
			startActivity(new Intent(MainActivity.this, TestRemotePayService.class));
			break;
		case R.id.day32_b6:
			startActivity(new Intent(MainActivity.this, TestStyles.class));
			break;
		default:
			break;
		}
	}
}
