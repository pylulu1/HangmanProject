package com.example.hangman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameBoard extends AppCompatActivity {

    private Intent intent;
    String word = "MOOSE";
    String current = "";
    int lives = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        start();

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
        final TextView wordText = findViewById(R.id.word);
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thisLetter = (String) letter.getText();
                letter.setEnabled(false);
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (thisLetter.equals(word.substring(i, i + 1))) {
                        current = current.substring(0, 2 * i) + thisLetter + current.substring(2 * i + 1);
                        System.out.println(current);
                        wordText.setText(current);
                        count++;
                    }
                }
                if (count == 0) {
                    TextView livesCount = findViewById(R.id.counter);
                    livesCount.setText(String.valueOf(--lives));
                }
                if (lives == 0) {
                    checkGame();
                }
            }
        });
    }

    protected void checkGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        builder.setMessage("The word was: "  + word);
        builder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                start();
            }
        });
        //builder.setNegativeButton("Return to Home", (dialog, id) -> finish());
    }

    protected void start() {
        //intent = new Intent(this, GameBoard.class);
        final TextView livesText = findViewById(R.id.counter);
        livesText.setText(String.valueOf(lives));

        //set word from api here

        for (int num = 0; num < word.length(); num++) {
            current += "— ";
        }

        final TextView wordText = findViewById(R.id.word);
        wordText.setText(current);
    }

}
