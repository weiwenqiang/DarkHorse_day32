package com.example.day32.codebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if(Intent.ACTION_SCREEN_OFF.equals(action)){
			Log.d("��̬ע��㲥", "��Ļ�ر�");
		}else if(Intent.ACTION_SCREEN_ON.equals(action)){
			Log.d("��̬ע��㲥", "��Ļ��");
		}
	}

}
