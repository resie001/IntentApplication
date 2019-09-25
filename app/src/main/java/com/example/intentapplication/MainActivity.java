package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_RESULT = null;
    public static final int EXTRA_ACTIVATED = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity;
        Button btnMoveActivityWithData;
        Button btnDialNumber;
        Button btnMoveActivityWithResult;
        TextView tvResult;

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_with_data);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnMoveActivityWithResult = findViewById(R.id.btn_move_activity_with_result);
        tvResult = findViewById(R.id.tv_result);

        btnMoveActivity.setOnClickListener(this);
        btnMoveActivityWithData.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnMoveActivityWithResult.setOnClickListener(this);

        String recieve = getIntent().getStringExtra(EXTRA_RESULT);
        if (recieve == null){
            tvResult.setText("Hasil Dari Activity");
        } else {
            tvResult.setText(recieve);
        }


//        if (EXTRA_ACTIVATED == 1){
//            String recieve = getIntent().getStringExtra(EXTRA_RESULT);
//            tvResult.setText(recieve);
//        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent intent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_move_activity_with_data:
                Intent moveWithData = new Intent(MainActivity.this,MoveActivityData.class);
                moveWithData.putExtra(MoveActivityData.EXTRA_NAME,"Ade Resie Muchorobbi Setiawan");
                moveWithData.putExtra(MoveActivityData.EXTRA_AGE,"20");
                startActivity(moveWithData);
                break;
            case R.id.btn_dial_number:
                String numberPhone = "082219727572";
                Intent dialNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+numberPhone));
                startActivity(dialNumber);
                break;
            case R.id.btn_move_activity_with_result:
                Intent moveWithResult = new Intent(MainActivity.this,MoveActivityResult.class);
                startActivity(moveWithResult);
                break;
        }
    }
}
