package info.goodline.cardbag;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmList;


public class CardAddActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Card card;
    private ImageView ivFront;
    private ImageView ivBack;
    private EditText etName;
    private EditText etCategory;
    private EditText etDiscount;

    private static final int REQUEST_CODE_FRONT_PHOTO = 1;
    private static final int REQUEST_CODE_BACK_PHOTO = 2;

    private static final int ADD_CATEGORY = 0;

    Photo photoFront;
    Photo photoBack;
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
        findViewById(R.id.flFront).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImagFromGallery(REQUEST_CODE_FRONT_PHOTO);
            }
        });

        findViewById(R.id.flBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImagFromGallery(REQUEST_CODE_BACK_PHOTO);
            }
        });
        ivFront = findViewById(R.id.ivPhotoFront);
        ivBack = findViewById(R.id.ivPhotoBack);
        //переменные для хранения текузего времени
        long currentTime = System.currentTimeMillis();
        photoFront = new Photo(currentTime+1);
        photoBack = new Photo(currentTime+2);
        //Тут закончил
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

        ArrayList<Photo> photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.card));
        photos.add(new Photo(R.drawable.card));

        Random random = new Random();
        int id = random.nextInt(2000);
        card.setId(id);
        card.setPhotos(photos);
        card.setDiscount(etDiscount.getText().toString());
        card.setName(etName.getText().toString());
        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra(Card.class.getSimpleName(), card);
        addCard(card);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void etCategoryClick(View view) {
        Intent intent = new Intent(this, CategoryListActivity.class);
        startActivityForResult(intent, ADD_CATEGORY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ADD_CATEGORY:
                if (resultCode == RESULT_OK) {
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
                    card.setCategory(category);
                }
                break;
            case REQUEST_CODE_FRONT_PHOTO:
            case REQUEST_CODE_BACK_PHOTO:
                showImage(requestCode, data);
                break;
        }
    }

    public void showImage(int requestCode, Intent data)
    {
        try{
            final Uri imageUri = data.getData();
            final InputStream imageStream = getContentResolver().openInputStream(imageUri);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            switch (requestCode)
            {
                case REQUEST_CODE_FRONT_PHOTO:
                    ivFront.setImageBitmap(selectedImage);
                    break;
                case REQUEST_CODE_BACK_PHOTO:
                    ivBack.setImageBitmap(selectedImage);
                    break;
            }
            ivFront.setImageBitmap(selectedImage);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    public void addCard(Card card) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(map2CardRealm(card));
            }
        });
    }

    public CardRealm map2CardRealm(Card card) {
        CardRealm cardRealm = new CardRealm();
        cardRealm.setId(card.getId());
        cardRealm.setName(card.getName());
        cardRealm.setDiscount(card.getDiscount());
        cardRealm.setCategory(categoryMap2Realm(card.getCategory()));
        cardRealm.setPhoto(photoMap2Realm(card.getPhotos()));
        return cardRealm;
    }

    public CategoryRealm categoryMap2Realm(Category category) {
        CategoryRealm categoryRealm = new CategoryRealm();
        categoryRealm.setId(category.getId());
        categoryRealm.setName(category.getName());
        return categoryRealm;
    }

    public RealmList<PhotoRealm> photoMap2Realm(List<Photo> photo) {
        RealmList<PhotoRealm> photoRealm = new RealmList<>();
        for (Photo photos : photo) {
            PhotoRealm photoRealm1 = new PhotoRealm();
            photoRealm1.setImgID(photos.getIconSources());
            photoRealm.add(photoRealm1);
        }
        return photoRealm;
    }

    private void chooseImagFromGallery(int requestCode) {

        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Выберите изображение");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
        startActivityForResult(chooserIntent, requestCode);
    }

}

