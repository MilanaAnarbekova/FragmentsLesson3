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


public class ThirdFragment extends Fragment {
    static final String PUT_KEY = "key.put.one";
    private TextView textView3;
    private Button btn3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener(view);
        onClick(view);

    }


    private void initListener(View view) {
        textView3 = view.findViewById(R.id.text_view_3);
        btn3 = view.findViewById(R.id.btn_3);
        Bundle bundle = this.getArguments();
        String text = getArguments().getString(FirstFragment.PUT_KEY);
        textView3.setText(text);
    }

    private void onClick(View view) {
        btn3.setOnClickListener
                (new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Bundle bundle = new Bundle();
                         bundle.putString(PUT_KEY, textView3.getText().toString());
                         Fragment fragment = new FourthFragment();
                         fragment.setArguments(bundle);
                         requireActivity().getSupportFragmentManager().
                                 beginTransaction().replace(R.id.container, fragment).commit();
                     }
                 }
                );
    }
}