package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    private Planete planetes[] = new Planete[9];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        planetes[0] = new Planete("Sun",R.drawable.sun);
        planetes[1] = new Planete("Mercury",R.drawable.mercury);
        planetes[2] = new Planete("Venus",R.drawable.venus);
        planetes[3] = new Planete("Earth",R.drawable.earth);
        planetes[4] = new Planete("Mars",R.drawable.mars);
        planetes[5] = new Planete("Jupiter",R.drawable.jupiter);
        planetes[6] = new Planete("Saturn",R.drawable.saturn);
        planetes[7] = new Planete("Uranus",R.drawable.uranus);
        planetes[8] = new Planete("Neptune",R.drawable.neptune);

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planetes, android.R.layout.simple_list_item_1);
        //busca en values/string.xml ese array
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            Bundle bungalo= new Bundle();
            bungalo.putParcelable("KEY",planetes[i]);


            Intent newIntent = new Intent(getActivity().getApplicationContext(), Portrait_second_screen.class);
            newIntent.putExtras(bungalo);
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY",planetes[i]);

            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
