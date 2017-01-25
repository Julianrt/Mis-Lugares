package mislugares.perstudio.com.mislugares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicion_lugar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.acercaDe){
            lanzarAcercaDe();
            return true;
        }
        if(id == R.id.config){
            lanzarEdicion();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void lanzarAcercaDe(){
        Intent i = new Intent(this,AcercaDe.class);
        startActivity(i);
    }
    private void lanzarEdicion(){
        Intent i = new Intent(this,VistaLugar.class);
        startActivity(i);
    }
}
