/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import DTO.LoaiDTO;
import javax.swing.DefaultComboBoxModel;
import hibernate.entities.Category;

/**
 *
 * @author Asus
 */
public class LoaiModel extends DefaultComboBoxModel<Category>{

    public LoaiModel(Category[] items) {
        super(items);
    }

}
