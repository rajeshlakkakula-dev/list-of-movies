package rajesh.com.listofmovies;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by rajesh.lakkakula on 11/21/2017.
 */


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Movies> mMovies;
    private final Context context;


    public DataAdapter(Context context, ArrayList<Movies> mMovies) {
        this.context = context;
        this.mMovies = mMovies;


    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        Context context = viewGroup.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.movieslist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        final Movies listItem = mMovies.get(i);

        final String url = mMovies.get(i).getMovie_image_url();


        viewHolder.movie_name.setText(listItem.getMovie_name());
        viewHolder.movie_rating.setText(listItem.getMovie_rating());
        viewHolder.movie_crew.setText(listItem.getMovie_cast_and_crew());
        Picasso.with(context).load(listItem.getMovie_image_url()).into(viewHolder.movie_image);

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckNetwork.isInternetAvailable(context)) {

                    final Intent intent;
                    Toast.makeText(context, "" + listItem.getMovie_name(), Toast.LENGTH_SHORT).show();
                    intent = new Intent(context, MovieView.class);
                    intent.putExtra("url", url);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                {
                    Toast.makeText(context,"No Internet Connection",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView movie_name , movie_rating, movie_crew;
        public ImageView movie_image;
        public RelativeLayout relativeLayout;

        public ViewHolder(View view) {
            super(view);
            movie_name = view.findViewById(R.id.movieName);
            movie_image = view.findViewById(R.id.movieImage);
            movie_rating = view.findViewById(R.id.movieRating);
            movie_crew = view.findViewById(R.id.movieCrew);
            relativeLayout = view.findViewById(R.id.relativeLayout);
        }


    }
}