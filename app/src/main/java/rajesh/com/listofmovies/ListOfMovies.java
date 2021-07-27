package rajesh.com.listofmovies;

import android.app.ProgressDialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListOfMovies extends AppCompatActivity {

    private ArrayList<Movies> movieList;
    private static String URL_DATA = "https://rajtechi.github.io/AllShops/Movies/movies.json";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_movies);
        initViews();

    }


    private void initViews() {

        recyclerView =  findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        movieList = new ArrayList<>();


        loadData();

    }


    private void loadData()
    {
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Loading Movies Data");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("movies");

                    for(int i = 0 ; i< jsonArray.length();i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Movies item;
                        item = new Movies(
                                object.getString("movie_name"),
                                object.getString("movie_url"),
                                    object.getString("movie_rating"),
                                object.getString("movie_cast_and_crew")

                        );
                        movieList.add(item);


                    }

                    adapter = new DataAdapter(getApplicationContext(), movieList);
                    recyclerView.setAdapter(adapter);


                } catch (JSONException e)
                {
                    e.printStackTrace();
                }





            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}
