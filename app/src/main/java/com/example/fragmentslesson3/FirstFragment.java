package com.example.fragmentslesson3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {
    static final String PUT_KEY = "key.put.one";
    private EditText editText;
    private Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);

    }
    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Bundle bundle = new Bundle();
            bundle.putString(PUT_KEY, editText.getText().toString());
            SecondFragment secondFragment =new SecondFragment();
            secondFragment.getArguments(bundle);
requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,secondFragment).commit();
            }

        });

    }
    private void initView() {
        editText = getView().findViewById(R.id.edit_text);
        btn = getView().findViewById(R.id.btn);
    }
}