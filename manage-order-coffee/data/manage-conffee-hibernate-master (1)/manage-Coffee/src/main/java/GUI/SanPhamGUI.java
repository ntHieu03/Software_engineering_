/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.CategoryBLL;
import BLL.RandomCode;
//import BUS.LoaiBUS;
import BLL.SanPhamBLL;
//import DTO.Category;
//import DTO.Product;
import hibernate.entities.Category;
import hibernate.entities.Product;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.BorderFactory.createLineBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class SanPhamGUI extends JPanel implements KeyListener {

    private SanPhamBLL spBUS = new SanPhamBLL();
    private CategoryBLL cateBLL=new CategoryBLL();
   private JTable tbl;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtId, txtTenSP, txtGia, txtMT, txtNSX, txtLoai, txtSearch;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JTextField sortTenSP;
    private JTextField txtMaxPrice;
    private JTextField sortMaSP;
    private JTextField txtMinPrice;
    private JTextField sortMaLoai;
    private JTextField sortMaNSX;
    private JComboBox cmbLoai;
    private JComboBox cmbNSX;
    private JComboBox cmbSortLoai;
    private JComboBox cmbSortNSX;
    private JButton btnAdd, btnEdit, btnDelete, btnConfirm, btnBack, btnFile;

    private boolean tableSelectionActive = true;

    //
    public SanPhamGUI(int width) {
        DEFALUT_WIDTH = width;
        init();
    }

    public void init() {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        Font font2 = new Font("Tahoma", Font.PLAIN, 25);


           LoaiModel loaiModel1 = listCategory();
//        LoaiModel loaiModel2 = listLoai();

        /**
         * **************************** PHẦN HIỂN THỊ THÔNG TIN
         * *****************************************
         */
        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 20, this.DEFALUT_WIDTH - 220, 250));
        ItemView.setBackground(new Color(247, 241, 227));

        /**
         * ****** Tao Cac Label & TextField ***********************
         */
        JLabel lbId = new JLabel("Mă Sản Phẩm");
        lbId.setBounds(new Rectangle(0, 0, 200, 30));
        lbId.setFont(font1);
        txtId = new JTextField("");
        txtId.setBounds(new Rectangle(100, 0, 220, 30));
        txtId.setFont(font0);
        txtId.setEditable(false);

        JLabel lbName = new JLabel("Tên Sản Phẩm");
        lbName.setBounds(new Rectangle(0, 40, 200, 30));
        lbName.setFont(font1);
        txtTenSP = new JTextField("");
        txtTenSP.setBounds(new Rectangle(100, 40, 220, 30));
        txtTenSP.setFont(font0);

        JLabel lbGia = new JLabel("Đơn giá (VNĐ)");
        lbGia.setBounds(new Rectangle(0, 80, 200, 30));
        lbGia.setFont(font1);
        txtGia = new JTextField("");
        txtGia.setBounds(new Rectangle(100, 80, 220, 30));
        txtGia.setFont(font0);
        txtGia.setInputVerifier(new MyInputVerifier());

        JLabel lbmota = new JLabel("Mô tả");
        lbmota.setBounds(new Rectangle(0, 120, 200, 30));
        lbmota.setFont(font1);
        txtMT = new JTextField("");
        txtMT.setBounds(new Rectangle(100, 120, 220, 30));
        txtMT.setFont(font0);

        JLabel lbLoai = new JLabel("Loại");
        lbLoai.setBounds(new Rectangle(0, 180, 40, 30));
        lbLoai.setFont(font1);
        cmbLoai = new JComboBox<>(loaiModel1);
        cmbLoai.setFont(font0);
        cmbLoai.setBounds(new Rectangle(100, 180, 220, 30));



        img = new JLabel("Thêm hình");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(350, 0, 200, 230));

        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(lbId);
        ItemView.add(txtId);
        ItemView.add(lbName);
        ItemView.add(txtTenSP);
        ItemView.add(lbGia);
        ItemView.add(txtGia);
        ItemView.add(lbmota);
        ItemView.add(txtMT);
        ItemView.add(lbLoai);
        ItemView.add(cmbLoai);


        /**
         * *********************************************************
         */
        /**
         * ************** TẠO CÁC BTN THÊM ,XÓA, SỬA *******************
         */
