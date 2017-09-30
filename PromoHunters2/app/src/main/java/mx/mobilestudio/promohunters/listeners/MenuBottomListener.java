package mx.mobilestudio.promohunters.listeners;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import mx.mobilestudio.promohunters.MainActivity;
import mx.mobilestudio.promohunters.R;

/**
 * Created by cesar on 9/30/17.
 */

public class MenuBottomListener implements  BottomNavigationView.OnNavigationItemSelectedListener {
    private MainActivity mainActivity;


    public MenuBottomListener(MainActivity mainActivity) {

        this.mainActivity = mainActivity;


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.navigation_home:

                // Mandar a llamar un metodo de mi Activity.  switchFragment

                mainActivity.switchFragment(1);

                return true;
            case R.id.navigation_dashboard:
                mainActivity.switchFragment(2);

                return true;

            case R.id.navigation_notifications:
                mainActivity.switchFragment(3);


                return true;
        }
        return false;    }
}
