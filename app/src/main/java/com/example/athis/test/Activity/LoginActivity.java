package com.example.athis.test.Activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dspot.declex.Action.$LoginFragment;
import com.dspot.declex.annotation.RunWith;
import com.example.athis.test.R;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
    @RunWith
    $LoginFragment onCreate;

}
