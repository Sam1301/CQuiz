package com.example.sam.cquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Function called with submit button is pressed and calculates
     * and displays the score.
     *
     * @param v, where v is the Submit Button view
     */
    public void evaluate(View v) {
        // variable to store score of quiz
        int score = 0;

        // increment score if answers are correct
        if (isFirstCorrect())
            score++;
        if (isSecondCorrect())
            score++;
        if (isThirdCorrect())
            score++;
        if (isFourthCorrect())
            score++;

        // display calculated score
        Toast.makeText(this, String.format(getResources().getString(R.string.score_toast), score), Toast.LENGTH_SHORT).show();
    }

    /**
     * Function to check the answer of first question
     *
     * @return true if answer to first question is correct
     */
    private boolean isFirstCorrect() {
        RadioButton noRadioButton = (RadioButton) findViewById(R.id.no_q1_radiobutton);

        // only check if correct answer radio button is selected
        if (noRadioButton.isChecked())
            return true;

        // wrong answer
        return false;
    }

    /**
     * Function to check the answer of second question
     *
     * @return true if answer to second question is correct
     */
    private boolean isSecondCorrect() {
        CheckBox autoCheckBox = (CheckBox) findViewById(R.id.auto_q2_checkbox);
        CheckBox registerCheckBox = (CheckBox) findViewById(R.id.register_q2_checkbox);
        CheckBox staticCheckBox = (CheckBox) findViewById(R.id.static_q2_checkbox);
        CheckBox externCheckBox = (CheckBox) findViewById(R.id.extern_q2_checkbox);

        // check if all checkboxes are selected as per the answer
        if (autoCheckBox.isChecked() && registerCheckBox.isChecked() &&
                staticCheckBox.isChecked() && externCheckBox.isChecked())
            return true;

        // wrong answer
        return false;
    }

    /**
     * Function to check the answer of third question
     *
     * @return true if answer to third question is correct
     */
    private boolean isThirdCorrect() {
        EditText answerEditText = (EditText) findViewById(R.id.edit_text_q3);

        // checks if text in editText matches right answer
        if (answerEditText.getText().toString().equals("sizeof"))
            return true;

        // wrong answer
        return false;
    }


    /**
     * Function to check the answer of fourth question
     *
     * @return true if answer to first question is correct
     */
    private boolean isFourthCorrect() {
        RadioButton yesRadioButton = (RadioButton) findViewById(R.id.yes_q4_radiobutton);

        // only check if correct answer radio button is selected
        if (yesRadioButton.isChecked())
            return true;

        // wrong answer
        return false;
    }

}
