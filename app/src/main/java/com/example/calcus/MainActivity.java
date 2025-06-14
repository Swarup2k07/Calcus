package com.example.calcus;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calcus.R;

public class MainActivity extends AppCompatActivity {

    private EditText input1;
    private EditText input2;

    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        output = findViewById(R.id.output);

        add.setOnClickListener(v -> performOperation("+"));
        sub.setOnClickListener(v -> performOperation("-"));
        mul.setOnClickListener(v -> performOperation("*"));
        div.setOnClickListener(v -> performOperation("/"));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void performOperation(String operator) {
        String str1 = input1.getText().toString();
        String str2 = input2.getText().toString();

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        output.setText("Result: " + result);
}
}