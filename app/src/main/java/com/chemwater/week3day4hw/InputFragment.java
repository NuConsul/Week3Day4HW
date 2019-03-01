package com.chemwater.week3day4hw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class InputFragment extends Fragment implements View.OnClickListener {

    EditText etName, etEmail, etPassword ;

    Button btnSend ;

    private OnFragmentInteractionListener mListener;


    public InputFragment() {
        // Required empty public constructor
    }


    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etName = (EditText) view.findViewById(R.id.etUserNameView) ;
        etEmail = (EditText) view.findViewById(R.id.etUserEmailView) ;
        etPassword = (EditText) view.findViewById(R.id.etUserPasswordView) ;
        btnSend = (Button) view.findViewById(R.id.btnSubmitInfo) ;
        btnSend.setOnClickListener(this) ;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListenerOutput");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        ArrayList<User> userArrayList = new ArrayList<>() ;
        if (mListener != null) {
            /*etName = view.findViewById(R.id.etUserNameView);
            etEmail = (EditText) view.findViewById(R.id.etUserEmailView) ;
            etPassword = (EditText) view.findViewById(R.id.etUserPasswordView) ;*/
            String name = etName.getText().toString() ;
            String email = etEmail.getText().toString() ;
            String password = etPassword.getText().toString() ;


            User anotherUser = new User(name, email, password) ;

            userArrayList.add(anotherUser) ;

            Log.d("TAG", anotherUser.getUserName()+ "The user is logged in ") ;
            mListener.onFragmentInteraction(userArrayList) ;
        }
    }

    public void setInput(String string) {
        etName.setText(string);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(ArrayList<User> uri);
    }
}