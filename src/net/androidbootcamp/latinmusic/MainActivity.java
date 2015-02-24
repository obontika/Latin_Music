package net.androidbootcamp.latinmusic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btMarimba, btMerengue;
	MediaPlayer mpMarimba, mpMerengue;
	int playing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btMarimba = (Button) findViewById(R.id.btnMarimba);
		btMerengue = (Button)findViewById(R.id.btnMerengue);
		btMarimba.setOnClickListener(bMarimba);
		btMerengue.setOnClickListener(bMerengue);
		mpMarimba = new MediaPlayer();
		mpMarimba = MediaPlayer.create(this, R.raw.marimba);
		mpMerengue = new MediaPlayer();
		mpMerengue = MediaPlayer.create(this,  R.raw.merengue);
		playing = 0;
	}
	Button.OnClickListener bMarimba = new Button.OnClickListener() {
		

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(playing) {
			    case 0:
				mpMarimba.start();
				playing = 1;
				btMarimba.setText("Pause Marimba Song");
				btMerengue.setVisibility(View.INVISIBLE);
				break;
			    case 1:
				mpMarimba.pause();
				playing = 0;
				btMarimba.setText("Play Marimba Song");
				btMerengue.setVisibility(View.VISIBLE);
				break;
			}
			
		}
    };
    Button.OnClickListener bMerengue = new Button.OnClickListener() {
    	
    	@Override
    	public void onClick(View v) {
    		//TODO Auto-generated method stub
    		switch(playing) {
		    case 0:
			mpMerengue.start();
			playing = 1;
			btMerengue.setText("Pause Merengue Song");
			btMarimba.setVisibility(View.INVISIBLE);
			break;
		    case 1:
			mpMerengue.pause();
			playing = 0;
			btMerengue.setText("Play Merengue Song");
			btMarimba.setVisibility(View.VISIBLE);
    		
    	}
    	}
    };
    }
 
