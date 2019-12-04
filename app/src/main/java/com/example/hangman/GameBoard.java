package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameBoard extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        intent = new Intent(this, GameBoard.class);
        final TextView lives = findViewById(R.id.counter);
        lives.setText("7");

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
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter((String) letter.getText());
                System.out.print(letter.getText());
                letter.setEnabled(false);
            }
        });
    }

    //checks whether the letter is in the word
    protected boolean checkLetter(String s) {
        return false;
    }
}
