package com.sebastian.appnotas;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import model.Config;


public class Configuracion extends Activity {

    Principal principal = new Principal();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        final EditText camnot1 = (EditText) findViewById(R.id.txtCamNota1);
        final EditText camnot2 = (EditText) findViewById(R.id.txtcamNota2);
        final EditText camnot3 = (EditText) findViewById(R.id.txtcamNota3);
        final EditText camnot4 = (EditText) findViewById(R.id.txtcamNota4);


        camnot1.setText(Double.toString(Config.getInstance().getQuiz()));
        camnot2.setText(Double.toString(Config.getInstance().getExposicion()));
        camnot3.setText(Double.toString(Config.getInstance().getPractica()));
        camnot4.setText(Double.toString(Config.getInstance().getProject()));


        final Button guardar = (Button) findViewById(R.id.btnGuardar);

       guardar.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {
                Config.getInstance().setQuiz((Double.parseDouble(camnot1.getText().toString())));
                Config.getInstance().setExposicion((Double.parseDouble(camnot2.getText().toString())));
                Config.getInstance().setPractica((Double.parseDouble(camnot3.getText().toString())));
                Config.getInstance().setProject((Double.parseDouble(camnot4.getText().toString())));

                if (Double.parseDouble(camnot1.getText().toString())+
                    Double.parseDouble(camnot2.getText().toString()) +
                    Double.parseDouble(camnot3.getText().toString())+
                    Double.parseDouble(camnot4.getText().toString())==1){

                    Toast.makeText(Configuracion.this, "Porcentaje Actual de las notas" +
                            "\nQuiz:"+camnot1.getText()+"\nExposionones"+camnot2.getText()+"\nPractica"+
                            camnot3.getText()+"\nProyecto"+camnot4.getText(), Toast.LENGTH_LONG).show();

                    finish();
                }

               else {
                    Toast.makeText(getBaseContext(), "Los porcentajes ingresados deben sumar el 100%", Toast.LENGTH_SHORT).show();
                }
           }
      });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.configuracion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
