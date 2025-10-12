package es.iescarrillo.diadeandalucia;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cogemos el XML
        setContentView(R.layout.activity_main);

        //Acción del botón -- cuando hago onclick
        Button boton=(Button)findViewById(R.id.button);
        boton.setOnClickListener(this);

        //Seleccionamos el mp3 de Andalucía
        mp = MediaPlayer.create(this, R.raw.andalucia);
    }

    @Override
    public void onClick(View v) {
        //En la accción de hacer un clic al botón izquierdo del ratón, iniciamos el himno
        //y añadimos un mensaje emergente
        mp.start();
        Toast.makeText(getApplicationContext(),
                "Feliz Día de Andalucía", Toast.LENGTH_LONG).show();
    }









    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Estado","Actividad iniciada");
    }

    protected void onResume(){

        super.onResume();
        Log.i("Estado","Actividad ejecutada");

    }

    @Override
    protected void onPause(){

        super.onPause();
        mp.stop();
        Log.i("Estado","Actividad Pausada");

    }

    @Override
    protected void onStop(){

        super.onStop();
        Log.i("Estado","Actividad Detenida");
        mp.stop();
    }


    @Override
    protected void onDestroy(){

        super.onDestroy();
        mp.stop();
        Log.i("Estado","Actividad destruida");

    }
}