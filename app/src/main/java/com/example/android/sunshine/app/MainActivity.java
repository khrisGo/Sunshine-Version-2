package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //On récupère la vue conteneur
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //On génére les données factices
            ArrayList<String> weatherList = new ArrayList<>();
            weatherList.add("Today - Sunny - 88/63");
            weatherList.add("Tomorrow - Foggy - 70/46");
            weatherList.add("Weds - Cloudy - 72/63");
            weatherList.add("Thurs- Rainy - 64/51");
            weatherList.add("Fri - Foggy - 70/46");
            weatherList.add("Saturday - Sunny - 76/68");
            weatherList.add("Sunday - Sunny - 88/63");

            //On crée un Adapter qui va servir à indiquer comment chaque élément doit être affiché.
            //L'Adapter récupère une référence vers les données brutes (Paramètre 4)
            //L'Adapter récupère la façon dont chaque donnée doit être affichée :
            //Où la donnée doit être affichée ? Dans le layout list_item_forecast (Paramètre 2)
            //Comment ? Selon les indications dans le TextView list_item_forecast_textview (Paramètre 3)
            ArrayAdapter<String> weatherAdapter;
            weatherAdapter = new ArrayAdapter<String>(getActivity(),
                                                      R.layout.list_item_forecast,
                                                      R.id.list_item_forecast_textview,
                                                      weatherList);

            //On récupère la référence vers la ListView
            ListView listViewFC = (ListView) rootView.findViewById(R.id.listview_forecast);

            //On lie la ListView à l'Adapter
            listViewFC.setAdapter(weatherAdapter);

            return rootView;
        }
    }
}
