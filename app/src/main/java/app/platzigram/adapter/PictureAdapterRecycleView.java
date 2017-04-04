package app.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import app.platzigram.R;
import app.platzigram.model.Picture;
import app.platzigram.views.PictureDetailActivity;

/**
 * Created by arodriguez on 6/02/2017.
 */

public class PictureAdapterRecycleView extends RecyclerView.Adapter<PictureAdapterRecycleView.PictureViewHolder> {
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecycleView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLikeNumber());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, PictureDetailActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(
                            activity,
                            view,
                            activity.getString(R.string.transition_name_picture)
                    ).toBundle());
                } else {
                    activity.startActivity(i);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.pictures.size();
    }

    class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        PictureViewHolder(View itemView) {
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.picture);
            usernameCard = (TextView) itemView.findViewById(R.id.username_card);
            timeCard = (TextView) itemView.findViewById(R.id.time_card);
            likeNumberCard = (TextView) itemView.findViewById(R.id.like_number);
        }
    }
}
