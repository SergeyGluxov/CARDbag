package info.goodline.cardbag;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class CardAddActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Card card;

    private EditText etName;
    private EditText etCategory;
    private EditText etDiscount;

    private static final int ADD_CATEGORY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        card = new Card();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Добавить карту");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etName = findViewById(R.id.name);
        etCategory = findViewById(R.id.category);
        etDiscount = findViewById(R.id.discount);
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

        card.setName(etName.getText().toString());
        card.setCategory(etCategory.getText().toString());
        card.setDiscount(etDiscount.getText().toString());

        ArrayList<Photo> photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.card));
        photos.add(new Photo(R.drawable.card));
        card.setPhotos(photos);


        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra(Card.class.getSimpleName(), card);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void etCategoryClick(View view) {
        Intent intent = new Intent(this, CardCategoryList.class);
        startActivityForResult(intent,ADD_CATEGORY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_CATEGORY:

                    Bundle arg = data.getExtras();
                    if (arg == null) {
                        return;
                    }

                    Category category = (Category) arg.getSerializable(Category.class.getSimpleName());
                    if (category == null) {
                        return;
                    }
                    String nameCateg = category.getName();
                    etCategory.setText(nameCateg);
            }
        }
    }
}
