package com.example.hptouchsmart.facebookchallenge;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.hptouchsmart.facebookchallenge.Models.Users;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton ;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    AccessToken accessToken;
    ProfileTracker profileTracker;
    Profile profile;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListner;




    public static final String TAG_reg = "Register Callback";
    public static final String TAG_Access_Tracker = "Access Token Tracker";
    public static final String TAG_Profile_TRacker = "Profile token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
         setContentView(R.layout.activity_main);

        AppEventsLogger.activateApp(this);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        mAuth = FirebaseAuth.getInstance();

        loginButton.setReadPermissions("user_friends","email","user_photos");

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                profile = Profile.getCurrentProfile();

                String name = profile.getName();

                Toast.makeText(MainActivity.this, "welcome "+name, Toast.LENGTH_SHORT).show();
                Log.d(TAG_reg , "OnSuccess Called");


                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

                Log.d("TAG" , "on cancel called");

            }

            @Override
            public void onError(FacebookException error) {
                Log.d("TAG" , "on error called");

            }
        });




        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){

                    Log.d("TAG" , "onStateChanged : SighnIn:" + user.getUid() + " Email :" + user.getEmail());

                }else{
                    Log.d("TAG" , "onStateChanged :Signout" );
                    FirebaseAuth.getInstance().signOut();

                }

            }
        };


        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };

        accessToken = AccessToken.getCurrentAccessToken(); accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
                Log.d(TAG_Access_Tracker , "Access token Called");
            }
        };

        accessToken = AccessToken.getCurrentAccessToken();


        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                profile = currentProfile;
                Log.d(TAG_Profile_TRacker , "Profile tracker called");
            }
        };



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode , resultCode , data);
        Log.d("TAG" , "ActivityResult called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

    }

    @Override
    protected void onPause() {
        super.onPause();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListner);
    }

    private void handleFacebookAccessToken(AccessToken accessToken){
        Log.d("TAG" , "handle Facebook Access Token : " + accessToken);
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TAG" , "Sign in with credentials complete !");
                        
                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        Users user =  new Users(firebaseUser.getUid(), firebaseUser.getDisplayName()  , firebaseUser.getEmail(), "" , "" , ""  );
                        DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();
                        mdatabase.child("user").child(firebaseUser.getUid()).setValue(user);

                        Intent i = new Intent(MainActivity.this , UserLoginActivity.class);
                        startActivity(i);



                        if(!task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Authentication Failed ", Toast.LENGTH_SHORT).show();

                        }

                    }
                });


    }
}