//        btnEdit,btnDelete,btnConfirm,btnBack,btnFile
        btnAdd = new JButton("THÊM");
        btnEdit = new JButton("SỬA");
        btnDelete = new JButton("XÓA");
        btnConfirm = new JButton("XÁC NHẬN");
        btnBack = new JButton("QUAY LẠI");
        btnFile = new JButton("CHỌN ẢNH");

        //font chữ
        btnAdd.setFont(font2);
        btnAdd.setForeground(Color.WHITE);
        btnEdit.setFont(font2);
        btnEdit.setForeground(Color.WHITE);
        btnDelete.setFont(font2);
        btnDelete.setForeground(Color.WHITE);
        btnConfirm.setFont(font2);
        btnConfirm.setForeground(Color.WHITE);
        btnBack.setFont(font2);
        btnBack.setForeground(Color.WHITE);
        btnFile.setFont(font2);
        btnFile.setForeground(Color.WHITE);

        //màu nền
        Color colorAdd = new Color(255, 218, 121);
        btnAdd.setBackground(colorAdd);
        Color colorEdit = new Color(255, 218, 121);
        btnEdit.setBackground(colorEdit);
        Color colorDelete = new Color(255, 218, 121);
        btnDelete.setBackground(colorDelete);
        Color colorConfirm = new Color(255, 218, 121);
        btnConfirm.setBackground(colorConfirm);
        Color colorBack = new Color(255, 218, 121);
        btnBack.setBackground(colorBack);
        Color colorFile = new Color(255, 218, 121);
        btnFile.setBackground(colorFile);

        //viền
        btnAdd.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnEdit.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnDelete.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnConfirm.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnBack.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnFile.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));

        //vị trí và con trỏ
        btnAdd.setBounds(new Rectangle(620, 0, 200, 50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnEdit.setBounds(new Rectangle(620, 70, 200, 50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnDelete.setBounds(new Rectangle(620, 140, 200, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(620, 0, 200, 50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(620, 70, 200, 50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnFile.setVisible(false);
        btnFile.setBounds(new Rectangle(620, 140, 200, 50));
        btnFile.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //icon
        JLabel lbAdd = new JLabel(new ImageIcon("./src/main/java/image/add-icon.png"));
        lbAdd.setBounds(new Rectangle(0, 0, 50, 50));
        btnAdd.add(lbAdd);

        JLabel lbEdit = new JLabel(new ImageIcon("./src/main/java/image/icons8-gear-32.png"));
        lbEdit.setBounds(new Rectangle(0, 0, 50, 50));
        btnEdit.add(lbEdit);

        JLabel lbDelete = new JLabel(new ImageIcon("./src/main/java/image/icons8-delete-32.png"));
        lbDelete.setBounds(new Rectangle(0, 0, 50, 50));
        btnDelete.add(lbDelete);

        JLabel btnXuatExcel = new JLabel(new ImageIcon("./src/main/java/image/btnXuatExcel.png"));
        btnXuatExcel.setBounds(new Rectangle(820, 70, 200, 50));
        btnXuatExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //hiển thị
        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);
        ItemView.add(btnConfirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);
        ItemView.add(btnXuatExcel);

        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditOrAdd = true;
                tableSelectionActive = false;
                cleanView();
                setEdit(true);
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);

                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);

                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });

        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "\"Vui lòng chọn sản phẩm cần xóa !!!\"");
                    return;
                }
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông Báo Xác Nhận", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    System.out.println(txtId.getText());
                    spBUS.delete(txtId.getText());
                    JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công !!!");
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<Product>) spBUS.getListProduct());
                }
            }
        });

        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "\"Vui lòng chọn sản phẩm cần sửa !!!\"");
                    return;
                }
                setEdit(true);
                tableSelectionActive = false;
                EditOrAdd = false;

                txtId.setEditable(false);

                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);

                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);

               tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });

        // MouseClick btnFile
        btnFile.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        String name = RandomCode.randomAlphaNumeric(8);
                        imgName = name.concat(".jpg"); //Tên hình

                        // Thay đổi hình hiển thị
                        img.setText("");
                        img.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));

                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //MouseClick btnBack
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cleanView();
                tableSelectionActive = true;
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);
                setEdit(false);
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
                btnFile.setVisible(false);

                tbl.setEnabled(true);
            }
        });

        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                txtTenSP.requestFocus();
                int i;
                if (EditOrAdd) //Thêm Sản Phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        //Lấy dữ liệu từ TextField
                        String tenSP = txtTenSP.getText();
                        float gia = txtGia.getText().equals("") ? 0 : Float.parseFloat(txtGia.getText());
                        String mota = txtMT.getText();
                        Category loai = (Category) cmbLoai.getSelectedItem();
                        //gán loại tạm
                      //  Category loai=new Category(1,"Bánh Đàn");
                        int maLoai = loai.getId();
                        String IMG = imgName;
                        //Upload sản phẩm lên DAO và BUS
                        if (tenSP.equals("") || gia == 0 || mota.equals("") || IMG.equals("") || maLoai == 0) {
                          JOptionPane.showMessageDialog(null,"Bạn chưa nhập đủ thông tin để thêm sản phẩm !!!");
                            return;
                        }
                        Product sp = new Product();
                        sp.setCategory(loai);
                        sp.setName(tenSP);
                        sp.setDescription(mota);
                        sp.setAmount(10);
                        sp.setPrice(gia);
                        sp.setImage(IMG);
                        spBUS.add(sp);
                        outModel(model, (ArrayList<Product>) spBUS.getListProduct());// Load lại table
                        saveIMG();// Lưu hình ảnh
                        JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công !!!");
                        cleanView();
                    }
                } else // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        //Lấy dữ liệu từ TextField
                        int maSP = Integer.parseInt(txtId.getText());
                        String tenSP = txtTenSP.getText();
                        float gia = Float.parseFloat(txtGia.getText());
                        String mota = txtMT.getText();

                       Category loai = (Category) cmbLoai.getSelectedItem();
                       /// Category loai=new Category(3,"Cà Phê Pha Máy");
                        int maLoai = loai.getId();

                        String IMG = imgName;
                        if (tenSP.equals("") || gia == 0 || IMG.equals("") || maLoai == 0) {
                          JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin để sửa sản phẩm");
                            return;
                        }
                        //Upload sản phẩm lên DAO và BUS
                        Product sp = new Product();
                        sp.setCategory(loai);
                        sp.setName(tenSP);
                        sp.setDescription(mota);
                        sp.setAmount(10);
                        sp.setPrice(gia);
                        sp.setImage(IMG);
                        sp.setId(maSP);
                        spBUS.update(sp);
                        outModel(model, (ArrayList<Product>) spBUS.getListProduct());// Load lại table
                        saveIMG();// Lưu hình ảnh
                        JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công");
                    }
                }
            }
        });


        /**
         * *********************** PHẦN TABLE
         * ************************************
         */
        /**
         * ************ TẠO MODEL VÀ HEADER ********************
         */
        Vector header = new Vector();
        header.add("Mă Sản Phẩm");
        header.add("Tên Sản Phẩm");
        header.add("Đơn Giá");
        header.add("Loại");
        header.add("Mô tả");
