package mx.mobilestudio.placefinder;

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

public class MainActivity extends AppCompatActivity implements Response.Listener,
                                                                Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callFourSquareApi("gasolinera");
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

        Toast.makeText(this,"asdasdasdasd", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.v("ERROR", "No hace nada");
        Toast.makeText(this,"ERROR", Toast.LENGTH_LONG).show();

    }
}