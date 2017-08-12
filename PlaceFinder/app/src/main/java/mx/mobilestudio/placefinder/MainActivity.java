package mx.mobilestudio.placefinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import mx.mobilestudio.placefinder.fragment.ListLocationsResultsFragment;
import mx.mobilestudio.placefinder.model.ApiFourSquareResponse;

public class MainActivity extends AppCompatActivity implements Response.Listener,
                                                                Response.ErrorListener ,
                                                                ListLocationsResultsFragment.OnFragmentInteractionListener{


    public static  final  int FRAGMENT_LIST_ID = 1;
    public static  final  int FRAGMENT_MAP_ID = 2;

    public FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callFourSquareApi("gasolinera");


        fragmentManager = getFragmentManager();
    }



    public void onFragmentAttach(int FRAGMENT_REQUIRED){



            switch (FRAGMENT_REQUIRED){

                case FRAGMENT_LIST_ID :

                    FragmentTransaction   fragmentTransaction = fragmentManager.beginTransaction();

                    Fragment listLocationsResultsFragment = ListLocationsResultsFragment.newInstance("","");

                    fragmentTransaction.add(R.id.main_central_content_container,  listLocationsResultsFragment);

                    fragmentTransaction.commit();


                    break;

                case  FRAGMENT_MAP_ID :

                    break;
            }

    }



    public void callFourSquareApi(String  query) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String locationString = "19.395209"+","+"-99.1544203";


        String URL  = Uri.parse("https://api.foursquare.com/v2/venues/search").buildUpon()
                .appendQueryParameter("client_id", "L4UK14EMS0MCEZOVVUYX2UO5ULFHJN3EHOFVQFSW0Z1MSFSR")
                .appendQueryParameter("client_secret", "YKJB0JRFDPPSGTHALFOEP5O1NDDATHKQ2IZ5RO2GOX452SFA")
                .appendQueryParameter("v", "20130815")
                .appendQueryParameter("ll",locationString)
                .appendQueryParameter("query",query).build().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL,this, this);


        // Aqui ejecutamos el request.
        queue.add(stringRequest);

    }


    @Override
    public void onResponse(Object response) {



        //Toast.makeText(this, (String) response, Toast.LENGTH_LONG).show();

            /* Interpretaremos el response en formato JSON por medio de la libreria GSON*/

            Gson  gson = new Gson();

            try {


                ApiFourSquareResponse fourSquareResponse = gson.fromJson((String) response, ApiFourSquareResponse.class);

                //  Imprimimos en pantalla el nombre del primer Venue del arreglo
                Toast.makeText(this, fourSquareResponse.getResponse().getVenues().get(2).getName(), Toast.LENGTH_SHORT).show();

                onFragmentAttach(FRAGMENT_LIST_ID);

            }catch ( JsonParseException e){

            }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.v("ERROR", "No hace nada");
        Toast.makeText(this,"ERROR", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
