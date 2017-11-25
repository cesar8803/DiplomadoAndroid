package mx.mobilestudio.promohunters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import mx.mobilestudio.promohunters.fragment.CategoriesFragment;
import mx.mobilestudio.promohunters.fragment.HomeFragment;
import mx.mobilestudio.promohunters.fragment.OnFragmentInteractionListener;
import mx.mobilestudio.promohunters.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener, View.OnClickListener {

    private TextView mTextMessage;
    private FragmentManager fragmentManager;

    private String token;

    private FirebaseAuth  firebaseAuth; //Crear usuarios y validar si estan Autentificados

    private ImageButton buton_agrega_promo;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(1);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(2);
                    return true;
                case R.id.navigation_notifications:
                    switchFragment(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        buton_agrega_promo = (ImageButton) findViewById(R.id.buton_agrega_promo);
        buton_agrega_promo.setOnClickListener(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager  =getFragmentManager();


         token  = FirebaseInstanceId.getInstance().getToken();





        // Metodo para suscrobirse a notificaciones de un tema en particular.
        FirebaseMessaging.getInstance().subscribeToTopic("promociones");


        //Inicializamos Firebase Auth que nos permitira verificar si tenemos una sesión.
        firebaseAuth = FirebaseAuth.getInstance();

        Toast.makeText(this,token, Toast.LENGTH_LONG).show();




        switchFragment(1);

    }




    public void switchFragment(int CODE_BUTTON){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(CODE_BUTTON==1){
            Fragment homeFragment = new HomeFragment();

            fragmentTransaction.replace(R.id.main_container,homeFragment);
            fragmentTransaction.commit();

        }else if (CODE_BUTTON==2){

            Fragment categoriesFragment =  CategoriesFragment.newInstance("","");


            fragmentTransaction.replace(R.id.main_container,categoriesFragment);
            fragmentTransaction.commit();


        }else if (CODE_BUTTON==3){

            Fragment searchFragment = new SearchFragment();


            fragmentTransaction.replace(R.id.main_container,searchFragment);
            fragmentTransaction.commit();



        }

    }

    @Override
    public void onFragmentInteraction(Object param) {

    }

    @Override
    public void onClick(View v) {
        Intent  intent;


        if(firebaseAuth.getCurrentUser() == null){
            intent = new Intent(this, LoginActivity.class);

            startActivity(intent);
        }else{
            intent = new Intent(this, CreateNewPromoFormActivity.class);

            startActivity(intent);
        }




    }
}
