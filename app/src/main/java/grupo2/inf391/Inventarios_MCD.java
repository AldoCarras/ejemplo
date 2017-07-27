package grupo2.inf391;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static grupo2.inf391.R.id.c1;
import static grupo2.inf391.R.id.c2;
import static grupo2.inf391.R.id.c3;
import static grupo2.inf391.R.id.c4;
import static grupo2.inf391.R.id.ct;
import static grupo2.inf391.R.id.d;
import static grupo2.inf391.R.id.im;
import static grupo2.inf391.R.id.q;
import static grupo2.inf391.R.id.r;
import static grupo2.inf391.R.id.s;

public class Inventarios_MCD extends AppCompatActivity implements  View.OnClickListener{

    Button calcular;
    EditText c1,c2,c3,c4,d,r;
    TextView q,s,im,ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventarios__mcd);
        this.setTitle("MANUFACTURAS CON DEFICIT");
        calcular = (Button)findViewById(R.id.BT_calcular);
        calcular.setOnClickListener(this);
        c1 = (EditText)findViewById(R.id.c1);
        c2 = (EditText)findViewById(R.id.c2);
        c3 = (EditText)findViewById(R.id.c3);
        c4 = (EditText)findViewById(R.id.c4);
        r= (EditText)findViewById(R.id.r);
        d = (EditText)findViewById(R.id.d);

        q = (TextView)findViewById(R.id.q);
        s = (TextView)findViewById(R.id.s);
        im = (TextView)findViewById(R.id.im);
        ct = (TextView)findViewById(R.id.ct);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BT_calcular:
                double D = Double.parseDouble(d.getText().toString());
                double C1 = Double.parseDouble(c1.getText().toString());
                double C2= Double.parseDouble(c2.getText().toString());
                double C3 = Double.parseDouble(c3.getText().toString());
                double C4 = Double.parseDouble(c4.getText().toString());
                double R = Double.parseDouble(r.getText().toString());
                double Q = (Math.pow(((2*D*C2)/C3),(1/2)))*(Math.pow(((C3+C4)/C4),(1/2)));
                double S = Math.pow(((2*D*C2)/C4),(1/2))*Math.pow((1-(D/R)),(1/2))*Math.pow((C3/(C3+C4)),(1/2));
                double CT = (C1 * Q) + C2 + (C3 *Math.pow(((1-(D/R)-S)/2),2)*(1/(1-(D/R)*D)))+(C4*(Math.pow(S,2)/2)*(1/(1-(D/R)*D)));


                Q=Math.round(Q* 100d) / 100d;
                S=Math.round(S* 100d) / 100d;
                CT=Math.round(CT* 100d) / 100d;
                q.setText(String.valueOf(Q));
                im.setText(String.valueOf(Q));
                ct.setText(String.valueOf(CT));
                s.setText(String.valueOf(S));
                break;
        }
    }
}
