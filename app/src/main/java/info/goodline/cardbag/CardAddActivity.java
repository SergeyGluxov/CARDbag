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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


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

        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra(Card.class.getSimpleName(), card);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void etCategoryClick(View view) {
        Intent intent = new Intent(this, Activity_category_list.class);
        startActivityForResult(intent,ADD_CATEGORY);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        else try{
            Bundle arguments = data.getExtras();
            Category category = (Category) arguments.getParcelable(Category.class.getSimpleName());
            if (arguments == null||category==null||resultCode!=RESULT_OK) {
                return;
            }
            else {
                etCategory.setText(category.getName());
            }
        }
        catch (Exception ex){
            Toast.makeText(this, ex.getMessage(),Toast.LENGTH_LONG);
        }
    }
}
