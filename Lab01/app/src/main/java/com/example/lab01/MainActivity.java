package com.example.lab01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final String[] titles = {"手撕面包", "华夫饼", "小麻花", "每日坚果", "盐焗鸡蛋"};
    private final String[] prices = {"￥32.90", "￥36.90", "￥18.80", "￥19.90", "￥30.70"};
    private final String[] shops = {"良品铺子旗舰店", "百草味旗舰店", "比比赞旗舰店", "憨豆熊旗舰店", "无穷旗舰店"};
    private final int[] icons = {R.drawable.tear_bread, R.drawable.waffle,R.drawable.dough_twist, R.drawable.daily_nuts,
            R.drawable.meat_floss};
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        listView.setOnItemClickListener((parent, view, position, id) -> {
            String price = prices[position];
            Toast.makeText(MainActivity.this, "Price: " + price, Toast.LENGTH_SHORT).show();
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View view1 = View.inflate(MainActivity.this, R.layout.lsiiitem, null);
            TextView tv_title = view1.findViewById(R.id.title);
            TextView tv_price = view1.findViewById(R.id.price);
            TextView tv_shop = view1.findViewById(R.id.shop);
            ImageView iv = view1.findViewById(R.id.iv);
            tv_price.setText(prices[position]);
            tv_title.setText(titles[position]);
            tv_shop.setText(shops[position]);
            iv.setImageResource(icons[position]);
            return view1;
        }
    }
}
