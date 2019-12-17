package com.example.androidtips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.androidtips.R.id;
import static com.example.androidtips.R.layout;
/*
    MainActivity.java
   @author Luke Vakasisikakala
   @version 04/29/19
   Tip calculator that finds out how much you owe in total
   and the tip percentage.

 */

public class MainActivity extends AppCompatActivity {

//    Creates the layout for the application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }
//    Method that calculates the final amount and actual tip percentage
//    and places the values into the designated text fields
        public void calculate(View view){
            EditText s = (EditText) findViewById(id.amtDue);
            EditText r = (EditText) findViewById(id.tipPerc);
            EditText q = (EditText) findViewById(id.roundTo);
            TipModel tp = new TipModel();
            double amt = Double.parseDouble(s.getText().toString());
            double tip = Double.parseDouble(r.getText().toString());
            double round = Double.parseDouble(q.getText().toString());

            tp.setTipPerc(amt, tip);
            double finalAmt = (tp.getTipPerc() + amt);
            tp.setRoundedTotal(finalAmt, round);
            tp.setTotalBill(tp.getRoundedTotal(), 2);
            finalAmt = Double.parseDouble(tp.getTotalBill());

            tp.setString(finalAmt);
            String finalAmt1 = tp.getString();

            TextView x = findViewById(id.actTip);
            tp.setRoundedTip(tip);
            x.setText(tp.getRoundedTip() + "%");


            TextView z = findViewById(id.finalAmt);
            z.setText(finalAmt1);
        }


}
