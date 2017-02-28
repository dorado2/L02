package qa.global.l02;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static qa.global.l02.R.id.right_side;
import static qa.global.l02.R.id.verticalAxe;

public class MainActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
//http://developer.alexanderklimov.ru/android/layout/relativelayout.php

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout parent = (RelativeLayout) findViewById(R.id.activity_main);
        View verticalLine = findViewById(R.id.verticalAxe);


// Right green box
        RelativeLayout boxViewR = new RelativeLayout(this);
        RelativeLayout.LayoutParams boxViewRParams = new RelativeLayout.LayoutParams(
               RelativeLayout.LayoutParams.MATCH_PARENT,
               RelativeLayout.LayoutParams.MATCH_PARENT);
//  old method to set colour:
//        boxViewR.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//newer method to set colour:
        boxViewR.setBackgroundResource(R.color.primaryGreen);
        boxViewRParams.addRule(RelativeLayout.RIGHT_OF, verticalLine.getId());
        boxViewRParams.addRule(RelativeLayout.END_OF, verticalLine.getId());
        boxViewRParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        boxViewRParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        boxViewRParams.addRule(RelativeLayout.ALIGN_PARENT_END);

        int margin = getResources().getDimensionPixelOffset(R.dimen.activity_vertical_margin);
        boxViewRParams.setMargins(margin, margin, margin, margin);

        parent.addView(boxViewR, boxViewRParams);
        parent.invalidate();

// White boxes
        TextView prevTextBox = null;
        int i = 0;
        while (i!=5){
        TextView currentTextBox = new TextView(this);
            currentTextBox.setId(i);
        currentTextBox.setText("Some text");
        currentTextBox.setBackgroundResource(R.color.primaryWhite);

        currentTextBox.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,0,0,0);
            RelativeLayout.LayoutParams textBoxParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            textBoxParams.addRule(RelativeLayout.RIGHT_OF, verticalLine.getId());
            textBoxParams.addRule(RelativeLayout.END_OF, verticalLine.getId());
            textBoxParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            textBoxParams.addRule(RelativeLayout.ALIGN_PARENT_END);

            if (prevTextBox == null) {
                textBoxParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            }else {
                textBoxParams.addRule(RelativeLayout.BELOW, prevTextBox.getId());
            }
            textBoxParams.setMargins(margin,margin,margin,0);
            currentTextBox.setLayoutParams(textBoxParams);
            boxViewR.addView(currentTextBox);

           i++ ;
            prevTextBox = currentTextBox;
        }

    }
}