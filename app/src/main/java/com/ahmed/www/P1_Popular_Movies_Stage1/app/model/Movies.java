package com.ahmed.www.P1_Popular_Movies_Stage1.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ismael on 10/06/2015.
 */
public class Movies implements Parcelable {

    private int movie_id;
    private String original_title;
    private String poster_path;
    private String backdrop_path;
    private String overview;
    private int vote_count;
    private double vote_average;
    private String release_date;

    public Movies() {

    }

    public Movies(JSONObject movie) throws JSONException {
        this.movie_id = movie.getInt("id");
        this.original_title = movie.getString("original_title");
        this.poster_path = movie.getString("poster_path");
        this.backdrop_path = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.vote_count = movie.getInt("vote_count");
        this.vote_average = movie.getDouble("vote_average");
        this.release_date = movie.getString("release_date");
    }


    private Movies(Parcel in) {
        movie_id = in.readInt();
        original_title = in.readString();
        poster_path = in.readString();
        backdrop_path = in.readString();
        overview = in.readString();
        vote_count = in.readInt();
        vote_average = in.readDouble();
        release_date = in.readString();
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public int getVote_count() {
        return vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(movie_id);
        dest.writeString(original_title);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        dest.writeString(overview);
        dest.writeInt(vote_count);
        dest.writeDouble(vote_average);
        dest.writeString(release_date);
    }

    public static final Creator<Movies> CREATOR
            = new Creator<Movies>() {
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
