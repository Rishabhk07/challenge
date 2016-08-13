package com.example.hptouchsmart.facebookchallenge;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Log.d("TAG" , user.getEmail());

        TextView profileName  = (TextView) view.findViewById(R.id.profileName);
        ImageButton profilePic = (ImageButton) view.findViewById(R.id.profilePic);

        profileName.setText(user.getDisplayName());
        Picasso.with(getActivity()).load(user.getPhotoUrl()).fit().into(profilePic);



        return view;
    }

}
