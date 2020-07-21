package mtech.com.ownerapp.dialogoncefreq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import mtech.com.ownerapp.R;

public class FeqcabFragment extends Fragment {
    private String mText = "";
    EditText daysOfWeek, selectValidity, timeSlot, companyName;
    Button ok;

    public static FeqcabFragment createInstance(String txt)
    {

        FeqcabFragment fragment = new FeqcabFragment();
//        fragment.mText = txt;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cab_frequent,container,false);
        daysOfWeek = v.findViewById(R.id.daysOfWeek);
        selectValidity = v.findViewById(R.id.selectValidity);
        timeSlot = v.findViewById(R.id.timeSlot);
        companyName = v.findViewById(R.id.companyName);
        ok = v.findViewById(R.id.okbtn);

        return v;
    }
}