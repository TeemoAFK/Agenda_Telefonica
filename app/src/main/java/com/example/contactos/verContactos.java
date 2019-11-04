package com.example.contactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class verContactos extends AppCompatActivity {

    private TextView mTextViewData;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_contactos);

        mTextViewData = (TextView) findViewById(R.id.tw);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Contactos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists());
                String apellido= dataSnapshot.child("Apellido").getValue().toString();
                String nombre= dataSnapshot.child("Nombre").getValue().toString();
                String Telefono = dataSnapshot.child("Teléfono").getValue().toString();

                mTextViewData.setText("Nomnbre"+nombre);
                mTextViewData.setText("Apellido:"+apellido);
                mTextViewData.setText("Telefono:"+Telefono);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void atras(View view){
        finish();
    }
}
