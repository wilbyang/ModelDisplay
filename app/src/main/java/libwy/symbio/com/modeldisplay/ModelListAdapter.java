package libwy.symbio.com.modeldisplay;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by wilbyang on 13/11/15.
 */


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class ModelListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Model> modelList;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public ModelListAdapter(Activity activity, List<Model> modelList) {
        this.activity = activity;
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int location) {
        return modelList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        Model m = modelList.get(position);

        // thumbnail image
        thumbNail.setImageUrl("http://" + m.getFirstImageUrl(), imageLoader);

        // title
        title.setText(m.getName());
       // rating.setText(m.getHeight());
        genre.setText(m.getEyeColor());
        // release year
        rating.setText(String.valueOf(m.getHeight()));

        return convertView;
    }

}

