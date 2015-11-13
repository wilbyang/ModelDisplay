package libwy.symbio.com.modeldisplay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wilbyang on 13/11/15.
 */
public class ModelDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modle_details_layout);


        GridView gridViewofModel = (GridView) findViewById(R.id.gridViewofModel);



ArrayList<String> modelPhotos =
        new ArrayList( Arrays.asList(new String[]{"9183bb00-9f16-40a3-8577-0d9e315d5615", "e9f6f5cb-ce8f-4ccc-ad49-4d4ff3cf0415", "833afc8e-54ed-4d31-923e-50fa40348225", "38faf477-97fe-4b15-be95-637da5feb8d6", "91f25ae4-f51c-4752-96e6-a0ffc5481ffe", "f7695161-65df-4a0f-aac8-63b9ee609080", "26ed2cb3-7631-4949-9fc2-94cb8039fd56", "ec8f2d81-3f00-41b1-a81d-5609079dd50e", "6a9d098b-2bd8-4ef0-af9a-51a20c620940", "8fc99b61-d9b8-4616-87ec-9c3380c861f4", "adafa692-cf88-498d-b096-72f77fc7f49a", "819e6485-e890-4925-a6ff-bf4252b68ba5", "2f76232e-1a40-4820-bbb1-dbc5c049a29d", "37068eea-bc8f-49c6-8fcd-9018af425e0e", "29195232-aca9-4615-a5a2-fb344de59455", "045db600-12a0-4925-9a39-32220b6a73bc", "ba36c297-610c-498d-a96d-ecebf18f2f22", "d93c53c8-66b2-47de-b713-bb342d44f17c", "0567ede9-184f-4d66-9a02-0bbc06172363", "fee50692-4441-471d-89a9-5ddcfdf8cf2e", "2d8e2444-5d82-4951-968a-64d547f14e17", "c9aef2f0-ab86-4efb-804c-9592bb67cef7"}) );
        ImageAdapter adapter= new ImageAdapter(modelPhotos, this);
        gridViewofModel.setAdapter(adapter);

    }




    public class ImageAdapter extends BaseAdapter {
        private Activity activity;

        public ImageAdapter(ArrayList<String> mThumbIds, Activity activity) {
            this.mThumbIds = mThumbIds;
            this.activity = activity;
        }
        private LayoutInflater inflater;
        private Context mContext;
        private ArrayList<String> mThumbIds;
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        public int getCount() {
            return mThumbIds.size();
        }

        public Object getItem(int position) {
            return mThumbIds.get(position);
        }

        public long getItemId(int position) {
            return 0;
        }

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            if (inflater == null)
                inflater = (LayoutInflater) activity
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null)
                convertView = inflater.inflate(R.layout.grid_cell, null);

            if (imageLoader == null)
                imageLoader = AppController.getInstance().getImageLoader();
            NetworkImageView thumbNail = (NetworkImageView) convertView
                    .findViewById(R.id.grid_cell_model_phtoto);
            thumbNail.setImageUrl("http://stockholmsgruppen.s3.amazonaws.com/images/" + mThumbIds.get(position), imageLoader);
            return convertView;
        }
    }
}
