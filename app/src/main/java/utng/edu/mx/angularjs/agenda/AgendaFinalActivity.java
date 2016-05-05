package utng.edu.mx.angularjs.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import utng.edu.mx.angularjs.R;
import utng.edu.mx.angularjs.gato.AcercaDe;

public class AgendaFinalActivity extends Activity {
	//Declaraciones de Tipos
	private Button boton_nota;
    /** onCreare para mandar a la actividad principal de la agenda  */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainag);

        crearEventoCalendario();

    }
    /* Instrucciones a los botones correspondientes*/

    
    private void crearEventoCalendario() {
    	this.boton_nota = (Button) findViewById(R.id.boton_nota);
         this.boton_nota.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				crearNotaCalendario();

			}
		});
    }

    
    public void lanzarListado() { 
  	  Intent i = new Intent(this, Notepad.class);
  	  startActivity(i); 
  	}      
    
    public void lanzarAcercaDe() {
    	Intent i = new Intent (this, AcercaDe.class);
    	startActivity(i);
    	
    }   
    
    private void crearNotaCalendario() {
    	Intent l_intent = new Intent(Intent.ACTION_EDIT);
    	//utilizamos la api de calendario proporcionada por android
    	l_intent.setType("vnd.android.cursor.item/event");
    	l_intent.putExtra("Asunto", "Asunto");
    	l_intent.putExtra("Descripcion", "Introduce tu descripcion");
    	l_intent.putExtra("Lugar", "@home");
    	l_intent.putExtra("Fecha Inicio", System.currentTimeMillis());
    	l_intent.putExtra("Fecha Final", System.currentTimeMillis() + 1800*1000);
    	l_intent.putExtra("Todo el dia", 0);
    	//status: 0~ tentative; 1~ confirmed; 2~ canceled
    	l_intent.putExtra("eventStatus", 1);
    	//0~ default; 1~ confidential; 2~ private; 3~ public
    	l_intent.putExtra("visibility", 0);
    	l_intent.putExtra("transparency", 0);
    	//0~ false; 1~ true
    	l_intent.putExtra("Activar Alarma", 1);
    	try {
    		startActivity(l_intent);
    	} catch (Exception e) {/*Mensaje dado cuando la aplicacion no encuentra un calendario disponible para agregar evento*/
    		Toast.makeText(this.getApplicationContext(), "Error, no se ha encontrado un calendario compatible!", Toast.LENGTH_LONG).show();
    	}
    }
}