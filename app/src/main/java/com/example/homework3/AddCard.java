package com.example.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddCard extends AppCompatActivity {

    private Toolbar toolbar;
    private Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Мои карты");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        card = new Card();
        card.setName((EditText) findViewById(R.id.name));
        card.setCategory((EditText) findViewById(R.id.category));
        card.setDiscount((EditText) findViewById(R.id.discount));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addCard(View view) {
        if (card == null) {
            return;
        }

        Intent data = new Intent(this, CardList.class);
        data.putExtra(Card.class.getSimpleName(), card);
        setResult(RESULT_OK, data);
        finish();
    }
}
