# My First Application



## Descripción

En este primer proyecto tendremos una primera toma de contacto con:

- [ ] Edición de vistas XML
- [ ] Asignar funcionalidad a eventos de botones
- [ ] Navegar entre diferentes Activities
- [ ] Enviar información de una Activity a otra

## Edición de vistas XML
Ejemplos:
```
 <TextView
            android:id="@+id/tvTitle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="Bienvenidos a mi primera APP"
            android:textAlignment="center"
            android:textColor="@color/black"
            android:textSize="25dp"
            android:textStyle="bold" />

 <EditText
            android:id="@+id/etName"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:layout_marginLeft="15dp"
            android:layout_marginTop="35dp"
            android:layout_marginRight="15dp"
            android:ems="10"
            android:inputType="text"
            android:hint="Escribe tu nombre..."
            android:textSize="18sp" />

 <Button
        android:id="@+id/btnNext"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:backgroundTint="@color/myColor"
        android:text="Siguiente"
        android:textColor="@color/white"
        android:textStyle="bold"
        android:layout_marginBottom="50dp"
        android:layout_marginLeft="25dp"
        android:layout_marginRight="25dp"
        app:layout_constraintBottom_toBottomOf="parent"/>
```

## Asignar funcionalidad a eventos de botones

```
Button btnSpanish = (Button) findViewById(R.id.btnSpanish);
btnSpanish.setOnClickListener(v -> translate());
```

## Navegar entre diferentes Activities & enviar informaicón

```
bntNext.setOnClickListener(v -> {
    // Creamos un Intent para ir a la siguiente Activity
    Intent viewNameIntent = new Intent(this, SecondActivity.class);

    // Añadir datos
    viewNameIntent.putExtra("name", etName.getText().toString());

    // Inicia actividad
    startActivity(viewNameIntent);
});
```

## Recoger información de otra Activity

```
// Recuperamos el intent los datos
Intent viewMainIntent = getIntent();
TextView tvName = (TextView) findViewById(R.id.tvName);
tvName.setText("Tu nombre es " + viewMainIntent.getStringExtra("name"));
```