package com.example.primerparcial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModificarProducto extends AppCompatActivity  {

    EditText edtCantidad;
    EditText edtNombreProducto;
    EditText edtPrecioUnitario ;
    Integer posicion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_producto);


        posicion = (Integer)super.getIntent().getExtras().get("posicion");
        Producto productoModel = MainActivity.getLista().get(posicion);

         edtCantidad = (EditText) super.findViewById(R.id.edtcantidad);
         edtNombreProducto = (EditText) super.findViewById(R.id.edtNombreProducto);
         edtPrecioUnitario = (EditText) super.findViewById(R.id.edtPrecioUnitario);
        Button  btnmodificar = (Button)super.findViewById(R.id.button_guardar);

        MainActivity vista = new MainActivity() ;
        MyAdapter adapter = new MyAdapter(this ,vista , posicion );
        btnmodificar.setOnClickListener(adapter);

        edtCantidad.setText(productoModel.getCantidad());
        edtNombreProducto.setText(productoModel.getNombreProducto());
        edtPrecioUnitario.setText(productoModel.getPrecioUnitario());

        ActionBar toolbar =  getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);

    }



}
