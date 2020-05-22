package com.example.primerparcial;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txtCantidad;
    TextView txtPrecioUnitario;
    TextView txtNombreProducto ;
    private MyOnItemClick listener;
    private int position;

    public void setPosition(int position)
    {
        this.position = position;
    }

    public MyViewHolder(View itemView , MyOnItemClick listener) {
        super (itemView);
        txtCantidad = (TextView) itemView.findViewById(R.id.txtcantidad);
        txtPrecioUnitario = (TextView) itemView.findViewById(R.id.txtPrecioUnitario);
        txtNombreProducto = (TextView) itemView.findViewById(R.id.txtNombreProducto);
        itemView.setOnClickListener(this);
        this.listener = listener ;
    }

    @Override
    public void onClick(View v) {


        listener.onItemClick(position);
    }
}
