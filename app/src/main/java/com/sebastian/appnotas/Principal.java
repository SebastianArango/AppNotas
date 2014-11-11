package com.sebastian.appnotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import model.AlertaMensaje;
import model.Config;


public class Principal extends Activity {

    TextView mres;
    EditText not1,not2, not3, not4;
    Button calc;
    double nota1, nota2, nota3, nota4, notafinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.mres = (TextView) findViewById(R.id.lblresultado);
        this.not1 = (EditText) findViewById(R.id.txtNota1);
        this.not2 = (EditText) findViewById(R.id.txtNota2);
        this.not3 = (EditText) findViewById(R.id.txtNota3);
        this.not4 = (EditText) findViewById(R.id.txtNota4);
        this.calc = (Button) findViewById(R.id.btnCalcular);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(not1.getText().toString())  || TextUtils.isEmpty(not2.getText().toString())
                        || TextUtils.isEmpty(not3.getText().toString()) || TextUtils.isEmpty(not4.getText().toString())) {

                    Toast.makeText(Principal.this, "Debes ingresar todos los campos", Toast.LENGTH_SHORT).show();


                }
                    else {
                    nota1 = Double.parseDouble(not1.getText().toString());
                    nota2 = Double.parseDouble(not2.getText().toString());
                    nota3 = Double.parseDouble(not3.getText().toString());
                    nota4 = Double.parseDouble(not4.getText().toString());
                }

                    if (nota1 >= 0.0 && nota1 <= 5.0 && nota2 >= 0.0 && nota2 <= 5.0 && nota3 >= 0.0
                            && nota3 <= 5.0 && nota4 >= 0.0 && nota4 <= 5.0) {


                        notafinal = (nota1 * Config.getInstance().getQuiz()) + (nota2 * Config.getInstance().getExposicion()) +
                                (nota3 * Config.getInstance().getPractica()) + (nota4 * Config.getInstance().getProject());

                        mres.setText("Su resultado es: " + notafinal);
                    }
                    else{

                        Toast.makeText(getBaseContext(), "Debes ingresar notas en el rango de 0.0 - 5.0", Toast.LENGTH_SHORT).show();

                    }



            }


        });
        final Button limpiar = (Button) findViewById(R.id.btnlimpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            not1.setText("");
            not2.setText("");
            not3.setText("");
            not4.setText("");
            mres.setText("");
            calc.setText("Calcular");
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


        if (TextUtils.isEmpty(not1.getText().toString())  || TextUtils.isEmpty(not2.getText().toString())
                || TextUtils.isEmpty(not3.getText().toString()) || TextUtils.isEmpty(not4.getText().toString())) {

            Intent intent = new Intent(this, Configuracion.class);

            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, Configuracion.class);
            calc.setText("Recalcular");
            startActivity(intent);
        }



    }
        else if (id == R.id.ver_alertdialog){
        AlertaMensaje daveta = new AlertaMensaje();
        daveta.show(getFragmentManager(), "key");
    }
        else {
        not1.setText("");
        not2.setText("");
        not3.setText("");
        not4.setText("");
        mres.setText("");
        calc.setText("Calcular");

        }
    return  super.onOptionsItemSelected(item);
}



}
