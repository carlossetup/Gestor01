package com.example.android.gestor01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    EditText nombreEditTextView;
    EditText emailEditTextView;
    Button guardarButton;
    ListView usuarioListView;
    List<String> usuarios = new ArrayList<String>();

    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreEditTextView = (EditText) findViewById(R.id.editTextNombre);
        emailEditTextView = (EditText) findViewById(R.id.editTextEmail);
        guardarButton = (Button) findViewById(R.id.buttonGuardar);

        usuarioListView = (ListView)findViewById(R.id.listViewUsuario);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,usuarios);

        usuarioListView.setAdapter(adapter);

        guardarButton.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                String nombre = nombreEditTextView.getText().toString();
                String email = emailEditTextView.getText().toString();

                //validando

                if (!validarNombre(nombre)){
                    //error
                    nombreEditTextView.setError("error");
                }else {
                    String mensaje = getString(R.string.Bienvenido_msje)+""+email;

                    Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
                    String datos = nombre+""+email;

                    usuarios.add(datos);
                    adapter.notifyDataSetChanged();

                    nombreEditTextView.setText(null);
                    emailEditTextView.setText(null);
                }
            }

        });
    }

    private boolean validarNombre(String nombre) {

        return !nombre.equals("");
    }

    private  boolean validarEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
}
