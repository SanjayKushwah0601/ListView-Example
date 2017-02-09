package sanjay.simplelist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Sanjay on 2/9/2017.
 */
public class ListActivity extends AppCompatActivity {
    private ListView list;
    private ArrayList<String> addArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView) findViewById(R.id.listView);
        addArray = new ArrayList<>();

        //first clear all the contents in list if there is any
        addArray.clear();

        // Now fetch the contents from intent
        addArray = getIntent().getStringArrayListExtra("list");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, addArray);
        list.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
