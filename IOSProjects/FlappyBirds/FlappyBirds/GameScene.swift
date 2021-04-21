//
//  GameScene.swift
//  FlappyBirds
//
//  Created by Javi Trujillo on 20/4/21.
//

import SpriteKit
import GameplayKit

class GameScene: SKScene {
    
    //Creamos las variables necesarias para el juego
    
    enum Colision: UInt32 {
        case Bird = 1
        case Object = 2
        case Gap = 5 //No hace falta que sean numeros seguidos, por eso está el 5
    }
    
    var bird = SKSpriteNode()
    var background = SKSpriteNode()
    var pipe1 = SKSpriteNode()
    var pipe2 = SKSpriteNode()
    var scoreLabel = SKLabelNode()
    var score = 0
    var gameOverLabel = SKLabelNode()
    var gameOver = false
    var timer = Timer() //Esto es para controlar el tiempo
    var play = false
    
    override func sceneDidLoad() {
        super.sceneDidLoad()
        setupGame()
    }
    
    // MARK: Private methods
    
    private func setupGame() {
        addBackground()
    }
    
    private func addBackground() {
        //Así creamos la textura con la imagen del fondo
        let textureBG = SKTexture(imageNamed: "background")
        
        //Creamos las animaciones que va a tener nuestro fondo
        
        //Esta animación hará que el fondo se mueva hacia la izquierda
        let animation1 = SKAction.moveBy(x: -textureBG.size().width, y: 0, duration: 6)
        
        //Esta animación pondrá el fondo otra vez al principio para que se vuelva a mover
        let animation2 = SKAction.moveBy(x: textureBG.size().width, y: 0, duration: 0)
        
        //Creamos el movimiento, repeatForever es que esté constantemente haciendo esas 2 animaciones
        let bgMovement = SKAction.repeatForever(SKAction.sequence([animation1, animation2]))
        
        var i: CGFloat = 0
        
        while i < 3 {
            background = SKSpriteNode(texture: textureBG)
            background.position = CGPoint(x: textureBG.size().width * i, y: self.frame.midY)
            background.size = CGSize(width: self.frame.size.width, height: self.frame.size.height)
            background.run(bgMovement)
            background.zPosition = -2 //Esto es lo alejado o acercado que esté el fondo
            
            self.addChild(background)
            
            i += 1
        }
    }
}
