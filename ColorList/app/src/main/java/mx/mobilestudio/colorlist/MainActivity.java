package mx.mobilestudio.colorlist;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import mx.mobilestudio.colorlist.adapter.AdapterColor;
import mx.mobilestudio.colorlist.model.Color;
import mx.mobilestudio.colorlist.model.ColorsResponse;

public class MainActivity extends AppCompatActivity implements Response.Listener , Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callColorsApi(String  query) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String URL  = Uri.parse("https://api.myjson.com/bins/147a7h").toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL,this, this);


        // Aqui ejecutamos el request.
        queue.add(stringRequest);


    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(Object response) {

        // Aqui responde el request.
        Gson gson = new Gson();

        ColorsResponse  colorsResponse = gson.fromJson((String) response,  ColorsResponse.class);

        List<Color> colorList  = colorsResponse.getColors();


        AdapterColor adapterColor = new AdapterColor(colorList);



    }
}
