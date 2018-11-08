package info.goodline.cardbag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CardListActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RelativeLayout rlCard;
    private  RelativeLayout rlNoCard;

    private TextView tvName;
    private TextView tvCategory;
    private TextView tvDiscount;
    private static final int COUNT_CARD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Мои карты");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rlCard = findViewById(R.id.rl_card);
        rlNoCard = findViewById(R.id.rl_no_card);

        tvName = findViewById(R.id.tvName);
        tvCategory = findViewById(R.id.tvCategory);
        tvDiscount = findViewById(R.id.tvDiscount);
        rlCard.setVisibility(View.GONE);
    }

    public void btAddCard(View view) {
        Intent intent = new Intent(this, CardAddActivity.class);
        startActivityForResult(intent, COUNT_CARD);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case COUNT_CARD:
                    rlCard.setVisibility(View.VISIBLE);
                    rlNoCard.setVisibility(View.GONE);

                    Bundle arg = data.getExtras();
                    if (arg == null) {
                        return;
                    }

                    Card card = (Card) arg.getSerializable(Card.class.getSimpleName());
                    if (card == null) {
                        return;
                    }

                    String name = card.getName();
                    String category = card.getCategory();
                    String discount = card.getDiscount();
                    tvName.setText(name);
                    tvCategory.setText(category);
                    tvDiscount.setText("Скидка" + discount + "%");

            }
        }
    }
}
