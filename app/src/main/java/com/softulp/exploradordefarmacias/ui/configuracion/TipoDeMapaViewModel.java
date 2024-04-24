package com.softulp.exploradordefarmacias.ui.configuracion;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TipoDeMapaViewModel extends ViewModel {
    private MutableLiveData<Integer> mapType = new MutableLiveData<>();

    public void setMapType(int type) {
        mapType.setValue(type);
    }

    public LiveData<Integer> getMapType() {
        return mapType;
    }
}

