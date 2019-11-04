package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevaContacto extends AppCompatActivity {

    EditText txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_contacto);
    }

    public void enviarBDD(View view){
        //escribir en la base
        txt1=(EditText)findViewById(R.id.nombre);
        String a=txt1.getText().toString();
        txt2=(EditText)findViewById(R.id.apellido);
        String b=txt2.getText().toString();
        txt3=(EditText)findViewById(R.id.telefono);
        String c=txt3.getText().toString();

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef =database.getReference("mensaje");
        myRef.setValue(a);
        myRef.setValue(b);
        myRef.setValue(c);

    }

    public void cancel(View view){
        finish();
    }
}
