//
//  PlayerTableViewCell.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 15/4/21.
//

import UIKit

class PlayerTableViewCell: UITableViewCell {
    
    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var jerseyLabel: UILabel!
    @IBOutlet weak var positionLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    public func loadPlayer(player: Player) {
        nameLabel.text = player.fantasyDraftName
        jerseyLabel.text = player.jersey?.description
        positionLabel.text = player.position
    }

}
