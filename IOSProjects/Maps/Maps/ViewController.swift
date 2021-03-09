//
//  ViewController.swift
//  Maps
//
//  Created by Angela Velilla on 20/01/2021.
//

import UIKit
import MapKit
import CoreLocation

class ViewController: UIViewController {
    
    @IBOutlet weak var mapView: MKMapView!
    
    
    //Para quitar el safe area y que se vea en toda la superficie del movil, pulsamos sobre una constraint y en second item o first item (donde ponga safe area), pulsamos en superview y ponemos la constante a 0
    
    fileprivate let locationManager: CLLocationManager = CLLocationManager()
    
    let destinationCoordinates = CLLocationCoordinate2D(latitude: 41.6561, longitude: -0.8787)

    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadMap()
        addMark()
        getDirections()
    }
    
    //MARK: - Private methods
    
    private func loadMap() {
        //Pedimos permisos
        locationManager.requestWhenInUseAuthorization()
        
        //El radio que medira nuestro mapa, lo ponemos en kilometros
        locationManager.desiredAccuracy = kCLLocationAccuracyKilometer
        
        //Filtro de distancia, lo ponemos a none porque no queremos filtro
        locationManager.distanceFilter = kCLDistanceFilterNone
        
        //Le decimos que empiece a actualizar la localizacion
        locationManager.startUpdatingLocation()
        
        //Asignamos como delegado el mapView
        mapView.delegate = self
        
        mapView.showsUserLocation = true
        centerMapOnUserLocation()
    }
    
    
    //Funcion para centrar el mapa en la ubicacion del usuario
    private func centerMapOnUserLocation() {
        guard let coordinates = locationManager.location?.coordinate else {
            return
        }
        
        let coordinateRegion = MKCoordinateRegion(center: coordinates, span: MKCoordinateSpan(latitudeDelta: 0.10, longitudeDelta: 0.10))
        
        mapView.setRegion(coordinateRegion, animated: true)
    }
    
    //Creamos una marca en el mapa en la plaza del pilar
    private func addMark() {
        let pointAnnotation = MKPointAnnotation()
        pointAnnotation.title = "Plaza del Pilar"
        pointAnnotation.coordinate = destinationCoordinates
        mapView.addAnnotation(pointAnnotation)
    }
    
    //Para añadir un mensaje personalizado al pedir permisos, nos vamos a Info.plist

    
    //Creo unas rutas y que las ponga en el mapa
    private func getDirections() {
        //Obtengo las coordenadas del usuario
        guard let coordinates = locationManager.location?.coordinate else {
            return
        }
        
        let directionRequest = MKDirections.Request()
        directionRequest.source = MKMapItem(placemark: MKPlacemark(coordinate: coordinates))
        directionRequest.destination = MKMapItem(placemark: MKPlacemark(coordinate: destinationCoordinates))
        directionRequest.requestsAlternateRoutes = true
        directionRequest.transportType = .automobile
        
        let directions = MKDirections(request: directionRequest)
        
        directions.calculate { (response, error) in
            guard let routeResponse = response else {
                return
            }
            
            for route in routeResponse.routes {
                self.mapView.addOverlay(route.polyline)
                self.mapView.setVisibleMapRect(route.polyline.boundingMapRect, animated: true)
            }
        }
    }

}

//MARK: - Map View Delegate

//Las extensiones de las clases sirven para crear bloques de codigo aparte para que quede la clase mas diferenciada y se pueda ver mejor

extension ViewController: MKMapViewDelegate {
    func mapView(mapView: MKMapView, rendererFor overlay: MKOverlay) ->
        MKOverlayRenderer {
        
        //Esto es lo que va a renderizar las lineas en el mapa
        let renderer = MKPolylineRenderer(polyline: overlay as! MKPolyline)
        renderer.strokeColor = UIColor.red
        
        return renderer
    }
}

