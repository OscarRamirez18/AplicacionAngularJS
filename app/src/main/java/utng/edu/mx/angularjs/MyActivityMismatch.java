package utng.edu.mx.angularjs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class MyActivityMismatch extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);  //se saca porque sino se solapan

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("JPA (Java Persistent API)");
        actionBar.setSubtitle("Luis Colmenero Morales");

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab()
                .setText("Informacion")
                .setTabListener(new TabsListener(
                        this, "Informacion", FragmentsInformacionMismatch.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Video")
                .setTabListener(new TabsListener(
                        this, "video", FragmentsVideoMismatch.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Cuestionario")
                .setTabListener(new TabsListener(
                        this, "cuestionario", FragmentsCuestionarioMismatch.class));
        actionBar.addTab(tab);


    }

    public class TabsListener implements ActionBar.TabListener {

        private Fragment fragment;
        private final String tag;

        public TabsListener(Activity activity, String tag, Class cls) {
            this.tag = tag;
            fragment = Fragment.instantiate(activity, cls.getName());
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(android.R.id.content, fragment, tag);
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    }

}