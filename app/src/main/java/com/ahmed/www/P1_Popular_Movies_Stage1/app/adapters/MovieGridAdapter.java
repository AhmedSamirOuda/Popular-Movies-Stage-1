package com.ahmed.www.P1_Popular_Movies_Stage1.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmed.www.P1_Popular_Movies_Stage1.app.R;
import com.ahmed.www.P1_Popular_Movies_Stage1.app.model.Movies;
import com.squareup.picasso.Picasso;

/**
 * Created by Ismael on 10/06/2015.
 */
public class MovieGridAdapter extends ArrayAdapter<Movies> {

    public static class ViewHolder {
        public final ImageView imageView;
        public final TextView titleView;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.grid_item_image);
            titleView = (TextView) view.findViewById(R.id.grid_item_title);
        }
    }

    public MovieGridAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Movies movies = getItem(position);
        String image_url = "http://image.tmdb.org/t/p/w185" + movies.getPoster_path();

        viewHolder = (ViewHolder) view.getTag();
        Picasso.with(getContext()).load(image_url).into(viewHolder.imageView);

        return view;
    }
}
