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

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static io.realm.Realm.getDefaultInstance;

public class CardListActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView rlCard;
    private  RelativeLayout rlNoCard;
    private List<Card> cards;
    private LinearLayoutManager linearLayoutManager;
    private CardAdapter adapter;

    private static final int COUNT_CARD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Мои карты");
        rlCard = findViewById(R.id.rvCard);
        rlNoCard = findViewById(R.id.rl_no_card);

        rlCard = findViewById(R.id.rvCard);
        rlCard.setLayoutManager(new LinearLayoutManager(this));
        cards = new ArrayList<>();

        adapter = new CardAdapter(this, cards);
        rlCard.setAdapter(adapter);

        loadCardList();


    }

    private void loadCardList() {
        RealmResults<CardRealm> result = getDefaultInstance().where(CardRealm.class).findAll();
        if (result.isEmpty()) {
            // Карточек нет
            showCardList(false);
            return;
        }

        cards = CardMapper.map2DataList(result);
        adapter.setCards(cards);
        showCardList(true);
    }
    public void showCardList(boolean enableList ) {
        // Если enableList равно true, то отобразить список карточек (View.VISIBLE)
        rlCard.setVisibility(enableList ? View.VISIBLE : View.GONE);
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

        if (resultCode != RESULT_OK || data.getExtras() == null) {
            return;
        }

        switch (requestCode) {
            case (COUNT_CARD):
                showCardList(true);
                Bundle arg = data.getExtras();
                Card card =(Card) arg.getSerializable(Card.class.getSimpleName());
                adapter.insertItem(card);
        }
    }
}
