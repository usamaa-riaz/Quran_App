package com.example.myapplication.ui.parahUrdu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.ParaContext;
import com.example.quranappv3.Parah;
import com.example.quranappv3.ParahCustomListConfig;
import com.example.quranappv3.Store;
import com.example.quranappv3.databinding.FragmentParahUrduBinding;

import java.util.ArrayList;

public class parahUrduFragment extends Fragment {
    private FragmentParahUrduBinding binding;
    Store store;
    ListView l;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentParahUrduBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        DataBaseHelper db;
        db = new DataBaseHelper(getContext());
        l = binding.listview;
        store = new Store();
        ArrayList<Parah> arraylist = store.getAllPararh();
        ParahCustomListConfig list = new ParahCustomListConfig(getContext(), 0, arraylist);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ParaContext.class);
                intent.putExtra("index", l + "");
                intent.putExtra("type","urdu");
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}