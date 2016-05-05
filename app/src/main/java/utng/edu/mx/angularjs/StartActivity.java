package utng.edu.mx.angularjs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import utng.edu.mx.angularjs.agenda.AgendaFinalActivity;

public class StartActivity extends ActionBarActivity implements View.OnClickListener {

    public Button btnRegistro;
    public ImageButton acercaDe;
    public Button btngalerias;
    public Button btnPagina;
    public Button btnAgenda;
    public Button btnCalcu;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        btnRegistro=(Button)findViewById(R.id.btn_regis);
        btnRegistro.setOnClickListener(this);
        acercaDe=(ImageButton)findViewById(R.id.acerca_de);
        acercaDe.setOnClickListener(this);
        btngalerias=(Button)findViewById(R.id.galerias);
        btngalerias.setOnClickListener(this);
        btnPagina=(Button)findViewById(R.id.pagina_web);
        btnPagina.setOnClickListener(this);
        btnAgenda=(Button)findViewById(R.id.agenda);
        btnAgenda.setOnClickListener(this);
        btnCalcu=(Button)findViewById(R.id.calcula);
        btnCalcu.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_regis:
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                break;
            case R.id.acerca_de:
                startActivity(new Intent(StartActivity.this, CreditosActivity.class));
                break;
            case R.id.galerias:
                startActivity(new Intent(StartActivity.this, ActivityGalerias.class));
                break;
            case R.id.pagina_web:
                startActivity(new Intent(StartActivity.this, ActivityPaginaWeb.class));
                break;
            case R.id.agenda:
                startActivity(new Intent(StartActivity.this, AgendaFinalActivity.class));
                break;
            case R.id.calcula:
                startActivity(new Intent(StartActivity.this, Calculadora.class));
                break;
        }
    }
}
