package be.stefan.formtocall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CODE_ACTIVITE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_insert = (Button) findViewById(R.id.insert);
        bt_insert.setOnClickListener((View v) -> {
            EditText firstName = (EditText) findViewById(R.id.first_name);
            EditText lastName = (EditText) findViewById(R.id.last_name);
            EditText phone = (EditText) findViewById(R.id.phone);

            Intent i = new Intent(MainActivity.this, welcome.class);
            i.putExtra("firstName", firstName.getText().toString());
            i.putExtra("lastName", lastName.getText().toString());
            i.putExtra("phone", phone.getText().toString());
            startActivityForResult(i, CODE_ACTIVITE);

        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            EditText firstName = (EditText) findViewById(R.id.first_name);
            String text = String.format("Bye Bye : %s", firstName.getText().toString());

            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        }
    }
}