package com.example.ejemplomapas;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Address> direcciones; //Lista de direcciones
    private Geocoder geocoder; //Información de una dirección
    //Creamos un marcador desde cero
    private MarkerOptions marker;

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

        //Asignamos zoom minimo y maximo permitido
        mMap.setMinZoomPreference(10);
        mMap.setMaxZoomPreference(20);

        // Add a marker in Lucena and move the camera
        LatLng lucena = new LatLng(37.412147146981425, -4.487882852554322);
        //setDraggable signigica que el marcador es arastrable, el usuario puede arrastrarlo
        //mMap.addMarker(new MarkerOptions().position(lucena).title("Hola desde Lucena")).setDraggable(true);

        //Añadimos el marcador creado desde cero
        marker = new MarkerOptions();
        marker.position(lucena);
        marker.title("Mi marcador");
        marker.draggable(true);
        //BitMapDescriptorFactory es para crear un icono. FromResource son de los que nos ofrece Android por defecto
        // Si quisieramos poner una imagen de Internet, tendriamos que poner fromFile
        marker.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.btn_star_big_on));
        //Snipper es un texto debajo del titulo
        marker.snippet("Este es el texto a modificar");

        //Añadimos el marcador personalizado al mapa
        mMap.addMarker(marker);

        //Creamos una nueva posicion de camara y le insertamos datos
        CameraPosition camara = new CameraPosition.Builder()
                .target(lucena) //La localizacion
                .zoom(15) //Modificar el zoom predeterminado (Numero entre 1 y 21)
                .bearing(90) //Grados de giro hacia el Oeste (Numero entre 0 y 365)
                .tilt(30) //Inclinacion de la camara en grados (Entre 0 y 90) Si ponemos 90 se verá como un GPS
                .build(); //OBLIGATORIO para inicializar

        //Animamos la camara y le insertamos la posicion creada anteriormente
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camara));

        //Añadimos el geocoder
        geocoder = new Geocoder(getBaseContext(), Locale.getDefault()); //getDefault es donde esta el marcador

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(lucena)); //Movimiento de camara


        //Evento para cuando pulsemos sobre el mapa
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(MapsActivity.this, "Click: \n" + "Lat: " + latLng.latitude +
                        "\nLong:" + latLng.longitude, Toast.LENGTH_SHORT).show();
            }
        });

        //Evento para el marcador (El puntero rojo). Drag sifnifica arrastrar
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                //Esto es para que oculte el snippet al principio hasta que arrastremos
                marker.hideInfoWindow();
            }

            //Esto es para cuando arrastremos el marcador
            @Override
            public void onMarkerDrag(Marker marker) {

            }

            //Esto es para cuando soltamos el marcador después de arrastrarlo
            @Override
            public void onMarkerDragEnd(Marker marker) {
                //Insertamos la latitud y longitud en variables
                double latitud = marker.getPosition().latitude;
                double longitud = marker.getPosition().longitude;

                //El try catch se añade automaticamente despues de poner getFromLocation
                try {
                    // Le metemos la localizacion del marcador con latitud y longitud para obtener la informacion
                    // con geocoder
                    direcciones = geocoder.getFromLocation(latitud, longitud, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Almacenamos en variables informacion de las direccioness
                String direccion = direcciones.get(0).getAddressLine(0);
                String ciudad = direcciones.get(0).getLocality();
                String comunidadAutonoma = direcciones.get(0).getAdminArea();
                String pais = direcciones.get(0).getCountryName();
                String codigoPostal = direcciones.get(0).getPostalCode();

                marker.setSnippet(direccion);

                Toast.makeText(getBaseContext(), "Direccion: " + direccion + "\nCiudad: "
                        + ciudad + "\nComunidad Autonoma: " + comunidadAutonoma + "\nPais: " + pais
                        + "\nCodigo postal: " + codigoPostal, Toast.LENGTH_SHORT).show();

                /*Toast.makeText(MapsActivity.this, "Marcador \n" + "Lat: "
                        + marker.getPosition().latitude + "\nLong: " + marker.getPosition().longitude,
                        Toast.LENGTH_LONG).show(); */
            }
        });
    }
}