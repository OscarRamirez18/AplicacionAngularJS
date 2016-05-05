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
public class VideoActivityTres extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_relation);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r8---sn-a5m7lnel.googlevideo.com/Cj0LENy73wIaNAlSvThd6p939RMYDSANFC1ZRilXMOCoAUIASARghvyJ1saFgIpXigELLTVSY3RXSUJDekkM/6699134B073B6B22563921C4AE2F1C9B0A37496F.A82DE4E627FD4F313BCECA42E57FA1CA059C0BDE/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}