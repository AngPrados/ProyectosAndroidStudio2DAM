package es.iescarrillo.android.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnEnglish ;
    Button btnSpanish ;
    Button bntNext ;
    EditText etName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnEnglish = (Button) findViewById(R.id.btnEnglish);
         btnSpanish = (Button) findViewById(R.id.btnSpanish);
         bntNext = (Button) findViewById(R.id.btnNext);
         etName = (EditText) findViewById(R.id.etName);



         btnSpanish.setOnClickListener(this);
         btnEnglish.setOnClickListener(this);
         bntNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // etName = (EditText) findViewById(R.id.etName);
        TextView tvGrettings = (TextView) findViewById(R.id.tvGrettings);

        if(etName.getText().toString().length() == 0){
            tvGrettings.setText("Debes escribir tu nombre");
            tvGrettings.setTextColor(Color.RED);
        }else {
            tvGrettings.setTextColor(Color.BLACK);
            if(findViewById(R.id.btnEnglish).isPressed()) {
                tvGrettings.setText("Hello " + etName.getText().toString() + "!");
            }else{
                tvGrettings.setText("Hola " + etName.getText().toString() + "!");
            }

        }



        if(findViewById(R.id.btnNext).isPressed()) {
            // Creamos un Intent para ir a la siguiente Activity
            Intent viewNameIntent = new Intent(this, SecondActivity.class);

            // Añadir datos
            viewNameIntent.putExtra("name", etName.getText().toString());

            // Inicia actividad
            startActivity(viewNameIntent);

        }



    }
}