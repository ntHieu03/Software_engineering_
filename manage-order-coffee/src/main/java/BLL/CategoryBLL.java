/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CategoryDAL;
import DAL.ProductDAL;
import hibernate.entities.Category;
import hibernate.entities.Category;
import hibernate.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class CategoryBLL {

    private static List<Category> listCategory;
    private CategoryDAL dal = new CategoryDAL();

    public CategoryBLL() {
    }

    public static List<Category> getListCategory() {
        return listCategory;
    }

    public static void setListCategory(List<Category> listCategory) {
        CategoryBLL.listCategory = listCategory;
    }

    public void loadListCategory() {
        if (listCategory== null) {
            listCategory = new ArrayList<Category>();
        }
        listCategory=dal.findAll();
    }
    public ArrayList<Category> searchCourseWithID(int id) {
        ArrayList<Category> search = new ArrayList<>();
        for (Category cs : listCategory) {
            if (cs.getId()==id) {
              search.add(cs);
            }
        }
        return search;
    }
    public ArrayList<Category> searchCourseWithName(String name) {
        ArrayList<Category> search = new ArrayList<>();
        for (Category cs : listCategory) {
            if (cs.getName().toLowerCase().contains(name.toLowerCase())) {
                search.add(cs);
            }
        }
        return search;
    }
    public long getCountCategory(){
        return dal.getCount();
    }
    public void add(Category category) {
        try {
            dal.insertCategory(category);
           listCategory.add(category);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {

        int idCate = Integer.parseInt(id);
        for(int i = 0 ; i < listCategory.size() ; i++){
            if (listCategory.get(i).getId() == idCate) {
                try {
                    dal.deleteCategory(idCate);
                    listCategory.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Category ct) {
        for (int i = 0; i < listCategory.size(); i++) {
            if (listCategory.get(i).getId() == ct.getId()) {
                try {
                    dal.updateCategory(ct);
                    listCategory.set(i, ct);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
