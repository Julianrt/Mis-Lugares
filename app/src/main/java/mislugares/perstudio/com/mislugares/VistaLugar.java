package mislugares.perstudio.com.mislugares;


import java.text.DateFormat;
import java.util.Date;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;

public class VistaLugar extends AppCompatActivity {

    private long id;

    private Lugar lugar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_lugar);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id",-1);
        lugar = Lugares.elementos((int)id);
        actualizarVista();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vista_lugar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.accion_compartir:
                return true;
            case R.id.accion_llegar:
                return true;
            case R.id.accion_editar:
                lanzarEdicionLugar(null);
                return true;
            case R.id.accion_borrar:
                eliminarLugar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void eliminarLugar(){
        new AlertDialog.Builder(this)
                .setTitle("Borrar lugar")
                .setMessage("¿Estas seguro que quieres eliminar este lugar?")
                .setNegativeButton("Cancel",null)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Lugares.borrar((int)id);
                        finish();
                    }
                })
                .show();
    }
    public void lanzarEdicionLugar(View view){
        Intent i = new Intent(this,EdicionLugar.class);
        i.putExtra("id",id);
        startActivityForResult(i,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234) {
            actualizarVista();
            findViewById(R.id.scrollView1).invalidate();
        }
    }

    public void actualizarVista(){
        TextView nombre = (TextView)findViewById(R.id.nombre);
        nombre.setText(lugar.getNombre());

        ImageView logo_tipo = (ImageView)findViewById(R.id.logo_tipo);
        logo_tipo.setImageResource(lugar.getTipo().getRecurso());

        TextView tipo = (TextView)findViewById(R.id.tipo);
        tipo.setText(lugar.getTipo().getTexto());

        TextView direccion = (TextView)findViewById(R.id.direccion);
        direccion.setText(lugar.getDireccion());

        TextView telefono = (TextView)findViewById(R.id.telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));

        TextView url =(TextView)findViewById(R.id.url);
        url.setText(lugar.getUrl());

        TextView comentario = (TextView)findViewById(R.id.comentario);
        comentario.setText(lugar.getComentario());

        TextView fecha = (TextView)findViewById(R.id.fecha);
        fecha.setText(DateFormat.getDateInstance().format(new Date(lugar.getFecha())));

        TextView hora = (TextView)findViewById(R.id.hora);
        hora.setText(DateFormat.getTimeInstance().format(new Date(lugar.getFecha())));

        RatingBar valoracion = (RatingBar)findViewById(R.id.valoracion);
        valoracion.setRating(lugar.getValoracion());
        valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float valor, boolean fromUser) {
                lugar.setValoracion(valor);
            }
        });
    }
}
