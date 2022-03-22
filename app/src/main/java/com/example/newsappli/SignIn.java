package com.example.newsappli;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends Fragment {

    private ProgressDialog dialog;
    private EditText nameEdit,emailEdit,contactEdit,passwordEdit;
    private Button btnregister;
    private FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in,container,false);
        nameEdit = view.findViewById(R.id.nameEdit);
        emailEdit = view.findViewById(R.id.emailEdit);
        contactEdit = view.findViewById(R.id.contactEdit);
        passwordEdit = view.findViewById(R.id.passEdit);
        btnregister = view.findViewById(R.id.saveBtn);
        dialog = new ProgressDialog(getActivity());
        mAuth = FirebaseAuth.getInstance();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            String userName = nameEdit.getText().toString();
            String email = emailEdit.getText().toString().trim();
            String contact = contactEdit.getText().toString();
            String password = passwordEdit.getText().toString().trim();
            if(TextUtils.isEmpty(userName) && TextUtils.isEmpty(password) && TextUtils.isEmpty(contact) && TextUtils.isEmpty(email)){
                Toast.makeText(getActivity(), "Please add your credentials...", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            if(dialog.isShowing()){
                                dialog.cancel();
                            }

                            Toast.makeText(getActivity(), "User Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }else{
                            if(dialog.isShowing()){
                                dialog.cancel();
                            }


                            Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            }
        });

        return view;
    }
}