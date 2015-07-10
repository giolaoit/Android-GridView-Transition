package net.awpspace.android_gridview_transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import net.awpspace.android_gridview_transition.adapter.GridViewAdapter;
import net.awpspace.android_gridview_transition.model.Item;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private GridView mGridView;

    private GridViewAdapter mGridAdapter;
    private ArrayList<Item> mGridData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = (GridView) findViewById(R.id.activity_main_gv_gridView);

        mGridData = new ArrayList<>();
        mGridAdapter = new GridViewAdapter(this, R.layout.layout_gridview_item, mGridData);
        mGridView.setAdapter(mGridAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Item item = (Item) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                ImageView imageView = (ImageView) v.findViewById(R.id.activity_details_iv_image);


                int[] screenLocation = new int[2];
                imageView.getLocationOnScreen(screenLocation);

                intent.putExtra("left", screenLocation[0]).
                        putExtra("top", screenLocation[1]).
                        putExtra("width", imageView.getWidth()).
                        putExtra("height", imageView.getHeight()).
                        putExtra("title", item.getTitle()).
                        putExtra("image", item.getImage());

                startActivity(intent);
            }
        });

        createTempData();
    }

    private void createTempData() {
        /**
         * Now, i'm create a temp data to fill gridview.
         */
        mGridData.add(new Item("http://media.van.vn/Upload/2014/12/16/huong-dan-cach-chup-anh-hoa-cho-nguoi-moi-bat-dau%20(6)-599x385.jpg"));
        mGridData.add(new Item("http://anh.24h.com.vn/upload/news/2013-01-29/1359427195-hoa-ban-cong-48.jpg"));
        mGridData.add(new Item("http://ngoisaonet.info/wp-content/uploads/2014/08/nhung-hinh-anh-dep-y-nghia-cua-hoa-tulip-3.jpg"));
        mGridData.add(new Item("http://a9.vietbao.vn/images/vi955/2011/2/55356875-1296651481-hoa-co-mua-xuan-1.JPG"));
        mGridData.add(new Item("http://khoahoc.tv/photos/image/022013/20/hoa-cam-chuong1.jpg"));
        mGridData.add(new Item("http://www.haonguyen.com/uploads/2010/01/tigon1.jpg"));
        mGridData.add(new Item("http://anhdep.pro/wp-content/uploads/2014/06/hinh-anh-dep-muon-mau-hoa-khoe-sac-4.jpg"));
        mGridData.add(new Item("http://www.hoasaigon.com.vn/kcfinder/upload/images/hoa-cuc(1).jpg"));
        mGridData.add(new Item("http://sieuthisocantho.com/images/data/Y-nghia/hoa-giot-tuyet.jpg"));
        mGridData.add(new Item("http://shopdienhoa.com/wp-content/uploads/2011/04/hoa-lan.jpg"));
        mGridData.add(new Item("http://anh.eva.vn/upload/2-2013/images/2013-06-27/1372321808-anh5.jpg"));
        mGridData.add(new Item("http://hatgionghoa.net/images/stories/baiviet/hoa-cuc-7-20130412150150.jpg"));
        mGridData.add(new Item("http://m.f29.img.vnecdn.net/2013/11/22/0136838-1388-1385095047.jpg"));
        mGridData.add(new Item("http://shopdienhoa.com/wp-content/uploads/2011/04/hoatulip.jpg"));
        mGridData.add(new Item("http://static.laodong.com.vn/uploaded/hoangthudung/2015_02_12/1_ajmo.jpg"));
        mGridData.add(new Item("http://sieuthihatgiong.net/images/stories/baiviet/hoa-tulip-20131011090006.jpg"));
        mGridData.add(new Item("http://static.laodong.com.vn/uploaded/hoangthudung/2015_02_12/7_drux.jpg"));
        mGridData.add(new Item("http://media.van.vn/Upload/2014/12/16/huong-dan-cach-chup-anh-hoa-cho-nguoi-moi-bat-dau%20(6)-599x385.jpg"));
        mGridData.add(new Item("http://anh.24h.com.vn/upload/news/2013-01-29/1359427195-hoa-ban-cong-48.jpg"));
        mGridData.add(new Item("http://ngoisaonet.info/wp-content/uploads/2014/08/nhung-hinh-anh-dep-y-nghia-cua-hoa-tulip-3.jpg"));
        mGridData.add(new Item("http://a9.vietbao.vn/images/vi955/2011/2/55356875-1296651481-hoa-co-mua-xuan-1.JPG"));
        mGridData.add(new Item("http://khoahoc.tv/photos/image/022013/20/hoa-cam-chuong1.jpg"));
        mGridData.add(new Item("http://www.haonguyen.com/uploads/2010/01/tigon1.jpg"));
        mGridData.add(new Item("http://anhdep.pro/wp-content/uploads/2014/06/hinh-anh-dep-muon-mau-hoa-khoe-sac-4.jpg"));
        mGridData.add(new Item("http://www.hoasaigon.com.vn/kcfinder/upload/images/hoa-cuc(1).jpg"));
        mGridData.add(new Item("http://sieuthisocantho.com/images/data/Y-nghia/hoa-giot-tuyet.jpg"));
        mGridData.add(new Item("http://shopdienhoa.com/wp-content/uploads/2011/04/hoa-lan.jpg"));
        mGridData.add(new Item("http://anh.eva.vn/upload/2-2013/images/2013-06-27/1372321808-anh5.jpg"));
        mGridData.add(new Item("http://hatgionghoa.net/images/stories/baiviet/hoa-cuc-7-20130412150150.jpg"));
        mGridData.add(new Item("http://m.f29.img.vnecdn.net/2013/11/22/0136838-1388-1385095047.jpg"));
        mGridData.add(new Item("http://shopdienhoa.com/wp-content/uploads/2011/04/hoatulip.jpg"));
        mGridData.add(new Item("http://static.laodong.com.vn/uploaded/hoangthudung/2015_02_12/1_ajmo.jpg"));
        mGridData.add(new Item("http://sieuthihatgiong.net/images/stories/baiviet/hoa-tulip-20131011090006.jpg"));
        mGridData.add(new Item("http://static.laodong.com.vn/uploaded/hoangthudung/2015_02_12/7_drux.jpg"));

        mGridAdapter.setGridData(mGridData);
    }
}
