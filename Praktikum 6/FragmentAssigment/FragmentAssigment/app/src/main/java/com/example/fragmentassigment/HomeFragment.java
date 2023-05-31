package com.example.fragmentassigment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private PostAdapter adapter;

// metode onCreateView() ini bertujuan untuk menghasilkan tampilan fragment
// dengan menginflasi layout XML "fragment_home" menjadi objek View,
// dan kemudian mengembalikan tampilan tersebut untuk ditampilkan oleh sistem Android.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }
    // kode ini mengatur tampilan RecyclerView dalam fragment dengan menggunakan LinearLayoutManager
    // yang mengatur tata letak item-item dalam RecyclerView
    // adapter diset untuk menghubungkan data dengan tampilan RecyclerView.
    // agar RecyclerView akan dapat menampilkan item-item data yang sesuai.

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostAdapter(getContext(), PostDataSource.dataList);
        recyclerView.setAdapter(adapter);
    }
}

