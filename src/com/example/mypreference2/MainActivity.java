package com.example.mypreference2;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void buttonMethod(View button){
		// 設定画面起動
		Intent intent = new Intent(this, MyPreferenceActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 設定の読み取り
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		// text1
		TextView text1 = (TextView)findViewById(R.id.textView1);
		boolean anim = pref.getBoolean("pref_anim", false);
		text1.setText("アニメーション設定：" + (anim ? "ON" : "OFF"));
		// text2
		TextView text2 = (TextView)findViewById(R.id.textView2);
		boolean sound = pref.getBoolean("pref_sound", false);
		text2.setText("サウンド設定：" + (sound ? "ON" : "OFF"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
