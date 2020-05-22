package com.example.primerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyViewHolder>  implements View.OnClickListener {

    private List<Producto> lista;
    private MyOnItemClick listener;

    private Producto producto;
    private  Integer posicion ;
    private ModificarProducto mp ;
    private MainActivity vista ;
    private Integer posicionenlista;


    public MyAdapter(Producto p , Integer posicion){

        this.producto = p;
        this.posicion = posicion;
    }


    public MyAdapter(List<Producto> lista, MyOnItemClick listener)
    {
        this.lista=lista;
        this.listener= listener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v , this.listener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Producto p = lista.get(position);
        holder.txtCantidad.setText(p.getCantidad());
        holder.txtPrecioUnitario.setText(p.getPrecioUnitario());
        holder.txtNombreProducto.setText(p.getNombreProducto());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public MyAdapter (ModificarProducto mp,MainActivity vista, Integer posicion){
        this.mp = mp ;
        this.vista = vista ;
        this.posicion = posicion ;
    }

    @Override
    public void onClick(View v) {

        Producto p = new Producto();
        p.setNombreProducto(mp.edtNombreProducto.getText().toString());
        p.setCantidad(mp.edtCantidad.getText().toString());
        p.setPrecioUnitario(mp.edtPrecioUnitario.getText().toString()) ;

       MainActivity.getLista().get(posicion).precioUnitario = p.precioUnitario ;
        MainActivity.getLista().get(posicion).cantidad=   p.cantidad ;
        MainActivity.getLista().get(posicion).nombreProducto = p.nombreProducto ;

        vista.ActualizarLista(posicion);
    }
}
