package utng.edu.mx.angularjs;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LUISITO on 21/02/2016.
 */
public class FragmentsInformacionIntro extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_informacion_introduccion, container, false);
        return rootView;
    }
}
