package com.example.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GamePlay extends Activity implements OnClickListener {

	private int counter;
	private int position;
	private final Context gameContext = this;
	private MediaPlayer mp;
	private boolean gameOver;
	private boolean disableSound = false;


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

		View player1Label= findViewById(R.id.textView_player1);
		player1Label.setOnClickListener(this);
		View player2Label= findViewById(R.id.textView_player2);
		player2Label.setOnClickListener(this);

	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  // Save UI state changes to the savedInstanceState.
	  // This bundle will be passed to onCreate if the process is
	  // killed and restarted.
	  savedInstanceState.putBoolean("disableSound", disableSound);
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  // Restore UI state from the savedInstanceState.
	  // This bundle has also been passed to onCreate.
	  disableSound = savedInstanceState.getBoolean("disableSound");
	  Menu menu = (Menu)findViewById(R.menu.tic_tac_toe);
	  MenuItem toggleSoundItemMenu = menu.findItem(R.id.toogle_sound_menu);
	  if(disableSound)
		  toggleSoundItemMenu.setTitle(R.string.toggle_sound_off_label);
	  else
		  toggleSoundItemMenu.setTitle(R.string.toggle_sound_on_label);
	  
	}
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tic_tac_toe, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		//respond to menu item selection
		switch (item.getItemId()) {
		case R.id.action_settings_menu:
			return true;
		case R.id.toogle_sound_menu:
			if(disableSound){
				disableSound = false;
				AlertDialog alert = new AlertDialog.Builder(this).create();
				alert.setTitle("Sound Toggle Notification");
				alert.setMessage("Sound is now Enabled");
				alert.setButton(AlertDialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();

					}
				});
				alert.show();
				item.setTitle(R.string.toggle_sound_on_label);
			}
			else{
				disableSound = true;
				AlertDialog alert = new AlertDialog.Builder(this).create();
				alert.setTitle("Sound Toggle Notification");
				alert.setMessage("Sound is now Disabled");
				alert.setButton(AlertDialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();

					}
				});
				alert.show();
				item.setTitle(R.string.toggle_sound_off_label);
			}
			return true;
		case R.id.about_menu:
			Intent aboutActivity = new Intent(this,About.class);
			startActivity(aboutActivity);
			return true;
		case R.id.help_menu:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}



	@Override
	public void onClick(View v) {

		if(mp != null)
			mp.release();

		if(!disableSound) {
			mp = MediaPlayer.create(this, R.raw.keypress_standard);
			mp.start();
		}

		switch(v.getId()){

		case R.id.user_option_button_1_1 :
			Button b_1_1 = (Button) v;
			setXAndO(b_1_1);
			position  = 1;
			break;
		case R.id.user_option_button_1_2 :
			Button b_1_2 = (Button) v;
			setXAndO(b_1_2);
			position  = 2;
			break;
		case R.id.user_option_button_1_3 :
			Button b_1_3 = (Button) v;
			setXAndO(b_1_3);
			position  = 3;
			break;
		case R.id.user_option_button_2_1 :
			Button b_2_1 = (Button) v;
			setXAndO(b_2_1);
			position  = 4;
			break;
		case R.id.user_option_button_2_2 :
			Button b_2_2 = (Button) v;
			setXAndO(b_2_2);
			position  = 5;
			break;
		case R.id.user_option_button_2_3 :
			Button b_2_3 = (Button) v;
			setXAndO(b_2_3);
			position  = 6;
			break;
		case R.id.user_option_button_3_1 :
			Button b_3_1 = (Button) v;
			setXAndO(b_3_1);
			position  = 7;
			break;
		case R.id.user_option_button_3_2 : 
			Button b_3_2 = (Button) v;
			setXAndO(b_3_2);
			position  = 8;
			break;
		case R.id.user_option_button_3_3 :
			Button b_3_3 = (Button) v;
			setXAndO(b_3_3);
			position  = 9;
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
		case R.id.textView_player1:
			TextView textViewPlayer1 = (TextView) v;
			setPlayerName(textViewPlayer1);
			break;
		case R.id.textView_player2:
			TextView textViewPlayer2 = (TextView) v;
			setPlayerName(textViewPlayer2);
			break;


		}


		if(counter >= 5 && isGameOver(position) && !gameOver){

			gameOver = true;

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(gameContext);

			// set title
			alertDialogBuilder.setTitle("Game Over");

			String player1Name = ((TextView)findViewById(R.id.textView_player1)).getText().toString();
			String player2Name = ((TextView)findViewById(R.id.textView_player2)).getText().toString();

			if(counter % 2 == 0) {
				// set dialog message
				alertDialogBuilder
				.setMessage(player2Name + " Won the Game! \n Restart Game?")
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						Intent restartActivity = new Intent(gameContext,GamePlay.class);
						finish();
						startActivity(restartActivity);
					}
				})
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
				//Player 2 won the game
			}
			else {
				// set dialog message
				alertDialogBuilder
				.setMessage(player1Name + " Won the Game! \n Restart Game?")
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						Intent restartActivity = new Intent(gameContext,GamePlay.class);
						finish();
						startActivity(restartActivity);
					}
				})
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
				//Player 1 won the game
			}

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();

		}
		else if(counter == 9 && !gameOver) {

			gameOver = true;

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(gameContext);
			// set title
			alertDialogBuilder.setTitle("Game Over");

			alertDialogBuilder
			.setMessage("Game Resulted in a Draw! \n Restart Game?")
			.setCancelable(false)
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					Intent restartActivity = new Intent(gameContext,GamePlay.class);
					finish();
					startActivity(restartActivity);
				}
			})
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});

			//No one won the game

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
		}
	}

	private void setXAndO(Button b) {
		if(b.getText().toString().length() == 0) {
			if(counter % 2 == 0)
				b.setText("X");
			else
				b.setText("O");

			counter++;
		}
	}

	private void setPlayerName(final TextView textView) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Title");
		alert.setMessage("Enter Player Name");

		// Set an EditText view to get user input 
		final EditText inputText = new EditText(this);
		alert.setView(inputText);

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				String value = inputText.getText().toString();
				if(value != null && value.length()>0) {
					textView.setText(value);
				}
			}
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				dialog.cancel();
			}
		});

		alert.show();
	}

	private boolean isGameOver(int position) {

		String data11 = ((Button)findViewById(R.id.user_option_button_1_1)).getText().toString();
		String data12 = ((Button)findViewById(R.id.user_option_button_1_2)).getText().toString();
		String data13 = ((Button)findViewById(R.id.user_option_button_1_3)).getText().toString();
		String data21 = ((Button)findViewById(R.id.user_option_button_2_1)).getText().toString();
		String data22 = ((Button)findViewById(R.id.user_option_button_2_2)).getText().toString();
		String data23 = ((Button)findViewById(R.id.user_option_button_2_3)).getText().toString();
		String data31 = ((Button)findViewById(R.id.user_option_button_3_1)).getText().toString();
		String data32 = ((Button)findViewById(R.id.user_option_button_3_2)).getText().toString();
		String data33 = ((Button)findViewById(R.id.user_option_button_3_3)).getText().toString();

		switch(position) {

		case 1:
			if(data11.equals(data12) ? data11.equals(data13) : false) {
				return true;
			}
			if(data11.equals(data21) ? data11.equals(data31) : false) {
				return true;
			}
			if(data11.equals(data22) ? data11.equals(data33) : false) {
				return true;
			}
			break;
		case 2:
			if(data12.equals(data11) ? data12.equals(data13) : false) {
				return true;
			}
			if(data12.equals(data22) ? data12.equals(data32) : false) {
				return true;
			}
			break;
		case 3: 
			if(data13.equals(data11) ? data13.equals(data12) : false) {
				return true;
			}
			if(data13.equals(data22) ? data13.equals(data31) : false) {
				return true;
			}
			if(data13.equals(data23) ? data13.equals(data33) : false) {
				return true;
			}
			break;
		case 4:
			if(data21.equals(data11) ? data21.equals(data31) : false) {
				return true;
			}
			if(data21.equals(data22) ? data21.equals(data23) : false) {
				return true;
			}
			break;
		case 5:
			if(data22.equals(data12) ? data22.equals(data32) : false) {
				return true;
			}
			if(data22.equals(data21) ? data22.equals(data23) : false) {
				return true;
			}
			if(data22.equals(data11) ? data22.equals(data33) : false) {
				return true;
			}
			if(data22.equals(data13) ? data22.equals(data31) : false) {
				return true;
			}
			break;
		case 6:
			if(data23.equals(data13) ? data23.equals(data33) : false) {
				return true;
			}
			if(data23.equals(data21) ? data23.equals(data22) : false) {
				return true;
			}
			break;
		case 7:
			if(data31.equals(data11) ? data31.equals(data21) : false) {
				return true;
			}
			if(data31.equals(data32) ? data31.equals(data33) : false) {
				return true;
			}
			if(data31.equals(data22) ? data31.equals(data13) : false) {
				return true;
			}
			break;
		case 8:
			if(data32.equals(data12) ? data32.equals(data22) : false) {
				return true;
			}
			if(data32.equals(data31) ? data32.equals(data33) : false) {
				return true;
			}
			break;
		case 9:
			if(data33.equals(data11) ? data33.equals(data22) : false) {
				return true;
			}
			if(data33.equals(data13) ? data33.equals(data23) : false) {
				return true;
			}
			if(data33.equals(data31) ? data33.equals(data32) : false) {
				return true;
			}
			break;

		}

		return false;
	}



}

class inputclickListener implements android.content.DialogInterface.OnClickListener {

	TextView textView;

	public inputclickListener(TextView textView){
		this.textView = textView;
	}


	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub

	}

}
