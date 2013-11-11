package com.example.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GamePlay extends Activity implements OnClickListener {
	
	int counter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_play);
		
		View backButton  = findViewById(R.id.game_play_back_button);
		backButton.setOnClickListener(this);
		View restartButton = findViewById(R.id.game_play_restart_button);
		restartButton.setOnClickListener(this);
		View quitButton = findViewById(R.id.game_play_quit_button);
		quitButton.setOnClickListener(this);
		View user11Button = findViewById(R.id.user_option_button_1_1);
		user11Button.setOnClickListener(this);
		View user12Button = findViewById(R.id.user_option_button_1_2);
		user12Button.setOnClickListener(this);
		View user13Button = findViewById(R.id.user_option_button_1_3);
		user13Button.setOnClickListener(this);
		View user21Button = findViewById(R.id.user_option_button_2_1);
		user21Button.setOnClickListener(this);
		View user22Button = findViewById(R.id.user_option_button_2_2);
		user22Button.setOnClickListener(this);
		View user23Button = findViewById(R.id.user_option_button_2_3);
		user23Button.setOnClickListener(this);
		View user31Button = findViewById(R.id.user_option_button_3_1);
		user31Button.setOnClickListener(this);
		View user32Button = findViewById(R.id.user_option_button_3_2);
		user32Button.setOnClickListener(this);
		View user33Button = findViewById(R.id.user_option_button_3_3);
		user33Button.setOnClickListener(this);
		
		
	}
	
	

	@Override
	public void onClick(View v) {

		switch(v.getId()){

		case R.id.user_option_button_1_1 :
			Button b_1_1 = (Button) v;
			setXAndO(b_1_1);
			break;
		case R.id.user_option_button_1_2 :
			Button b_1_2 = (Button) v;
			setXAndO(b_1_2);
			break;
		case R.id.user_option_button_1_3 :
			Button b_1_3 = (Button) v;
			setXAndO(b_1_3);
			break;
		case R.id.user_option_button_2_1 :
			Button b_2_1 = (Button) v;
			setXAndO(b_2_1);
			break;
		case R.id.user_option_button_2_2 :
			Button b_2_2 = (Button) v;
			setXAndO(b_2_2);
			break;
		case R.id.user_option_button_2_3 :
			Button b_2_3 = (Button) v;
			setXAndO(b_2_3);
			break;
		case R.id.user_option_button_3_1 :
			Button b_3_1 = (Button) v;
			setXAndO(b_3_1);
			break;
		case R.id.user_option_button_3_2 : 
			Button b_3_2 = (Button) v;
			setXAndO(b_3_2);
			break;
		case R.id.user_option_button_3_3 :
			Button b_3_3 = (Button) v;
			setXAndO(b_3_3);
			break;
		case R.id.game_play_back_button:
			Intent mainScreenActivity = new Intent(this,TicTacToe.class);
			finish();
			startActivity(mainScreenActivity);
			break;
		case R.id.game_play_restart_button:
			Intent restartActivity = new Intent(this,GamePlay.class);
			finish();
			startActivity(restartActivity);
			break;
		case R.id.game_play_quit_button:
			finish();
			break;


		}
	}
	
	private void setXAndO(Button b) {
		if(counter % 2 == 0)
			b.setText("X");
		else
			b.setText("O");
		
		counter++;
	}



}
