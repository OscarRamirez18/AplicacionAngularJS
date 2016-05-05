package utng.edu.mx.angularjs.video;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import utng.edu.mx.angularjs.R;

public class VideoActivityUno extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_jpa);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r15---sn-a5m7ln7d.googlevideo.com/Cj0LENy73wIaNAnNlhrhmaOHUxMYDSANFC0V8ydXMOCoAUIASARghvyJ1saFgIpXigELLTVSY3RXSUJDekkM/DEA53AF7647288B22443FB106B015C4143FA95B5.72081F8FDBF5ABB5E174F3D01E87566A1C42D989/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}