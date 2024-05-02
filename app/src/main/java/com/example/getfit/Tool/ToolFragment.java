package com.example.getfit.Tool;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.getfit.R;
import com.example.getfit.Tool.Calculator.BmiCalculator;

public class ToolFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tool, container, false);

        CardView button = view.findViewById(R.id.bmi_card);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the OtherActivity
                Intent intent = new Intent(getActivity(), BmiCalculator.class);
                startActivity(intent);
            }
        });

        return view;
    }
}