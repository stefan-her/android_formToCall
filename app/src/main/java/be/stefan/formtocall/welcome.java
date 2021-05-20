package be.stefan.formtocall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    public static final String WELCOME_FIRSTNAME = "firstName";
    public static final String WELCOME_LASTNAME = "lastName";
    public static final String WELCOME_PHONE = "phone";
    public static final String WELCOME_MSG = "msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Bundle elements = this.getIntent().getExtras();
        if(elements != null) {
            TextView firstName = (TextView) findViewById(R.id.first_name);
            TextView lastName = (TextView) findViewById(R.id.last_name);
            String phone = new String();

            firstName.setText(elements.getString(WELCOME_FIRSTNAME));
            lastName.setText(elements.getString(WELCOME_LASTNAME));

            Button bt_call = (Button) findViewById(R.id.call);
            bt_call.setOnClickListener(v -> {
                this.call(elements.getString(WELCOME_PHONE));
            });
        }

        Button bt_back = (Button) findViewById(R.id.back);
        bt_back.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra(WELCOME_MSG, elements.getString(WELCOME_FIRSTNAME) + ":(");
            setResult(RESULT_CANCELED, i);
            finish();
        });
    }

    public void call(String nb) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + nb));
        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}