package be.stefan.formtocall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class condition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);


        Button bt_close = (Button) findViewById(R.id.close);
        bt_close.setOnClickListener(v -> {
            finish();
        });
    }
}