package com.example.pm1e10515;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm1e10515.Configuracion.Operaciones;
import com.example.pm1e10515.Configuracion.SQLiteConexion;

public class Pais extends AppCompatActivity {

    EditText codpais,nompais;
    Button btnGUARDAR, btnATRAS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        codpais = (EditText) findViewById(R.id.CodPais);
        nompais = (EditText) findViewById(R.id.NomPais);
        btnGUARDAR = (Button) findViewById(R.id.btnGUardar);
        btnATRAS = (Button) findViewById(R.id.btnATras);

        btnGUARDAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertarPais();
            }
        });

        btnATRAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void InsertarPais() {
        SQLiteConexion conexion = new SQLiteConexion(this, Operaciones.NameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Operaciones.codigo,codpais.getText().toString());
        valores.put(Operaciones.p_pais,nompais.getText().toString());

        Long resultado = db.insert(Operaciones.tblPaises,Operaciones.codigo,valores);

        Toast.makeText(getApplicationContext(),"Registrado con Exito!!!"+resultado.toString(),Toast.LENGTH_LONG).show();
        db.close();

        limpiarPantalla();

    }

    private void limpiarPantalla() {
        nompais.setText("");
        codpais.setText("");
    }
    private String codigo;
    private String nombrePais;

    public Pais() {
    }

    public Pais(String codigo, String nombrePais) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

}