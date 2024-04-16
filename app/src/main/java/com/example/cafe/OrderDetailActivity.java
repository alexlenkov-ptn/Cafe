package com.example.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ADDITIVES = "additives";
    private static final String EXTRA_DRINKTYPE = "drinkType";
    private static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_DRINK = "drink";

    private String userName;
    private String drink;
    private String drinkType;
    private String additives;

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewDrinkType;
    private TextView textViewDrinkAdditives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setupUserName();
        setupDrink();
        setupDrinkType();
        setTextViewDrinkAdditives();
    }
    public static Intent newIntent(Context context,
                                   String userName,
                                   String drink,
                                   String drinkType,
                                   String additives) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_DRINKTYPE, drinkType);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        return intent;
    }

    private void setupUserName() {
        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        textViewName.setText(userName);
    }
    private void setupDrink() {
        drink = getIntent().getStringExtra(EXTRA_DRINK);
        textViewDrink.setText(drink);
    }
    private void setupDrinkType() {
        drinkType = getIntent().getStringExtra(EXTRA_DRINKTYPE);
        textViewDrinkType.setText(drinkType);
    }
    private void setTextViewDrinkAdditives() {
        additives = getIntent().getStringExtra(EXTRA_ADDITIVES);
        textViewDrinkAdditives.setText(additives);
    }

    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewDrinkAdditives = findViewById(R.id.textViewDrinkAdditives);
    }
}