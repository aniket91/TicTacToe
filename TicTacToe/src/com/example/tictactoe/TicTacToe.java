package com.example.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class TicTacToe extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tic_tac_toe);
		
		View continueButton  = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		View newgameButton = findViewById(R.id.new_game_button);
		newgameButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tic_tac_toe, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		
		case R.id.continue_button : 
			System.out.println("Continue button Pressed");
			break;
		case R.id.new_game_button:
			System.out.println("New Game button Pressed");
			break;
		case R.id.about_button:
			Intent aboutActivity = new Intent(this,About.class);
			startActivity(aboutActivity);
			break;
		case R.id.exit_button:
			finish();
			break;
		
		}
		
	}

}
