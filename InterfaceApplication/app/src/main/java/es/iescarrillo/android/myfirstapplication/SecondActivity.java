package es.iescarrillo.android.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnVolver;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnVolver = (Button) findViewById(R.id.btnBack);
        tvName = (TextView) findViewById(R.id.tvName);

        // Recuperamos el intent los datos
        Intent viewMainIntent = getIntent();
        tvName.setText("Tu nombre es " + viewMainIntent.getStringExtra("name"));
        btnVolver.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(findViewById(R.id.btnBack).isPressed()) {
            // Creamos un Intent para ir a la siguiente Activity
            Intent viewNameIntent = new Intent(this, MainActivity.class);

            // Inicia actividad
            startActivity(viewNameIntent);


        }
    }
}