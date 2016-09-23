package com.example.hptouchsmart.facebookchallenge.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hptouchsmart.facebookchallenge.Models.Challenges;
import com.example.hptouchsmart.facebookchallenge.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class challengeFragment extends Fragment {

    FirebaseListAdapter mAdapter;



    public challengeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_challenge2, container, false);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Challenges");




        mAdapter = new FirebaseListAdapter<Challenges>(getActivity() , Challenges.class , R.layout.challenge_card_layout , ref) {
            @Override
            protected void populateView(View v, Challenges model, int position) {

            }

        };





        return root;
    }

}
