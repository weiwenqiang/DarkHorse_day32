package com.example.day32.startservice;

import com.example.day32.R;
import com.example.day32.startservice.MyService.ZhouMi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestStartService extends Activity implements OnClickListener {
	private Intent intent;
	private MyServiceConn conn;
	
	PublicBusiness pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b1_startservice);
		findViewById(R.id.b1_start).setOnClickListener(this);
		findViewById(R.id.b1_stop).setOnClickListener(this);
		findViewById(R.id.b1_bind).setOnClickListener(this);
		findViewById(R.id.b1_unbind).setOnClickListener(this);
		intent = new Intent(TestStartService.this, MyService.class);
		conn = new MyServiceConn();
		findViewById(R.id.b1_banzheng).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b1_start:
			startService(intent);
			break;
		case R.id.b1_stop:
			stopService(intent);
			break;
		case R.id.b1_bind:
			//�󶨷���
			bindService(intent, conn, BIND_AUTO_CREATE);
			break;
		case R.id.b1_unbind:
			//������
			unbindService(conn);
			break;
		case R.id.b1_banzheng:
			//���м���ǣ�߰�֤
			pb.QianXian();
			break;
		default:
			break;
		}
	}
	class MyServiceConn implements ServiceConnection{
		//�������ӳɹ�ʱ����
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			pb = (PublicBusiness) service;
		}
		//����ʧȥ����ʱ����
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
