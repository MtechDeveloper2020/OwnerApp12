package mtech.com.ownerapp.deliverydialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import mtech.com.ownerapp.R;

public class DeliveryFragmentFrequent extends Fragment {
    private String mText = "";
    EditText daysOfWeek, selectValidity, timeslot;
    Button ok;
    Spinner companyName;
    ArrayAdapter<String> branch_adapter,company_adapter;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String m, d, mf, df, f_date, f_time, t_time;

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

        selectValidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                // Launch Date Picker Dialog
                DatePickerDialog dpd = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Display Selected date in textbox
                                SimpleDateFormat dd = new SimpleDateFormat("dd");
                                SimpleDateFormat dm = new SimpleDateFormat("MM");
                                SimpleDateFormat dy = new SimpleDateFormat("yyyy");

                                int day = Integer.parseInt(dd.format(c
                                        .getTime()));
                                int month = Integer.parseInt(dm.format(c
                                        .getTime()));
                                int yearr = Integer.parseInt(dy.format(c
                                        .getTime()));

                                if (dayOfMonth < 10) {
                                    df = "0" + dayOfMonth;
                                } else {
                                    df = String.valueOf(dayOfMonth);
                                }
                                if ((monthOfYear + 1 < 10)) {
                                    mf = "0" + (monthOfYear + 1);
                                } else {
                                    mf = String.valueOf(monthOfYear + 1);
                                }
                                String selected_date = df + "-" + mf + "-" + year;
                                Log.e("selected date", "" + selected_date);

                                String current_date = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(yearr);
                                Log.e("selected date", "" + current_date);
                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                Date cur = new Date();
                                Date sel = new Date();
                                try {
                                    cur = df.parse(current_date);
                                    sel = df.parse(selected_date);
                                } catch (ParseException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
//                                date.setText(selected_date);
                                if (sel.after(cur) || cur.equals(sel)) {
                                    selectValidity.setText(selected_date);
                                } else {
                                    Toast.makeText(getContext(),
                                            "Selected Date Is Not Valid",
                                            Toast.LENGTH_SHORT).show();
                                    selectValidity.setText("");
                                }
                            }
                        }, mYear, mMonth, mDay);
                dpd.show();

            }
        });


        ArrayList<String> purpose1 = new ArrayList<String>();
        purpose1.add("Select Company name");
        purpose1.add("Ola");
        purpose1.add("Uber");
        purpose1.add("Others");

        company_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, purpose1);
        companyName.setAdapter(company_adapter);

        return v;
    }
}