package com.example.ominext.countdownwatch;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (!text.equalsIgnoreCase("")) {
                    int seconds = Integer.valueOf(text);
                    CountDownTimer countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                        @Override
                        public void onTick(long millis) {
                            textView.setText("seconds: " + (int) (millis / 1000));
                        }

                        @Override
                        public void onFinish() {
                            textView.setText("Finished");
                        }
                    }.start();
                }
            }
        });
    }
}
