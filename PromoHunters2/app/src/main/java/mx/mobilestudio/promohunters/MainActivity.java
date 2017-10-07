package mx.mobilestudio.promohunters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import mx.mobilestudio.promohunters.fragment.CategoriesFragment;
import mx.mobilestudio.promohunters.fragment.HomeFragment;
import mx.mobilestudio.promohunters.fragment.OnFragmentInteractionListener;
import mx.mobilestudio.promohunters.fragment.SearchFragment;
import mx.mobilestudio.promohunters.listeners.MenuBottomListener;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener ,View.OnClickListener {

    private MenuBottomListener menuBottomListener;
    public FragmentManager fragmentManager;
    private FirebaseAnalytics firebaseAnalytics;

    private ImageButton imageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = (ImageButton) findViewById(R.id.buton_agrega_promo);
        imageButton.setOnClickListener(this);



        menuBottomListener = new MenuBottomListener(this);
        fragmentManager = getFragmentManager();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(menuBottomListener);
        switchFragment(1);
        String token = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();

        FirebaseMessaging.getInstance().subscribeToTopic("news");

        //Tracking Analitycs

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);


    }



    public void switchFragment(int CODE_BUTTON){


        FragmentTransaction  fragmentTransaction = fragmentManager.beginTransaction();

        if(CODE_BUTTON==1){
            Toast.makeText(this,"navigation_home", Toast.LENGTH_LONG).show();

            Fragment homeFragment =  new HomeFragment();

            fragmentTransaction.replace(R.id.main_container, homeFragment);
            fragmentTransaction.commit();

        } else if (CODE_BUTTON==2){

            Fragment categoriesFragment =  new CategoriesFragment();
            fragmentTransaction.replace(R.id.main_container, categoriesFragment);
            fragmentTransaction.commit();


            Toast.makeText(this,"navigation_dashboard", Toast.LENGTH_LONG).show();

        } else if (CODE_BUTTON == 3){

            Fragment searchFragment =  new SearchFragment();
            fragmentTransaction.replace(R.id.main_container, searchFragment);
            fragmentTransaction.commit();


            Toast.makeText(this,"navigation_notifications", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
                Toast.makeText(this,"Se dio Click ", Toast.LENGTH_LONG ).show();

        Intent  intent;

        intent = new Intent(this, CreateNewPromotionFormActivity.class);

        startActivity(intent);





    }
}
