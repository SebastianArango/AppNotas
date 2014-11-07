package com.sebastian.appnotas;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        final TextView mres = (TextView) findViewById(R.id.lblresultado);
        final EditText not1 = (EditText) findViewById(R.id.txtNota1);
        final EditText not2 = (EditText) findViewById(R.id.txtNota2);
        final EditText not3 = (EditText) findViewById(R.id.txtNota3);
        final EditText not4 = (EditText) findViewById(R.id.txtNota4);

        final Button calc = (Button) findViewById(R.id.btnCalcular);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

            if (id == R.id.ver_configuracion) {
                Intent intent = new Intent(this, Configuracion.class);
                intent.putExtra("Quinces", 15);
                intent.putExtra("Expo", 10);
                intent.putExtra("Pract", 40);
                intent.putExtra("Proye", 35);
                startActivityForResult(intent, 1234);


            }
        return  super.onOptionsItemSelected(item);
    }



}
