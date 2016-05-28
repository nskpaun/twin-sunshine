package com.twinsunshinelauncher.twinsunshinelauncher.dialogs;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.twinsunshinelauncher.twinsunshinelauncher.R;
import com.twinsunshinelauncher.twinsunshinelauncher.models.Presentation;

import java.util.List;

public class MyPresentationRecyclerViewAdapter extends RecyclerView.Adapter<MyPresentationRecyclerViewAdapter.ViewHolder> {

    private final List<Presentation> mValues;
    private final OnListFragmentInteractionListener mListener;

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Presentation presentation);
    }

    public MyPresentationRecyclerViewAdapter(List<Presentation> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    public void addPresentation(Presentation presentation) {
        mValues.add(presentation);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.presentation_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        Uri uri = Uri.parse(mValues.get(position).getImageUrls().get(0));
        holder.mContentView.setImageURI(uri);

        uri = Uri.parse(mValues.get(position).getImageUrls().get(1));
        holder.mContentView2.setImageURI(uri);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final SimpleDraweeView mContentView;
        public final SimpleDraweeView mContentView2;
        public Presentation mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.presentation_name);
            mContentView = (SimpleDraweeView) view.findViewById(R.id.presentation_preview);
            mContentView2 = (SimpleDraweeView) view.findViewById(R.id.presentation_preview_2);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "";
        }
    }
}
