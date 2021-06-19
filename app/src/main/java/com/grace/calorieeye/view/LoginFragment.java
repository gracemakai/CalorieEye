package com.grace.calorieeye.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.grace.calorieeye.R;
import com.grace.calorieeye.helper.Validation;

public class LoginFragment extends Fragment {

    View view;
    EditText email, password;
    Button login;
    TextView noAccount;

    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);

        mAuth = FirebaseAuth.getInstance();

        initViews();

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            newPage(new HomeScreenFragment());
        }
    }

    private void initViews() {

        email = view.findViewById(R.id.email_login);
        password = view.findViewById(R.id.password_login);
        login = view.findViewById(R.id.login_btn);
        noAccount = view.findViewById(R.id.no_account);

        login.setOnClickListener(v -> validate());

        noAccount.setOnClickListener(v -> newPage(new RegistrationFragment()));

    }

    private void validate() {
        if (Validation.getInstance().isEmailAddress(email, true) &&
                Validation.getInstance().isPassword(password, true)){
            logInUser();
        }
    }

    private void logInUser() {

        mAuth.signInWithEmailAndPassword(email.getText().toString(),
                password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    newPage(new HomeScreenFragment());
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(getClass().getSimpleName(), "signInWithEmail:failure", task.getException());
                    Toast.makeText(getContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void newPage(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment)
                .addToBackStack("");
        fragmentTransaction.commit();
    }
}