package com.example.techquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.techquiz.adapterClass.SubAdapter;
import com.example.techquiz.databinding.FragmentHomeBinding;
import com.example.techquiz.databinding.FragmentSubBinding;
import com.example.techquiz.madelClass.SubModel;

import java.util.ArrayList;


public class subFragment extends Fragment {
    FragmentSubBinding binding;
    ArrayList<SubModel> list = new ArrayList<>();
    SubAdapter adapter;
    String title;

    public subFragment() {

    }
    public subFragment(String title) {
        this.title=title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSubBinding.inflate(getLayoutInflater());
        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        if(title.equals("C")) {
            list.add(new SubModel("C-School", "C","C"));
            list.add(new SubModel("C-Basic", "C","C"));
            list.add(new SubModel("C-Easy", "C","C"));
            list.add(new SubModel("C-Moderate", "C","C"));
            list.add(new SubModel("C-Hard", "C","C"));

        }else if(title.equals("C++")) {
            list.add(new SubModel("CPP-School", "C++","C++"));
            list.add(new SubModel("CPP-Basic", "C++","C++"));
            list.add(new SubModel("CPP-Easy", "C++","C++"));
            list.add(new SubModel("CPP-Moderate", "C++","C++"));
            list.add(new SubModel("CPP-Hard", "C++","C++"));

        }else if(title.equals("Java")) {
            list.add(new SubModel("Java-School", "Java","Java"));
            list.add(new SubModel("Java-Basic", "Java","Java"));
            list.add(new SubModel("Java-Easy", "Java","Java"));
            list.add(new SubModel("Java-Moderate", "Java","Java"));
            list.add(new SubModel("Java-Hard", "Java","Java"));
        }else if(title.equals("Python")) {
            list.add(new SubModel("Python-School", "Python","Python"));
            list.add(new SubModel("Python-Basic", "Python","Python"));
            list.add(new SubModel("Python-Easy", "Python","Python"));
            list.add(new SubModel("Python-Moderate", "Python","Python"));
            list.add(new SubModel("Python-Hard", "Python","Python"));

        }else if(title.equals("HTML/CSS")) {
            list.add(new SubModel("HTML/CSS-School", "HTML/CSS","HTML/CSS"));
            list.add(new SubModel("HTML/CSS-Basic", "HTML/CSS","HTML/CSS"));
            list.add(new SubModel("HTML/CSS-Easy", "HTML/CSS","HTML/CSS"));
            list.add(new SubModel("HTML/CSS-Moderate", "HTML/CSS","HTML/CSS"));
            list.add(new SubModel("HTML/CSS-Hard", "HTML/CSS","HTML/CSS"));
        }
        adapter = new SubAdapter(getContext(), list);
        binding.rcv.setAdapter(adapter);
    }
}