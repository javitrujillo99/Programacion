package com.example.ejerciciogooglemaps;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Address> direcciones; //Lista de direcciones
    private Geocoder geocoder; //Información de una dirección
    //Creamos un marcador desde cero
    private MarkerOptions marker;
    private CameraPosition camara;
    private double lat;
    private double lng;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //setDraggable signigica que el marcador es arastrable, el usuario puede arrastrarlo
        //mMap.addMarker(new MarkerOptions().position(lucena).title("Hola desde Lucena")).setDraggable(true);

        //Inicializamos el fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        miUbicacion();

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(lucena)); //Movimiento de camara

    }

    /**
     * Metodo para conocer la localizacion actual por GPS
     */
    public void miUbicacion() {
        /*
        //Esto sale solo
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //Inicializamos localizacion
                Location currentLocation = task.getResult();

                // Comprobamos que la localización sea correcta para que no se cierre la app
                if (currentLocation != null) {
                    actualizarUbicacion(currentLocation);
                }
            }
        });
        */
        // Comprobación sobre los permisos requeridos
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        /* El método getLastKnowLocation nos ofrece la última posición conocida
           la localización que nos devuelve se la pasamos a nuestro método actualizarUbicacion
           haremos esto cada 10 segundos */
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locListener);
    }


    /**
     * Método encargado de pasar los datos de ubicación al marcador
     * @param currentLocation
     */
    private void actualizarUbicacion(Location currentLocation) {
        // Comprobamos que la localización sea correcta para que no se cierre la app
        if (currentLocation != null) {
            lat = currentLocation.getLatitude();
            lng = currentLocation.getLongitude();
            agregarMarker(lat, lng);
        }
    }

    /**
     * Método encargado de crear el marcador con los datos de la ubicación actual
     * @param lat
     * @param lng
     */
    public void agregarMarker(double lat, double lng) {
        LatLng location = new LatLng(lat, lng);
        //Añadimos el marcador creado desde cero
        marker = new MarkerOptions();
        marker.position(location);
        marker.title("Mi marcador");
        marker.draggable(true);
        marker.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.btn_star_big_on));
        //Snipper es un texto debajo del titulo
        mMap.addMarker(marker);

        //Añadimos la camara
        camara = new CameraPosition.Builder()
                .target(location) //La localizacion
                .zoom(15) //Modificar el zoom predeterminado (Numero entre 1 y 21)
                .bearing(90) //Grados de giro hacia el Oeste (Numero entre 0 y 365)
                .tilt(30) //Inclinacion de la camara en grados (Entre 0 y 90) Si ponemos 90 se verá como un GPS
                .build(); //OBLIGATORIO para inicializar
        //Animamos la camara y le insertamos la posicion creada anteriormente
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camara));

        //Geocoder
        geocoder = new Geocoder(getBaseContext(), Locale.getDefault());

        //Insertamos la latitud y la longitud en variables
        lat = marker.getPosition().latitude;
        lng = marker.getPosition().longitude;

        //Obtenemos la informacion de la localizacion mediante el geocoder.getFromLocation
        try {
            direcciones = geocoder.getFromLocation(lat, lng, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Almacenamos en variables informacion de las direccioness
        String direccion = direcciones.get(0).getAddressLine(0);
        String ciudad = direcciones.get(0).getLocality();
        String comunidadAutonoma = direcciones.get(0).getAdminArea();
        String pais = direcciones.get(0).getCountryName();
        String codigoPostal = direcciones.get(0).getPostalCode();

        marker.snippet(direccion);
    }

    //Creamos el Location Listener
    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            /* El método LocationChanged atiende cualquier cambio de ubicación en el GPS
               le pasamos nuestro método actualizarUbicación */
            actualizarUbicacion(location);
        }
    };

}