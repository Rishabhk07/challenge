package com.example.hptouchsmart.facebookchallenge.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hptouchsmart.facebookchallenge.DialogActivity;
import com.example.hptouchsmart.facebookchallenge.Models.Topics;
import com.example.hptouchsmart.facebookchallenge.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    DatabaseReference ref;
    ListView topicList;
    FirebaseListAdapter mAdapter;



    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_topic, container, false);

        topicList = (ListView) root.findViewById(R.id.topiclist);

        ref = FirebaseDatabase.getInstance().getReference("topics");

        mAdapter = new FirebaseListAdapter<Topics>(getActivity() , Topics.class , R.layout.challenge_card , ref) {

            @Override
            protected void populateView(View v, Topics model, int position) {

                String topic = model.getTopic().toString();


                TextView topicsTV = (TextView) v.findViewById(R.id.elevatedCardView);

                String modelUid = model.getUid().toString();

//                Log.d("TAG", topic);

//
                topicsTV.setText(topic);
//                topicsTV.setTag(Integer.parseInt("uid"), modelUid);

                mAdapter.notifyDataSetChanged();

            }
        };

        topicList.setAdapter(mAdapter);


        FloatingActionButton fl = (FloatingActionButton) root.findViewById(R.id.floating_topic);


        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                        final AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());
//
//
//                        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
//
//                        builder.setView(layoutInflater.inflate(R.layout.dialog_custom_view,null));
//
//
//                        builder.setPositiveButton("Add new challenge", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//
//
//
//                            }
//                        });
//
//                        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        });

                Intent i = new Intent(getActivity() , DialogActivity.class);
                startActivity(i);


            }
        });






        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }
}
