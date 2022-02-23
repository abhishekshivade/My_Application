package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MainActivityViewTablet extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView textViewNameT;
    private TextView textViewEmailT;
    private TextView textViewDateT;
    private TextView textViewGenderT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_tablet);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("UserData");
        textViewNameT = findViewById(R.id.textViewNameT);
        textViewEmailT = findViewById(R.id.textViewEmailT);
        textViewDateT = findViewById(R.id.textViewDateT);
        textViewGenderT = findViewById(R.id.textViewGenderT);
        getData();
    }


    private void getData(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
//                UserData userData = snapshot.getValue(UserData.class);
                textViewNameT.setText(value);
                textViewEmailT.setText(value);
                textViewDateT.setText(value);
                textViewGenderT.setText(value);


//                Log.d("firebase", String.valueOf(task.getResult().getValue()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityViewTablet.this,"Fail to get data.", Toast.LENGTH_SHORT).show();
//                Log.w(,"Failed", error.toException());
            }
        });
    }
}