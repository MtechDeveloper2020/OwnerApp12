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

public class CustomFragment extends Fragment {
    private String mText = "";
    EditText selectDate, startTime, validForNext, vehicleNo, companyName;
    Button  ok;
    public static CustomFragment createInstance(String txt)
    {

        CustomFragment fragment = new CustomFragment();
        fragment.mText = txt;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sample,container,false);
        ((TextView) v.findViewById(R.id.textView)).setText(mText);
        selectDate = v.findViewById(R.id.selectDate);
        startTime = v.findViewById(R.id.startTime);
        validForNext = v.findViewById(R.id.validForNext);
        vehicleNo = v.findViewById(R.id.vehicleNo);
        companyName = v.findViewById(R.id.companyName);
        ok = v.findViewById(R.id.okbtn);
        return v;
    }
}