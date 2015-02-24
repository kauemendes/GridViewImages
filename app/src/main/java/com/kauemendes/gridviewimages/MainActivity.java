package com.kauemendes.gridviewimages;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import static android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity implements OnItemClickListener {

    GridView gridview;

    TextView txtSoloMsg;
    ImageView imgSoloPhoto;
    Button btnSoloBack;


    //frame-captions;
    String[] itens = { "Data-1", "Data-2", "Data-3", "Data-4", "Data-5",
            "Data-6", "Data-7", "Data-8", "Data-9", "Data-10" };

    Integer[] thumbnails = { R.drawable.image_thumb1 ,
            R.drawable.image_thumb2 ,
            R.drawable.image_thumb3 ,
            R.drawable.image_thumb4 ,
            R.drawable.image_thumb5 ,
            R.drawable.image_thumb6 ,
            R.drawable.image_thumb7 ,
            R.drawable.image_thumb8 ,
            R.drawable.image_thumb9 ,
            R.drawable.image_thumb10
    };

    Integer[] largeImages = { R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
    };

    Bundle myOriginalMemoryBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOriginalMemoryBundle = savedInstanceState;

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MyImageAdapter(this, thumbnails));
        gridview.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        setContentView(R.layout.solo_picture);
        txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
        imgSoloPhoto = (ImageView) findViewById(R.id.imgSoloPhoto);
        txtSoloMsg.setText("Image " + position);

        imgSoloPhoto.setImageResource( largeImages[position] );

        btnSoloBack = (Button) findViewById(R.id.btnSoloBack);

        btnSoloBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myOriginalMemoryBundle);
            }
        });
    } // ShowBigScreen
}
