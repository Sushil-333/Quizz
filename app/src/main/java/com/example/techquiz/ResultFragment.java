package com.example.techquiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.techquiz.databinding.FragmentHomeBinding;
import com.example.techquiz.databinding.FragmentResultBinding;
import com.example.techquiz.madelClass.QuizModel;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    int right,allQuestion;
    String category,title;
    public ResultFragment() {

    }
    public ResultFragment(int right,int allQuestion,String category,String title) {
        this.right=right;
        this.allQuestion=allQuestion;
        this.category=category;
        this.title=title;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(getLayoutInflater());
        String rightScore=String.valueOf(right);
        String  wrongScore=String.valueOf(allQuestion-right);
        String totalScore=String.valueOf(allQuestion);
        binding.correct.setText(rightScore + " Correct");
        binding.incorrect.setText(wrongScore+" incorrect");
        binding.score.setText("You got the "+rightScore+" out of "+totalScore);
        binding.explorebtn.setOnClickListener(v -> {
            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new subFragment(category)).commit();

        });
        binding.replay.setOnClickListener(v -> {
            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new quizFragment(category,title)).commit();

        });
        return binding.getRoot();
    }
}