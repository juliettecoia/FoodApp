package com.example.juliettecoia.essai_carte;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends android.support.v4.app.Fragment {

    public static StringBuilder donateSent;
    public ActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false);
    }

    private void populateListView(){
        //Create list of items
        donateSent = new StringBuilder();
        donateSent.append(NavigationDrawer.logged_in_user.getName());
        donateSent.append(" is donating ");
        donateSent.append(DonateFragment.foodList);
        donateSent.append(" to ");
        donateSent.append(MapsActivity.FBTitle);
        donateSent.append("$");

        //ListView list = (ListView) getActivity().findViewById(R.id.listView);
    }
}
