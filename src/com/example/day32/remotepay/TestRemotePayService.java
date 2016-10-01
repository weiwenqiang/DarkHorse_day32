package com.example.day32.remotepay;

import com.example.day32.R;
import com.example.day32.remoteservice.PayInterface;
import com.example.day32.remoteservice.PayInterface.Stub;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestRemotePayService extends Activity implements OnClickListener {
	Intent intent;
	MyServiceConnection conn = new MyServiceConnection();
	PayInterface pi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b5_remotepay);
		findViewById(R.id.b5_pay).setOnClickListener(this);
		intent = new Intent();
		intent.setAction("test.day32.remote.pay.service");
		startService(intent);
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b5_pay:
			//����Զ�̷����֧������
			try {
				pi.pay();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}
	class MyServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//��ʵҲ��ǿת�������������˺ܶ��жϣ����������API
			pi = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
