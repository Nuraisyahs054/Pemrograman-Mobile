package com.example.fragmentassigment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivHome, ivAdd, ivProfile, ivSearch;
    private ProfileFragment profileFragment = new ProfileFragment();
    private UploadFragment uploadFragment = new UploadFragment();
    private HomeFragment homeFragment = new HomeFragment();
    private SearchFragment searchFragment = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // untuk menginisialisasi/memanggil id agar id dapat dikenali

        ivHome = findViewById(R.id.iv_home);
        ivAdd = findViewById(R.id.iv_add);
        ivProfile = findViewById(R.id.iv_profile);
        ivSearch = findViewById(R.id.iv_search);
        ivSearch.setColorFilter(Color.WHITE);

        // agar bisa diklik
        ivHome.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        ivProfile.setOnClickListener(this);
        ivSearch.setOnClickListener(this);

        // Mencari fragment dengan tag HomeFragment, dan jika tidak ditemukan,
        // menambahkan fragment HomeFragment ke dalam tampilan.
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameContainer, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }
        // Mengatur judul pada ActionBar menjadi "Instaglamor".
        getSupportActionBar().setTitle("Instaglamor");
    }

    // kode ini menangani klik pada elemen-elemen tampilan dengan ID tertentu,
    // dan melakukan perubahan tampilan fragment serta judul ActionBar
    // berdasarkan ID elemen yang diklik.

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                Bundle bundle = getIntent().getExtras();
                homeFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, homeFragment).commit();
                getSupportActionBar().setTitle("Instaglamor");
                break;
            case R.id.iv_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, searchFragment).commit();
                getSupportActionBar().setTitle("Search");
                break;
            case R.id.iv_add:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, uploadFragment).commit();
                getSupportActionBar().setTitle("Upload");
                break;
            case R.id.iv_profile:
                PostModel postModel = new PostModel("aisyahcaca", "Aisyah", "", "https://i.pinimg.com/564x/99/1a/5a/991a5aaca528a38b4788c8ec7f531909.jpg", "");
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, profileFragment).commit();
                getSupportActionBar().setTitle("Profile");
                break;
        }
    }
}
