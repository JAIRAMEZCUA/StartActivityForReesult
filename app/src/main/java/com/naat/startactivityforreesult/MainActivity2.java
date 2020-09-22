package com.naat.startactivityforreesult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static  String EXTRA_REPLY="com.example.android.twiactivities.extraMessage";
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();

    TextView textView,textView2;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.edt2);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        btn=findViewById(R.id.btnresponder);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reply = editText.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY,reply);
                setResult(RESULT_OK,replyIntent);
                Log.d(LOG_TAG,"END SecondActivity");
                finish();
            }
        });

    }
}