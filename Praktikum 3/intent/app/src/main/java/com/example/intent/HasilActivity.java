package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class HasilActivity extends AppCompatActivity {

    public static final String EXTRA_FULLNAME = "extra_fullname";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_CAPTION = "extra_caption";

    public static final String EXTRA_PROFILE = "extra_profile";
    public static final String EXTRA_POST = "extra_post";

    private TextView tFullname, tUsername, tCapt;

    ShapeableImageView profile;
    ImageView post;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tFullname = findViewById(R.id.fullname);
        tUsername = findViewById(R.id.username);
        tCapt = findViewById(R.id.capt);
        profile = findViewById(R.id.profil);
        post = findViewById(R.id.post);

        String nama = getIntent().getStringExtra(EXTRA_FULLNAME);
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        String capt = getIntent().getStringExtra(EXTRA_CAPTION);
        String profil = getIntent().getStringExtra(EXTRA_PROFILE);
        String postingan = getIntent().getStringExtra(EXTRA_POST);
        post.setImageURI(Uri.parse(postingan));


        tFullname.setText(nama);
        tUsername.setText(username);
        tCapt.setText(capt);
        profile.setImageURI(Uri.parse(profil));

    }
}