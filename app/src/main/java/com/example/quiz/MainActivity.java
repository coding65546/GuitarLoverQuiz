package com.example.quiz;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int points;
    int passedQuestions;
    String sixthQuestion;
    String resultMessage;
    String passedQMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates questions points
     */
    public void calculatePoints() {

        // Start getting RadioButton results code
        // From question 1 to question 4
        if (((RadioButton) findViewById(R.id.right_answer_101)).isChecked()) {
            points += 30;
            passedQuestions++;
        } else {
            points -= 30;
        }
        if (((RadioButton) findViewById(R.id.right_answer_102)).isChecked()) {
            points += 30;
            passedQuestions++;
        } else {
            points -= 30;
        }
        if (((RadioButton) findViewById(R.id.right_answer_103)).isChecked()) {
            points += 30;
            passedQuestions++;
        } else {
            points -= 30;
        }
        if (((RadioButton) findViewById(R.id.right_answer_104)).isChecked()) {
            points += 30;
            passedQuestions++;
        } else {
            points -= 30;
        }
        // End of getting RadioButton results code

        // Start getting CheckBox results code
        // Question 5
        CheckBox checkBox1 = findViewById(R.id.chk_bx_1);
        CheckBox checkBox2 = findViewById(R.id.chk_bx_2);
        CheckBox checkBox3 = findViewById(R.id.chk_bx_3);

        // I fixed the bug now, also with simpler code
        if (checkBox1.isChecked() && !checkBox3.isChecked() && !checkBox2.isChecked()) {
            points += 15;
        }
        if (!checkBox1.isChecked() && checkBox3.isChecked() && !checkBox2.isChecked()) {
            points += 15;
        }
        if (checkBox1.isChecked() && checkBox3.isChecked() && !checkBox2.isChecked()) {
            points += 30;
        }
        if (checkBox1.isChecked() && checkBox3.isChecked() && checkBox2.isChecked()) {
            points -= 30;
        }
        if (checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked()) {
            passedQuestions++;
        }
        // End of getting CheckBox results code

        // Start getting EditText results code
        // Question 6
        EditText answerEditText1 = findViewById(R.id.edit_answer);
        sixthQuestion = answerEditText1.getText().toString();

        if (sixthQuestion.equalsIgnoreCase("Slash")) {
            points += 30;
            passedQuestions++;
        } else {
            points -= 30;

        }
        // End of getting EditText results code
    }

    /**
     * Displays the number of passed questions
     */
    private void passedQuestionsNum() {
        passedQMessage = "You Passed ";
        passedQMessage += passedQuestions + " out of 6";

        TextView questionPassed = findViewById(R.id.passed_questions);
        questionPassed.setText(String.valueOf(passedQMessage));
    }

    /**
     * Displays the number of passed questions
     */
    private void displayResult() {
        if (points > 0) {
            resultMessage = "Congrats you won" + "\nyour score is: ";
            resultMessage += "\n" + points + " Points";
        } else {
            resultMessage = "Sorry, You Fail";
        }

        TextView scoreView = findViewById(R.id.points_view);
        scoreView.setText(String.valueOf(resultMessage));

        Toast toast = Toast.makeText(this, resultMessage, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 10, 10);
        toast.show();
    }

    /**
     * Submit Button
     */
    public void onClick(View view) {
        calculatePoints();
        passedQuestionsNum();
        displayResult();
        //Fixing score bug
        passedQuestions = 0;
        points = 0;
    }


}