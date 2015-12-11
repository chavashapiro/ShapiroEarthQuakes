package shapiro.shapiroearthquakes;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EarthquakeAsyncTask extends AsyncTask<String, String, AllEarthquakes>  {

    private RecyclerView recyclerView;
    private AllEarthquakes earthquakes;

    public EarthquakeAsyncTask(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.earthquakes = null;
    }


    protected AllEarthquakes doInBackground(String... params) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        try {
            URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream in = connection.getInputStream();

            earthquakes = gson.fromJson(new InputStreamReader(in), AllEarthquakes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return earthquakes;
    }


    protected void onPostExecute(AllEarthquakes earthquakes) {
        super.onPostExecute(earthquakes);
        EarthquakeRecycleViewAdapter adapter = new EarthquakeRecycleViewAdapter(earthquakes);
        recyclerView.setAdapter(adapter);
    }
}
