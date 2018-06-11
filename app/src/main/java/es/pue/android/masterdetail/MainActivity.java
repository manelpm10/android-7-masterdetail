package es.pue.android.masterdetail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import es.pue.android.masterdetail.fragments.DataFragment;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String data) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("data", data);
        startActivity(i);
    }
}
