package com.example.day32.codebroadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class RegisterService extends Service {
	private ScreenReceiver receiver;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		//代码注册广播接收者
		//1.创建广播接收者对象
		receiver = new ScreenReceiver();
		//2.创建意图过滤器对象
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
//		//电量改变广播
//		filter.addAction(Intent.ACTION_BATTERY_CHANGED);
//		//低电广播
//		filter.addAction(Intent.ACTION_BATTERY_LOW);
//		//恢复到正常电量广播
//		filter.addAction(Intent.ACTION_BATTERY_OKAY);
		//3.注册广播接收者
		registerReceiver(receiver, filter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//代码解除广播接收者
		unregisterReceiver(receiver);
	}
}