//        header.add("Mă NSX");
        header.add("IMG");
        model = new MyTable(header, 0) {
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 5:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }

        };
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        loadListProduct(); //Đọc từ database lên table
        /**
         * ******************************************************
         */

        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        // Chỉnh width các cột
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(180);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(30);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(5).setCellRenderer(centerAlign);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0)); //232, 57, 99
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 360, this.DEFALUT_WIDTH - 400, 300));
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));
        add(scroll);
        add(ItemView);
        /**
         * **************************************************************************************
         */

        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (tableSelectionActive) {
                    int i = tbl.getSelectedRow();
                    if (i == -1) {
                        return;
                    }
                    if (tbl.getRowSorter() != null) {
                        i = tbl.getRowSorter().convertRowIndexToModel(i);
                    }
                    imgName = tbl.getModel().getValueAt(i, 5).toString();
                    Image newImage;
                    try {
                        newImage = new ImageIcon("./src/main/java/image/SanPham/" + imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                    } catch (NullPointerException E) {
                        newImage = new ImageIcon("./src/main/java/image/SanPham/NoImage.jpg").getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                    }
                    txtId.setText(tbl.getModel().getValueAt(i, 0).toString());
                    txtTenSP.setText(tbl.getModel().getValueAt(i, 1).toString());
                    txtGia.setText(tbl.getModel().getValueAt(i, 2).toString());

                    txtMT.setText(tbl.getModel().getValueAt(i, 4).toString());
                    cmbLoai.setSelectedItem(cateBLL.searchCourseWithID((Integer) tbl.getModel().getValueAt(i, 3)));
                    img.setText("");
                    img.setIcon(new ImageIcon(newImage));
                }

            }
        });
        /**
         * ******************* THANH SEARCH
         * **********************************************
         */

