package es.pue.android.masterdetail.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import es.pue.android.masterdetail.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {
    private EditText etData;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (DataListener) context;
        } catch(Exception e) {
            throw new ClassCastException("Error in conversion");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        etData = view.findViewById(R.id.etData);

        Button btnSend = view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(getClickSendButtonListener());

        return view;
    }

    @NonNull
    private View.OnClickListener getClickSendButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataToSend = etData.getText().toString();
                callback.sendData(dataToSend);
            }
        };
    }

    public interface DataListener {
        void sendData(String data);
    }
}
