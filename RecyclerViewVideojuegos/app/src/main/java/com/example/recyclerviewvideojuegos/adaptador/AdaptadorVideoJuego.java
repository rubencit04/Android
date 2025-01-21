package com.example.recyclerviewvideojuegos.adaptador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewvideojuegos.MainActivity;
import com.example.recyclerviewvideojuegos.R;
import com.example.recyclerviewvideojuegos.editar;
import com.example.recyclerviewvideojuegos.entidad.VideoJuego;
import com.example.recyclerviewvideojuegos.singelton.ListaVideoJuegosSingelton;

import java.util.List;

public class AdaptadorVideoJuego  extends RecyclerView.Adapter<AdaptadorVideoJuego.ViewHolder> {
    private List<VideoJuego> listaVideoJuegos;

    public AdaptadorVideoJuego(List<VideoJuego> listaVideoJuegos) {
        this.listaVideoJuegos = listaVideoJuegos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView nombre;
        private TextView fechaCreacion;
        private TextView puntuacion;
        private Button botonEditar;
        private Button botonEliminar;

        public ViewHolder(View v) {
            super(v);
            id = v.findViewById(R.id.id);
            nombre = v.findViewById(R.id.nombre);
            fechaCreacion = v.findViewById(R.id.fechaCreacion);
            puntuacion = v.findViewById(R.id.puntuacion);

            botonEditar = v.findViewById(R.id.editarVJ);
            botonEliminar = v.findViewById(R.id.eliminarVJ);
        }
    }
    @NonNull
    @Override
    public AdaptadorVideoJuego.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_juegos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorVideoJuego.ViewHolder holder, int position) {
        String sId = String.valueOf(listaVideoJuegos.get(position).getId());
        holder.id.setText(sId);
        holder.nombre.setText(listaVideoJuegos.get(position).getNombre());
        holder.fechaCreacion.setText(listaVideoJuegos.get(position).getFechaCreacion());
        holder.puntuacion.setText(String.valueOf(listaVideoJuegos.get(position).getPuntuacion()));


        holder.botonEditar.setOnClickListener(view -> {
            Toast.makeText(holder.id.getContext(), "Editando VideJuego " + sId, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(holder.id.getContext(), editar.class);
            intent.putExtra("videojuego_id", listaVideoJuegos.get(position).getId());
            intent.putExtra("videojuego_nombre", listaVideoJuegos.get(position).getNombre());
            intent.putExtra("videojuego_fecha", listaVideoJuegos.get(position).getFechaCreacion());
            intent.putExtra("videojuego_puntuacion", listaVideoJuegos.get(position).getPuntuacion());
            holder.id.getContext().startActivity(intent);
        });

        holder.botonEliminar.setOnClickListener(view -> {
            Toast.makeText(holder.id.getContext(), "Eliminando VideJuego " + sId, Toast.LENGTH_SHORT).show();
            ListaVideoJuegosSingelton.getInstance().borrar(listaVideoJuegos.get(position));
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return listaVideoJuegos.size();
    }
}
