package sanjay.simplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txt;
    private Button add;
    private ArrayList<String> addArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.name);
        add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if (addArray.contains(getInput)) {
                    Toast.makeText((getBaseContext()), "Plant Already Added", Toast.LENGTH_LONG).show();
                } else {
                    addArray.add(getInput);

                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    intent.putStringArrayListExtra("list", addArray);
                    startActivity(intent);

                    ((TextView) findViewById(R.id.name)).setText(" ");
                }
            }
        });
    }
}
