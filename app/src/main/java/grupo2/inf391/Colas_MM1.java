package grupo2.inf391;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;
import static grupo2.inf391.R.id.toolbar;

public class Colas_MM1 extends AppCompatActivity implements View.OnClickListener{

    EditText tasallegadas;
    EditText tasausuario;

    TextView Ls;
    TextView Lq;
    TextView Ws;
    TextView Wq;
    TextView p;

    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colas__mm1);

        this.setTitle("M COLAS MM1");
        tasallegadas = (EditText)findViewById(R.id.tasallegadas);
        tasausuario = (EditText)findViewById(R.id.tasaservicio);
        calcular = (Button)findViewById(R.id.BT_calcular);
        calcular.setOnClickListener(this);
        Ls = (TextView)findViewById(R.id.Ls);
        Lq = (TextView)findViewById(R.id.Lq);
        Ws = (TextView)findViewById(R.id.Ws);
        Wq = (TextView)findViewById(R.id.Wq);
        p = (TextView)findViewById(R.id.P);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BT_calcular:
                double x= Double.parseDouble(tasallegadas.getText().toString());
                double y= Double.parseDouble(tasausuario.getText().toString());
                double z = x /(y-x);
                z=Math.round(z * 100d) / 100d;
                Ls.setText(String.valueOf(z));
                z = (x*x)/(y*(y-x));
                z=Math.round(z * 100d) / 100d;
                Lq.setText(String.valueOf(z));
                z = 1/(y-x);
                z=Math.round(z * 100d) / 100d;
                Ws.setText(String.valueOf(z));
                z = x/(y*(y-x));
                z=Math.round(z * 100d) / 100d;
                Wq.setText(String.valueOf(z));
                z= (x/y);
                z=Math.round(z * 100d) / 100d;
                p.setText(String.valueOf(z));
                break;
        }
    }
}
