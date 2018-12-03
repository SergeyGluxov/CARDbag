package info.goodline.cardbag;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class CardListActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView rlCard;
    private  RelativeLayout rlNoCard;
    private List<Card> cards;
    private CardAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private static final int COUNT_CARD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Мои карты");

        cards = new ArrayList<>();
        adapter = new CardAdapter(this);
        rlCard = findViewById(R.id.rvCard);
        rlNoCard = findViewById(R.id.rl_no_card);

        rlCard.setVisibility(View.GONE);

        rlCard.setAdapter(adapter);

        linearLayoutManager = new LinearLayoutManager(this);
        rlCard.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        rlCard.addItemDecoration(dividerItemDecoration);

    }

    public void btAddCard(View view) {
        Intent intent = new Intent(this, CardAddActivity.class);
        startActivityForResult(intent, COUNT_CARD);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);
        return true;
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

                    adapter.insertItem(card);
            }
        }
    }
}
