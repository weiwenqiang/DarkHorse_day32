package com.example.day32.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	//��ʱ����
	@Override
	public IBinder onBind(Intent intent) {
		Log.d("������������", "onBind��");
		return new ZhouMi();
	}
	
	class ZhouMi extends Binder implements PublicBusiness{
		public void QianXian(){
			banZheng();
		}
		
		public void DaMaJiang(){
			
		}
	}
	
	public void banZheng(){
		Log.d("MyService", "������֤");
	}
	//���ʱ����
	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("������������", "onUnbind���");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("������������", "onCreate����");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("������������", "onStartCommand����");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("������������", "onDestroy����");
	}
	
}
