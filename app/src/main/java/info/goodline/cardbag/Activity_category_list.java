package info.goodline.cardbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Activity_category_list extends AppCompatActivity implements CategoryAdapter.onItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Inbox");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.rvCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // создаем адаптер
        CategoryAdapter adapter = new CategoryAdapter(this, DataBaseHelper.getCategories(), this);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }


    @Override
    public void onItemClick (Category item) {
        Intent intent = new Intent(this,CardAddActivity.class);
        intent.putExtra(Category.class.getSimpleName(), item);
        setResult(RESULT_OK, intent);
        finish();
    }
}
