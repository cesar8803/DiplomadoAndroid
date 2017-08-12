package mx.mobilestudio.placefinder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * Created by cesar on 8/12/17.
 */

public class ListLocationVenuesAdapter extends RecyclerView.Adapter{

    private List<Venue> venues;

    public ListLocationVenuesAdapter(List<Venue> venues) {
        this.venues = venues;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View  view_item = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_item_list,null);


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
