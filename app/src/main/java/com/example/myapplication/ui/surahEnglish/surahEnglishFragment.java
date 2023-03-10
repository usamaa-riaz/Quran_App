package com.example.myapplication.ui.surahEnglish;

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
import com.example.quranappv3.Surah;
import com.example.quranappv3.SurahContext;
import com.example.quranappv3.SurahCustomListConfig;
import com.example.quranappv3.databinding.FragmentSurahEnglishBinding;

import java.util.List;

public class surahEnglishFragment extends Fragment {
    private FragmentSurahEnglishBinding binding;
    ListView l;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSurahEnglishBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        DataBaseHelper db;
        db = new DataBaseHelper(getContext());
        List<Surah> surahs = db.getSurahs();
        l = binding.listview;
        SurahCustomListConfig list = new SurahCustomListConfig(getContext(),0,surahs);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), SurahContext.class);
                intent.putExtra("index", l + "");
                intent.putExtra("type","english");
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