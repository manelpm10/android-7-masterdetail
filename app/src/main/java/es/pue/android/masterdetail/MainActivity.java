package es.pue.android.masterdetail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import es.pue.android.masterdetail.fragments.DataFragment;
import es.pue.android.masterdetail.fragments.DetailFragment;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {

    private boolean isMultiPanel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isMultiPanel = isMultiPanel();
    }

    @Override
    public void sendData(String data) {
        /**
         * If we are in portrait, we send data to new activity.
         * If we are in landscape we are in multipanel scenario, so we can send data directly to
         * the detail fragment.
         */
        if (isMultiPanel) {
            DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                    .findFragmentById(R.id.detailFragment);
            detailFragment.renderData(data);
        } else {
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("data", data);
            startActivity(i);
        }
    }

    private boolean isMultiPanel() {
        return (null != getFragmentManager().findFragmentById(R.id.detailFragment));
    }
}
