//
//  InterfaceController.swift
//  SelectorWatch WatchKit Extension
//
//  Created by Javi Trujillo on 19/4/21.
//

import WatchKit
import Foundation


class InterfaceController: WKInterfaceController {
    
    
    @IBOutlet weak var activatedSwitch: WKInterfaceSwitch!
    @IBOutlet weak var intensitySlider: WKInterfaceSlider!
    @IBOutlet weak var scalePicker: WKInterfacePicker!
    
    //Creamos unas variables para guardar todo lo que tienen dentro nuestros elemenos
    var activatedSwitchState = true
    var intensitySladerValue: Float = 1
    var scalePickerIndex = 0
    
    override func awake(withContext context: Any?) {
        
        //Rellenamos el picker
        var scales: [WKPickerItem] = []
        
        for i in 1...10 {
            let element = WKPickerItem()
            element.title = "Escala \(i)"
            scales.append(element)
        }
        
        scalePicker.setItems(scales)
    }
    
    override func willActivate() {
        // This method is called when watch view controller is about to be visible to user
    }
    
    override func didDeactivate() {
        // This method is called when watch view controller is no longer visible
    }
    
    // MARK: - Button actions
    
    @IBAction func acceptButtonAction() {
        
        //Creamos una alerta al pulsar aceptar en la que salgan los valores introducidos
        var title = "Máquina activada"
        let message = "Intensidad: \(intensitySladerValue) Escala: \(scalePickerIndex)"
        
        if !activatedSwitchState {
            title = "Máquina desactivada"
        }
        
        let alertAction = WKAlertAction(title: "Aceptar", style: .default) {}
        
        self.presentAlert(withTitle: title, message: message, preferredStyle: .alert, actions: [alertAction])
    }
    
    
    //El apple watch no tiene mucha memoria, por lo que para recoger las propiedades asociadas a los elementos, tenemos que añadir las funciones asociadas a ellos
    
    //Esta es la función del switch
    @IBAction func valueChange(_ value: Bool) {
        activatedSwitchState = value
    }
    
    //Esta es la función del slider
    @IBAction func setValue(_ value: Float) {
        intensitySladerValue = value
    }
    
    //Esta es la función del picker
    @IBAction func setSelectedItemIndex(_ value: Int) {
        scalePickerIndex = value + 1
    }
    
}
