package universalradioapp.ddroidtechno.googleadddemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";
    AdView adViewsimplebanner,adViewlargebanner,adViewmediumRect,adViewFULL_BANNER,adViewLEADERBOARD,adViewSMART_BANNER;

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load an ad into the AdMob banner view.
        adViewsimplebanner = (AdView) findViewById(R.id.adViewsimplebanner);
        adViewlargebanner =(AdView) findViewById(R.id.adViewlargebanner);
        adViewmediumRect=(AdView) findViewById(R.id.adViewmediumRect);
        adViewFULL_BANNER=(AdView) findViewById(R.id.adViewFULL_BANNER);
        adViewLEADERBOARD=(AdView) findViewById(R.id.adViewLEADERBOARD);
        adViewSMART_BANNER=(AdView) findViewById(R.id.adViewSMART_BANNER);

        adViewlargebanner.loadAd(new AdRequest.Builder().build());
        adViewsimplebanner.loadAd(new AdRequest.Builder().build());
        adViewmediumRect.loadAd(new AdRequest.Builder().build());
        adViewFULL_BANNER.loadAd(new AdRequest.Builder().build());
        adViewLEADERBOARD.loadAd(new AdRequest.Builder().build());
        adViewSMART_BANNER.loadAd(new AdRequest.Builder().build());

        //Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        //Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                //beginPlayingGame();
            }
        });

        requestNewInterstitial();
    }


    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
      //  if (mAdView != null) {
      //      mAdView.pause();
       // }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
      //  if (mAdView != null) {
      //      mAdView.resume();
      //  }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
       // if (mAdView != null) {
      //      mAdView.destroy();
       // }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            super.onBackPressed();
        }
        else
        {
            super.onBackPressed();
        }

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

        if (id == R.id.nat_ads_adv) {

            startActivity(new Intent(MainActivity.this,MainActivity_NativeAdd.class));

            return true;
        }
        else  if (id == R.id.nat_ads_exp) {

            startActivity(new Intent(MainActivity.this,MainActivity_NativeExp.class));

            return true;
        }
        else if(id==R.id.revarded_video)
        {
            startActivity(new Intent(MainActivity.this,MainActivity_RevardedVideo.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
