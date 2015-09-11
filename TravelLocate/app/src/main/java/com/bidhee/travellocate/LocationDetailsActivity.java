package com.bidhee.travellocate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by user on 9/10/2015.
 */
public class LocationDetailsActivity extends AppCompatActivity {

    private TextView tvcatDetails;
    private TextView tvcatDetailsTitle;
    private ImageView ivCatDetails;

    private String title;
    private String details;
    private String image;
    private Toolbar tbDetailsDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);
        ivCatDetails = (ImageView) findViewById(R.id.ivCatDetails);
        tvcatDetails = (TextView) findViewById(R.id.tvcatDetails);
        tvcatDetailsTitle = (TextView) findViewById(R.id.tvcatDetailsTitle);
        tbDetailsDetails = (Toolbar) findViewById(R.id.tbDetailsDetails);


        Bundle b = getIntent().getExtras();
        title = b.getString("title");
        details = b.getString("details");
        image = b.getString("image");
        tbDetailsDetails.setTitle(title);

        tbDetailsDetails.setNavigationIcon(R.drawable.ic_action_back);
        tbDetailsDetails.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        Picasso.with(getApplicationContext()).load(image).into(ivCatDetails);

        tvcatDetails.setText(details);
        tvcatDetailsTitle.setText(title);










    }


}
