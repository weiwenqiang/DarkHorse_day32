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
		//����ע��㲥������
		//1.�����㲥�����߶���
		receiver = new ScreenReceiver();
		//2.������ͼ����������
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
//		//�����ı�㲥
//		filter.addAction(Intent.ACTION_BATTERY_CHANGED);
//		//�͵�㲥
//		filter.addAction(Intent.ACTION_BATTERY_LOW);
//		//�ָ������������㲥
//		filter.addAction(Intent.ACTION_BATTERY_OKAY);
		//3.ע��㲥������
		registerReceiver(receiver, filter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//�������㲥������
		unregisterReceiver(receiver);
	}
}
