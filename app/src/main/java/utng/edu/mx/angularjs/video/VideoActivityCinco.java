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
public class VideoActivityCinco extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_primarykey);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r11---sn-a5m7lner.googlevideo.com/Cj0LENy73wIaNAnjFYbkJq4ibxMYDSANFC3ORilXMOCoAUIASARghvyJ1saFgIpXigELLTVSY3RXSUJDekkM/1906DBB69C878653F839F8465EA0E2EDA6B6BCDF.DCA4B501E56D0E853966DAF952902A40920C586E/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}