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
    private TextView tv_player;
    private TextView tv_bot;
    private TextView tv_results;
    private Button b_ko;
    private Button b_papir;
    private Button b_ollo;
    private Random random;
    private int guess;
    private int player;
    private int bot;
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
                }else if(guess == 1){
                    i_bot.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    bot++;
                }else if(guess == 2){
                    i_bot.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "A játékos nyert!", Toast.LENGTH_SHORT).show();
                    player++;
                }
                tv_results.setText("Eredmény: Ember: "+player+" Computer: "+bot);
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
                }else if(guess == 1){
                    i_bot.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                }else if(guess == 2){
                    i_bot.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                    bot++;
                }
                tv_results.setText("Eredmény: Ember: "+player+" Computer: "+bot);
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
                }else if(guess == 1){
                    i_bot.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "A játékos nyert!", Toast.LENGTH_SHORT).show();
                    player++;
                }else if(guess == 2){
                    i_bot.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                }
                tv_results.setText("Eredmény: Ember: "+player+" Computer: "+bot);
                if(player == 3 || bot == 3){
                    GG();
                }
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

    public void ujJatek(){
        i_player.setImageResource(R.drawable.rock);
        i_bot.setImageResource(R.drawable.rock);
        player = 0;
        bot = 0;
        tv_results.setText("Eredmény: Ember: "+player+" Computer: "+bot);

    }

    public void init(){
        i_player = findViewById(R.id.i_player);
        i_bot = findViewById(R.id.i_bot);
        tv_player = findViewById(R.id.tv_player);
        tv_bot = findViewById(R.id.tv_bot);
        tv_results = findViewById(R.id.tv_results);
        b_ko = findViewById(R.id.b_ko);
        b_ollo = findViewById(R.id.b_ollo);
        b_papir = findViewById(R.id.b_papir);
        random = new Random();
        guess = random.nextInt(3);
        player = 0;
        bot = 0;
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