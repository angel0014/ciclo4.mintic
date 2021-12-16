package usa.cicloiv.mireto3.Vista;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;


import usa.cicloiv.mireto3.Modelo.Adaptadores.SucursalAdapter;
import usa.cicloiv.mireto3.Modelo.BaseDatos.DBHelper;
import usa.cicloiv.mireto3.Modelo.CasoUsoSucursal;
import usa.cicloiv.mireto3.Modelo.Sucursal;
import usa.cicloiv.mireto3.R;




public class SucursalesFragment extends Fragment {
    private String TABLE_NAME = "SUCURSALES";
    private CasoUsoSucursal casoUsoSucursal;
    private ListView listView;
    private DBHelper dbHelper;
    private ArrayList<Sucursal> sucursales;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sucursales, container,false);
        try{
            casoUsoSucursal = new CasoUsoSucursal();
            dbHelper = new DBHelper(getContext());
            Cursor cursor = dbHelper.getData(TABLE_NAME);
            sucursales = casoUsoSucursal.llenarListaSucursales(cursor);
            listView = (ListView) root.findViewById(R.id.lista_sucursales);
            SucursalAdapter sucursalAdapter = new SucursalAdapter(root.getContext(), sucursales);
            listView.setAdapter(sucursalAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_sucursal:
                Intent intent = new Intent(getContext(), FormProductos.class);
                intent.putExtra("name", "SUCURSALES");
                getActivity().startActivity(intent);
                return true;

            case R.id.show_all:
                Toast.makeText(getContext(), "Mostrar todo", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}