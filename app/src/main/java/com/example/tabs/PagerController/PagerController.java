package com.example.tabs.PagerController;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerController extends FragmentPagerAdapter {
    // Se crea esta variable para controlar el número de tabs
    int numoftabs;
    // Creamos el constructor de la clase
    public PagerController(@NonNull FragmentManager fm, int behavior)
    {
        super(fm, behavior);
        this.numoftabs = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
// aquí se determina cual fragment cargar
        switch (position){
            case 0:
                return new frag1();
            case 1:
                return new frag2();
            case 2:
                return new frag3();
            case 3:
                return new frag4();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
// Este método retorna el número de tabs
        return numoftabs;
    }
}
