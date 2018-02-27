package com.morpheus.lectorcodigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.morpheus.lectorcodigo.Resources.Permisos;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Checa los permisos
        new Permisos(this).checarPermisos();

        Button btCaptura = (Button)findViewById(R.id.btCaptura);
        btCaptura.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Lector.class);
                startActivity(intent);
            }
        });
    }
}
