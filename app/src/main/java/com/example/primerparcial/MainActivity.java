package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick  {

    Activity activity;
    Producto producto ;
    private static List<Producto> Productos;
    MyAdapter adapter ;

    public static List<Producto> getLista() {
        return Productos; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Productos = new ArrayList<Producto>();
        Productos.add(new Producto("Cocacola","1","5"));
        Productos.add(new Producto("Pepsi","3","5"));
        Productos.add(new Producto("jorgelin","5","5"));
        Productos.add(new Producto("fanta","8","5"));
        Productos.add(new Producto("ades","10","5"));
        Productos.add(new Producto("Gatorade","20","5"));
        Productos.add(new Producto("Quilmes","21","5"));
        Productos.add(new Producto("fosforos","22","5"));
        Productos.add(new Producto("jabon","16","5"));
        Productos.add(new Producto("pintura","18","5"));
        Productos.add(new Producto("galletitas","20","5"));
        Productos.add(new Producto("yogurt","2","5"));


        RecyclerView list = (RecyclerView)findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        adapter = new MyAdapter(Productos,this);
        list.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this,ModificarProducto.class);
        intent.putExtra("posicion",position) ;
        super.startActivity(intent);


    }

  public void ActualizarLista (Integer posicion){

      this.adapter.notifyItemChanged(posicion);
  }


}
