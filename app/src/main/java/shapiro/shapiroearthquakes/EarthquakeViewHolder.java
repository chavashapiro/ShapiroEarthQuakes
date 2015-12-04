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

    public void bind(Feature feature) {
        magnitude.setText(String.valueOf(feature.getProperties().getMagnitude()));
        place.setText(feature.getProperties().getPlace());
    }
}
