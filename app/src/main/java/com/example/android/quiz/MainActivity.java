/**
 * This application is a project for Android Basics Nanodegree by Google.
 * <p>
 * The task was to make an educational app (a quiz) on any topic.
 * The quiz has 4 questions with radio buttons, check boxes and a text entry.
 * <p>
 * Following the requirements, the layouts of this single-activity app includes:
 * TextView, ImageView, ScrollView, View, RadioGroup, RadioButton, Button, CheckBox, EditText,
 * LinearLayout and RelativeLayout. The score is shown in a Toast message.
 * <p>
 * Image – Daniel Shearing
 */

package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int NUMBER_OF_QUESTIONS = 4;

    // no questions are answered at the beginning,
    // thus initially all the values are false by default
    boolean answeredQuestion[] = new boolean[NUMBER_OF_QUESTIONS];
    int[] point = {0, 0, 0, 0}; //points for answers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @param view; this method is called when Question 1 is answered,
     *              ie button CHOOSE is clicked
     */
    public void question1(View view) {

        answeredQuestion[0] = true; //yes, now Question 1 is answered

        RadioGroup radioGroup = findViewById(R.id.radio_group_1);
        //checks if the answer is correct
        if (radioGroup.getCheckedRadioButtonId() == findViewById(R.id.answer_1_3).getId())
            point[0] = 1;
        else
            point[0] = 0;
        //oops, now it is false (although you may have chosen the right answer before)
    }

    /**
     * @param view; this method is called when Question 1 is answered,
     *              ie button CHOOSE is clicked
     */
    public void question2(View view) {

        answeredQuestion[1] = true; //yes, now Question 1 is answered

        RadioGroup radioGroup = findViewById(R.id.radio_group_2);

        //checks if the answer is correct
        if (radioGroup.getCheckedRadioButtonId() == findViewById(R.id.answer_2_1).getId())
            point[1] = 1;
        else
            point[1] = 0;
        //oops, now it is false (although you may have chosen the right answer before)
    }

    /**
     * @param view; this method is called when Question 3 is answered,
     *              ie button CHOOSE is clicked
     */
    public void question3(View view) {

        answeredQuestion[2] = true; //yes, now Question 3 is answered

        CheckBox answer_3_1 = findViewById(R.id.answer_3_1);
        boolean answer_3_1_Chosen = answer_3_1.isChecked();

        CheckBox answer_3_2 = findViewById(R.id.answer_3_2);
        boolean answer_3_2_Chosen = answer_3_2.isChecked();

        CheckBox answer_3_3 = findViewById(R.id.answer_3_3);
        boolean answer_3_3_Chosen = answer_3_3.isChecked();

        CheckBox answer_3_4 = findViewById(R.id.answer_3_4);
        boolean answer_3_4_Chosen = answer_3_4.isChecked();

        // checks if the answer is correct
        if (answer_3_1_Chosen && answer_3_3_Chosen && !answer_3_2_Chosen && !answer_3_4_Chosen)
            point[2] = 1;
        else
            point[2] = 0;
        //oops, now it is false (although you may have chosen the right answer before)
    }

    /**
     * @param view; this method is called when Question 4 is answered,
     *              ie button CHOOSE is clicked
     */
    public void question4(View view) {

        answeredQuestion[3] = true; //yes, now Question 4 is answered

        EditText answer_4 = findViewById(R.id.answer_4);
        String answer_4_Correct = answer_4.getText().toString();
        if (answer_4_Correct.trim().equals("2016"))// trims spaces and checks if the answer is correct
            point[3] = 1;
        else
            point[3] = 0;
        //oops, now it is false (although you may have chosen the right answer before)
    }

    public void theScore(View view) {

        int score = 0;

        String encouragement[] = new String[NUMBER_OF_QUESTIONS + 1];

        encouragement[0] = getString(R.string.encouragement_0);
        encouragement[1] = getString(R.string.encouragement_1);
        encouragement[2] = getString(R.string.encouragement_2);
        encouragement[3] = getString(R.string.encouragement_3);
        encouragement[4] = getString(R.string.encouragement_4);

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            if (!answeredQuestion[i]) {
                Toast.makeText(getApplicationContext(), R.string.questions_omitted, Toast.LENGTH_LONG).show();
                return;
            } else {
                score += point[i];
            }
        }
        String theMessage = "Your score is " + score + "/" + NUMBER_OF_QUESTIONS + " "
                + encouragement[score] + " " + getString(R.string.encouragement_to_all);

        Toast.makeText(getApplicationContext(), theMessage, Toast.LENGTH_LONG).show();
        return;
    }
}
