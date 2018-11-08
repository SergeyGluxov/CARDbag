package info.goodline.cardbag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

        rlNoCard.setVisibility(View.VISIBLE);
        rlCard.setVisibility(View.GONE);
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

             if (requestCode == 1)
             {

                if (resultCode == Activity.RESULT_OK) {

                    rlCard.setVisibility(View.GONE);
                    rlNoCard.setVisibility(View.GONE);

                    Bundle arguments = getIntent().getExtras();
                    Card card = (Card)arguments.getSerializable(Card.class.getSimpleName());

                   String name =  data.getStringExtra(card.getName());
                   String categor = data.getStringExtra(card.getCategory());
                   String discount = data.getStringExtra(card.getDiscount());

                    tvName.setText(name);
                    tvCategory.setText(categor);
                    tvDiscount.setText("Скидка" + discount + "%");
                }
        }
    }

    public void btAddCard(View view) {
        Intent intent = new Intent(this, CardAddActivity.class);
        startActivityForResult(intent, 1);
    }

}
