package shapiro.shapiroearthquakes;

import java.util.ArrayList;
import java.util.Collection;

public class EarthquakeList extends ArrayList<Feature> {

    public EarthquakeList() {

    }

    public EarthquakeList(Collection<? extends Feature> collection) {
        super(collection);
    }
}
