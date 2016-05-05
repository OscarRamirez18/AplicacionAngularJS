package utng.edu.mx.angularjs;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


/**
 * Created by Nodo-13 on 16/02/2016.
 */
public class  VideoActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView videoView = (VideoView) findViewById(R.id.videoView_video);
        Uri path = Uri.parse("android.resource://mx.edu.utng.jpajavaluis/"+R.raw.video);
        videoView.setVideoURI(path);
        videoView.start();
    }
}

