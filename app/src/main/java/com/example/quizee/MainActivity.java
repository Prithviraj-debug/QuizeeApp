package com.example.quizee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<index, questions> extends AppCompatActivity {
    private final String[] questions = {
            "1. In school, Albert Einstein failed most of the subjects, except for physics and math.",
            "2. The first song ever sung in the space was “Happy Birthday.”",
            "3. The first country in the world to use postcards was the United States of America.",
            "4. A male canary tends to have a better singing voice than a female canary.",
            "5. Tea contains more caffeine than coffee and soda.",
            "6. Dogs have an appendix.",
            "7. Bill Gates is the founder of Amazon.",
            "8. Mice have more bones than humans.",
            "9. John F. Kennedy is one of the four U.S. President who is on Mount Rushmore.",
            "10. The first product with a bar code was chewing gum.",
            "11. Quidditch is the most popular sport among witches and wizards in “Harry Potter”.",
            "12. The Beatles is a famous rock band from Manchester, the United Kingdom.",
            "13. Machu Picchu is an abandoned Incan citadel located in Chile.",
            "14. The star is the most common symbol used in all national flags around the world.",
            "15. Black is the most commonly used colour in all national flags around the world."
    };
    private final boolean[] answers = {true, true, false, true, false, false, false, true, false, true, true, false, false, true, false};
    public int score = 0;
    Button yes;
    Button no;
    Button result;
    TextView ques;

    private int index = 0;

    public static final String EXTRA_NAME = "com.example.quizee.result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        result = findViewById(R.id.result);
        ques = findViewById(R.id.ques);
        ques.setText(questions[index]);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index <= questions.length - 1){
                        if (answers[index]){
                            score++;
                        }
                        index++;
                        if (index <= questions.length - 1){
                            ques.setText(questions[index]);
                        }
                }
                else{
                    result.setEnabled(true);
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index <= questions.length - 1){
                    if (!answers[index]){
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1){
                        ques.setText(questions[index]);
                    }

                }

                else{
                    result.setEnabled(true);
                }
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Your Score is: " + score + " / " + questions.length, Toast.LENGTH_SHORT).show();
            }
        });

    }
}