//         Tạo Search Box
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(620, 200, 250, 30));
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền

        //Phần TextField
        txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(5, 0, 200, 30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // Custem Icon search
        JLabel searchIcon = new JLabel(new ImageIcon("./src/main/java/image/search_25px.png"));
        searchIcon.setBounds(new Rectangle(200, -9, 50, 50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add tất cả vào search box
        searchBox.add(searchIcon);
        searchBox.add(txtSearch);

        //bắt sự kiện Focus vào search box
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchIcon.setIcon(new ImageIcon("./src/main/java/image/search_25px_focus.png")); //Đổi màu icon
                searchBox.setBorder(createLineBorder(new Color(52, 152, 219))); // Đổi màu viền
            }

            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon("./src/main/java/image/search_25px.png"));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", 1));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", 1));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        ItemView.add(searchBox);
        /**
         * ******************************************************************************
         */
        /**
         * ********************* PHẦN SEARCH TABLE ****************************
         */
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30, 265, this.DEFALUT_WIDTH - 400, 100);

        JLabel sortTitle = new JLabel("--------------------------------------------------------------------------- TÌM KIẾM THÔNG TIN ---------------------------------------------------------------------------", JLabel.CENTER); // Mỗi bên 74 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0, 0, this.DEFALUT_WIDTH - 400, 30));
        sort.add(sortTitle);

        /**
         * ****** SORT MAKH *************
         */
        JLabel lbSortMaSP = new JLabel("Mă SP :");
        lbSortMaSP.setFont(font0);
        lbSortMaSP.setBounds(0, 40, 50, 30);
        sort.add(lbSortMaSP);

        sortMaSP = new JTextField("");
        sortMaSP.setFont(font0);
        sortMaSP.setBounds(new Rectangle(50, 42, 100, 30));
        sortMaSP.setInputVerifier(new MyInputVerifier());
