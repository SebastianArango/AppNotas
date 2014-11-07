package com.sebastian.appnotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Configuracion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        final EditText camnot1 = (EditText) findViewById(R.id.txtCamNota1);
        final EditText camnot2 = (EditText) findViewById(R.id.txtcamNota2);
        final EditText camnot3 = (EditText) findViewById(R.id.txtcamNota3);
        final EditText camnot4 = (EditText) findViewById(R.id.txtcamNota4);

        Bundle bundle = getIntent().getExtras();
        camnot1.setText(String.valueOf(bundle.getInt("Quinces")));
        camnot2.setText(String.valueOf(bundle.getInt("Expo")));
        camnot3.setText(String.valueOf(bundle.getInt("Pract")));
        camnot4.setText(String.valueOf(bundle.getInt("Proye")));



        final Button guardar = (Button) findViewById(R.id.btnGuardar);

       guardar.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {

              Intent intent1 = new Intent();
                intent1.putExtra("prQuiz", camnot1.getText().toString());
                intent1.putExtra("prExpos", camnot2.getText().toString());
                intent1.putExtra("prPracti", camnot3.getText().toString());
                intent1.putExtra("prProyect", camnot4.getText().toString());
                setResult(RESULT_OK, intent1);
                finish();



           }
      });
    }


    protected void onActivityResult (int requestCode, int resultCode, Intent Data){
        if (requestCode==1234 && resultCode==RESULT_OK){
            String quiz = Data.getExtras().getString("PrQui");
            String expo = Data.getExtras().getString("PrExp");
            String proy = Data.getExtras().getString("PrPro");
            String prac = Data.getExtras().getString("PrPra");

            Toast.makeText(this, "Quis: "+quiz+ "Exposiones: "+expo+ "Proyecto: "+proy+ "Practica: " +prac, Toast.LENGTH_SHORT).show();


        }

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
