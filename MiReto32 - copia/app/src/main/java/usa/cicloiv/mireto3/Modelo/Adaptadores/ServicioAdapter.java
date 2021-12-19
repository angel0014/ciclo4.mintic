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

import usa.cicloiv.mireto3.Modelo.Servicio;
import usa.cicloiv.mireto3.R;

public class ServicioAdapter extends BaseAdapter {
    Context context;
    ArrayList<Servicio> servicios;
    LayoutInflater inflater;

    public ServicioAdapter(Context context, ArrayList<Servicio> servicios) {
        this.context = context;
        this.servicios = servicios;
    }

    @Override
    public int getCount() {
        return servicios.size();
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
            convertView = inflater.inflate(R.layout.item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imagen_item2);
        TextView campo1 = convertView.findViewById(R.id.nombre_item2);
        TextView campo2 = convertView.findViewById(R.id.descripcion_item2);
        TextView campo3 = convertView.findViewById(R.id.precio_item);
        TextView campoId = convertView.findViewById(R.id.id_item2);

        Servicio servicio = servicios.get(position);
        byte[] image = servicio.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        campoId.setText("ID :"+ servicio.getId());
        campo1.setText(servicio.getName());
        campo2.setText(servicio.getDescription());
        campo3.setText(servicio.getPrice());

        imageView.setImageBitmap(bitmap);

        return convertView;
    }
}
