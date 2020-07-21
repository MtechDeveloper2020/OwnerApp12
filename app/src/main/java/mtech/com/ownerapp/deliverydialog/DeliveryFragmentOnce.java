package mtech.com.ownerapp.deliverydialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import mtech.com.ownerapp.R;

public class DeliveryFragmentOnce extends Fragment {
    EditText selectDate, startTime, validForNext, companyName;
    Button ok;

    public static DeliveryFragmentOnce createInstance(String txt)
    {

        DeliveryFragmentOnce fragment = new DeliveryFragmentOnce();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.delivery_once,container,false);
        selectDate = v.findViewById(R.id.selectDate);
        startTime = v.findViewById(R.id.startTime);
        validForNext = v.findViewById(R.id.validForNext);
        companyName = v.findViewById(R.id.companyName);
        ok = v.findViewById(R.id.okbtn);

        return v;
    }
}