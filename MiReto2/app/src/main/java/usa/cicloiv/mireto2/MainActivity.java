package usa.cicloiv.mireto2;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import usa.cicloiv.mireto2.databinding.ActivityMainBinding;

/**
 *
 * @author Angello Perilla
 */


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * boton flotante
             * @param view
             */
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contactenos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_productos, R.id.nav_sucursales, R.id.nav_servicios)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     *
     * menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     *
     * navegacion
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     *
     * Dar click en imagen para mostrar msjs
     * @param view
     */
    public void Seleccion(View view){
        switch (view.getId()){
            case R.id.idChaqueta1:
                Toast.makeText(this, "$ 108.500,00", Toast.LENGTH_SHORT).show();
                break;

            case R.id.idChaqueta2:
                Toast.makeText(this, "$ 149.999,00", Toast.LENGTH_SHORT).show();
                break;

            case R.id.idChaqueta3:
                Toast.makeText(this, "$ 124.999,00", Toast.LENGTH_SHORT).show();
                break;

            case R.id.idChaqueta4:
                Toast.makeText(this, "$ 219.999,00", Toast.LENGTH_SHORT).show();
                break;

        }
    }

}//fin main