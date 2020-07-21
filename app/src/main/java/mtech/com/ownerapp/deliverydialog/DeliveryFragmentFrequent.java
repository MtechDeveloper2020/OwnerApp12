package mtech.com.ownerapp.deliverydialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import mtech.com.ownerapp.R;

public class DeliveryFragmentFrequent extends Fragment {
    private String mText = "";
    EditText daysOfWeek, selectValidity, timeslot, companyName;
    Button ok;
    public static DeliveryFragmentFrequent createInstance(String txt)
    {

        DeliveryFragmentFrequent fragment = new DeliveryFragmentFrequent();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.delivery_frequent,container,false);
        daysOfWeek = v.findViewById(R.id.daysOfWeek);
        selectValidity = v.findViewById(R.id.selectValidity);
        timeslot = v.findViewById(R.id.timeSlot);
        companyName = v.findViewById(R.id.companyName);
        ok = v.findViewById(R.id.okbtn);


        return v;
    }
}