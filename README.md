
# Bienvenidos a un minitutorial de Android Studio

El día de hoy les mostrare como agregar un menú a su aplicación de android studio, ¡Vamos al código! 

## Menu.xml

Paso 1: En la carpeta *res* agregaremos un nuevo directorio al que le pondremos como titulo menu

![Agregando un nuevo directorio](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/cxr2pr3re72rmj05bav1.png)

Dentro de esa carpeta agregaremos un menú dando clic derecho en el nuevo directorio y seleccionar la opcion agregar "Menu Resource File" el cual nos generará un archivo .xml al que llamaremos menu.xml


![Agregando un nuevo archivo tipo Menu Resource File](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/gtpqudc1e5jvknqt7d2r.png)

Dentro de este archivo agregaremos una elemento tipo <item> este elemento lo nombraremos "Contacto" este valor viene de la carpeta values/strings.xml (Es buena practica crear todos los textos que se utilizarán en nuestra aplicación en esta sección) y se lo asignamos al item que acabamos de crear. 

Puedes agregar tantos ítems como desees para este ejemplo solo agregaremos 1


```
    <item
        android:id="@+id/item1"
        android:title="@string/Contacto" />

```

Quedando de la siguiente manera el menu.xml

![Ejemplo del menu.xml](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/b1g6ddffk0k3zkczodnt.png)

# MainActivity
Paso 2: En el MainActivity agregaremos un conjunto de metodos.

### onCreateOptionsMenu

Este método nos servirá para poder agregar el menú que creamos a nuestra aplicación creando un elemento tipo MenuInflater


```

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

```

Posteriormente agregaremos un switch donde agregaremos tantos case como items de nuestro menu agreguemos en el menu.xml en este caso solo tengo 1 item, por eso solo agregare un case y un metodo que nos permitirá abrir el intent (Activity) correspondiente.


```
   public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            // En caso de que el id seleccionado sea el de item1 lo enviaremos a Contacto
            case R.id.item1:
            {
                abrirActivityContacto();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);

        }
    }


```

Como podrán ver se utiliza el metodo *item.getItemId()* el cual sirve para obtener el id de la opción seleccionada en el menú, en este caso tengo el id *item1* al momento de ser seleccionado se ejecuta el metodo abrirActivityContacto()


### abrirActivityContacto()

```
 public void abrirActivityContacto()
    {
        Intent intent = new Intent(MainActivity.this, Contacto.class);
        startActivity(intent);

    }


```

Este método ejecutamos una activity con un *intent* el cual incluye la ubicación donde nos encontramos y a que actividad queremos ir en este caso estamos en MainActivity y queremos ver el activity *Contacto.class*


## AndroidManifest.xml

Ahora para concluir agregaremos una flecha de retroceso en el activity *Contacto* para retornar a *MainActivity*, para hacer esto, tenemos que ir al archivo manifest/AndroidManifest.xml donde editaremos el *activity Contacto* y agregaremos lo siguiente: *android:parentActivityName=".MainActivity"* 

También agregaremos un meta-data donde agregaremos la actividad padre el cual le indicara a donde tiene que retornar.

```
    <meta-data
            android:name="@android.support.PARENT_ACTIVITY"
            android:value=".MainActivity"
            >

        </meta-data>
``` 



Listo!, hemos terminado!, ya tenemos nuestro menú dentro de nuestra aplicación, Felicidades!.

Si deseas ver el código en github te dejo el enlace a continuación.


[Ver código en github](https://github.com/fynio/agregar_menu_android_studio.git)

 




