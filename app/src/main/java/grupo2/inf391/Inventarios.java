package grupo2.inf391;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Inventarios extends Fragment {
    Activity activity;

    ListView lista;
    ArrayList<Modelo> AL;
    Item_adapter adapter;
    private OnFragmentInteractionListener mListener;

    public Inventarios() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventarios, container, false);

        activity = getActivity();
        getActivity().setTitle("MODELO DE INVENTARIOS");

        lista = (ListView)view.findViewById(R.id.LV_Inventarios);
        AL = new ArrayList<Modelo>();
        Modelo modelo = new Modelo("Compra con deficit");
        AL.add(modelo);
        Modelo modelo1 = new Modelo("Manofactura con deficit");
        AL.add(modelo1);
        Modelo modelo2 = new Modelo("Compra sin deficit");
        AL.add(modelo2);
        Modelo modelo3 = new Modelo("Manofactura sin deficit");
        AL.add(modelo3);
        adapter = new Item_adapter(activity,AL);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(activity,Inventarios_CCD.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(activity,Inventarios_MCD.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(activity,Inventarios_CSD.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(activity,Inventarios_MSD.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        return view;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
