package com.example.andreea.eightball;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    ImageButton eight_ball_button;
    TextView ball_answer;
    EditText input;
    List<String> ball_answers =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eight_ball_button = findViewById(R.id.eight_ball);
        ball_answer = findViewById(R.id.answer);
        input = findViewById(R.id.user_input);

        eight_ball_button.setOnClickListener(this);

        // positive
        ball_answers.add("It is certain.");
        ball_answers.add("It is decidedly so.");
        ball_answers.add("Without a doubt.");
        ball_answers.add("Yes - definitely.");
        ball_answers.add("You may rely on it.");
        ball_answers.add("As I see it, yes.");
        ball_answers.add("Most likely.");
        ball_answers.add("Outlook good.");
        ball_answers.add("Yes.");
        ball_answers.add("Signs point to yes");

        // non-committal
        ball_answers.add("Reply hazy, try again.");
        ball_answers.add("Ask again later.");
        ball_answers.add("Better not tell you now.");
        ball_answers.add("Cannot predict now.");
        ball_answers.add("Concentrate and ask again.");

        // negative
        ball_answers.add("Don't count on it.");
        ball_answers.add("My reply is no.");
        ball_answers.add("My sources say no.");
        ball_answers.add("Outlook not so good.");
        ball_answers.add("Very doubtful");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eight_ball:
                if (input.getText().length() == 0) {
                    ball_answer.setText("Give me a question");
                }
                else{
                    String user_question = input.getText().toString();
                    if (user_question.contains("?")) {
                        ball_answer.setText(ball_answers.get(random_number()));
                    }
                    else{
                        ball_answer.setText("Concentrate and ask again.");
                    }
                }
        }
    }


    int random_number(){
        int min = 0;
        int max = 19;
        Random r = new Random();
        int value = r.nextInt(max-min+1)+min;
        return value;
    }
}
