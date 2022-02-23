package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivityTablet extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView textViewNameT;
    private TextView textViewEmailT;
    private TextView textViewDateT;
    private TextView textViewGenderT;
    private EditText userNameEdt, userEmailEdt, userBirthDateEdt, userGenderEdt;
    private Button proceedbtn;

    UserData userData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tablet);

        userNameEdt = findViewById(R.id.editTextTextPersonName2);
        userEmailEdt = findViewById(R.id.editTextTextEmailAddress2);
        userBirthDateEdt = findViewById(R.id.editTextDate2);
        userGenderEdt = findViewById(R.id.editTextGender2);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");
        userData = new UserData();
        proceedbtn = findViewById(R.id.buttonTablet);

        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userNameEdt.getText().toString();
                String email = userEmailEdt.getText().toString();
                String date = userBirthDateEdt.getText().toString();
                String gender = userGenderEdt.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(date) && TextUtils.isEmpty(gender)){
                    Toast.makeText(MainActivityTablet.this, "Feild is empty", Toast.LENGTH_SHORT).show();
                } else {
                    addDatatoFirebase(name, email, date, gender);
                }

                setContentView(R.layout.activity_main_view_tablet);
            }
        });

//        Button button = (Button) findViewById(R.id.buttonPhone);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                setContentView(R.layout.activity_main_view_phone);
//                startActivity(new Intent(MainActivityPhone.this, MainActivityViewPhone.class));
//            }
//        });
    }
    private void addDatatoFirebase(String name, String email, String date, String gender){
        userData.setUserName(name);
        userData.setUserEmail(email);
        userData.setUserBirthDate(date);
        userData.setUserGender(gender);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(userData);

                Toast.makeText(MainActivityTablet.this, "Data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityTablet.this, "Fail to add data "+ error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}