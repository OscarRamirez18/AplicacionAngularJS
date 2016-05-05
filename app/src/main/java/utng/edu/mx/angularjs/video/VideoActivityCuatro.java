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
public class VideoActivityCuatro extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_jpa);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r2---sn-a5mekn7d.googlevideo.com/Cj0LENy73wIaNAmszjpZo0MbMxMYDSANFC19RilXMOCoAUIASARghvyJ1saFgIpXigELLTVSY3RXSUJDekkM/1E2A088E2560E186C6EFCECD22B67CCD9165ADBE.C403601F20C6F5B4B0CB9DA7565B754001598FE6/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}