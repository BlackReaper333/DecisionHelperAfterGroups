package com.google.sdl.decisionhelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by aditya on 22/9/17.
 */

public class GroupProfile extends AppCompatActivity {

    private static final int RC_PHOTO_PICKER =  2;

    private Toolbar toolbar;
    private ImageButton mPhotoPickerButton;
    private EditText GroupName;
    private GroupObj mGroup;
    private ImageView mImageView;
    private Uri selectImageUri;
    private Uri downloadUrl;
    private UserObj mUser;
    private  String uid;

    //firebase variable declaration
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseStorage mFirebaseStorage;
    private StorageReference mPhotosStorageReference;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_profile);


        toolbar = (Toolbar) findViewById(com.google.sdl.decisionhelper.R.id.toolbar);
        setSupportActionBar(toolbar);
        GroupName=(EditText)findViewById(R.id.group_profile_name);
        mPhotoPickerButton = (ImageButton) findViewById(R.id.group_profile_photoPickerButton);
        mImageView=(ImageView)findViewById(R.id.group_profile_imageview);

        //firebase variable defination
        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mFirebaseStorage=FirebaseStorage.getInstance();
        mPhotosStorageReference= mFirebaseStorage.getReference().child("group_icons");




        // ImagePickerButton shows an image picker to upload a image for a message
        mPhotoPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main8, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_profile:
                //sign out
                if (GroupName.getText().toString().trim().equalsIgnoreCase("")) {
                    GroupName.setError("This field can not be blank");
                }else {
                    updateGroupProfile();
                    startActivity(new Intent(this,MainActivity.class));
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_PHOTO_PICKER && resultCode==RESULT_OK)
        {
            selectImageUri=data.getData();
            StoreImageToFirebase();
        }
    }

    void StoreImageToFirebase(){
        //get reference to storage file at chat_photos/<FileName>
        StorageReference photoRef =mPhotosStorageReference.child(selectImageUri.getLastPathSegment());

        //upload file to firebase storage
        photoRef.putFile(selectImageUri)
                .addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        downloadUrl=taskSnapshot.getDownloadUrl();
                    }
                });
    }


    private void updateGroupProfile() {


    }



}
