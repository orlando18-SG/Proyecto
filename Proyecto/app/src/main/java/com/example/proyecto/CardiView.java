package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CardiView extends AppCompatActivity {

    private RecyclerView recyclerfut;
    private List<Productos> items = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaProductos();
        setContentView(R.layout.activity_cardi_view);
        getSupportActionBar().hide();

        recyclerfut=(RecyclerView)findViewById(R.id.RecyclerProd);
        recyclerfut.setHasFixedSize(true);


        lmanager= new LinearLayoutManager(this);
        recyclerfut.setLayoutManager(lmanager);

        adapter= new RecyclerViewAdaptador(items);
        recyclerfut.setAdapter(adapter);
    }

    private void listaProductos(){
        items.add(new Productos("Inka Kola","S/. 7.50","Gaseosa sin Azúcar\n" + "Botella 2.25L",R.drawable.inka));
        items.add(new Productos("Pepsi","S/. 4.40","Botella 1.5L",R.drawable.pepsi));
        items.add(new Productos("Seven Up","S/. 9.00","Gaseosa Lima Limón\n" + "Botella 3L x 2un",R.drawable.seven));
        items.add(new Productos("San Luis","S/. 6.90","Agua sin Gas\n" + "Bidón 7L",R.drawable.sanluis));
        items.add(new Productos("San Mateo","S/. 3.50","Agua Mineral sin Gas\n" + "Botella 2.5L",R.drawable.sanmateo));
        items.add(new Productos("Black Label","S/. 84.90","Whisky JOHNNIE WALKER\n" + "Botella 750ml",R.drawable.blacklabel));
        items.add(new Productos("Red Label","S/. 49.90","Whisky JOHNNIE WALKER\n" + "Botella 750ml",R.drawable.redlabel));
        items.add(new Productos("Galleta OREO","S/. 3.39","Regular Paquete 6un",R.drawable.oreo));
        items.add(new Productos("Galleta Chokosoda","S/. 3.99","FIELD Paquete 6un",R.drawable.chokosoda));
        items.add(new Productos("Galleta Doña Pepa","S/. 3.09","FIELD Paquete 6un",R.drawable.donapepa));
        items.add(new Productos("Galleta RITZ","S/. 2.59","Regular Paquete 6un",R.drawable.ritz));
        items.add(new Productos("Galleta Morochas","S/. 6.00","Paquete 240g Caja 8un",R.drawable.morochas));
        items.add(new Productos("Galletas Picaras","S/. 3.90","Clásicas Paquete 6un",R.drawable.picaras));
        items.add(new Productos("Galletas CHOCO ¡BUM!","S/. 3.70","Sabor a Chocolate \n" + "Paquete 6un",R.drawable.chucobum));
        items.add(new Productos("Batti Mix","S/. 2.80","Vainilla con Bolitas de Chocolate\n" + "Vaso 125g",R.drawable.battimix));
        items.add(new Productos("Yogurt Gloria","S/. 5.90","Fresa Botella 1Kg",R.drawable.yogurt));
        items.add(new Productos("Helado Bombones","S/. 9.99","Pote 216ml",R.drawable.bombones));
        items.add(new Productos("Salchicha de Pollo","S/. 3.90","SAN FERNANDO \n" + "Paquete 250g",R.drawable.salchicha));
        items.add(new Productos("Arroz Extra","S/. 21.30","COSTEÑO\n" + "Bolsa 5Kg",R.drawable.arroz));
        items.add(new Productos("Aceite Vegetal","S/. 16.80","PRIMOR Premium\n" + "Botella 1.8L",R.drawable.aceite));
        items.add(new Productos("Mayonesa","S/. 15.90","ALACENA\n" + "Doypack 950g",R.drawable.mayonesa));
        items.add(new Productos("Spaghetti","S/. 3.59","DON VITTORIO\n" + "Bolsa 1Kg",R.drawable.fideos));
        items.add(new Productos("Azúcar Rubia","S/. 13.99","BELL'S\n" + "Bolsa 5Kg",R.drawable.azucar));
        items.add(new Productos("Leche GLORIA","S/. 17.99","Evaporada Entera\n" + "Lata 400g Paquete 6un",R.drawable.leche));
    }
}