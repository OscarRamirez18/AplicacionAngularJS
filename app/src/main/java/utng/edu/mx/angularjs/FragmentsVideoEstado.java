package utng.edu.mx.angularjs;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

/**
 * Created by LUISITO on 21/02/2016.
 */
public class FragmentsVideoEstado extends Fragment {
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_video_estado, container, false);
        return rootView;
    }
    public void mostrarDetalle(VideoView video){
        VideoView videoView = (VideoView)getView().findViewById(R.id.videoView_video);
        Uri path = Uri.parse("android.resource://mx.edu.utng.jpajavaluis/"+R.raw.video);
        videoView.setVideoURI(path);
        videoView.start();
    }
}
