//
//  TaskTableViewCell.swift
//  TaskPlanification
//
//  Created by Javi Trujillo on 16/3/21.
//

import UIKit

class TaskTableViewCell: UITableViewCell {


    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var locationLabel: UILabel!
    @IBOutlet weak var dateTimeLabel: UILabel!
    @IBOutlet weak var importantImageView: UIImageView!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    public func configureCell(name: String, location: String, date: Date, isImportant: Bool) {
        nameLabel.text = name
        locationLabel.text = location
        
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "dd/MM/yyyy hh:mm"
        dateTimeLabel.text = dateFormatter.string(from: date)
        
        //Esto hace que lo ocultaria si no es importante
        importantImageView.isHidden = !isImportant
    }

}
