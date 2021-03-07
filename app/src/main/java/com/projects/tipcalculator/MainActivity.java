package com.projects.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtEdit;
    private TextView percentage;
    private TextView txt1;
    private TextView txt2;
    private SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = findViewById(R.id.seekBar);
        txtEdit = findViewById(R.id.text);
        percentage = findViewById(R.id.textView);
        txt1 = findViewById(R.id.textView3);
        txt2 = findViewById(R.id.textView7);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentage.setText(progress + "%");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    public void calculate() {
        String txtValue = txtEdit.getText().toString();
        if (txtValue == null || txtValue.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro", Toast.LENGTH_SHORT).show();
        }
        else {
            double num = Double.parseDouble(txtValue) * sb.getProgress() / 100;
            double total = Double.parseDouble(txtValue) + num;
            txt1.setText("R$ " + num);
            txt2.setText("R$ " + total);
        }
    }

}