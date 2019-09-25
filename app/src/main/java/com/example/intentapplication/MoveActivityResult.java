package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MoveActivityResult extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_result);

        rgAngka = findViewById(R.id.radio_group);
        Button btnSelect = findViewById(R.id.btn_select);

        btnSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int selectedRB = rgAngka.getCheckedRadioButtonId();
        RadioButton rbSelect = findViewById(selectedRB);
        String selected = rbSelect.getText().toString();
        if (selected.matches("")){
            Toast.makeText(getApplicationContext(),"Harus Memilih",Toast.LENGTH_SHORT).show();
        } else {
            Intent moveWithResult = new Intent(MoveActivityResult.this,MainActivity.class);
            moveWithResult.putExtra(MainActivity.EXTRA_RESULT,selected);
            moveWithResult.putExtra(String.valueOf(MainActivity.EXTRA_ACTIVATED),1);
            startActivity(moveWithResult);
        }
    }
}
