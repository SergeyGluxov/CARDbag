package info.goodline.cardbag;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CardAddActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Добавить карту");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

    public void btSaveCard(View view) {

        String tvName = findViewById(R.id.tvName).toString();
        String tvCategory = findViewById(R.id.tvCategory).toString();
        String tvDiscount = findViewById(R.id.tvDiscount).toString();

        card = new Card();
        card.setName(tvName);
        card.setCategory(tvCategory);
        card.setDiscount(tvDiscount);

        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra(Card.class.getSimpleName(),card);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
