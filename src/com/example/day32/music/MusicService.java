package com.example.day32.music;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		
		return new MusicController();
	}
	
	class MusicController extends Binder implements MusicInterface{
		public void play(){
			MusicService.this.play();
		}
		public void pause(){
			MusicService.this.pause();
		}
	}
	
	public void play(){
		Log.d("��̨���ַ���", "��������");
	}
	public void pause(){
		Log.d("��̨���ַ���", "��ͣ����");
	}
}
