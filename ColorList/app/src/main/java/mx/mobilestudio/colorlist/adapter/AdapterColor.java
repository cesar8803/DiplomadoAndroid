package mx.mobilestudio.colorlist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import mx.mobilestudio.colorlist.model.Color;

/**
 * Created by cesar on 9/2/17.
 */

public class AdapterColor extends   RecyclerView.Adapter {


    public AdapterColor(List<Color> colorList) {
        this.colorList = colorList;
    }

    public List<Color> colorList;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
