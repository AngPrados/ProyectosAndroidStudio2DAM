package es.iescarrillo.contador2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //variable para contar
    public int contador;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado=(TextView)findViewById(R.id.contadorTexto);
        contador=0;
    }

    //Método que incrementa en 1 el contador
    public void incrementaContador(View vista){
         contador++;
         textoResultado.setText(""+contador);
         textoResultado.setVisibility(TextView.VISIBLE);
    }


    public void decrementaContador(View vista){
        contador--;
        textoResultado.setText(""+contador);
        textoResultado.setVisibility(TextView.VISIBLE);

        if (contador<0){
            CheckBox negativos=(CheckBox) findViewById(R.id.checkBox);
            if(!negativos.isChecked()){
                contador=0;
                textoResultado.setText(""+contador);

                textoResultado.setVisibility(TextView.VISIBLE);
            }
        }

    }
    public void reseteaContador(View vista){

        EditText textoReseteo=(EditText) findViewById(R.id.editTextNumber);
            try {

               contador = Integer.parseInt(textoReseteo.getText().toString());

            }catch (Exception e){

                contador=0;
            }
        textoReseteo.setText("");
        textoResultado.setText(""+contador);
        textoResultado.setVisibility(TextView.VISIBLE);

        Toast.makeText(getApplicationContext(),"La variable contador essssssss: " + contador, Toast.LENGTH_LONG).show();
    }

   /* public void mostrarResultado(){
        TextView textoResultado = (TextView) findViewById(R.id.contadorTexto);
        textoResultado.setText(""+contador);
        textoResultado.setVisibility(TextView.VISIBLE);
    }*/
}