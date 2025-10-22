package es.iescarrillo.agenda;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextArchivo, editTextTextMultiLine2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextArchivo = (EditText) findViewById(R.id.editTextArchivo);
        editTextTextMultiLine2 = (EditText) findViewById(R.id.editTextTextMultiLine2);
    }


    private void limpiarTexto(){

        editTextArchivo.setText("");
        editTextTextMultiLine2.setText("");
    }



   private boolean existeFile(String[] archivos, String archivo){

        for(int i=0; i< archivos.length; i++) {
            if (archivo.equals(archivos[i]))
                return true;
        }
       return false;
   }

    public void limpiar(View v){
        this.limpiarTexto();
    }

    public void buscar(View v){
        String[] archivos = fileList();
        String archivo = editTextArchivo.getText().toString();
        archivo=archivo.replace('/','-');

        if(existeFile(archivos,archivo)){

            try {
                InputStreamReader file = new InputStreamReader(openFileInput(archivo));
                BufferedReader br = new BufferedReader(file);
                String linea = br.readLine();
                String texto = "";
                while(linea != null){
                    texto = texto + linea +"\n";
                    linea = br.readLine();
                }
                br.close();
                file.close();
                editTextTextMultiLine2.setText(texto);
            }catch(IOException e){
                    Log.i("Agenda", e.toString());

            }

        }else{
            Toast.makeText(this,"El archivo no existe",Toast.LENGTH_SHORT).show();
        }
    }



    public void grabar(View v){
        String archivo = editTextArchivo.getText().toString();

        archivo = archivo.replace('/','-');

        try{
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput(archivo, MODE_PRIVATE));
            file.write(editTextTextMultiLine2.getText().toString());
            file.flush();
            file.close();

        }catch(IOException e){
            Log.i("Agenda", e.toString());

        }
        Toast.makeText(this,"Se grabó correctamente",Toast.LENGTH_SHORT).show();
        this.limpiarTexto();

    }

}