package com.example.hangman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.media.AudioManager.ADJUST_UNMUTE;

public class GameBoard extends AppCompatActivity {

    private Intent intent;
    String word;
    String current;
    int lives;
    int count;
    int index = 0;
    String[] words = {"SERENDIPITY", "GOOSE", "DIFFERENT", "HELLO", "ENDING"};
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.creativeminds);
        mediaPlayer.setVolume(40, 40);
        System.out.println("SONG" + R.raw.hands);
        System.out.println(mediaPlayer == null);
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        //mediaPlayer.start();

        startGame();

        final Button exit = findViewById(R.id.exitGame);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
        final Button newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(intent);
            }
        });

    }

    //disables the letter buttons once they're clicked
    protected void createButton(final Button letter) {
        letter.setEnabled(true);
        final TextView wordText = findViewById(R.id.word);
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thisLetter = (String) letter.getText();
                letter.setEnabled(false);
                int difCount = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (thisLetter.equals(word.substring(i, i + 1))) {
                        System.out.println("Is playing: " + mediaPlayer.isPlaying());
                        current = current.substring(0, 2 * i) + thisLetter + current.substring(2 * i + 1);
                        System.out.println(current);
                        wordText.setText(current);
                        count++;
                        difCount++;
                    }
                }
                if (difCount == 0) {
                    TextView livesCount = findViewById(R.id.counter);
                    livesCount.setText(String.valueOf(--lives));
                }
                if (lives == 0) {
                    checkGame("lost");
                }
                if (count == word.length()) {
                    checkGame("won");
                }
            }
        });
    }

    protected void checkGame(String done) {
        String title;
        String message;
        if (done.equals("lost")) {
            title = "Game Over";
            message = "The word was: "  + word;
        } else {
            title = "You won!";
            message = "Would you like to play again?"; //definition of word
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startGame();
            }
        });
        builder.setNegativeButton("Return to Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }

    protected void startGame() {
        intent = new Intent(this, GameBoard.class);
        final TextView livesText = findViewById(R.id.counter);

        //getWord();

        count = 0;
        word = "SERENDIPITY";
        current = "";
        lives = 7;

        livesText.setText(String.valueOf(lives));

        if (index == words.length) {
            index = 0;
        }
        word = words[index];
        index++;


        for (int num = 0; num < word.length(); num++) {
            current += "— ";
        }

        final TextView wordText = findViewById(R.id.word);
        wordText.setText(current);

        final Button a = findViewById(R.id.a);
        createButton(a);
        final Button b = findViewById(R.id.b);
        createButton(b);
        final Button c = findViewById(R.id.c);
        createButton(c);
        final Button d = findViewById(R.id.d);
        createButton(d);
        final Button e = findViewById(R.id.e);
        createButton(e);
        final Button f = findViewById(R.id.f);
        createButton(f);
        final Button g = findViewById(R.id.g);
        createButton(g);
        final Button h = findViewById(R.id.h);
        createButton(h);
        final Button i = findViewById(R.id.i);
        createButton(i);
        final Button j = findViewById(R.id.j);
        createButton(j);
        final Button k = findViewById(R.id.k);
        createButton(k);
        final Button l = findViewById(R.id.l);
        createButton(l);
        final Button m = findViewById(R.id.m);
        createButton(m);
        final Button n = findViewById(R.id.n);
        createButton(n);
        final Button o = findViewById(R.id.o);
        createButton(o);
        final Button p = findViewById(R.id.p);
        createButton(p);
        final Button q = findViewById(R.id.q);
        createButton(q);
        final Button r = findViewById(R.id.r);
        createButton(r);
        final Button s = findViewById(R.id.s);
        createButton(s);
        final Button t = findViewById(R.id.t);
        createButton(t);
        final Button u = findViewById(R.id.u);
        createButton(u);
        final Button v = findViewById(R.id.v);
        createButton(v);
        final Button w = findViewById(R.id.w);
        createButton(w);
        final Button x = findViewById(R.id.x);
        createButton(x);
        final Button y = findViewById(R.id.y);
        createButton(y);
        final Button z = findViewById(R.id.z);
        createButton(z);
    }

}
