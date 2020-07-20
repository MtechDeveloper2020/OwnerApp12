package mtech.com.ownerapp.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import mtech.com.ownerapp.R;

public class SecurityAlertDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.securityalert_dialog,container,false);
//        Button doneBtn = (Button) view.findViewById(R.id.btn);
//        doneBtn.setOnClickListener(doneAction);
        return view;
    }

//    View.OnClickListener doneAction = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(getActivity(),"Test",Toast.LENGTH_LONG).show();
//        }
//    };
}
