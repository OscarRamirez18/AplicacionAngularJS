package utng.edu.mx.angularjs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import utng.edu.mx.angularjs.estrategia.Manager;
import utng.edu.mx.angularjs.galeria.GaleryJPA;
import utng.edu.mx.angularjs.galeria.GaleryUTNG;

/**
 * Created by Oscar on 03/05/2016.
 */
public class ActivityGalerias extends AppCompatActivity implements View.OnClickListener {

    public Button btngalery,btnutng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galerias);

        btngalery=(Button)findViewById(R.id.btn_galery_jpa);
        btngalery.setOnClickListener(this);

        btnutng=(Button)findViewById(R.id.btn_galery_utng);
        btnutng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_galery_jpa:
                startActivity(new Intent(ActivityGalerias.this, GaleryJPA.class));
                break;
            case R.id.btn_galery_utng:
                startActivity( new Intent(ActivityGalerias.this, GaleryUTNG.class));
                break;

        }
    }
}


