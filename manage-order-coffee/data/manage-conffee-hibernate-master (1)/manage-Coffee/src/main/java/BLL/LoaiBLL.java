/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CategoryDAL;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import hibernate.entities.Category;

/**
 *
 * @author Asus
 */
public class LoaiBLL {

    private List<Category> loaiBUS;
    CategoryDAL dal=new CategoryDAL();

    public LoaiBLL() {
        loaiBUS = null;
    }

    public List<Category> getLoaiBUS() {
        return loaiBUS;
    }

    public void list() {
        CategoryDAL loaiDAO = new CategoryDAL();
        loaiBUS = new ArrayList<>();
        loaiBUS = loaiDAO.findAll();
    }

    public void add(Category loaiDTO) {
        loaiBUS.add(loaiDTO);
        CategoryDAL loaiDAO = new CategoryDAL();
        try {
            loaiDAO.insertCategory(loaiDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idLoai = Integer.parseInt(id);
        for (Category loaiDTO : loaiBUS) {
            if (loaiDTO.getId()== idLoai) {
                loaiBUS.remove(loaiDTO);
                CategoryDAL loaiDAO = new CategoryDAL();
                try {
                    loaiDAO.deleteCategory(idLoai);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(Category loaiDTO) {
        for (int i = 0; i < loaiBUS.size(); i++) {
            if (loaiBUS.get(i).getId()== loaiDTO.getId()) {
                loaiBUS.set(i, loaiDTO);
                CategoryDAL loaiDAO = new CategoryDAL();
                try {
                    loaiDAO.updateCategory(loaiDTO);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public Category searchMaLoai(int maloai) {
        for (Category loai : loaiBUS) {
            if (loai.getId()== maloai) {
                return loai;
            }
        }
        return null;
    }

    public String getName(int idLoai){
        String name = "";
        for (Category loaiDTO : loaiBUS) {
            if (loaiDTO.getId()== idLoai) {
                name = loaiDTO.getName();
                break;
            }
        }
        return name;
    }

    public int getID(String name){
        int id = 0;
        for (Category loaiDTO : loaiBUS) {
            if (loaiDTO.getName().equals(name)) {
                id = loaiDTO.getId();
                break;
            }
        }
        return id;
    }
    public long getCountCategory(){
        return dal.getCount();
    }
    public static void main(String[] args) {
        LoaiBLL bus = new LoaiBLL();
        bus.list();
        Category rs = bus.searchMaLoai(7);
        System.out.println(rs);
//        bus.getLoaiBUS().forEach(s->System.out.println(s));
    }
}
