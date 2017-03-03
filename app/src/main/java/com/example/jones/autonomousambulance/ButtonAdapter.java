package com.example.jones.autonomousambulance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jones on 3/3/17.
 */

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nameTextView;
        public ImageView imageButton;
        private Context context;

        public ViewHolder(final View itemView) {

            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.buttonText);
            imageButton = (ImageView) itemView.findViewById(R.id.imageButton);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                            Log.i("Values",v.toString());
                            v.
                        }
                    }
                }
            });*/
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Log.i("Values",""+position);
            Intent i = new Intent(getContext(),LocationActivity.class);
            getContext().startActivity(i);

        }
    }

    private Context mContext;
    private List<ImageButton> mImageButton;

    public ButtonAdapter(Context context, List<ImageButton> imageButtons) {
        mImageButton = imageButtons;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View ButtonView = inflater.inflate(R.layout.layout_buttons, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(ButtonView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ImageButton imageButton = mImageButton.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(imageButton.getmText());
        ImageView imageView = viewHolder.imageButton;
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(imageButton.getmSrcname(), "drawable", context.getPackageName());
        imageView.setImageResource(id);

    }

    @Override
    public int getItemCount() {
        return mImageButton.size();
    }

}
