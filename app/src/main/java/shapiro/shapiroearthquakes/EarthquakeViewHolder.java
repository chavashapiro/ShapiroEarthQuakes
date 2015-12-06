package shapiro.shapiroearthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class EarthquakeViewHolder extends RecyclerView.ViewHolder{
    private TextView magnitude;
    private TextView place;

    public EarthquakeViewHolder (View itemView) {
        super(itemView);
        magnitude = (TextView) itemView.findViewById(R.id.magnitude);
        place = (TextView) itemView.findViewById(R.id.place);
    }

    public void bind(Earthquake feature, int position) {
        magnitude.setText(position+1  + ". Magnitude: " + String.valueOf(feature.getProperties().getMag()));
        place.setText("Place: " + feature.getProperties().getPlace());
    }
}
