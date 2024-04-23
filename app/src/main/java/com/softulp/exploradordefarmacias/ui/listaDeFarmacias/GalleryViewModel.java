package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.modelo.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private  MutableLiveData<List<Farmacia>> listaMutable;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Farmacia>>getListaMutable(){
        if(listaMutable == null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }
    public void crearLista(){
        ArrayList<Farmacia> lista = new ArrayList<>();
        lista.add(new Farmacia(
                "Farmacia Cruz Verde",
                R.drawable.facetta,
                "09:00hs a 21:00hs",
                "CHACABUCO 447"
        ));

        lista.add(new Farmacia(
                "Farmacia Accetta",
                R.drawable.fcruzverde,
                "08:00hs a 16:00hs",
                "AVENIDA 25 DE MAYO Nº 933"
        ));

        listaMutable.setValue(lista);
    }
}