package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class bmi extends AppCompatActivity {
TextView tv1,tv2,tv3,t4,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
         t4=findViewById(R.id.tv4);
         t3=findViewById(R.id.t3);



        String TempHolder = getIntent().getStringExtra("to");
        tv3.setText(TempHolder);

        String TempHolder1 = getIntent().getStringExtra("from");
        t4.setText(TempHolder1);

        final DecimalFormat df2 = new DecimalFormat(".##");
        Double weight,height,heightinmeter,bmi,finalht;
        weight=Double.parseDouble(""+tv3.getText());
        height=Double.parseDouble(""+t4.getText());
        bmi=weight/(height*height)*10000;
        tv1.setText(""+df2.format(bmi));

        float _heightSquare=(float) pow(height/100, 2);

        int minWeightAtHeight= (int) (18.5 * _heightSquare);

        int maxWeightAtHeight = (int) (25 * _heightSquare);

        t3.setText("Normal weight at your height should be in range " +minWeightAtHeight+"kg to "+ maxWeightAtHeight+"kg");

        if(bmi<18.5)
        {
            tv2.setText("underweight");
        }
        else if(bmi>18.5&&bmi<25)
        {
            tv2.setText("normal weight");
        }
        else if(bmi>25&&bmi<30)
        {
            tv2.setText("overweight");
        }
        else if(bmi>30&&bmi<40)
        {
            tv2.setText("obesity");
        }
        else if(bmi>40)
        {
            tv2.setText("severe obesity");
        }
    }


    public void fsub(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
