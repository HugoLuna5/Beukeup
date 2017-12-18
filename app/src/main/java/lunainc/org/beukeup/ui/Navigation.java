package lunainc.org.beukeup.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import lunainc.org.beukeup.R;
import lunainc.org.beukeup.ui.fragment.AboutFragment;
import lunainc.org.beukeup.ui.fragment.HomeFragment;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView = navigationView.getHeaderView(0);

        if (auth != null) {
            ImageView photo = (CircleImageView) hView.findViewById(R.id.imageView);
            TextView correo = (TextView) hView.findViewById(R.id.email);
            TextView nombre = (TextView) hView.findViewById(R.id.name);

            correo.setText(auth.getCurrentUser().getEmail());
            nombre.setText(auth.getCurrentUser().getDisplayName());
            Picasso.with(Navigation.this).load(auth.getCurrentUser().getPhotoUrl()).into(photo);

        }
        setFragment(0);
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            setFragment(0);
        } else if (id == R.id.nav_about) {
            setFragment(1);

        } else if (id == R.id.nav_share) {
            setFragment(2);

        } else if (id == R.id.nav_email) {
            setFragment(3);

        }else if(id == R.id.nav_close){

            setFragment(4);

        }else if(id == R.id.nav_info){

            setFragment(5);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment, homeFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                AboutFragment aboutFragment = new AboutFragment();
                fragmentTransaction.replace(R.id.fragment, aboutFragment);
                fragmentTransaction.commit();
                break;
            case 2://compartir
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "¡Descarga la aplicación!\n Visita nuestra pagina @BeukupOficial en FB");
                startActivity(Intent.createChooser(intent, "Compartir con: "));


                break;
            case 3://email
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","bkpaplicacion@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "BeuKeup");
                startActivity(Intent.createChooser(emailIntent,  "Enviar email"));
                break;
            case 4:
                auth.signOut();
                Intent closeSesion = new Intent(Navigation.this,LoginActivity.class);
                startActivity(closeSesion);
                finish();

                break;
            case 5:
                Intent infoIntent =  new Intent(Navigation.this,InfoActivity.class);
                startActivity(infoIntent);

                break;

        }
    }
}
