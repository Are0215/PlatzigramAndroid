package app.platzigram.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.platzigram.R;
import app.platzigram.adapter.PictureAdapterRecycleView;
import app.platzigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getString(R.string.home), false, view);
        RecyclerView picutreRecycle = (RecyclerView) view.findViewById(R.id.recycleview_pictures);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picutreRecycle.setLayoutManager(linearLayoutManager);
        PictureAdapterRecycleView adapterRecycleView = new PictureAdapterRecycleView(buildPictures(),R.layout.cardview_picture, this.getActivity());
        picutreRecycle.setAdapter(adapterRecycleView);
        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> arrayList = new ArrayList<>();
        arrayList.add(new Picture("http://media.istockphoto.com/photos/selfie-picture-id491464500?k=6&m=491464500&s=170667a&w=0&h=uzt1s3PSLsi1jim9oTESOgm9x0vY95_WKQM4ydqz50s=","Arodridueze","4 días","4"));
        arrayList.add(new Picture("http://media.istockphoto.com/photos/selfie-picture-id491464500?k=6&m=491464500&s=170667a&w=0&h=uzt1s3PSLsi1jim9oTESOgm9x0vY95_WKQM4ydqz50s=","Arodridueze","4 días","4"));
        arrayList.add(new Picture("http://media.istockphoto.com/photos/selfie-picture-id491464500?k=6&m=491464500&s=170667a&w=0&h=uzt1s3PSLsi1jim9oTESOgm9x0vY95_WKQM4ydqz50s=","Arodridueze","4 días","4"));
        arrayList.add(new Picture("http://media.istockphoto.com/photos/selfie-picture-id491464500?k=6&m=491464500&s=170667a&w=0&h=uzt1s3PSLsi1jim9oTESOgm9x0vY95_WKQM4ydqz50s=","Arodridueze","4 días","4"));
        arrayList.add(new Picture("http://media.istockphoto.com/photos/selfie-picture-id491464500?k=6&m=491464500&s=170667a&w=0&h=uzt1s3PSLsi1jim9oTESOgm9x0vY95_WKQM4ydqz50s=","Arodridueze","4 días","4"));
        return arrayList;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(upButton);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
