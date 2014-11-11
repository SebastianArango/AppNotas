package model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.sebastian.appnotas.R;

/**
 * Created by igdev on 10/11/14.
 */
public class AlertaMensaje extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Acerca de");
        builder.setMessage("Desarrollada por: Sebastian Arango Oquendo" +
                "\nVersion: 1.0 \nDerechos reservados");

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"AppNotas Vesion 1,0",Toast.LENGTH_SHORT).show();
            }
        });

        Dialog dialog = builder.create();

        return dialog;


    }

}

