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
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    private EditText eFullName, eUsername;

    ShapeableImageView image;

    private Uri uri;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFullName = findViewById(R.id.fullname);
        eUsername = findViewById(R.id.username);
        image = findViewById(R.id.image);

        uri = Uri.parse("");
    }

    public void submit(View view) {
        String fullname = eFullName.getText().toString();
        String username = eUsername.getText().toString();
        String profil = uri.toString();

        if (uri.toString() == "") {
            Toast.makeText(MainActivity.this, "Please pick a photo profile first", Toast.LENGTH_SHORT).show();
        } else if(fullname.isEmpty() && username.isEmpty()){
            eFullName.setError("Field can't be Empty");
            eUsername.setError("Field can't be Empty");
        } else if (fullname.isEmpty()){
            eFullName.setError("Field can't be Empty");
        } else if (username.isEmpty()){
            eUsername.setError("Field can't be Empty");
        } else {
            Intent post = new Intent(MainActivity.this, PostActivity.class);
            post.putExtra(PostActivity.EXTRA_FULLNAME, fullname);
            post.putExtra(PostActivity.EXTRA_USERNAME, username);
            post.putExtra(PostActivity.EXTRA_PROFILE, profil);
            startActivity(post);
        }
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
}