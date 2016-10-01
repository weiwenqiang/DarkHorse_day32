package com.example.day32.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	//绑定时调用
	@Override
	public IBinder onBind(Intent intent) {
		Log.d("服务生命周期", "onBind绑定");
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
		Log.d("MyService", "李处帮你办证");
	}
	//解绑时调用
	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("服务生命周期", "onUnbind解绑");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("服务生命周期", "onCreate创建");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("服务生命周期", "onStartCommand启动");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("服务生命周期", "onDestroy销毁");
	}
	
}
