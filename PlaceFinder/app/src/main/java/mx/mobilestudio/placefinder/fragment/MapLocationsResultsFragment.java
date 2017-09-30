package mx.mobilestudio.placefinder.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapLocationsResultsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapLocationsResultsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapLocationsResultsFragment extends Fragment implements OnMapReadyCallback{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private GoogleMap googleMap;

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    private List<Venue>  venues;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MapLocationsResultsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapLocationsResultsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapLocationsResultsFragment newInstance(String param1, List<Venue> param2) {
        MapLocationsResultsFragment fragment = new MapLocationsResultsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setVenues(param2);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

          View mapfragmentview =      inflater.inflate(R.layout.fragment_map_locations_results, container, false);


        MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        //TODO   Una ves que obtenemos la referencia del map fragment se debera manipular

        return mapfragmentview;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng latLng = new LatLng(19.395209,-99.1544203 );

        CameraUpdate  cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,14f);


        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("MobileStudio")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));


        this.googleMap.addMarker(markerOptions);

        this.googleMap.moveCamera(cameraUpdate);

        paintFourSquareMarketsinMap(venues);

    }



    public void paintFourSquareMarketsinMap(List<Venue> venues){
        // Metodo encargado de pintar los marcadores de los venues en el mapa
                for(Venue currentVenue : venues){
                        double  lat = currentVenue.getLocation().getLat();
                        double lng  = currentVenue.getLocation().getLng();

                        MarkerOptions currentVenueoptions =  new MarkerOptions();

                        currentVenueoptions.position(new LatLng(lat,lng));
                        currentVenueoptions.title( currentVenue.getName() );

                        googleMap.addMarker(currentVenueoptions);

                }

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
