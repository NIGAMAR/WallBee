package com.nigamar.wallbee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Appy on 24/07/16.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    List<Image> imageList;
    Context context;

    public ImagesAdapter(Context context, List<Image> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View singleImageView = LayoutInflater.from(context).inflate(R.layout.single_image_view, parent, false);
        return new ImageViewHolder(singleImageView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Image image = imageList.get(position);
        holder.getImageTitle().setText(image.getImageName());
        Glide.with(context).load(image.getImageUrl()).fitCenter().into(holder.getPic());
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void addImage(Image image) {
        imageList.add(image);
        notifyItemInserted(getItemCount());
    }
}

class ImageViewHolder extends RecyclerView.ViewHolder {

    private TextView imageTitle;
    private ImageView pic;

    public ImageViewHolder(View itemView) {
        super(itemView);
        imageTitle = (TextView) itemView.findViewById(R.id.imageTitle);
        pic = (ImageView) itemView.findViewById(R.id.pic);
    }

    public TextView getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(TextView imageTitle) {
        this.imageTitle = imageTitle;
    }

    public ImageView getPic() {
        return pic;
    }

    public void setPic(ImageView pic) {
        this.pic = pic;
    }
}
