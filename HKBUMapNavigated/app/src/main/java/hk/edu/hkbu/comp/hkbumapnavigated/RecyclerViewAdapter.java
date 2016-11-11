package hk.edu.hkbu.comp.hkbumapnavigated;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{
    private HKBULocation[] locations;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView location;
        public TextView abbreviation;
        public ImageView image;

        public RecyclerViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            location = (TextView) v.findViewById(R.id.location);
            abbreviation = (TextView) v.findViewById(R.id.abbreviation);
            image = (ImageView) v.findViewById(R.id.image);
        }
    }

    public Context context;

    public RecyclerViewAdapter(HKBULocation[] locations, Context context) {
        this.locations = locations;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        RecyclerViewHolder vh = new RecyclerViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.location.setText(locations[position].getName());
        holder.abbreviation.setText(locations[position].getAbbreviation());
        holder.image.setImageResource(getResId(locations[position].getImage()));
    }

    public int getResId(String resName) {
        Class res = R.drawable.class;
        try {
            Field field = res.getField(resName);
            return field.getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return locations.length;
    }
}
