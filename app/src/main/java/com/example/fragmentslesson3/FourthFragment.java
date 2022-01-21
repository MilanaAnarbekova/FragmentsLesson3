package com.example.fragmentslesson3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FourthFragment extends Fragment {
    static final String PUT_KEY = "key.put.one";
    private TextView textView4;
    private Button btn4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener(view);
        onClick(view);
    }


    private void initListener(View view) {
        textView4 = view.findViewById(R.id.text_view_4);
        btn4 = view.findViewById(R.id.btn_4);
        Bundle bundle = this.getArguments();
        String text = getArguments().getString(FirstFragment.PUT_KEY);
        textView4.setText(text);
    }

    private void onClick(View view) {
        btn4.setOnClickListener
                (new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Bundle bundle = new Bundle();
                         bundle.putString(PUT_KEY, textView4.getText().toString());
                         Fragment fragment = new FifthFragment();
                         fragment.setArguments(bundle);
                         requireActivity().getSupportFragmentManager().
                                 beginTransaction().replace(R.id.container, fragment).commit();
                     }
                 }
                );
    }
}