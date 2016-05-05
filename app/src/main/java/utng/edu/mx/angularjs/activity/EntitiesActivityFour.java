package utng.edu.mx.angularjs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import utng.edu.mx.angularjs.DatabaseHelperPoints;
import utng.edu.mx.angularjs.R;
import utng.edu.mx.angularjs.answers.entities.QuestionEntitiesActivity;
import utng.edu.mx.angularjs.video.VideoActivityCuatro;


public class EntitiesActivityFour extends Activity implements View.OnClickListener{

    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);
    private Button btnCuest;
    private Button btnVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_entities_four);  //se saca porque sino se solapan

        btnCuest=(Button)findViewById(R.id.btn_custionario);
        btnCuest.setOnClickListener(this);
        btnVideo=(Button)findViewById(R.id.btn_video);
        btnVideo.setOnClickListener(this);

        ScrollView temario=(ScrollView)findViewById(R.id.ScrollView01);
        int tema = helperPoints.tema();
        if (tema == 1) {
            temario.setBackgroundResource(R.drawable.fondo_azul);
        } else {
            if (tema == 2) {
                temario.setBackgroundResource(R.drawable.fondo_chivas);
            } else {
                if (tema == 3) {
                    temario.setBackgroundResource(R.drawable.fondo_ame);
                } else {
                    if (tema == 4) {
                        temario.setBackgroundResource(R.drawable.fondo_esperanza);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_custionario:
                Intent i= new Intent(this, QuestionEntitiesActivity.class);
                startActivity(i);
                System.exit(0);
                break;
            case R.id.btn_video:
                i = new Intent(this, VideoActivityCuatro.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}