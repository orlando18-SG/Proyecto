package com.example.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre,precio,descripcion;
        ImageView foto;

        public ViewHolder(View itemview){
            super(itemview);
            nombre=(TextView)itemview.findViewById(R.id.tvNombre);
            precio=(TextView)itemview.findViewById(R.id.tvPrecio);
            descripcion=(TextView)itemview.findViewById(R.id.tvDescripcion);
            foto=(ImageView)itemview.findViewById(R.id.imgProd);
        }
    }

    public List<Productos> listarProductos;

    public RecyclerViewAdaptador(List<Productos> listarProductos){
        this.listarProductos= listarProductos;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_productos,parent,false);
        ViewHolder viewholder= new ViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(listarProductos.get(position).getNombre());
        holder.precio.setText(listarProductos.get(position).getPrecio());
        holder.descripcion.setText(listarProductos.get(position).getDescripcion());
        holder.foto.setImageResource(listarProductos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listarProductos.size();
    }
}
