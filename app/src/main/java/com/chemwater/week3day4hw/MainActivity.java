package com.chemwater.week3day4hw;

import android.app.Activity ;
import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity implements InputFragment.OnFragmentInteractionListener, OutputFragment.OnFragmentInteractionListenerOutput {

    InputFragment inputFragment ;
    OutputFragment outputFragment ;
    FragmentManager fragmentManager ;

    //RecyclerView recyclerView ;


    //List of Animals that will be populated into the recycler view
    ArrayList<User> usersArrayList ;

    public static final String DYNAMIC_FRAG_ONE_TAG = "first_tag" ;
    public static final String DYNAMIC_FRAG_TWO_TAG = "second_tag" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        inputFragment = InputFragment.newInstance() ;
        outputFragment = OutputFragment.newInstance();

        fragmentManager = getFragmentManager() ;

        fragmentManager
                .beginTransaction()
                .replace(R.id.firstFrameLayout, InputFragment.newInstance())
                .addToBackStack(DYNAMIC_FRAG_ONE_TAG)
                .commit() ;

        fragmentManager
                .beginTransaction()
                .replace(R.id.secondFrameLayout, OutputFragment.newInstance())
                .addToBackStack(DYNAMIC_FRAG_TWO_TAG)
                .commit() ;



    }


    @Override
    public void onFragmentInteractions(String uri) {
        inputFragment.setInput(uri) ;
    }


    @Override
    public void onFragmentInteraction(ArrayList<User> user) {
        usersArrayList = user ;
        outputFragment.setRecyclerViewOutput(usersArrayList) ;


    }


}



/*
1.  Create an fragment that will allow the user to input the following:
                a)  User Name
                b)  User Email
                c)  User Password
2.  On the user input fragment, have a button that will add the User to an array list in the activity
3.  In another fragment, Have a recyclerView that will display the users entered in the User input fragment
4.  Both fragments should be in the same activity
 */