//
//  AddTaskViewController.swift
//  TaskPlanification
//
//  Created by Angela Velilla on 08/02/2021.
//

import UIKit
import CoreData

class AddTaskViewController: UIViewController {

    
    @IBOutlet weak var pickerView: UIView!
    @IBOutlet weak var datePicker: UIDatePicker!
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var locationTextField: UITextField!
    @IBOutlet weak var dateTimeTextField: UITextField!
    @IBOutlet weak var isImportantSwitch: UISwitch!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    // MARK: - Button actions
    
    
    @IBAction func aceptarPickerButtonAction(_ sender: UIBarButtonItem) {
        let formatter = DateFormatter()
        formatter.dateFormat = "dd/MM/yy hh:mm"
        dateTimeTextField.text = formatter.string(from: datePicker.date)
        self.view.endEditing(true)
        pickerView.isHidden = true
    }
    

    @IBAction func saveButtonAction(_ sender: UIButton) {
        
    }
    
    
    //Lo que hacemos con este botón es si lo activamos mostrar el datePicker, que lo hemos desactivado previamente manualmente desactivando el state: Enabled
    @IBAction func showDatePickerButtonAction(_ sender: UIButton) {
        pickerView.isHidden = false
    }
    
    //MARK: - Private methods
    
    private func addTask() {
        //AppDelegate es la clase principal donde tenemos todas las clases necesarias. Aqui llamamos a las clases de Coredata
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let context = appDelegate.persistentContainer.viewContext
        
        //Para usar NSEntityDescription y la otra hay que importar CoreData
        let entity = NSEntityDescription.entity(forEntityName: "Task", in: context)
        let newTask = NSManagedObject(entity: entity!, insertInto: context)
        
        newTask.setValue(nameTextField.text, forKey: "name")
        newTask.setValue(locationTextField.text, forKey: "location")
        newTask.setValue(datePicker.date, forKey: "dateTime")
        newTask.setValue(isImportantSwitch.isOn, forKey: "isImportant")
        
        do {
            try context.save()
        } catch {
            print("Error guardando")
        }
    }
}