//        sortMaSP.addKeyListener(this);
        sort.add(sortMaSP);
        /**
         * ****** SORT MALOAI *************
         */
        JLabel lbSortMaLoai = new JLabel("Loại :");
        lbSortMaLoai.setFont(font0);
        lbSortMaLoai.setBounds(170, 40, 40, 30);
        sort.add(lbSortMaLoai);

        cmbSortLoai = new JComboBox<>(listCategory());//loaiModel2);
        cmbSortLoai.setEditable(false);
        cmbSortLoai.setFont(font0);
        cmbSortLoai.setBounds(new Rectangle(210, 42, 110, 30));
        cmbSortLoai.addKeyListener(this);
        sort.add(cmbSortLoai);

        /**
         * **********************************
         */
        /**
         * ********** SORT THEO GIÁ **************
         */
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(510, 40, 70, 30);
        sort.add(sortPrice);

        txtMinPrice = new JTextField("");
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(580, 42, 100, 30));
        txtMinPrice.setInputVerifier(new MyInputVerifier());
        sort.add(txtMinPrice);

        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(690, 56, 10, 6);
        sort.add(sepPrice);

        txtMaxPrice = new JTextField("");
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(710, 42, 100, 30));
        txtMaxPrice.setInputVerifier(new MyInputVerifier());
        sort.add(txtMaxPrice);
        /**
         * ***************************************
         */
        setEdit(false);

        JLabel btnSearch = new JLabel(new ImageIcon("./src/main/java/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840, 26, 63, 63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                txtTenSP.requestFocus();
                search();
            }
        });
        sort.add(btnSearch);

        add(sort);
        /**
         * ****************************************************************
         */

    }

    public LoaiModel listCategory() {
        if (CategoryBLL.getListCategory() == null) {
            cateBLL.loadListCategory();
        }
        Category[] loai = new Category[CategoryBLL.getListCategory().size() + 1];
        Category all = new Category();
        all.setId(0);
        all.setName("Loại sản phẩm");
        int i = 0;
        loai[i] = all;
        for (Category loaiDTO : CategoryBLL.getListCategory()) {
            i++;
            loai[i] = loaiDTO;
        }
        LoaiModel model = new LoaiModel(loai);
        return model;
    }

    public void loadListProduct() // Chép ArrayList lên table
    {
        try {
            if (spBUS.getListProduct() == null) {
                spBUS.loadData();
            }
            ArrayList<Product> sp = (ArrayList<Product>) spBUS.getListProduct();
            model.setRowCount(0);
            outModel(model, sp);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không Thể Lấy Thông Tin Danh Sách Sản Phẩm");
        }
    }

    //FUNCTION FOR BTN
    public void cleanView() //Xóa trắng các TextField
    {
        txtId.setEditable(false);

        txtId.setText("");
        txtTenSP.setText("");
        txtGia.setText("");
        txtMT.setText("");

        img.setIcon(null);
        img.setText("Image");
        cmbLoai.setSelectedIndex(0);
        imgName = "null";
    }

    public void outModel(DefaultTableModel model, ArrayList<Product> sp) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (Product s : sp) {
            data = new Vector();
            data.add(s.getId());
            data.add(s.getName());
            data.add(s.getPrice());
            data.add(s.getCategory().getId());
            data.add(s.getDescription());
            data.add(s.getImage());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/main/java/image/SanPham/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search() {
        int masp = sortMaSP.getText().equals("") ? 0 : Integer.parseInt(sortMaSP.getText());
        int maloai = 0;
        if (cmbSortLoai.getSelectedIndex() != 0) {
            Category loai = (Category) cmbSortLoai.getSelectedItem();
            maloai = loai.getId();
            System.out.println(maloai);
        }

        int max = txtMaxPrice.getText().equals("") ? 999999999 : Integer.parseInt(txtMaxPrice.getText());
        int min = txtMinPrice.getText().equals("") ? 0 : Integer.parseInt(txtMinPrice.getText());

       outModel(model, spBUS.searchProduct(masp, maloai, max, min));
    }

    private void setEdit(boolean flag) {
        txtTenSP.setEditable(flag);
        txtGia.setEditable(flag);
        txtMT.setEditable(flag);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
