package shapiro.shapiroearthquakes;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EarthquakeRecycleViewAdapter extends RecyclerView.Adapter<EarthquakeViewHolder>{
    private EarthquakeList earthquakes;

    public EarthquakeRecycleViewAdapter(EarthquakeList earthquakes) {
        this.earthquakes = earthquakes;
    }


    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.earthquake_list_item, viewGroup, false);

        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EarthquakeViewHolder holder, final int position) {
        holder.bind(earthquakes.get(position));
    }

    @Override
    public int getItemCount() {
        return earthquakes.size();
    }
}
