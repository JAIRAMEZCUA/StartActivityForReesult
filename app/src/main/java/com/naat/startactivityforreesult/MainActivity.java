package com.naat.startactivityforreesult;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static  final int TEXT_REQUEST=1;
    public static  String EXTRA="com.example.android.twiactivities.extraMessage";

    Button button;
    EditText editText;
    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        editText=findViewById(R.id.edt1);
        textView=findViewById(R.id.textViewescribir);
        textView2=findViewById(R.id.textView2);


        //necesitamos decir si esta nulo o no
        /*
      if(savedInstanceState != null){
          String message = savedInstanceState.getString("KEYSTRING","Ninguno");
          textView.setText(message);
      }
*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecondActivity();
            }
        });

    }

    public void launchSecondActivity(){
        Log.d(LOG_TAG,"Button clicked");
        Intent intent= new Intent(MainActivity.this,MainActivity2.class);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA,message);
        //REQUEST ES PARA VER LOS PERMISOS
        //SOLICITANDO CON UN REQUEST Y ESPERO UNA RESPUESTA
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode==RESULT_OK) {
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                textView.setText(reply);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String message=editText.getText().toString();
        textView.setText(message);
        outState.putString("KEYSTRING",message);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String message=editText.getText().toString();
        textView.setText(message);
    }
}