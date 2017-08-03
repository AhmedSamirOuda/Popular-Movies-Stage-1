package com.ahmed.www.P1_Popular_Movies_Stage1.app.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ahmed.www.P1_Popular_Movies_Stage1.app.R;
import com.ahmed.www.P1_Popular_Movies_Stage1.app.model.Movies;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment {

    static final String Movie_detail = "detail";

    private Movies mMovies;

    private static Context context;

    public Context getContext() {
        return DetailFragment.context;
    }

    public DetailFragment() {
    }

    //to get image url
    public static String getImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            mMovies = arguments.getParcelable(DetailFragment.Movie_detail);
        }

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView mBackdrop_path = (ImageView) rootView.findViewById(R.id.backdrop);
        String image_url = getImageUrl(342, mMovies.getBackdrop_path());
        Picasso.with(getContext()).load(image_url).into(mBackdrop_path);

        ImageView mPoster_path = (ImageView) rootView.findViewById(R.id.poster);
        String image_url2 = getImageUrl(342, mMovies.getPoster_path());
        Picasso.with(getContext()).load(image_url2).into(mPoster_path);

        TextView mMovie_title = (TextView) rootView.findViewById(R.id.movie_title);
        mMovie_title.setText(mMovies.getOriginal_title());

        TextView mOverview = (TextView) rootView.findViewById(R.id.overview);
        mOverview.setText(mMovies.getOverview());

        TextView mRelease_date = (TextView) rootView.findViewById(R.id.release_date);
        mRelease_date.setText(mMovies.getRelease_date());

        TextView mVote_count = (TextView) rootView.findViewById(R.id.vote_count);
        mVote_count.setText(Integer.toString(mMovies.getVote_count()));

        TextView mVote_average = (TextView) rootView.findViewById(R.id.vote_average);
        mVote_average.setText(Double.toString(round(mMovies.getVote_average(), 1)) + "/10");

        RatingBar mRatingStarView = (RatingBar) rootView.findViewById(R.id.rating_Bar);
        double d = mMovies.getVote_average();
        float f = (float) d;
        mRatingStarView.setRating(f);

        return rootView;
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
