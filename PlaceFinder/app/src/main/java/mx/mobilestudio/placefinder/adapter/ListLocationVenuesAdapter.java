package mx.mobilestudio.placefinder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


        return new MyViewHolder(view_item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((MyViewHolder)holder).name.setText(venues.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }


    public class MyViewHolder extends  RecyclerView.ViewHolder{

        public TextView name;
        public TextView distance;
        public  TextView address;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_text_view);
            distance = (TextView) itemView.findViewById(R.id.distance_text_view);
            address = (TextView) itemView.findViewById(R.id.format_address_text_view);


        }
    }



}
