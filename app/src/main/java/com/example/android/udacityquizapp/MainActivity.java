package com.example.android.udacityquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
    }

    public void  onRadioClick1(View view){
        RadioButton radiobox1A = findViewById(R.id.radio1A);
        RadioButton radiobox1B = findViewById(R.id.radio1B);
        RadioButton radiobox1C = findViewById(R.id.radio1C);
        RadioButton radiobox1D = findViewById(R.id.radio1D);

        if (radiobox1A.isChecked()) {
            Toast correctToast = Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT);
            correctToast.show();

            radiobox1B.setEnabled(false);
            radiobox1C.setEnabled(false);
            radiobox1D.setEnabled(false);

            score += 1;

        } else if (radiobox1B.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox1A.setEnabled(false);
            radiobox1C.setEnabled(false);
            radiobox1D.setEnabled(false);

        }else if(radiobox1C.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox1A.setEnabled(false);
            radiobox1B.setEnabled(false);
            radiobox1D.setEnabled(false);

        }else if(radiobox1D.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox1A.setEnabled(false);
            radiobox1C.setEnabled(false);
            radiobox1B.setEnabled(false);
        }

    }

    public void  onRadioClick2(View view){
        RadioButton radiobox2A = findViewById(R.id.radio1A);
        RadioButton radiobox2B = findViewById(R.id.radio1B);
        RadioButton radiobox2C = findViewById(R.id.radio1C);
        RadioButton radiobox2D = findViewById(R.id.radio1D);

        if (radiobox2C.isChecked()) {
            Toast correctToast = Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT);
            correctToast.show();

            radiobox2B.setEnabled(false);
            radiobox2A.setEnabled(false);
            radiobox2D.setEnabled(false);

            score += 1;

        } else if (radiobox2A.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is B", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox2B.setEnabled(false);
            radiobox2C.setEnabled(false);
            radiobox2D.setEnabled(false);

        }else if(radiobox2B.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox2A.setEnabled(false);
            radiobox2C.setEnabled(false);
            radiobox2D.setEnabled(false);

        }else if(radiobox2D.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox2A.setEnabled(false);
            radiobox2C.setEnabled(false);
            radiobox2B.setEnabled(false);
        }

    }

    public void  onRadioClick3(View view){
        RadioButton radiobox3A = findViewById(R.id.radio1A);
        RadioButton radiobox3B = findViewById(R.id.radio1B);
        RadioButton radiobox3C = findViewById(R.id.radio1C);
        RadioButton radiobox3D = findViewById(R.id.radio1D);

        if (radiobox3D.isChecked()) {
            Toast correctToast = Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT);
            correctToast.show();

            radiobox3B.setEnabled(false);
            radiobox3A.setEnabled(false);
            radiobox3C.setEnabled(false);

            score += 1;

        } else if (radiobox3A.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is D", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox3B.setEnabled(false);
            radiobox3C.setEnabled(false);
            radiobox3D.setEnabled(false);

        }else if(radiobox3B.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox3C.setEnabled(false);
            radiobox3D.setEnabled(false);
            radiobox3A.setEnabled(false);

        }else if(radiobox3C.isChecked()){
            Toast wrongToast = Toast.makeText(this, "Wrong Answer, The Correct Answer is A", Toast.LENGTH_SHORT);

            wrongToast.show();

            radiobox3A.setEnabled(false);
            radiobox3B.setEnabled(false);
            radiobox3D.setEnabled(false);
        }

    }



    public void SubmitResults(View view){
        EditText name = findViewById(R.id.name);

        TextView result = findViewById(R.id.resultsDisplay);

        ImageView finalImage = findViewById(R.id.finalImage);

        String messageWin = "Dear " + name.getText() + "\n" + " Congratulation your final score is :" + score;

        String messageLost = "Dear " + name.getText() + "\n" + " Sorry your final score is :" + score;



        if (score < 5){
            finalImage.setImageDrawable((getResources().getDrawable(R.drawable.sad)));
            result.setText(messageLost);
            customMessage();

        } else if (score >= 5){
            finalImage.setImageDrawable((getResources().getDrawable(R.drawable.congratulation)));
            result.setText(messageWin);
            customMessage();
        }


    }

    /**
     * Set a custom Message at a the Bottom
     */
    public void customMessage(){
        TextView info = findViewById(R.id.bottomMessage);
        EditText name = findViewById(R.id.name);

        String displayMessage = "Thank You " + name.getText() + "\n" + "for using the app." + "\n" + "Udacity: Students First";

        info.setText(displayMessage);
    }

    public void shareResults(View view){
        String emailMessage = "I managed " + score + " points on the Audacity Quiz App by Crucialjun";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Results from Udacity quiz App by Crucialjun");
        intent.putExtra(Intent.EXTRA_TEXT, emailMessage);

        startActivity(intent);

    }

    public void resetQuiz(View view){
        TextView info = findViewById(R.id.bottomMessage);
        TextView result = findViewById(R.id.resultsDisplay);
        ImageView finalImage = findViewById(R.id.finalImage);
        RadioButton radioB1a = findViewById(R.id.radio1A);
        RadioButton radioB1b = findViewById(R.id.radio1B);
        RadioButton radioB1c = findViewById(R.id.radio1C);
        RadioButton radioB1d = findViewById(R.id.radio1D);
        RadioButton radioB2a = findViewById(R.id.radio2A);
        RadioButton radioB2b = findViewById(R.id.radio2B);
        RadioButton radioB2c = findViewById(R.id.radio2C);
        RadioButton radioB2d = findViewById(R.id.radio2D);
        RadioButton radioB3a = findViewById(R.id.radio3A);
        RadioButton radioB3b = findViewById(R.id.radio3B);
        RadioButton radioB3c = findViewById(R.id.radio3C);
        RadioButton radioB3d = findViewById(R.id.radio3D);

        score = 0;
        radioB1a.setChecked(false); radioB1b.setChecked(false); radioB1c.setChecked(false); radioB1d.setChecked(false);
        radioB1a.setEnabled(true); radioB1b.setEnabled(true); radioB1c.setEnabled(true); radioB1d.setEnabled(true);
        radioB2a.setChecked(false);radioB2b.setChecked(false);radioB2c.setChecked(false);radioB2d.setChecked(false);
        radioB2a.setEnabled(true);radioB2b.setEnabled(true);radioB2c.setEnabled(true);radioB2d.setEnabled(true);
        radioB3a.setChecked(false);radioB3b.setChecked(false);radioB3c.setChecked(false);radioB3d.setChecked(false);
        radioB3a.setEnabled(true);radioB3b.setEnabled(true);radioB3c.setEnabled(true);radioB3d.setEnabled(true);
        result.setText("");
        finalImage.setImageResource(0);
        info.setText("");






    }


}


