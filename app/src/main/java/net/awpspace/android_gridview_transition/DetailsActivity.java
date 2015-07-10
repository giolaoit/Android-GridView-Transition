package net.awpspace.android_gridview_transition;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by haint on 7/10/2015.
 */
public class DetailsActivity extends AppCompatActivity {

    private static final int DURATION = 800;
    private TextView mTvTitle;
    private ImageView mIvImage;

    private int mLeft;
    private int mTop;
    private float mWidthScale;
    private float mHeightScale;

    private FrameLayout mFlLayout;
    private ColorDrawable mColorDrawable;

    private int mTopThumbnail;
    private int mLeftThumbnail;
    private int mWidthThumbnail;
    private int mHeightThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle bundle = getIntent().getExtras();
        mTopThumbnail = bundle.getInt("top");
        mLeftThumbnail = bundle.getInt("left");
        mWidthThumbnail = bundle.getInt("width");
        mHeightThumbnail = bundle.getInt("height");

        String title = bundle.getString("title");
        String image = bundle.getString("image");

        mTvTitle = (TextView) findViewById(R.id.activity_details_tv_title);
        mTvTitle.setText(Html.fromHtml(title));

        mIvImage = (ImageView) findViewById(R.id.activity_details_iv_image);
        Picasso.with(this).load(image).into(mIvImage);

        mFlLayout = (FrameLayout) findViewById(R.id.main_background);
        mColorDrawable = new ColorDrawable(Color.BLACK);
        mFlLayout.setBackground(mColorDrawable);

        if (savedInstanceState == null) {
            ViewTreeObserver observer = mIvImage.getViewTreeObserver();
            observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

                @Override
                public boolean onPreDraw() {
                    mIvImage.getViewTreeObserver().removeOnPreDrawListener(this);

                    int[] screenLocation = new int[2];
                    mIvImage.getLocationOnScreen(screenLocation);
                    mLeft = mLeftThumbnail - screenLocation[0];
                    mTop = mTopThumbnail - screenLocation[1];

                    mWidthScale = (float) mWidthThumbnail / mIvImage.getWidth();
                    mHeightScale = (float) mHeightThumbnail / mIvImage.getHeight();

                    enterAnimation();

                    return true;
                }
            });
        }
    }

    private void enterAnimation() {

        mIvImage.setPivotX(0);
        mIvImage.setPivotY(0);
        mIvImage.setScaleX(mWidthScale);
        mIvImage.setScaleY(mHeightScale);
        mIvImage.setTranslationX(mLeft);
        mIvImage.setTranslationY(mTop);

        TimeInterpolator sDecelerator = new DecelerateInterpolator();

        mIvImage.animate().setDuration(DURATION).scaleX(1).scaleY(1).
                translationX(0).translationY(0).setInterpolator(sDecelerator);

        ObjectAnimator oAnimator = ObjectAnimator.ofInt(mColorDrawable, "alpha", 0, 255);
        oAnimator.setDuration(DURATION);
        oAnimator.start();
    }

    public void exitAnimation(final Runnable endAction) {

        TimeInterpolator sInterpolator = new AccelerateInterpolator();
        mIvImage.animate().setDuration(DURATION).scaleX(mWidthScale).scaleY(mHeightScale).
                translationX(mLeft).translationY(mTop)
                .setInterpolator(sInterpolator).withEndAction(endAction);

        ObjectAnimator oAnimator = ObjectAnimator.ofInt(mColorDrawable, "alpha", 0);
        oAnimator.setDuration(DURATION);
        oAnimator.start();
    }

    @Override
    public void onBackPressed() {
        exitAnimation(new Runnable() {
            public void run() {
                finish();
            }
        });
    }
}
