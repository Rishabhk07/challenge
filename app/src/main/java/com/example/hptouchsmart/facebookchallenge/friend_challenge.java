package com.example.hptouchsmart.facebookchallenge;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hptouchsmart.facebookchallenge.Models.Challenges;
import com.example.hptouchsmart.facebookchallenge.Models.UserFriends;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class friend_challenge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_challenge);

        FirebaseListAdapter mAdapter;
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userName = user.getDisplayName();
        final String UserUid = user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("UserFriends").child(user.getUid());

        final DatabaseReference refChallenge = FirebaseDatabase.getInstance().getReference("Challenges");


        mAdapter = new FirebaseListAdapter<UserFriends>(this , UserFriends.class , R.layout.friend_layout , ref) {

            @Override
            protected void populateView(View v, UserFriends model, int position) {
                final String uid = model.getUid();
                final String name = model.getName();

                TextView nameTV = (TextView) v.findViewById(R.id.friend_name);
                nameTV.setText(name);

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String key = refChallenge.push().getKey().toString();

                        Challenges newChallenge = new Challenges(refChallenge.toString() , "" , userName , name , UserUid , uid , "not completed");

                        refChallenge.child(key).setValue(newChallenge);

                        AlertDialog.Builder builder = new AlertDialog.Builder(friend_challenge.this);

                        builder.setNeutralButton("you challenged " + name, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

                        AlertDialog dialog = builder.create();




                    }
                });


            }
        };


    }
}
