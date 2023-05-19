/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ProductDAL;
//import DAO.ProductDAL;
//import DTO.Product;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

import hibernate.entities.Product;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Asus
 */
public class SanPhamBLL {

    private static List<Product> listProduct;
    private ProductDAL dal = new ProductDAL();

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void loadData() {
        if (listProduct == null) {
            listProduct = new ArrayList<Product>();
        }
        listProduct = dal.getAllProduct("ASC");
    }

    public void add(Product spDTO) {
        try {
            dal.insertProdct(spDTO);
            listProduct.add(spDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> searchCourseWithName(String name) {
        List<Product> search = null;
        for (Product ps : listProduct) {
            if (ps.getName().trim().toLowerCase().contains(name.trim().toLowerCase())) {
                search.add(ps);
            }
        }
        return search;
    }
    public List<Product> searchCourseWithCategory(String category) {
        List<Product> search = null;
        for (Product ps : listProduct) {
            if (ps.getCategory().getName().trim().toLowerCase().contains(category.trim().toLowerCase())) {
                search.add(ps);
            }
        }
        return search;
    }
    public ArrayList<Product> searchCourseWithnPrice(float min,float max) {
        ArrayList<Product> search = new ArrayList<>();
        for (Product ps : listProduct) {
            if (ps.getPrice() >= min && ps.getPrice() <= max) {
                search.add(ps);
            }
        }
        return search;
    }

    public Product getProductById(int id) {
        try {
            return dal.getProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String id) {

        int idSP = Integer.parseInt(id);
        for(int i = 0 ; i < listProduct.size() ; i++){
            if (listProduct.get(i).getId() == idSP) {
                try {

                   dal.deleteProduct(idSP);
                    listProduct.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Product spDTO) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == spDTO.getId()) {
                try {
                   dal.updateProduct(spDTO);
                    listProduct.set(i, spDTO);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public Product getSP(String masp) {
//        for (Product sp : listProduct) {
//            if (sp.getId_SP() == Integer.parseInt(masp)) {
//                return sp;
//            }
//        }
//        return null;
//    }
//
    public boolean checkMasp(int masp) {
        for (Product sp : listProduct) {
            if (sp.getId()== masp) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> searchProduct(int masp, int maloai, int max, int min) {
        ArrayList<Product> search = new ArrayList<>();

        for (Product sp : listProduct) {
            Product spTemp = null;
            if (masp == 0 && maloai == 0) {
                spTemp = sp;
            } else if (masp == 0) {
                if (sp.getCategory().getId() == maloai) {
                    spTemp = sp;
                }
            } else if (maloai == 0) {
                if (sp.getId() == masp) {
                    spTemp = sp;
                }
            }

            if (spTemp != null && spTemp.getPrice() >= min && spTemp.getPrice() <= max) {
                search.add(spTemp);
            }

        }
        return search;
    }
    
    public long getCountProduct(){
        return dal.getCount();
    }
    
    
    
//
//    public void exportProduct() {
//
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Product");
//        //set font , size and color
//        HSSFFont font = workbook.createFont();
//        font.setFontHeightInPoints((short) 12);
//        font.setBold(true);
//
//        font.setColor(IndexedColors.BLUE.getIndex());
//
//        // Create a CellStyle with the font
//        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
//        headerCellStyle.setFont(font);
//
//        // Create a Row
//        Row headerRow = sheet.createRow(0);
//        String[] columns = {
//            "Name",
//            "Descrption",
//            "Price",
//            "Img"
//        };
//
//        // Create cells
//        for (int i = 0; i < columns.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(columns[i]);
//            cell.setCellStyle(headerCellStyle);
//        }
//
//        // Create Other rows and cells with employees data
//        int rowNum = 1;
//        list();
//        List<Product> employeeDTOs = getSpBUS();
//        for (Product nv : employeeDTOs) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(nv.getName());
//            row.createCell(1).setCellValue(nv.getDescrption());
//            row.createCell(2).setCellValue(nv.getPrice());
//            row.createCell(3).setCellValue(nv.getImg());
//        }
//
//        for (int i = 0; i < columns.length; i++) {
//            sheet.autoSizeColumn(i);
//        }
//        try {
//            OutputStream os = new FileOutputStream(new File("./report/Product.xlsx"));
//            workbook.write(os);
////     Closing stream;
//            workbook.close();
//            os.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(ProductDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void importProduct(File file) throws FileNotFoundException, IOException, ParseException {
//        FileInputStream in = new FileInputStream(file);
//        HSSFWorkbook workbook = new HSSFWorkbook(in);
//        HSSFSheet sheet = workbook.getSheetAt(0);
//        Row row;
//
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            row = sheet.getRow(i);
//
//            String name = valueOf(row.getCell(0)).trim();
//
//            String tempIdType = valueOf(row.getCell(1)).trim();
//            int idType = parseInt(tempIdType);
//
//            String descrption = valueOf(row.getCell(2)).trim();
//
//            String tempAmount = valueOf(row.getCell(3)).trim();
//            int amount = parseInt(tempAmount);
//
//            String tempPrice = valueOf(row.getCell(4)).trim();
//            int price = parseInt(tempPrice);
//
//            String img = valueOf(row.getCell(5)).trim();
//
//            //set value
//            Product sp = new Product();
//            sp.setId_Loai(idType);
//            sp.setName(name);
//            sp.setDescrption(descrption);
//            sp.setPrice(price);
//            sp.setImg(img);
//
//            Product temp = findOneByName(sp.getName());
//            if (temp != null) {
//                sp.setId_SP(temp.getId_SP());
//                set(sp);
//            } else {
//                listProduct.add(sp);
//                add(sp);
//            }
//
//        }
//    }

}
