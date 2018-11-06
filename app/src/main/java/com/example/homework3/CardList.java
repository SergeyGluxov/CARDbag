package com.example.homework3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CardList extends AppCompatActivity {

    private Toolbar toolbar;
    private RelativeLayout relateCard;
    private RelativeLayout relatlNoCard;
    private static final int ADD_CARD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Добавить карту");

        relateCard = findViewById(R.id.rl_card);
        relateCard.setVisibility(View.GONE);
        relatlNoCard = findViewById(R.id.rl_no_card);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        relateCard.setVisibility(View.VISIBLE);
        relatlNoCard.setVisibility(View.GONE);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvCategory = findViewById(R.id.tvCategory);
        TextView tvDiscount = findViewById(R.id.tvDiscount);

        Bundle arg = getIntent().getExtras();
        if (arg == null) {
            return;
        }

        Card card = (Card) arg.getSerializable(Card.class.getSimpleName());

        String name = card.getName().toString();
        String category = card.getCategory().toString();
        String discount = card.getDiscount().toString();

        tvName.setText(name);
        tvCategory.setText(category);
        tvDiscount.setText("Скидка " + discount + "%");
        return;

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, AddCard.class);
        startActivityForResult(intent, ADD_CARD);
    }
}