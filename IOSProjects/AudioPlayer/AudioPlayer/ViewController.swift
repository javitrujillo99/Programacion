//
//  ViewController.swift
//  AudioPlayer
//
//  Created by Angela Velilla on 19/01/2021.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {
    
    //Importamos AVFoundation y creamos la variable audioPlayer
    var audioPlayer: AVAudioPlayer?
    
    @IBOutlet weak var volumenControl: UISlider!

    override func viewDidLoad() {
        super.viewDidLoad()
        loadAudio()
    }
    
    //MARK: - Button Actions
    
    
    @IBAction func playButtonAction(_ sender: Any) {
        audioPlayer?.play()
        audioPlayer?.rate = 1.0
    }
    

    @IBAction func pauseButtonAction(_ sender: Any) {
        audioPlayer?.pause()
    }
    
    
    @IBAction func stopButtonAction(_ sender: Any) {
        audioPlayer?.stop()
        
        //Esto es para que se inicie desde el principio al pararla
        audioPlayer?.currentTime = 0
    }
    
    
    //Boton de atrasar 10 segundos
    @IBAction func goBackward10(_ sender: Any) {
        
        //Controlamos por donde va la cancion
        if let currentTime = audioPlayer?.currentTime, currentTime > 10 {
            audioPlayer?.currentTime = currentTime - 10
        } else {
            //Si no lleva 10 segundos, se pondra a 0
            audioPlayer?.currentTime = 0
        }
        
        //Le decimos que siga sonando
        audioPlayer?.play()
    }
    
    
    //Boton de adelantar 10 segundos
    @IBAction func goForward10(_ sender: Any) {
        if let currentTime = audioPlayer?.currentTime {
            audioPlayer?.currentTime = currentTime + 10
        }
        
        audioPlayer?.play()
    }
    
    
    @IBAction func volumenButtonAction(_ sender: UISlider) {
        audioPlayer?.volume = volumenControl.value
    }
    
    //MARK: - Private Methods
    
    private func loadAudio() {
        
        //Guard es como un if inverso. Si la condición no se cumple es cuando se ejecutará la función
        
        //Bundle.main.path es un path que se encuentre en la pestaña de la izquierda, donde estan todos los archivos del codigo
        guard let audioLocation = Bundle.main.path(forResource: "Himno de España", ofType: "mp3") else {
            return
        }
        
        //Creamos el URL del audio porque hara falta luego para lanzarlo
        let audioURL = URL(fileURLWithPath: audioLocation)
        
        do {
            //Aqui lanzamos el audioPlayer con la URL, dentro de un try catch por si falla
            audioPlayer = try AVAudioPlayer(contentsOf: audioURL)
        } catch let exception {
            //Si falla imprimimos el fallo
            print(exception.localizedDescription)
        }
        
        //Una vez que lo tenemos lanzado le hacemos un prepare igual que en Android
        audioPlayer?.prepareToPlay()
    }
}

