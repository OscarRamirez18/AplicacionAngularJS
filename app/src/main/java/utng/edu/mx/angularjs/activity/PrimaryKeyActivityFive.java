package utng.edu.mx.angularjs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import utng.edu.mx.angularjs.DatabaseHelperPoints;
import utng.edu.mx.angularjs.R;
import utng.edu.mx.angularjs.answers.primarykey.QuestionPrimaryKeyActivity;
import utng.edu.mx.angularjs.video.VideoActivityCinco;


public class PrimaryKeyActivityFive extends Activity implements View.OnClickListener{

    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);
    private Button btnCuest;
    private Button btnVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_pimarykey_five);

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
                Intent i= new Intent(this, QuestionPrimaryKeyActivity.class);
                startActivity(i);
                System.exit(0);
                break;
            case R.id.btn_video:
                i = new Intent(this, VideoActivityCinco.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}