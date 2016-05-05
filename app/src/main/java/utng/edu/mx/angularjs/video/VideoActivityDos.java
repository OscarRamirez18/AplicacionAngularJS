package utng.edu.mx.angularjs.video;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import utng.edu.mx.angularjs.R;

/**
 * Created by LUISITO on 06/04/2016.
 */
public class VideoActivityDos extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_persisten);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r4---sn-a5m7znee.googlevideo.com/Cj0LENy73wIaNAls4COQYsO2VhMYDSANFC2bRSlXMOCoAUIASARghvyJ1saFgIpXigELLTVSY3RXSUJDekkM/3AF3CCDA83965CCF1DD6A480103D9D63C57BBF1A.B16ACA5638B3B6ED3685052744C44D76C574CDA9/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}