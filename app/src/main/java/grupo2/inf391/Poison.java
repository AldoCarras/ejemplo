package grupo2.inf391;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.x;
import static android.R.attr.y;
import static android.os.Build.VERSION_CODES.M;
import static grupo2.inf391.R.id.Lq;
import static grupo2.inf391.R.id.Ls;
import static grupo2.inf391.R.id.Wq;
import static grupo2.inf391.R.id.Ws;
import static grupo2.inf391.R.id.fx;
import static grupo2.inf391.R.id.tasallegadas;

public class Poison extends Fragment implements View.OnClickListener{
    private OnFragmentInteractionListener mListener;
    Activity activity;
    Button calcular;
    EditText frecuencuencia;
    EditText variable;
    TextView resultado;
    TextView acumulada;
    TextView menor;
    TextView mayor;


    public Poison() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        activity = getActivity();
        getActivity().setTitle("MODELO POISON");
        View view = inflater.inflate(R.layout.fragment_poison, container, false);
        frecuencuencia = (EditText) view.findViewById(R.id.frecuenciaesperada);
        variable = (EditText) view.findViewById(R.id.variablealeatoria);
        resultado=(TextView)view.findViewById(R.id.fx);
        activity = getActivity();
        calcular = (Button)view.findViewById(R.id.BT_calcular);
        calcular.setOnClickListener(this);
        acumulada = (TextView)view.findViewById(R.id.acumulada);
        menor = (TextView)view.findViewById(R.id.menor);
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
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BT_calcular:
               double x= Double.parseDouble(variable.getText().toString());
               double y= Double.parseDouble(frecuencuencia.getText().toString());
               double z = (Math.pow(2.718,-y)*(Math.pow(y,x)))/(factorial(x));
               z=Math.round(z * 100d) / 100d;
               resultado.setText(String.valueOf(z));
               acumulada.setText(String.valueOf(sumatoria(x,y)));

               break;
        }
    }
    public double factorial (double numero) {
        if (numero==0)
            return 1;
        else
            return numero * factorial(numero-1);
    }
    double sumatoria(double x,double y)
    {
        double z=0;
        for(int i =0; i<x;i++) {
            z = z+(Math.pow(2.718, -y) * (Math.pow(y, i))) / (factorial(i));
        }
     return z;
    }

}
