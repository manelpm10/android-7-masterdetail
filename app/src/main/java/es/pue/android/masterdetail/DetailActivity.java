package es.pue.android.masterdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.pue.android.masterdetail.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (null != getIntent().getExtras()) {
            data = getIntent().getStringExtra("data");
        }

        DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);

        detailFragment.renderData(data);
    }
}
