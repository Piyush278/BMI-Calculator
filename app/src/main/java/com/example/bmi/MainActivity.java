package com.example.bmi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Animation animation;
TextView tv,tv2,t3,textno,txtw,txth;
ListView tv1;
//ImageView img,img1;
LinearLayout layout;
    String countryList[] ={"190","185","180","175","170","165","160","155","150","145","140","135","130"};
    private int _xDelta,_yDelta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        tv2=findViewById(R.id.tv2);
        t3=findViewById(R.id.t3);
        txtw=findViewById(R.id.txtweight);
        txth=findViewById(R.id.textheight);
        textno=findViewById(R.id.textno);
       // img=findViewById(R.id.img);
        layout=findViewById(R.id.layout);
        //img1=findViewById(R.id.img1);

        animation = AnimationUtils.loadAnimation(this,R.anim.blink);
        tv.startAnimation(animation);
        tv1=findViewById(R.id.tv1);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.number, R.id.textView, countryList);
        tv1.setAdapter(arrayAdapter);


        tv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String selectedItem = (String) parent.getItemAtPosition(position);

                    t3.setText("Your height(cm) : " + selectedItem);
                    txth.setText(""+selectedItem);
                } catch (Exception ex) {
                    t3.setText(ex.getMessage());
                }
            }
        });
//        img.setOnTouchListener(new ChoiceTouchListener());
        //t3.setOnTouchListener(new ChoiceTouchListener1());

        NumberPicker np = (NumberPicker) findViewById(R.id.np);
try {
    np.setMinValue(31);
    np.setMaxValue(110);

    np.setWrapSelectorWheel(true);

    np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            txtw.setText("" + newVal);

        }
    });
}
catch (Exception ex){
    System.out.println(ex);
    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();

}


    }



//
//
//    private final class ChoiceTouchListener implements View.OnTouchListener {
//
//
//        @Override
//        public boolean onTouch(View view, MotionEvent event) {
//            try{
//                final int Y= (int) event.getRawY();
//            switch(event.getAction() & MotionEvent.ACTION_MASK) {
//                case MotionEvent.ACTION_DOWN:
//                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
//                  _yDelta = Y - layoutParams.topMargin;
//                   layoutParams.height=370;
//                    layoutParams.width=170;
//                    break;
//                case MotionEvent.ACTION_UP:
//                    break;
//
//                case MotionEvent.ACTION_MOVE:
//                    LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)view.getLayoutParams();
//                    layoutParams1.height=370;
//                   layoutParams1.width=430;
//                    layoutParams1.topMargin=Y-_yDelta;
//                    view.setLayoutParams(layoutParams1);
//
//                    break;
//
//            }
//
//               // t3.setText("Change Date: "+getCurrentDate());
//
//
//            }
//            catch (Exception ex){
//                System.out.println(ex);
//            }
//            return true;
//        }
//    }








    public void fadd(View view) {

        String str1 = txtw.getText().toString();


       String str2 = txth.getText().toString();

        if(TextUtils.isEmpty(str1)){
            //txtw.setError("Please enter your weight");
            txtw.requestFocus();
            Toast.makeText(MainActivity.this,"select weight", Toast.LENGTH_SHORT).show();

            return;
        }

        if(TextUtils.isEmpty(str2)){
           // t3.setError("Please enter your height");
            txth.requestFocus();
            Toast.makeText(MainActivity.this,"select height in approx", Toast.LENGTH_SHORT).show();

            return;
        }

            Animation animation;
            animation = AnimationUtils.loadAnimation(this, R.anim.move);
            tv2.startAnimation(animation);
          //  tv2.setSelected(true);
            Intent intent = new Intent(this, bmi.class);
            intent.putExtra("to", "" + txtw.getText());
           intent.putExtra("from", "" + txth.getText());

            startActivity(intent);


    }








}
