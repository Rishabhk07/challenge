package com.example.hptouchsmart.facebookchallenge;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hptouchsmart.facebookchallenge.Models.Topics;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogActivity extends Activity {

    Button cancel;
    Button addNew;
    EditText newTopic;
    FirebaseListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        cancel = (Button) findViewById(R.id.cancel);
        addNew = (Button) findViewById(R.id.addNew);
        newTopic = (EditText) findViewById(R.id.newTopic);
        final Dialog thisDialog = new Dialog(this);


        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String topic = newTopic.getText().toString();

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("topics");

                String key = ref.push().getKey();

                Topics newtopic = new Topics(key , topic);

                ref.child(key).setValue(newtopic);

                finish();


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(DialogActivity.this, " no new challenge  ", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
