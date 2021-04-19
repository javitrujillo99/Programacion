//
//  InterfaceController.swift
//  SelectorWatch WatchKit Extension
//
//  Created by Javi Trujillo on 19/4/21.
//

import WatchKit
import Foundation


class InterfaceController: WKInterfaceController {
    
    
    @IBOutlet weak var resultLabel: WKInterfaceLabel!
    @IBOutlet weak var additionButton: WKInterfaceButton!
    @IBOutlet weak var substractionButton: WKInterfaceButton!
    
    var actualNumber: Int = 0
    var previousNumber: Int = 0
    var result: Int = 0
    var additionPressed = false
    var substractionPressed = false
    
    override func awake(withContext context: Any?) {
        // Configure interface objects here.
    }
    
    override func willActivate() {
        // This method is called when watch view controller is about to be visible to user
    }
    
    override func didDeactivate() {
        // This method is called when watch view controller is no longer visible
    }
    
    //MARK: -Button Actions
    

    @IBAction func press9() {
        addNumber(number: 9)
    }
    
    
    @IBAction func press8() {
        addNumber(number: 8)
    }
    
    
    @IBAction func press7() {
        addNumber(number: 7)
    }
    
    
    @IBAction func press6() {
        addNumber(number: 6)
    }
    
    
    @IBAction func press5() {
        addNumber(number: 5)
    }
    
    
    @IBAction func press4() {
        addNumber(number: 4)
    }
    
    
    @IBAction func press3() {
        addNumber(number: 3)
    }
    
    
    @IBAction func press2() {
        addNumber(number: 2)
    }
    
    
    @IBAction func press1() {
        addNumber(number: 1)
    }
    
    
    @IBAction func press0() {
        addNumber(number: 0)
    }
    
    
    @IBAction func pressAddition() {
        pressOperation()
        additionPressed = true
    }
    
    
    @IBAction func pressSubstraction() {
        pressOperation()
        substractionPressed = true
    }
    
    
    @IBAction func pressEqualButton() {
        if (additionPressed) {
            result = previousNumber + actualNumber
            additionPressed = false
        }
        if (substractionPressed) {
            result = previousNumber - actualNumber
            substractionPressed = false
        }
        resultLabel.setText("\(result)")
        actualNumber = 0
        previousNumber = 0
    }
    
    
    @IBAction func pressACButton() {
        actualNumber = 0
        resultLabel.setText("0")
    }
    
    //MARK: Private methods
    
    private func addNumber(number: Int) {
        actualNumber = actualNumber * 10 + number
        resultLabel.setText("\(actualNumber)")
    }
    
    private func pressOperation() {
        //El número anterior, una vez pulsado el +, ya termina y empieza el nuevo número que se quiere sumar al anterior
        previousNumber = actualNumber
        
        actualNumber = 0
    }
}
