package com.example.day32.music;

import com.example.day32.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestMusicService extends Activity implements OnClickListener {
	Intent intent;
	MusicInterface mi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b2_music);
		findViewById(R.id.b2_play).setOnClickListener(this);
		findViewById(R.id.b2_pause).setOnClickListener(this);
		intent = new Intent(TestMusicService.this, MusicService.class);
		//混合调用，为了把服务所在的进程变成服务进程
		startService(intent);
		bindService(intent, new MusicServiceConn(), BIND_AUTO_CREATE);
		
	}
	
	class MusicServiceConn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mi = (MusicInterface) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b2_play:
			mi.play();
			break;
		case R.id.b2_pause:
			mi.pause();
			break;
		default:
			break;
		}
	}

}
