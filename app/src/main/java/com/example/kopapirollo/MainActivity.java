package com.example.kopapirollo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView i_player;
    private ImageView i_bot;
    private ImageView i_b_h1;
    private ImageView i_b_h2;
    private ImageView i_b_h3;
    private ImageView i_p_h1;
    private ImageView i_p_h2;
    private ImageView i_p_h3;
    private TextView tv_tie;
    private Button b_ko;
    private Button b_papir;
    private Button b_ollo;

    private Random random;
    private int guess;
    private int player;
    private int bot;
    private int tie;
    private AlertDialog alertDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        b_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i_player.setImageResource(R.drawable.rock);
                guess = random.nextInt(3);
                if(guess == 0){
                    i_bot.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                    tie++;
                }else if(guess == 1){
                    i_bot.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    bot++;
                    heartloss_p();
                }else if(guess == 2){
                    i_bot.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "A játékos nyert!", Toast.LENGTH_SHORT).show();
                    player++;
                    heartloss_b();
                }

                tv_tie.setText("Döntetlenek száma: "+tie);
                if(player == 3 || bot == 3){
                    GG();
                }
            }
        });
        b_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i_player.setImageResource(R.drawable.paper);
                guess = random.nextInt(3);
                if(guess == 0){
                    i_bot.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "A játékos nyert!", Toast.LENGTH_SHORT).show();
                    player++;
                    heartloss_b();
                }else if(guess == 1){
                    i_bot.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                    tie++;
                }else if(guess == 2){
                    i_bot.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    bot++;
                    heartloss_p();
                }

                tv_tie.setText("Döntetlenek száma: "+tie);
                if(player == 3 || bot == 3){
                    GG();
                }
            }
        });
        b_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i_player.setImageResource(R.drawable.scissors);
                guess = random.nextInt(3);
                if(guess == 0){
                    i_bot.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    bot++;
                    heartloss_p();
                }else if(guess == 1){
                    i_bot.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "A játékos nyert!", Toast.LENGTH_SHORT).show();
                    player++;
                    heartloss_b();
                }else if(guess == 2){
                    i_bot.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                    tie++;
                }

                tv_tie.setText("Döntetlenek száma: "+tie);
            }
        });
    }

    public void GG(){
        if(player == 3){
            alertDialog.setTitle("Győzelem");
            alertDialog.create();
            alertDialog.show();
        }else{
            alertDialog.setTitle("Vereség");
            alertDialog.create();
            alertDialog.show();
        }
    }

    public void heartloss_p(){
        if(bot== 1){
            i_p_h1.setImageResource(R.drawable.heart1);
        }else if(bot == 2){
            i_p_h2.setImageResource(R.drawable.heart1);
        }else if(bot == 3){
            i_p_h3.setImageResource(R.drawable.heart1);
            GG();
        }
    }
    public void heartloss_b(){
        if(player== 1){
            i_b_h3.setImageResource(R.drawable.heart1);
        }else if(player == 2){
            i_b_h2.setImageResource(R.drawable.heart1);
        }else if(player == 3){
            i_b_h1.setImageResource(R.drawable.heart1);
            GG();
        }
    }
    public void ujJatek(){
        i_player.setImageResource(R.drawable.rock);
        i_bot.setImageResource(R.drawable.rock);
        player = 0;
        bot = 0;
        i_p_h1.setImageResource(R.drawable.heart2);
        i_p_h2.setImageResource(R.drawable.heart2);
        i_p_h3.setImageResource(R.drawable.heart2);
        i_b_h1.setImageResource(R.drawable.heart2);
        i_b_h2.setImageResource(R.drawable.heart2);
        i_b_h3.setImageResource(R.drawable.heart2);
        tie = 0;
        tv_tie.setText("Döntetlenek száma: "+tie);

    }

    public void init(){
        i_player = findViewById(R.id.i_player);
        i_bot = findViewById(R.id.i_bot);
        b_ko = findViewById(R.id.b_ko);
        b_ollo = findViewById(R.id.b_ollo);
        b_papir = findViewById(R.id.b_papir);
        random = new Random();
        guess = random.nextInt(3);
        player = 0;
        bot = 0;
        tie = 0;
        i_p_h1 = findViewById(R.id.i_p_h1);
        i_p_h2 = findViewById(R.id.i_p_h2);
        i_p_h3 = findViewById(R.id.i_p_h3);
        i_b_h1 = findViewById(R.id.i_b_h1);
        i_b_h2 = findViewById(R.id.i_b_h2);
        i_b_h3 = findViewById(R.id.i_b_h3);
        tv_tie = findViewById(R.id.tv_tie);
        alertDialog = new android.app.AlertDialog.Builder(this).
                setTitle("Játék vége").
                setMessage("Szeretnél e új játékot?").
                setCancelable(false).
                setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                }).
                setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create();
    }
}