package com.morpheus.lectorcodigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.morpheus.lectorcodigo.Resources.Permisos;

public class MainActivity extends AppCompatActivity
{

    private static final int OK = 1;

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
                startActivityForResult(intent, OK);
            }
        });


    }

    //El resultado cuando termina la actividad de lectura
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK)
        {
            String codigo = data.getStringExtra("CODIGO");
            Toast.makeText(this, codigo, Toast.LENGTH_SHORT).show();
        }
    }
}
