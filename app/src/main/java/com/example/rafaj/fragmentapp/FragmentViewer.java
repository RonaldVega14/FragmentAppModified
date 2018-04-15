package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    private TextView parole;
    private ImageView icone;
    private Planete planete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        parole = view.findViewById(R.id.paroleV);
        icone = view.findViewById(R.id.planeteV);
        Bundle bungalo = this.getArguments();


        if(bungalo != null){
            planete = bungalo.getParcelable("KEY");
            //Toast.makeText(getActivity(), "Item: " + bungalo.getString("KEY"), Toast.LENGTH_SHORT).show();
            parole.setText(planete.getSurnom());
            icone.setImageResource(planete.getNombre());

        }

        return view;
    }


}
