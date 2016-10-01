package com.example.day32.remoteservice;

import com.example.day32.R;
import com.example.day32.remoteservice.PublicBusiness.Stub;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class TestRemoteService extends Activity implements OnClickListener {
	private Intent intent;
	private MyServiceConnection conn = new MyServiceConnection();
	
	public PublicBusiness pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b4_memoteservice);
		findViewById(R.id.b4_startremote).setOnClickListener(this);
		findViewById(R.id.b4_stopremote).setOnClickListener(this);
		findViewById(R.id.b4_bindremote).setOnClickListener(this);
		findViewById(R.id.b4_unbindremote).setOnClickListener(this);
		findViewById(R.id.b4_remotebanzheng).setOnClickListener(this);
		intent = new Intent();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b4_startremote:
		{
			//启动远程服务
			intent.setAction("test.day32.remote.service");
			startService(intent);
			break;
		}
		case R.id.b4_stopremote:
		{
			//关闭远程服务
			intent.setAction("test.day32.remote.service");
			stopService(intent);
			break;
		}
		case R.id.b4_bindremote:
		{
			//绑定远程服务
			intent.setAction("test.day32.remote.service");
			bindService(intent, conn, BIND_AUTO_CREATE);
			break;
		}
		case R.id.b4_unbindremote:
		{
			//解绑远程服务
			intent.setAction("test.day32.remote.service");
			unbindService(conn);
			break;
		}
		case R.id.b4_remotebanzheng:
		{
			try {
				pb.QianXian();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		}
		default:
			break;
		}
	}
	class MyServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d("TestRemoteService", "onServiceConnected");
			//把Ibinder中间人对象强转成PublicBusiness
			pb = Stub.asInterface(service);
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d("TestRemoteService", "onServiceDisconnected");
		}
	}
}
