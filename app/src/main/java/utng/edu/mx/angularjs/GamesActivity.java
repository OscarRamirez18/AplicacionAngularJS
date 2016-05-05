package utng.edu.mx.angularjs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import utng.edu.mx.angularjs.estrategia.Manager;
import utng.edu.mx.angularjs.galeria.GaleryJPA;
import utng.edu.mx.angularjs.galeria.GaleryUTNG;
import utng.edu.mx.angularjs.gato.JuegoCpu;

/**
 * Created by LUISITO on 22/04/2016.
 */
public class GamesActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btnPalabra, btnMemo, btnGato, btnBuscaminas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_activity);

        btnMemo=(Button)findViewById(R.id.btn_memo);
        btnMemo.setOnClickListener(this);

        btnPalabra=(Button)findViewById(R.id.btn_formar);
        btnPalabra.setOnClickListener(this);
        btnGato=(Button)findViewById(R.id.btn_gato);
        btnGato.setOnClickListener(this);
        btnBuscaminas=(Button)findViewById(R.id.btn_buscaminas);
        btnBuscaminas.setOnClickListener(this);

        ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_memo:
                Intent intent = new Intent(GamesActivity.this, Manager.class);
                startActivity(intent);
                break;
            case R.id.btn_formar:
                intent = new Intent(GamesActivity.this, PreguntaEjemplo.class);
                startActivity(intent);
                break;
            case R.id.btn_gato:
                intent = new Intent(GamesActivity.this, JuegoCpu.class);
                startActivity(intent);
                break;
            case R.id.btn_buscaminas:
                intent = new Intent(GamesActivity.this, ActivityBuscaminas.class);
                startActivity(intent);
                break;


        }
    }
}
