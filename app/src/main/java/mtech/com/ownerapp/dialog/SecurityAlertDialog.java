package mtech.com.ownerapp.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import mtech.com.ownerapp.R;

public class SecurityAlertDialog extends DialogFragment {

    ImageView fire, lift, animal, fight;
    Button raise_alarm;
    LinearLayout firell, liftll, animalll, fightll;
    String selected_value =null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.securityalert_dialog,container,false);
        fire = view.findViewById(R.id.fire);
        lift = view.findViewById(R.id.lift);
        animal = view.findViewById(R.id.animal);
        fight = view.findViewById(R.id.fight);
        firell = view.findViewById(R.id.ll1);
        liftll = view.findViewById(R.id.ll2);
        animalll = view.findViewById(R.id.ll3);
        fightll = view.findViewById(R.id.ll4);

        firell.setBackgroundColor(Color.LTGRAY);
        selected_value = "FIRE";


        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firell.setBackgroundColor(Color.LTGRAY);
                liftll.setBackgroundColor(Color.WHITE);
                animalll.setBackgroundColor(Color.WHITE);
                fightll.setBackgroundColor(Color.WHITE);
                selected_value = "FIRE";
            }
        });
        lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firell.setBackgroundColor(Color.WHITE);
                liftll.setBackgroundColor(Color.LTGRAY);
                animalll.setBackgroundColor(Color.WHITE);
                fightll.setBackgroundColor(Color.WHITE);
                selected_value = "LIFT";
            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firell.setBackgroundColor(Color.WHITE);
                liftll.setBackgroundColor(Color.WHITE);
                animalll.setBackgroundColor(Color.LTGRAY);
                fightll.setBackgroundColor(Color.WHITE);
                selected_value = "ANIMAL";
            }
        });
        fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firell.setBackgroundColor(Color.WHITE);
                liftll.setBackgroundColor(Color.WHITE);
                animalll.setBackgroundColor(Color.WHITE);
                fightll.setBackgroundColor(Color.LTGRAY);
                selected_value = "FIGHT";
            }
        });

        return view;
    }

}
