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

public class MainActivityViewPhone extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView textViewNameP;
    private TextView textViewEmailP;
    private TextView textViewDateP;
    private TextView textViewGenderP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_phone);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("UserData");
        textViewNameP = findViewById(R.id.textViewNameP);
        textViewEmailP = findViewById(R.id.textViewEmialP);
        textViewDateP = findViewById(R.id.textViewDateP);
        textViewGenderP = findViewById(R.id.textViewGenderP);
        getData();
    }

    private void getData(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                UserData userData = snapshot.getValue(UserData.class);
                textViewNameP.setText(value);
                textViewEmailP.setText(value);
                textViewDateP.setText(value);
                textViewGenderP.setText(value);


//                Log.d("firebase", String.valueOf(task.getResult().getValue()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityViewPhone.this,"Fail to get data.", Toast.LENGTH_SHORT).show();
//                Log.w(,"Failed", error.toException());
            }
        });
    }
}