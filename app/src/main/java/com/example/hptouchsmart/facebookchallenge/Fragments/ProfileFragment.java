package com.example.hptouchsmart.facebookchallenge.Fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hptouchsmart.facebookchallenge.R;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static java.lang.System.in;


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
        final ImageButton profilePic = (ImageButton) view.findViewById(R.id.profilePic);
       // ImageButton trial = (ImageButton) view.findViewById(R.id.trial);



//        FirebaseStorage storage = FirebaseStorage.getInstance();
//
//        final StorageReference ref= storage.getReferenceFromUrl("gs://facebook-challenge-217e9.appspot.com").child( user.getUid() + "/profilepic");
//
//
//
        Profile profile = Profile.getCurrentProfile();

        final Uri profilepicURI = profile.getProfilePictureUri(300,300);

        Picasso.with(getActivity()).load(profilepicURI).fit().into(profilePic);


//        Log.d("TAG experiment" ,profilepicURI..toString());
//
//        InputStream iStream = null;
//        try {
//            iStream = getActivity().getContentResolver().openInputStream(profilepicURI);
//            byte[] inputData = getBytes(iStream);
//            UploadTask uploadTask = ref.putBytes(inputData);
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    Toast.makeText(getActivity(), "could not upload", Toast.LENGTH_SHORT).show();
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
//                    Toast.makeText(getActivity(), "image uploaded", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        Bundle parameter = new Bundle();
//        parameter.putString("redirect", "false");
//        parameter.putString("height","300");
//        parameter.putString("width","300");
//        final String imageUrl= "";
//        final String[] profileURL = {null};
//        final Uri[] profilepicDownloaded = new Uri[1];
//        final InputStream[] in = new InputStream[1];
//
//        final long ONE_MEGABYTE = 1024 * 1024;
//        ref.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                // Data for "images/island.jpg" is returns, use this as needed
//
//                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//               profilePic.setImageBitmap(bmp);
//                Log.d( "TAG bytes",bytes.toString());
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//            }
//        });
//
//
//        new GraphRequest(
//                AccessToken.getCurrentAccessToken(),
//                "/me/picture",
//                parameter,
//                HttpMethod.GET,
//                new GraphRequest.Callback() {
//                    public void onCompleted(GraphResponse response) {
//
////                        Log.d("TAG response"  ,response.toString());
////
//                        JSONObject jsonObject = response.getJSONObject();
//                        try {
//                            JSONObject dataObject = jsonObject.getJSONObject("data");
//                            profileURL[0] = dataObject.getString("url");
//                            Log.d("TAG data object" , profileURL[0].toString());
//
//
//
//
//                            byte[] data = profileURL[0].toString().getBytes();
//                            UploadTask uploadTask = ref.putBytes(data);
//                            uploadTask.addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception exception) {
//                                    Toast.makeText(getActivity(), "could not upload", Toast.LENGTH_SHORT).show();
//                                }
//                            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
//                                    Toast.makeText(getActivity(), "image uploaded", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
////
////                        try {
//////                            in[0] = new FileInputStream(profileURL[0].toString());
////
////                        } catch (FileNotFoundException e) {
////                            e.printStackTrace();
////                        }
//
//
//
////                        String jsonObject = response.getJSONObject("url");
////
////                        try {
////                         picURL[0] = jsonObject.getJSONObject("url");
////                        } catch (JSONException e) {
////                            e.printStackTrace();
////                        }
//
////                        Log.d("TAG jsonObject" , picURL[0].toString());
//
//                    }
//
//                }
//        ).executeAsync();






//
//        Bitmap bitmap = null;
//        try {
//            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),profilepicURI);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
////        UploadTask uploadTask = ref.putFile(profilepicURI);
//
//        Log.d("profilepic uri " , profilePic.toString());
//


//        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//
//                Picasso.with(getActivity()).load(Uri.parse(uri.toString())).fit().into(profilePic);
//
//                Log.d("TAG URI " , Uri.parse(uri.toString()).toString());
//                // Got the download URL for 'users/me/profile.png'
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                Toast.makeText(getActivity(), "cannot download", Toast.LENGTH_SHORT).show();
//                // Handle any errors
//            }
//        });

//        profileName.setText(user.getDisplayName());

//        profilePic.setDrawingCacheEnabled(true);
//        Bitmap bitmap = profilePic.getDrawingCache();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] data = baos.toByteArray();
//
//        UploadTask uploadTask = ref.putBytes(data);
//        uploadTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle unsuccessful uploads
//            }
//        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
//                Uri downloadUrl = taskSnapshot.getDownloadUrl();
//            }
//        });








        return view;
    }

//    public byte[] getBytes(InputStream inputStream) throws IOException {
//        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
//        int bufferSize = 1024;
//        byte[] buffer = new byte[bufferSize];
//
//        int len = 0;
//        while ((len = inputStream.read(buffer)) != -1) {
//            byteBuffer.write(buffer, 0, len);
//        }
//        return byteBuffer.toByteArray();
//    }

}
