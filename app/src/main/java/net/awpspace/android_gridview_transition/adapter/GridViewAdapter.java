package net.awpspace.android_gridview_transition.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.awpspace.android_gridview_transition.model.Item;
import net.awpspace.android_gridview_transition.R;

import java.util.ArrayList;

/**
 * Created by haint on 7/10/2015.
 */
public class GridViewAdapter extends ArrayAdapter<Item>{

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<Item> mGridData = new ArrayList<Item>();

    public GridViewAdapter(Context mContext, int layoutResourceId, ArrayList<Item> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.grid_item_title);
            holder.imageView = (ImageView) row.findViewById(R.id.activity_details_iv_image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Item item = mGridData.get(position);
        holder.titleTextView.setText(Html.fromHtml(item.getTitle()));

        Picasso.with(mContext).load(item.getImage()).into(holder.imageView);
        return row;
    }

    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
    }

    public void setGridData(ArrayList<Item> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }
}
