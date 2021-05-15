package com.example.myprofile;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.Image;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class iceCream extends Fragment {

    ImageView mango = (ImageView) findViewById(R.id.mango);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mango nextFrag= new Mango();
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.ice_view, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ice_cream, container, false);

    }

    public void mg(View v)
    {

    }
}