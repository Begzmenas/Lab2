package com.example.lab2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner countSpinner = findViewById(R.id.spSelector);
        ArrayList<String> options = new ArrayList<>();
        options.add("Words");
        options.add("Symbols");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item, R.id.spinner_item_text, options);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        countSpinner.setAdapter(adapter);

        countSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id  ) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,"Selected: "+ selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        TextView countView = findViewById(R.id.countView);
        Button CountBtn = findViewById(R.id.btnCount);
        EditText edUserInput = findViewById(R.id.edUserInputText);
        CountBtn.setOnClickListener(v-> {
            String selectedOption = (String) countSpinner.getSelectedItem();
            String inputText = edUserInput.getText().toString();
            int count = Functions.countText(MainActivity.this, selectedOption, inputText);
            if(count > 0)
                countView.setText("  Count: " + count);
        });
        }
}