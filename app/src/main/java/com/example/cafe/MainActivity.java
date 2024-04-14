package com.example.cafe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView editTextName;
    private TextView editTextPassword;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("MainActivity", "onCreate");
        initViews();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextName.getText().toString().trim();
                String passWord = editTextPassword.getText().toString().trim();

                if (userName.isEmpty() || passWord.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.error_fields_empty,
                            Toast.LENGTH_SHORT
                    ).show();
                }else {
                    launchNextScreen(userName);
                }
            }
        });




    }

    public void launchNextScreen(String userName) {
        Intent intent = makeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }

    private void initViews() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
    }
}