package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ejemplo, menu);
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            // En caso de que el id seleccionado sea el de item1 lo enviaremos a Contacto
            case R.id.item1:
            {
                abrirActivityContacto();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void abrirActivityContacto()
    {
        Intent intent = new Intent(MainActivity.this, Contacto.class);
        startActivity(intent);

    }


}