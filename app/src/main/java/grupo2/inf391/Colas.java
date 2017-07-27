package grupo2.inf391;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colas extends Fragment {
    private OnFragmentInteractionListener mListener;
    Activity activity;

    ListView lista;
    ArrayList<Modelo> AL;
    Item_adapter adapter;

    public Colas() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_colas, container, false);
        activity = getActivity();

        getActivity().setTitle("MODELO DE COLAS");
        lista = (ListView)view.findViewById(R.id.LV_Colas);
        AL = new ArrayList<Modelo>();
        Modelo modelo = new Modelo("M/M/1");
        AL.add(modelo);
        Modelo modelo1 = new Modelo("M/M/S");
        AL.add(modelo1);
        Modelo modelo2 = new Modelo("M/M/1/C");
        AL.add(modelo2);
        Modelo modelo3 = new Modelo("M/M/S/C");
        AL.add(modelo3);
        Modelo modelo4 = new Modelo("M/M/1/K");
        AL.add(modelo4);
        Modelo modelo5 = new Modelo("M/M/S/K");
        AL.add(modelo5);
        adapter = new Item_adapter(activity,AL);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(activity,Colas_MM1.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(activity,Colas_MMS.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(activity,Colas_MM1C.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(activity,Colas_MMSC.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(activity,Colas_MM1K.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(activity,Colas_MMSK.class);
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
