package com.example.hptouchsmart.facebookchallenge.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hptouchsmart.facebookchallenge.Models.Topics;
import com.example.hptouchsmart.facebookchallenge.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    RecyclerView topicList;


    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_topic, container, false);

        topicList = (RecyclerView) root.findViewById(R.id.recyclerChallenge);




        return root;
    }


    public class TopicRecyclerViewholder extends RecyclerView.ViewHolder{

        TextView topics;


        public TopicRecyclerViewholder(View itemView) {
            super(itemView);

            topics = (TextView) itemView.findViewById(R.id.elevatedCardView);

        }
    }

    public class TopicRecyclerViewApater extends RecyclerView.Adapter<TopicRecyclerViewholder>{


        ArrayList<Topics> topicsArrayList;

        public TopicRecyclerViewApater(ArrayList<Topics> topicsArrayList) {
            this.topicsArrayList = topicsArrayList;
        }

        @Override
        public TopicRecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

            Log.d("TAG :" ,"inside recyclerViewHolder" );

            LayoutInflater li = getLayoutInflater(null);

            View itemView = li.inflate(R.layout.challenge_card , null);

            TopicRecyclerViewholder topicRecyclerViewholder  = new TopicRecyclerViewholder(itemView);


            return topicRecyclerViewholder;
        }

        @Override
        public void onBindViewHolder(TopicRecyclerViewholder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }



}
