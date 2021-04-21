//
//  GameScene.swift
//  FlappyBird
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
        case Gap = 4 //No hace falta que sean numeros seguidos, por eso está el 4, pero tiene que ser par para que no de problemas al colisionar con el pájaro que es 1
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
    
    //didMove es cuando empiece a moverse la vista
    override func didMove(to view: SKView) {
        super.didMove(to: view)
        
        //Asignamos el delegado de physicsWorld
        self.physicsWorld.contactDelegate = self
        
        //Llamamos a la función principal
        setupGame()
    }
    
    //Esta función recoge cuándo tocas la pantalla
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        if !gameOver {
            if !play { //Para empezar el juego con el primer toque en la pantalla
                timer = Timer.scheduledTimer(timeInterval: 3, target: self, selector: #selector(GameScene.addPipes), userInfo: nil, repeats: true)
                play = true
            }
            
            //Le damos velocidad e impulso hacia arriba al pájaro al tocar la pantalla
            bird.physicsBody?.velocity = CGVector(dx: 0, dy: 0)
            bird.physicsBody?.applyImpulse(CGVector(dx: 0, dy: 250))
            bird.physicsBody?.isDynamic = true
            
        } else { //En caso de que el juego haya terminado, reiniciamos
            score = 0
            self.speed = 1
            gameOver = false
            self.removeAllChildren()
            setupGame()
        }
    }
    
    // MARK: Private methods
    
    private func setupGame() {
        addBackground()
        addMainCharacter()
        addFloor()
        addScoreLabel()
    }
    
    private func addBackground() {
        
        //Así creamos la textura con la imagen del fondo
        let textureBG = SKTexture(imageNamed: "background")
        
        //Creamos las animaciones que va a tener nuestro fondo
        
        //Esta animación hará que el fondo se mueva hacia la izquierda
        let animation1 = SKAction.moveBy(x: -textureBG.size().width, y: 0, duration: 3)
        
        //Esta animación pondrá el fondo otra vez al principio para que se vuelva a mover
        let animation2 = SKAction.moveBy(x: textureBG.size().width, y: 0, duration: 0)
        
        //Creamos el movimiento, repeatForever es que esté constantemente haciendo esas 2 animaciones
        let bgMovement = SKAction.repeatForever(SKAction.sequence([animation1, animation2]))
        
        var i: CGFloat = 0
        
        while i < 3 {
            
            //Inicializamos el fondo como un SpriteNode
            background = SKSpriteNode(texture: textureBG)
            
            //Le damos una posición
            background.position = CGPoint(x: textureBG.size().width * i, y: self.frame.midY)
            
            //También un tamaño
            background.size = CGSize(width: self.frame.size.width, height: self.frame.size.height)
            
            //Iniciamos el movimiento
            background.run(bgMovement)
            
            //Esto es lo alejado que esté el fondo
            background.zPosition = -2
            
            self.addChild(background)
            
            i += 1
        }
    }
    
    //Creamos todo lo relacionado con el pájaro, tanto introducirlo como la física del mismo
    
    private func addMainCharacter() {
        
        //Siempre el mismo patrón. Creamos las texturas con las imágenes
        let birdTexture1 = SKTexture(imageNamed: "bird_downflap" )
        let birdTexture2 = SKTexture(imageNamed: "bird_upflap" )
        
        //Después hacemos las animaciones
        let birdAnimation = SKAction.animate(with: [birdTexture1, birdTexture2], timePerFrame: 0.1)
        let birdMovement = SKAction.repeatForever(birdAnimation)
        
        //Después inicializamos el pájaro como un SpriteNode
        bird = SKSpriteNode(texture: birdTexture1)
        
        //Le damos una posición
        bird.position = CGPoint(x: self.frame.midX, y: self.frame.midY)
        
        //Iniciamos el movimiento del pájaro
        bird.run(birdMovement)
        
        //Le creamos un cuerpo físico para poder controlar sus conexiones y su física. En este caso le creamos un phisicBody de un círculo en nuestro juego, con el radio de la mitad del pájaro, para que el diámetro sea el pájaro entero
        bird.physicsBody = SKPhysicsBody(circleOfRadius: birdTexture1.size().height / 2)
        
        //Le decimos que no es dinámico, es decir, la imagen no se va a mover de como está, no va a cambiar de tamaño ni nada
        bird.physicsBody?.isDynamic = false
        
        //Añadimos los objetos contra los que puede chocar nuestro pájaro. Recordemos que Colision es nuestra enum con las cosas con las que colisiona
        bird.physicsBody?.collisionBitMask = Colision.Bird.rawValue
        bird.physicsBody?.contactTestBitMask = Colision.Object.rawValue
        bird.physicsBody?.categoryBitMask = Colision.Bird.rawValue
        
        //Añadimos el pájaro a nuestra vista
        self.addChild(bird)
    }
    
    //Añadimos el suelo y los tubos para que colisionen
    
    //Empezamos con el suelo
    private func addFloor() {
        
        //En este caso, inicializaremos el suelo como un SKNode y no como un SKSpriteNode, ya que para el suelo no vamos a utilizar una imagen, es decir, un Sprite
        let floor = SKNode()
        
        //Le damos la posición
        floor.position = CGPoint(x: self.frame.midX, y: -self.frame.height / 2)
        
        //Creamos el cuerpo físico del suelo. En este caso lo hacemos con un rectángulo
        floor.physicsBody = SKPhysicsBody(rectangleOf: CGSize(width: self.frame.width, height: 1))
        
        //Le decimos que no será dinámico
        floor.physicsBody?.isDynamic = false
        
        //Le decimos con las cosas con las que colisionará
        floor.physicsBody?.collisionBitMask = Colision.Object.rawValue
        floor.physicsBody?.contactTestBitMask = Colision.Object.rawValue
        floor.physicsBody?.categoryBitMask = Colision.Object.rawValue
    }
    
    //Y añadimos ahora las tuberías
    @objc private func addPipes() {
        
        //Creamos una variable para la anchura de la brecha
        let gapHeight = bird.size.height * 3
        
        //Hacemos que cada vez la brecha se sitúe en un sitio diferente
        let movement = arc4random() % UInt32(self.frame.height / 2)
        
        //Esta constante indica dónde se situará la brecha
        let outPipe = CGFloat(movement) - self.frame.height / 4
        
        //Creamos una constante que sea el movimiento de las tuberías
        let movePipe = SKAction.moveBy(x: -2 * self.frame.width, y: 0, duration: TimeInterval(self.frame.width / 100))
        
        //Añadimos la primera tubería
        let pipeTexture1 = SKTexture(imageNamed: "pipe1")
        pipe1 = SKSpriteNode(texture: pipeTexture1)
        
        //En este caso, no crearemos animaciones ya que las tuberías serán estáticas
        
        //Le damos una posición. Aquí le decimos que tiene que ocupar toda la pantalla excepto la brecha
        pipe1.position = CGPoint(x: self.frame.midX + self.frame.width, y: self.frame.midY + pipeTexture1.size().height / 2 + gapHeight / 2 + outPipe)
        
        //Hacemos que la tubería ejecute el movimiento
        pipe1.run(movePipe)
        
        //Le damos cuerpo físico
        pipe1.physicsBody = SKPhysicsBody(rectangleOf: pipe1.size)
        
        //Le decimos que tampoco sera dinámica
        pipe1.physicsBody?.isDynamic = false
        
        //Le damos las colisiones
        pipe1.physicsBody?.collisionBitMask = Colision.Object.rawValue
        pipe1.physicsBody?.contactTestBitMask = Colision.Object.rawValue
        pipe1.physicsBody?.categoryBitMask = Colision.Object.rawValue
        
        //Introducimos el código para que las tuberías estén por detrás del pájaro.
        pipe1.zPosition = -1
        
        //Añadimos las tuberías a nuestra vista
        self.addChild(pipe1)
        
        //Añadimos la segunda tubería
        let pipeTexture2 = SKTexture(imageNamed: "pipe2")
        pipe2 = SKSpriteNode(texture: pipeTexture2)
        
        //En este caso, no crearemos animaciones ya que las tuberías serán estáticas
        
        //Le damos una posición. Aquí es donde le decimos que tiene que ocupar toda la pantalla menos la brecha
        pipe2.position = CGPoint(x: self.frame.midX + self.frame.width, y: self.frame.midY - pipeTexture2.size().height / 2 - gapHeight / 2 + outPipe)
        
        //Le damos movimiento a la tubería
        pipe2.run(movePipe)
        
        //Le damos cuerpo físico
        pipe2.physicsBody = SKPhysicsBody(rectangleOf: pipe2.size)
        
        //Le decimos que tampoco sera dinámica
        pipe2.physicsBody?.isDynamic = false
        
        //Le damos las colisiones
        pipe2.physicsBody?.collisionBitMask = Colision.Object.rawValue
        pipe2.physicsBody?.contactTestBitMask = Colision.Object.rawValue
        pipe2.physicsBody?.categoryBitMask = Colision.Object.rawValue
        
        //Introducimos el código para que las tuberías estén por detrás del pájaro.
        pipe2.zPosition = -1
        
        //Añadimos las tuberías a nuestra vista
        self.addChild(pipe2)
        
        //Creamos la brecha
        let gap = SKNode()
        
        //Le damos posición
        gap.position = CGPoint(x: self.frame.midX + self.frame.width, y: self.frame.midY + outPipe)
        
        //Le damos el cuerpo físico
        gap.physicsBody = SKPhysicsBody(rectangleOf: CGSize(width: pipeTexture1.size().width, height: pipeTexture1.size().height))
        
        //Le decimos que no es dinámico
        gap.physicsBody?.isDynamic = false
        
        //Le damos movimiento
        gap.run(movePipe)
        
        //Le damos las colisiones
        gap.physicsBody?.collisionBitMask = Colision.Gap.rawValue
        gap.physicsBody?.contactTestBitMask = Colision.Bird.rawValue
        gap.physicsBody?.categoryBitMask = Colision.Gap.rawValue
        
        //Añadimos la brecha
        self.addChild(gap)
        
    }
    
    //Creamos la label de la puntuación
    private func addScoreLabel() {
        scoreLabel.fontName = "Helvetica"
        scoreLabel.fontSize = 40
        scoreLabel.text = "0"
        scoreLabel.position = CGPoint(x: self.frame.midX, y: self.frame.height / 2 - 140)
        
        self.addChild(scoreLabel)
    }
    
    //Función para terminar el juego
    private func performGameOver() {
        gameOverLabel.fontName = "Helvetica"
        gameOverLabel.fontSize = 40
        gameOverLabel.text = "Game Over. Pulsa para comenzar"
        gameOverLabel.position = CGPoint(x: 0, y: 0)
        self.addChild(gameOverLabel)
        self.speed = 0
        gameOver = true
        play = false
        timer.invalidate()
    }
    
}

//MARK: - SK Physics contact delegate

//Controlamos los contactos
extension GameScene: SKPhysicsContactDelegate {
    func didBegin(_ contact: SKPhysicsContact) {
        if !gameOver {
            //En el contacto siempre hay un cuerpo A y un cuerpo B, que es lo que significa bodyA y B
            if contact.bodyA.categoryBitMask == Colision.Gap.rawValue || contact.bodyB.categoryBitMask == Colision.Gap.rawValue {
                //Si hay contacto con un Gap, es decir, si pasa por el medio de 2 tuberías, se anota un punto y se actualiza la label de la puntuación
                score += 1
                scoreLabel.text = "\(score)"
                
            //Esto significa que ahora hay contacto con una tubería, por lo que llamamos a terminar juego
            } else if contact.bodyA.categoryBitMask == Colision.Object.rawValue || contact.bodyB.categoryBitMask == Colision.Object.rawValue {
                performGameOver()
            }
        }
    }
}
