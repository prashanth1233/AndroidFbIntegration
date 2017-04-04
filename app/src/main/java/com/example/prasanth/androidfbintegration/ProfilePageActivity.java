package com.example.prasanth.androidfbintegration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfilePageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        TextView tv_fname, tv_mail, tv_id;
        ImageView profilePic;

        FbModel fbModel = (FbModel) getIntent().getExtras().getSerializable("modelClass");
        tv_fname = (TextView) findViewById(R.id.fName);
        tv_mail = (TextView) findViewById(R.id.lName);
        tv_id = (TextView) findViewById(R.id.facebookId);
        profilePic = (ImageView) findViewById(R.id.profilePic);

        tv_fname.setText(fbModel.getName());
        tv_mail.setText(fbModel.getEmail());
        tv_id.setText(fbModel.getId());

        String url = "https://graph.facebook.com/" + fbModel.getId() + "/picture?type=large";
        Picasso.with(this).load(url).into(profilePic);
    }
}
