package mtech.com.ownerapp.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

import mtech.com.ownerapp.R;

public class KidDialog extends DialogFragment {
    Spinner hours;
    ArrayAdapter<String> branch_adapter,company_adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.kid_dialog,container,false);
        hours = view.findViewById(R.id.hours);

        ArrayList<String> purpose = new ArrayList<String>();
        purpose.add("2 hours");
        purpose.add("6 hours");
        purpose.add("12 hours");
        purpose.add("24 hours");

        branch_adapter= new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, purpose);
        hours.setAdapter(branch_adapter);

        return view;
    }

}
