package grupo2.inf391;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Colas_MMS extends AppCompatActivity implements View.OnClickListener {
    Button calcular;
    EditText lambda,niu,numcanales;
    TextView ls,lq,lo,ld,ws,wq,pe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colas__mms);

        this.setTitle("M COLAS MMS");
        calcular=(Button)findViewById(R.id.BT_calcular);
        calcular.setOnClickListener(this);
        lambda = (EditText)findViewById(R.id.tasallegadas);
        niu = (EditText)findViewById(R.id.tasaservicio);
        numcanales= (EditText)findViewById(R.id.numcanales);

        ls = (TextView)findViewById(R.id.Ls);
        lq = (TextView)findViewById(R.id.Lq);
        lo = (TextView)findViewById(R.id.Lo);
        ld = (TextView)findViewById(R.id.Ld);
        ws = (TextView)findViewById(R.id.Ws);
        wq = (TextView)findViewById(R.id.Wq);
        pe = (TextView)findViewById(R.id.p);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BT_calcular:
                double y = Double.parseDouble(lambda.getText().toString());
                double x = Double.parseDouble(niu.getText().toString());
                int s = Integer.parseInt(numcanales.getText().toString());
                double p = y / (x*s);
                double po = calcularP0(y,x,s);
                double LQ = (Math.pow((y/x),s)*po*p)/(factorial(s)*Math.pow((1-p),2));
                double LO = s * p;
                double L = LQ + LO;
                double LD = s-LO;
                double WQ = LQ/y;
                double WS = WQ + (1/x);
                L=Math.round(L * 100d) / 100d;
                LQ=Math.round(LQ * 100d) / 100d;
                LD=Math.round(LD * 100d) / 100d;
                LO=Math.round(LO * 100d) / 100d;
                WS=Math.round(WS * 100d) / 100d;
                WQ=Math.round(WQ * 100d) / 100d;

                ls.setText(String.valueOf(L));
                lq.setText(String.valueOf(LQ));
                lo.setText(String.valueOf(LO));
                ld.setText(String.valueOf(LD));
                ws.setText(String.valueOf(WS));
                wq.setText(String.valueOf(WQ));
                pe.setText(String.valueOf(p));
                break;
        }
    }
    public Double calcularP0(Double y,Double x, int s){
        Integer numero_servidores = s-1;
        Double p0 = 0.0;
        Double resultado_aux = 0.0;
        for(int i = 0; i <= numero_servidores; i++){
            resultado_aux += (Math.pow(y/x, i)) / this.factorial(i);
        }

        p0 = resultado_aux + (Math.pow(y/x,s)) / (this.factorial(s) * (1 - calcularRo(s,y,x)));

        return 1/p0;
    }
    private Integer factorial(Integer numero){
        if(numero == 0){
            return 1;
        }else{
            return numero * factorial(numero-1);
        }
    }
    public Double calcularRo(int s, double y, double x){
        if(s > 1){
            return (y) / (s * x);
        }else{
            return 0.0;
        }
    }
}