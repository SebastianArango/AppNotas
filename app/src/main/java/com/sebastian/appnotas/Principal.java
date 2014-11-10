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
import android.app.AlertDialog;

import model.Config;


public class Principal extends Activity {

    TextView mres;
    EditText not1,not2, not3, not4;
    double nota1, nota2, nota3, nota4, notafinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.mres = (TextView) findViewById(R.id.lblresultado);
        this.not1 = (EditText) findViewById(R.id.txtNota1);
        this.not2 = (EditText) findViewById(R.id.txtNota1);
        this.not3 = (EditText) findViewById(R.id.txtNota3);
        this.not4 = (EditText) findViewById(R.id.txtNota4);
        final Button calc = (Button) findViewById(R.id.btnCalcular);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                nota1 = Double.parseDouble(not1.getText().toString());
                nota2 = Double.parseDouble(not2.getText().toString());
                nota3 = Double.parseDouble(not3.getText().toString());
                nota4 = Double.parseDouble(not4.getText().toString());

                notafinal = (nota1* Config.getInstance().getQuiz())+(nota2*Config.getInstance().getExposicion())+
                        (nota3*Config.getInstance().getPractica())+(nota4*Config.getInstance().getProject());

//
//                Bundle bundle = getIntent().getExtras();
//                not1.setText(String.valueOf(bundle.getInt("prQuiz")));
//                not2.setText(String.valueOf(bundle.getInt("prExpos")));
//                not3.setText(String.valueOf(bundle.getInt("prPracti")));
//                not4.setText(String.valueOf(bundle.getInt("prProyect")));

              //  notafinal = (nota1*not1.setText()+(nota2*0.10)+(nota3*0.40)+(nota4*0.35);
//
              mres.setText("Su resultado es: "+ notafinal);




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
//        intent.putExtra("Quinces", 15);
//        intent.putExtra("Expo", 10);
//        intent.putExtra("Pract", 40);
//        intent.putExtra("Proye", 35);
//        startActivityForResult(intent, 1234);
        startActivity(intent);
    }
        else {
        AlertaMensaje daveta = new AlertaMensaje();
        daveta.show(getFragmentManager(), "key");
    }
    return  super.onOptionsItemSelected(item);
}



}
