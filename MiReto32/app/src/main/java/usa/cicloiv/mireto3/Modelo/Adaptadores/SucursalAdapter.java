package usa.cicloiv.mireto3.Modelo.Adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

import usa.cicloiv.mireto3.Modelo.Sucursal;
import usa.cicloiv.mireto3.R;

public class SucursalAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sucursal> sucursales;
    LayoutInflater inflater;

    public SucursalAdapter(Context context, ArrayList<Sucursal> sucursales) {
        this.context = context;
        this.sucursales = sucursales;
    }

    @Override
    public int getCount() {
        return sucursales.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item2, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imagen_item2);
        TextView campo1 = convertView.findViewById(R.id.nombre_item2);
        TextView campo2 = convertView.findViewById(R.id.descripcion_item2);
        TextView campo3 = convertView.findViewById(R.id.localizacion_item2);
        TextView campoId = convertView.findViewById(R.id.id_item2);

        Sucursal sucursal = sucursales.get(position);
        byte[] image = sucursal.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        campoId.setText("ID :"+ sucursal.getId());
        campo1.setText(sucursal.getName());
        campo2.setText(sucursal.getDescription());
        campo3.setText(sucursal.getLocation());
        imageView.setImageBitmap(bitmap);

        return convertView;
    }
}
