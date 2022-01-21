package com.example.fragmentslesson3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FifthFragment extends Fragment {
private TextView textView5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener(view);
    }

    private void initListener(View view) {
        textView5 = view.findViewById(R.id.text_view_5);
        Bundle bundle = this.getArguments();
        String text = getArguments().getString(FirstFragment.PUT_KEY);
        textView5.setText(text);
    }

}