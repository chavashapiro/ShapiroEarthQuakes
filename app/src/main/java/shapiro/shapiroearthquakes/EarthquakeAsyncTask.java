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

public class EarthquakeAsyncTask extends AsyncTask<Long, String, String>  {

    private RecyclerView recyclerView;
    private EarthquakeList earthquakes;

    public EarthquakeAsyncTask(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.earthquakes = null;
    }

    @Override
    protected String doInBackground(Long... params) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        try {
            URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream in = connection.getInputStream();

            earthquakes = gson.fromJson(new InputStreamReader(in), EarthquakeList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        EarthquakeRecycleViewAdapter adapter = new EarthquakeRecycleViewAdapter(earthquakes);
        recyclerView.setAdapter(adapter);
    }
}
