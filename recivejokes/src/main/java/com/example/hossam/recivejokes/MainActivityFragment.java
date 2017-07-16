package com.example.hossam.recivejokes;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Hossam on 3/16/2017.
 */
public class MainActivityFragment extends Fragment {
    public static String JOKE_KEY = "Joke key";
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(MainActivity.JOKE_KEY);
        TextView jokeTextView = (TextView) root.findViewById(R.id.instructions_text_view);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return root;
    }
}
