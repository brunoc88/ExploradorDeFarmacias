package com.softulp.exploradordefarmacias.ui.mapa;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MapsFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<Location> mutableLocation;
    private FusedLocationProviderClient fused;
    private LocationCallback callback;
    private List<LatLng> farmacias;
    public MapsFragmentViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());
        cargarFarmacias();
    }
    public LiveData<Location> getMlocation() {
        if (mutableLocation == null) {
            mutableLocation = new MutableLiveData<>();
        }

        return mutableLocation;
    }
    public void lecturaPermanente() {
       /* LocationRequest request = LocationRequest.create();
        request.setInterval(5000);
        request.setFastestInterval(5000);
        request.setPriority(Priority.PRIORITY_HIGH_ACCURACY);
    */
        LocationRequest request = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build();
        callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                Location location = locationResult.getLastLocation();
                mutableLocation.postValue(location);
            }

        };

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fused.requestLocationUpdates(request, callback, null);
    }
    private void cargarFarmacias() {
        farmacias = new ArrayList<>();
        // Añado las coordenadas de las farmacias
        farmacias.add(new LatLng(-33.672547, -65.472500)); // farmacia cruz verde
        farmacias.add(new LatLng(-33.674869, -65.468547)); // farmacia acetto
    }

    public List<LatLng> getFarmacias() {
        return farmacias;
    }
    public void pararLecturaPermanente(){
        fused.removeLocationUpdates(callback);
    }
}
