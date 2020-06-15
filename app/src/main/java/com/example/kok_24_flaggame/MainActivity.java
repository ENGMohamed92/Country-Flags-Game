package com.example.kok_24_flaggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button ans_1, ans_2, ans_3, ans_4;
    List<CountryItem> list;
    Random random;
    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        random = new Random();
        img = findViewById(R.id.IV_Flag);
        ans_1 = findViewById(R.id.BTN_01);
        ans_2 = findViewById(R.id.BTN_02);
        ans_3 = findViewById(R.id.BTN_03);
        ans_4 = findViewById(R.id.BTN_04);

        // To Add Flags Ans Names In List
        for (int i = 0; i < new DataBase().answers.length; i++) {
            list.add(new CountryItem(new DataBase().answers[i], new DataBase().flags[i]));
        }

        // To Shuffle The List (Random The List Result)
        Collections.shuffle(list);
        newQuestion(turn);


        ans_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check If That Correct Answer
                if (ans_1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Correct !!", Toast.LENGTH_SHORT).show();

                    // Check If That Last Question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "You Finish The Game", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "WRONG ??", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "You Lost The Game", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        ans_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check If That Correct Answer
                if (ans_2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Correct !!", Toast.LENGTH_SHORT).show();

                    // Check If That Last Question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "You Finish The Game", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "WRONG ??", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "You Lost The Game", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        ans_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check If That Correct Answer
                if (ans_3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Correct !!", Toast.LENGTH_SHORT).show();

                    // Check If That Last Question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "You Finish The Game", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "WRONG ??", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "You Lost The Game", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        ans_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check If That Correct Answer
                if (ans_4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Correct !!", Toast.LENGTH_SHORT).show();

                    // Check If That Last Question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "You Finish The Game", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "WRONG ??", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "You Lost The Game", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });


    } // END On Create

    private void newQuestion(int number) {

        // Set Flag IMG In Screen
        img.setImageResource(list.get(number - 1).getImg());

        // Decide Witch Button Have Correct Answer
        int correct_answer = random.nextInt(4) + 1;

        int btnOne = number - 1;
        int btnTwo = number - 1;
        int btnThree = number - 1;
        int btnFour = number - 1;

        switch (correct_answer) {
            case 1:
                ans_1.setText(list.get(btnOne).getName());

                do {
                    btnTwo = random.nextInt(list.size());
                } while (btnTwo == btnOne);

                do {
                    btnThree = random.nextInt(list.size());
                } while (btnThree == btnOne || btnThree == btnTwo);

                do {
                    btnFour = random.nextInt(list.size());
                } while (btnFour == btnOne || btnFour == btnThree || btnFour == btnTwo);

                ans_2.setText(list.get(btnTwo).getName());
                ans_3.setText(list.get(btnThree).getName());
                ans_4.setText(list.get(btnFour).getName());

                break;

            case 2:
                ans_2.setText(list.get(btnTwo).getName());

                do {
                    btnOne = random.nextInt(list.size());
                } while (btnTwo == btnOne);

                do {
                    btnThree = random.nextInt(list.size());
                } while (btnThree == btnOne || btnThree == btnTwo);

                do {
                    btnFour = random.nextInt(list.size());
                } while (btnFour == btnOne || btnFour == btnThree || btnFour == btnTwo);

                ans_1.setText(list.get(btnOne).getName());
                ans_3.setText(list.get(btnThree).getName());
                ans_4.setText(list.get(btnFour).getName());

                break;
            case 3:
                ans_3.setText(list.get(btnThree).getName());

                do {
                    btnOne = random.nextInt(list.size());
                } while (btnThree == btnOne);

                do {
                    btnTwo = random.nextInt(list.size());
                } while (btnTwo == btnOne || btnThree == btnTwo);

                do {
                    btnFour = random.nextInt(list.size());
                } while (btnFour == btnOne || btnFour == btnThree || btnFour == btnTwo);

                ans_1.setText(list.get(btnOne).getName());
                ans_2.setText(list.get(btnTwo).getName());
                ans_4.setText(list.get(btnFour).getName());

                break;
            case 4:
                ans_4.setText(list.get(btnFour).getName());

                do {
                    btnOne = random.nextInt(list.size());
                } while (btnFour == btnOne);

                do {
                    btnTwo = random.nextInt(list.size());
                } while (btnTwo == btnOne || btnFour == btnTwo);

                do {
                    btnThree = random.nextInt(list.size());
                } while (btnThree == btnOne || btnFour == btnThree || btnThree == btnTwo);

                ans_1.setText(list.get(btnOne).getName());
                ans_2.setText(list.get(btnTwo).getName());
                ans_3.setText(list.get(btnThree).getName());

                break;
        }

    }

}// End Main