package com.example.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import com.example.tabs.PagerController.PagerController;


public class MainActivity extends AppCompatActivity {

    //PAGEVIEW ( PAGERCONTROLLER )


    // estos objetos servirán para hacer el enlace con los objetos en la activity
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2,tab3,tab4;

    // crear el controlador y crear la clase PageController
    // esto lo haremos una vez terminado

    PagerController pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // En el archivo R. están los objetos para el enlace
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tab1 = findViewById(R.id.A1);
        tab2 = findViewById(R.id.A2);
        tab3 = findViewById(R.id.A3);
        tab4 = findViewById(R.id.A4);

        // Este adaptador servirá para controlar los cambios de los fragment
        pagerAdapter = new PagerController(getSupportFragmentManager(),tabLayout.getTabCount());

        // los fragment se mostratán en este vista viewPager
        viewPager.setAdapter(pagerAdapter);

        // Evento clic para los tabs
        tabLayout.setOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                // Obtenemos la posición del tab a mostrar
                viewPager.setCurrentItem(tab.getPosition());

                // Determinar cual fragment se presenta
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==3){
                    pagerAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });



        // Aquí ViewPager en la activity sabe cual frafment mostrar
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        // al método inflate() le pasamos el nombre del menú
        getMenuInflater().inflate(R.menu.menu_principal, mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu){
        // obtiene el Item del menú que se presionó
        int id = opcion_menu.getItemId();
        // determinamos a quien corresponde la opción.
        if(id == R.id.usuarios){
            Toast.makeText(this,"Opcion de Usuarios",Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.configuracion){
            Toast.makeText(this,"Opcion de configuracion",Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.informacion){
            Toast.makeText(this,"Opcion de Informacion",Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == R.id.imagenes){
            Toast.makeText(this,"Opcion de Imagenes",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }


}
