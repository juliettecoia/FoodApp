package com.example.juliettecoia.essai_carte;
//DISPLAYS THE REQUESTED FOOD//
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class NeededFood extends android.support.v4.app.Fragment {
    public static StringBuilder foodList = new StringBuilder();
   // public static StringBuilder donateSent = new StringBuilder();

    public NeededFood() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_needed_food, container, false);
    }

   @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       showRequestFood();

    }

    public void showRequestFood()
    {
        final TextView food = (TextView) getView().findViewById(R.id.editText5);
            //One string for server
        //From request food
        if(NavigationDrawer.logged_in_user.getAcceptDon() == false)
        {
            foodList.append("$");
            foodList.append(NavigationDrawer.logged_in_user.getName());
            foodList.append(" is requesting ");
            foodList.append(DonateFragment.food);
            foodList.append("$");
        }

        else
        //From donated food
        {
            foodList.append("$");
            foodList.append(ActivityFragment.donateSent);
            foodList.append(NavigationDrawer.logged_in_user.getName());
            foodList.append(" is donating ");
            foodList.append(DonateFragment.foodList);
            foodList.append(" to ");
            foodList.append(MapsActivity.FBTitle);
            foodList.append("$");
        }

        food.append(foodList);

            /*food.append(food1);
            food.setTextSize(18);
            //add " - company name" when server is connected
            food.append("\n");*/


        //food.append(foodList);
       // food.append(donateSent);


    }
}