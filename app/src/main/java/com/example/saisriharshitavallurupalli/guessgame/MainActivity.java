package com.example.saisriharshitavallurupalli.guessgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   public static boolean matched;
   public int appNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button guessButton=(Button)findViewById(R.id.guess_Button);
        final TextView result=(TextView)findViewById(R.id.result);
        final EditText userNumber=(EditText)findViewById(R.id.number);
        final Random rand=new Random();
        appNum=rand.nextInt(20)+1;

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              Log.i("app generated",Integer.toString(appNum));

               int userNum=Integer.parseInt(userNumber.getText().toString());
              Toast.makeText(MainActivity.this, Integer.toString(appNum),Toast.LENGTH_LONG);

               if(userNum==appNum)
               {
                   matched=true;

                   result.setText("Your guess was right.Try again if you want to..");
                   //Random rand1=new Random();
                   appNum=rand.nextInt(20)+1;

               }
               else{
                   if(userNum>20||userNum<0)
                   {result.setText("Please Enter a valid number between 1-20.");}
                  else {
                       matched = false;

                       result.setText("Your guess was wrong. You lost!");
                   }
               }

            }
        });

    }
}
