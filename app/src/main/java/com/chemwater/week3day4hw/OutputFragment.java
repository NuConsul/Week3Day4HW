package com.chemwater.week3day4hw;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class OutputFragment extends Fragment {

    MyRecyclerViewAdapter myRecyclerViewAdapter ;

    TextView tvName, tvEmail, tvPassword ;

    //LinearLayoutManager manager ;

    ArrayList<User> userInput = new ArrayList<>() ;

    RecyclerView recyclerView ;



    //MyRecyclerViewAdapter myRecyclerViewAdapter ;
    LinearLayoutManager manager ;

    private OnFragmentInteractionListenerOutput mListener;

    public OutputFragment() {
        // Required empty public constructor
    }



    public static OutputFragment newInstance() {
        OutputFragment fragment = new OutputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_output, container, false) ;

         recyclerView = (RecyclerView) view.findViewById(R.id.rvRecyclerView) ;
         manager = new LinearLayoutManager(this.getActivity());
         Log.d("debugMode", "The application stopped after this");
         recyclerView.setLayoutManager(manager) ;

        myRecyclerViewAdapter = new MyRecyclerViewAdapter(userInput);
        recyclerView.setAdapter(myRecyclerViewAdapter);
       return view;





        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_output, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerOutput) {
            mListener = (OnFragmentInteractionListenerOutput) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListenerOutput");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState) ;

        recyclerView = view.findViewById(R.id.rvRecyclerView) ;

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext()) ;
        recyclerView.setLayoutManager(lm) ;





        /*tvName =  view.findViewById(R.id.tvUserName) ;
        tvEmail =  view.findViewById(R.id.tvUserEmail) ;
        tvPassword = view.findViewById(R.id.tvUserPassword) ;*/
        userInput.add(new User("name", "email", "password")) ;
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(userInput) ;


        recyclerView.setAdapter(myRecyclerViewAdapter) ;
        //myRecyclerViewAdapter = new MyRecyclerViewAdapter(userInput) ;
        //myRecyclerViewAdapter.
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setRecyclerViewOutput(ArrayList<User> anotherUser) {
        userInput = anotherUser ;
    }


    public interface OnFragmentInteractionListenerOutput {

        void onFragmentInteractions(String uri);
    }
}
