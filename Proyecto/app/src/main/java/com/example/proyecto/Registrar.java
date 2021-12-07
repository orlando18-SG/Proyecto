package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrar extends AppCompatActivity {

    EditText nombre,precio,descripcion;
    Button btn1;
    private DatabaseReference Clases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        getSupportActionBar().hide();

        Clases = FirebaseDatabase.getInstance().getReference("Tienda");

        nombre = (EditText) findViewById(R.id.tvNombre);
        precio = (EditText) findViewById(R.id.tvPrecio);
        descripcion = (EditText)findViewById(R.id.tvDescripcion);
        btn1 = (Button)findViewById(R.id.btnRegistrar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarClase();
            }
        });
    }

    private void RegistrarClase() {

        String nom = nombre.getText().toString();
        String prec = precio.getText().toString();
        String descrip = descripcion.getText().toString();

        if(!TextUtils.isEmpty(nom) && !TextUtils.isEmpty(prec) && !TextUtils.isEmpty(descrip))
        {
            String id = Clases.push().getKey();
            Producto producto = new Producto(id,nom,prec,descrip);
            Clases.child("Productos").child(id).setValue(producto);

            Toast.makeText(this, "Clase Registrada",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe Rellenar Todos los Campos", Toast.LENGTH_LONG).show();
        }
    }
}