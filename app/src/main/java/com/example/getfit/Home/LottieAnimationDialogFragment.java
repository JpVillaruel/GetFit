package com.example.getfit.Home;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.getfit.R;

public class LottieAnimationDialogFragment extends DialogFragment {

    private int animationResId;

    public LottieAnimationDialogFragment() {
        // Required empty public constructor
    }

    public static LottieAnimationDialogFragment newInstance(int animationResId) {
        LottieAnimationDialogFragment fragment = new LottieAnimationDialogFragment();
        Bundle args = new Bundle();
        args.putInt("animationResId", animationResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animationResId = getArguments().getInt("animationResId");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.dialog_lottie_animation);

        LottieAnimationView animationView = dialog.findViewById(R.id.dialogAnimationView);
        animationView.setAnimation(animationResId);
        animationView.playAnimation();

        return dialog;
    }
}
