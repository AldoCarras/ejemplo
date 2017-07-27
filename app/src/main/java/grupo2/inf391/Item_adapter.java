package grupo2.inf391;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ALDO on 7/5/2017.
 */

public class Item_adapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Modelo> item;

    public Item_adapter(Activity activity, ArrayList<Modelo> item) {
        this.activity = activity;
        this.item = item;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Modelo> getItem() {
        return item;
    }

    public void setItem(ArrayList<Modelo> item) {
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }
    @Override
    public long getItemId(int position) {
        return item.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null)
        {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item,null);
        }
        Modelo modelo = item.get(position);
        TextView nombre = (TextView)v.findViewById(R.id.TV_modelo);
        nombre.setText(modelo.getModelo());
        return v;
    }

}
