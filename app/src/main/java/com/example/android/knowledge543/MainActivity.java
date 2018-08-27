package com.example.android.knowledge543;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnShow = (Button) findViewById(R.id.sumit);


        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                String msg = "";

                final EditText text = (EditText) findViewById(R.id.add_name_view);
                String addName = text.getText().toString();
                if (addName.isEmpty())

                {
                    msg = "Name: Please fill in your Name. ";
                } else

                {
                    msg = "Name: " + addName;
                }

                EditText question6 = (EditText) findViewById(R.id.question1);
                String input = question6.getText().toString();
                if (input.isEmpty()) {
                    msg += "\nQuestion 1: Please fill in your answer! ";
                } else {
                    msg += "\nQuestion 1: " + input;
                }
                if (input.contains("0")) {
                    score = score + 1;
                }


                CheckBox check1 = (CheckBox) findViewById(R.id.c6_1);
                String checkCheck1 = check1.getText().toString();
                CheckBox check2 = (CheckBox) findViewById(R.id.c6_2);
                String checkCheck2 = check2.getText().toString();
                CheckBox check3 = (CheckBox) findViewById(R.id.c6_3);
                String checkCheck3 = check3.getText().toString();

                if (check1.isChecked() && check2.isChecked()) {
                    msg += "\nQuestion 2: " + checkCheck1 + checkCheck2;
                } else if (check1.isChecked() && check3.isChecked()) {
                    msg += "\nQuestion 2: " + checkCheck1 + checkCheck3;
                    score = score + 1;
                } else if (check2.isChecked() && check3.isChecked()) {
                    msg += "\nQuestion 2: " + checkCheck2 + checkCheck3;
                } else {
                    msg += "\n Question 2: Please check your answer again.";
                }

                RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
                if (rg1.getCheckedRadioButtonId() == -1) {
                    msg += "\n Question 3: Please check your answer again.";
                } else {
                    int selectedId1 = rg1.getCheckedRadioButtonId();
                    RadioButton rdButton1 = (RadioButton) findViewById(selectedId1);
                    int correct1 = R.id.correct1;
                    if (selectedId1 == correct1)

                    {
                        score = score + 1;
                    }
                    msg += "\nQuestion 3: " + rdButton1.getText();
                }

                RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
                if (rg2.getCheckedRadioButtonId() == -1) {
                    msg += "\n Question 4: Please check your answer again.";
                } else {
                    int selectedId2 = rg2.getCheckedRadioButtonId();
                    RadioButton rdButton2 = (RadioButton) findViewById(selectedId2);
                    int correct2 = R.id.correct2;
                    if (selectedId2 == correct2)

                    {
                        score = score + 1;
                    }
                    msg += "\nQuestion 4: " + rdButton2.getText();
                }


                RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg3);
                if (rg3.getCheckedRadioButtonId() == -1) {
                    msg += "\n Question 5: Please check your answer again.";
                } else {
                    int selectedId3 = rg3.getCheckedRadioButtonId();
                    RadioButton rdButton3 = (RadioButton) findViewById(selectedId3);
                    int correct3 = R.id.correct3;
                    if (selectedId3 == correct3)

                    {
                        score = score + 1;
                    }
                    msg += "\nQuestion 5: " + rdButton3.getText();
                }


                RadioGroup rg4 = (RadioGroup) findViewById(R.id.rg4);
                if (rg4.getCheckedRadioButtonId() == -1) {
                    msg += "\n Question 6: Please check your answer again.";
                } else {
                    int selectedId4 = rg4.getCheckedRadioButtonId();
                    RadioButton rdButton4 = (RadioButton) findViewById(selectedId4);
                    int correct4 = R.id.correct4;
                    if (selectedId4 == correct4)

                    {
                        score = score + 1;
                    }
                    msg += "\nQuestion 6: " + rdButton4.getText();
                }


                final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                            case DialogInterface.BUTTON_NEUTRAL:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Please confirm your answer: " + "\n" + msg);
                builder.setNegativeButton("Re-Check", dialogClickListener);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener()

                {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (score < 6) {
                            Toast.makeText(getApplicationContext(), "Correct : " + score, Toast.LENGTH_SHORT).show();
                        }
                        if (score == 6) {
                            Toast.makeText(getApplicationContext(), "Good Job! All correct! ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();
            }

        });


    }

}








