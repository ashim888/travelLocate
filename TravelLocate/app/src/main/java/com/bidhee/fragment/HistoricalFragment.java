package com.bidhee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bidhee.adapter.MainCategoryAdapter;
import com.bidhee.metadata.TestMetadata;
import com.bidhee.model.CategoryModel;
import com.bidhee.travellocate.LocationDetailsActivity;
import com.bidhee.travellocate.R;

import java.util.ArrayList;

/**
 * Created by user on 9/10/2015.
 */
public class HistoricalFragment extends Fragment {
    private View rootView;
    private ArrayList<CategoryModel> catArray;
    private MainCategoryAdapter mainCatAdapter;
    private ListView lvMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_categories,container,false);
        lvMain = (ListView) rootView.findViewById(R.id.lvCat);
        catArray = TestMetadata.getcatOne();
        mainCatAdapter = new MainCategoryAdapter(getActivity(),catArray);
        lvMain.setAdapter(mainCatAdapter);



        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent detailsIntent = new Intent(getActivity(), LocationDetailsActivity.class);
               detailsIntent.putExtra("details",catArray.get(i).getCatDetails());
               detailsIntent.putExtra("image",catArray.get(i).getCatImage());
               detailsIntent.putExtra("title",catArray.get(i).getCatName());
               startActivity(detailsIntent);

            }
        });

        return rootView;
    }
}
