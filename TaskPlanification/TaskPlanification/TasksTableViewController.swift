//
//  TasksTableViewController.swift
//  TaskPlanification
//
//  Created by Javi Trujillo on 16/3/21.
//

import UIKit
import CoreData

class TasksTableViewController: UITableViewController {

    var tasksArray: [Task] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()

    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        getData()
    }
    
    //MARK: - Private methods
    
    private func setupView() {
        tableView.rowHeight = UITableView.automaticDimension
    }
    
    private func getData() {
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let context = appDelegate.persistentContainer.viewContext
        
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Task")
        request.returnsObjectsAsFaults = false
        
        do {
            let result = try context.fetch(request)
            self.tasksArray = result as! [Task]
        } catch {
            print("Error al recuperar los datos")
        }
        
        tableView.reloadData()
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return tasksArray.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "taskCellId", for: indexPath) as! TaskTableViewCell
        
        let task = tasksArray[indexPath.row]
        cell.configureCell(name: task.name ?? "", location: task.location ?? "", date: task.dateTime ?? Date(), isImportant: task.isImportant)

        return cell
    }

}
