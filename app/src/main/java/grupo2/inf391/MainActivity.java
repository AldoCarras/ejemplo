package grupo2.inf391;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Colas.OnFragmentInteractionListener,
        Poison.OnFragmentInteractionListener,
        Inventarios.OnFragmentInteractionListener,
        Inicio.OnFragmentInteractionListener
{
    int cont = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Model App");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
        Inicio fragment1 = new Inicio();
        transaction1.replace(R.id.Layout_Main, fragment1);
        transaction1.commit();
        //toolbar.setNavigationIcon(R.drawable.list);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_poison) {
            cont=0;
            FragmentManager fragmentManager1 = getFragmentManager();
            FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
            Poison fragment1 = new Poison();
            transaction1.replace(R.id.Layout_Main, fragment1);
            transaction1.commit();

        } else if (id == R.id.nav_colas) {
            cont=0;
            FragmentManager fragmentManager1 = getFragmentManager();
            FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
            Colas fragment1 = new Colas();
            transaction1.replace(R.id.Layout_Main, fragment1);
            transaction1.commit();

        } else if (id == R.id.nav_inventarios) {
            cont=0;
            FragmentManager fragmentManager1 = getFragmentManager();
            FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
            Inventarios fragment1 = new Inventarios();
            transaction1.replace(R.id.Layout_Main, fragment1);
            transaction1.commit();
            cont=0;
        } else if (id == R.id.acercade) {
            Intent intent = new Intent(MainActivity.this,Acerca.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onFragmentInteraction(Uri Uri)
    {

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch(keyCode){

            case KeyEvent.KEYCODE_BACK:
                cont++;
                if(cont == 2)
                {
                    cont=0;
                    finish();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else
                {
                    FragmentManager fragmentManager1 = getFragmentManager();
                    FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
                    Inicio fragment1 = new Inicio();
                    transaction1.replace(R.id.Layout_Main, fragment1);
                    transaction1.commit();
                    Toast.makeText(this, "Pulse nuevamente atras para salir",
                            Toast.LENGTH_SHORT).show();
                }

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
