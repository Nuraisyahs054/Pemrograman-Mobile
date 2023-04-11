package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.imageview.ShapeableImageView;

public class PostActivity extends AppCompatActivity {

    public static final String EXTRA_FULLNAME = "extra_fullname";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_PROFILE = "extra_profile";

    private EditText eCapt;
    ImageView image;
    private Uri uri;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        eCapt = findViewById(R.id.capt);
        image = findViewById(R.id.image);

        uri = Uri.parse("");


    }
    public void image(View view) {
        Intent image = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(image, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK) {
            uri = data.getData();
            image.setImageURI(Uri.parse(uri.toString()));
        }
    }

    public void upload(View view) {
        String post = uri.toString();
        String caption = eCapt.getText().toString();
        String fullname = getIntent().getStringExtra(EXTRA_FULLNAME);
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        String profil = getIntent().getStringExtra(EXTRA_PROFILE);
        Intent hasil = new Intent(PostActivity.this, HasilActivity.class);
        hasil.putExtra(HasilActivity.EXTRA_FULLNAME, fullname);
        hasil.putExtra(HasilActivity.EXTRA_USERNAME, username);
        hasil.putExtra(HasilActivity.EXTRA_CAPTION, caption);
        hasil.putExtra(HasilActivity.EXTRA_PROFILE, profil);
        hasil.putExtra(HasilActivity.EXTRA_POST, post);

        startActivity(hasil);

    }
}