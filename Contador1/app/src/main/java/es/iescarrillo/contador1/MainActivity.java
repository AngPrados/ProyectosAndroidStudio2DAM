package es.iescarrillo.contador1;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variable para contar
    public int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador=0;
    }

    //Método que incrementa en 1 el contador
    public void incrementaContador(View vista){
        contador++;
        mostrarResultado();
        //Toast.makeText(getApplicationContext(), "Incremento" + contador, Toast.LENGTH_LONG).show();
    }
    public void decrementaContador(View vista){
        contador--;
        mostrarResultado();
    }
    public void reseteaContador(View vista){
        contador=0;
        mostrarResultado();
    }

    public void mostrarResultado(){
        //Elementos del xml
        TextView textoResultado = (TextView) findViewById(R.id.contadorTexto);
        textoResultado.setText(""+contador);
        textoResultado.setVisibility(TextView.VISIBLE);
    }
}