package com.example.techquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.techquiz.adapterClass.HomeAdapter;
import com.example.techquiz.databinding.FragmentHomeBinding;
import com.example.techquiz.madelClass.HomeModel;

import java.util.ArrayList;


public class homeFragment extends Fragment {


    FragmentHomeBinding binding;
    ArrayList<HomeModel> list = new ArrayList<>();
    HomeAdapter adapter;
    public homeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("C","C"));
        list.add(new HomeModel("C++","C++"));
        list.add(new HomeModel("Java","Java"));
        list.add(new HomeModel("Python","Python"));
        list.add(new HomeModel("HTML/CSS","HTML/CSS"));
        adapter=new HomeAdapter(getContext(),list);
        binding.rcv.setAdapter(adapter);
    }
}