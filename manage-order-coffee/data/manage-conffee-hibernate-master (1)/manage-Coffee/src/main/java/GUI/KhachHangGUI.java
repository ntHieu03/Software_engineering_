/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CustomerBLL;
import hibernate.entities.Customer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.BorderFactory.createLineBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Trần Kim Phú
 */
public class KhachHangGUI extends JPanel {
//

    private CustomerBLL khBLL = new CustomerBLL();

    private JTable tbl;
    private JTextField txtMaKH, txtHoKH, txtTenKH, txtSDT, txtEmail, txtAddress;
    private JTextField sortMaKH, sortHoKH, sortTenKH;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JButton btnAdd, btnEdit, btnDelete, btnConfirm, btnBack, btnFile;

    private boolean tableSelectionActive = true;

    public KhachHangGUI(int width) {
        DEFALUT_WIDTH = width;
        init();
    }

    public void init() {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));

        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        /**
         * **************************** PHẦN HIỂN THỊ THÔNG TIN
         * *****************************************
         */

        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(30, 40, this.DEFALUT_WIDTH - 220, 180));
        itemView.setBackground(null);

        /**
         * ****** Tao Cac Label & TextField ***********************
         */
        JLabel lbMaKH = new JLabel("Mă khách hàng");
        txtMaKH = new JTextField("");
        lbMaKH.setBounds(new Rectangle(50, 0, 200, 30));
        lbMaKH.setFont(font1);
        txtMaKH.setBounds(new Rectangle(150, 0, 220, 30));
        txtMaKH.setFont(font0);
        txtMaKH.setEditable(false);

        JLabel lbSDT = new JLabel("Số điện thoại");
        txtSDT = new JTextField("");
        lbSDT.setBounds(new Rectangle(400, 0, 100, 30));
        lbSDT.setFont(font1);
        txtSDT.setBounds(new Rectangle(500, 0, 220, 30));
        txtSDT.setFont(font0);

        JLabel lbTenKH = new JLabel("Tên");
        txtTenKH = new JTextField("");
        lbTenKH.setBounds(new Rectangle(50, 40, 200, 30));
        lbTenKH.setFont(font1);
        txtTenKH.setBounds(new Rectangle(150, 40, 220, 30));
        txtTenKH.setFont(font0);

        JLabel lbHoKH = new JLabel("Họ");
        txtHoKH = new JTextField("");
        lbHoKH.setBounds(new Rectangle(400, 40, 200, 30));
        lbHoKH.setFont(font1);
        txtHoKH.setBounds(new Rectangle(500, 40, 220, 30));
        txtHoKH.setFont(font0);

        JLabel lblAddress = new JLabel("Địa chỉ");
        txtAddress = new JTextField("");
        lblAddress.setBounds(new Rectangle(50, 80, 200, 30));
        lblAddress.setFont(font1);
        txtAddress.setBounds(new Rectangle(150, 80, 220, 30));
        txtAddress.setFont(font0);

        JLabel lblEmail = new JLabel("Email");
        txtEmail = new JTextField("");
        lblEmail.setBounds(new Rectangle(400, 80, 200, 30));
        lblEmail.setFont(font1);
        txtEmail.setBounds(new Rectangle(500, 80, 220, 30));
        txtEmail.setFont(font0);

        // THÊM VÀO PHẦN HIỂN THỊ
        itemView.add(lbMaKH);
        itemView.add(txtMaKH);
        itemView.add(lbHoKH);
        itemView.add(txtHoKH);
        itemView.add(lbTenKH);
        itemView.add(txtTenKH);
        itemView.add(lbSDT);
        itemView.add(txtSDT);
        itemView.add(lblAddress);
        itemView.add(txtAddress);
        itemView.add(lblEmail);
        itemView.add(txtEmail);

        add(itemView);

        /**
         * ************** TẠO CÁC BTN THÊM ,XÓA, SỬA *******************
         */
        Font font2 = new Font("Tahoma", Font.PLAIN, 25);
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
        Color color = new Color(255, 218, 121);
        btnAdd.setBackground(color);
        btnEdit.setBackground(color);
        btnDelete.setBackground(color);
        btnConfirm.setBackground(color);
        btnBack.setBackground(color);
        btnFile.setBackground(color);

        //viền
        btnAdd.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnEdit.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnDelete.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnConfirm.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnBack.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnFile.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));

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

//        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd.png"));
        btnAdd.setBounds(new Rectangle(750, 0, 200, 50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(750, 55, 200, 50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(750, 110, 200, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        JLabel btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(750, 0, 200, 50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(750, 55, 200, 50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        itemView.add(btnAdd);
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        itemView.add(btnConfirm);
        itemView.add(btnBack);

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

                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });

        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtMaKH.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "\"Vui lòng chọn khách hàng cần xóa !!!\"");
                    return;
                }
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông Báo Xác Nhận", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    khBLL.delete(txtMaKH.getText());
                    JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công !!!");
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<Customer>) khBLL.getListCustomer());
                }
            }
        });

        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtMaKH.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "\"Vui lòng chọn khách hàng cần sửa !!!\"");
                    return;
                }
                setEdit(true);
                tableSelectionActive = false;
                EditOrAdd = false;

                txtMaKH.setEditable(false);

                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);

                btnConfirm.setVisible(true);
                btnBack.setVisible(true);

                tbl.clearSelection();
                tbl.setEnabled(false);
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

                tbl.setEnabled(true);
            }
        });

        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                txtTenKH.requestFocus();
                int i;
                if (EditOrAdd) //Thêm khách hàng
                {
                    String sdt = txtSDT.getText();
                    //validate SDT
                    Pattern pattern = Pattern.compile("^\\d{10,11}$");
                    Matcher m = pattern.matcher(sdt);   //so sánh
                    if (!m.matches()) {
                        JOptionPane.showConfirmDialog(null, "\"Số điện thoại không hợp lệ!! Vui lòng nhập 10 hoặc 11 số !!!\"");
                        return;
                    }
                    for (int j = 0; j < khBLL.getListCustomer().size(); j++) {
                        if (khBLL.getListCustomer().get(j).getPhoneNumber().equals(sdt)) {
                            JOptionPane.showConfirmDialog(null, "\"Số điện thoại đã tồn tại, vui lòng nhập số khác !!!\"");
                            return;
                        }
                    }
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm khách hàng", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        //Lấy dữ liệu từ TextField
                        String hoKH = txtHoKH.getText();
                        String tenKH = txtTenKH.getText();
                        String dienThoai = txtSDT.getText();
                        String diachi = txtAddress.getText();
                        String email = txtEmail.getText();

                        if (hoKH.equals("") || tenKH.equals("") || dienThoai.equals("") || diachi.equals("") || email.equals("")) {
                            JOptionPane.showConfirmDialog(null, "\"Vui lòng nhập đầy đủ thông tin !!!\"");
                            return;
                        }
                        //Upload khách hàng lên DAO và BUS
                        Customer c = new Customer();
                        c.setFirstName(hoKH);
                        c.setLastName(tenKH);
                        c.setPhoneNumber(dienThoai);
                        c.setAddress(diachi);
                        c.setEmail(email);
                        khBLL.add(c);
                        outModel(model, (ArrayList<Customer>) khBLL.getListCustomer());
                        JOptionPane.showConfirmDialog(null, "\"Thêm khách hàng thành công !!!\"");
                        cleanView();
                    }

                } else // Edit khách hàng
                {
                    String sdt = txtSDT.getText();
                    //validate SDT
                    Pattern pattern = Pattern.compile("^\\d{10,11}$");
                    Matcher m = pattern.matcher(sdt);   //so sánh
                    if (!m.matches()) {
                        JOptionPane.showConfirmDialog(null, "\"Số điện thoại không hợp lệ!! Vui lòng nhập 10 hoặc 11 số !!!\"");
                        return;
                    }
                    for (int j = 0; j < khBLL.getListCustomer().size(); j++) {
                        if (khBLL.getListCustomer().get(j).getPhoneNumber().equals(sdt) && khBLL.getListCustomer().get(j).getId() != Integer.parseInt(txtMaKH.getText())) {
                            JOptionPane.showConfirmDialog(null, "\"Số điện thoại đã tồn tại, vui lòng nhập số khác !!!\"");
                            return;
                        }
                    }
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa Khách hàng", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        int maKH = Integer.parseInt(txtMaKH.getText());
                        String hoKH = txtHoKH.getText();
                        String tenKH = txtTenKH.getText();
                        String dienThoai = txtSDT.getText();
                        String diachi = txtAddress.getText();
                        String email = txtEmail.getText();

                        if (hoKH.equals("") || tenKH.equals("") || dienThoai.equals("") || diachi.equals("") || email.equals("")) {
                            JOptionPane.showConfirmDialog(null, "Vui lòng nhập đầy đủ thông tin !!!");
                        }
                        Customer c = new Customer();
                        c.setId(maKH);
                        c.setFirstName(hoKH);
                        c.setLastName(tenKH);
                        c.setPhoneNumber(dienThoai);
                        c.setAddress(diachi);
                        c.setEmail(email);
                        khBLL.update(c);
                        outModel(model, (ArrayList<Customer>) khBLL.getListCustomer());// Load lại table
                        JOptionPane.showConfirmDialog(null, "Sửa thông tin khách hàng thành công");

                    }
                }

            }
        });

        /**
         * ************ TẠO MODEL VÀ HEADER ********************
         */
        Vector header = new Vector();
        header.add("Mă KH");
        header.add("TÊN KH");
        header.add("HỌ KH");
        header.add("SĐT");
        header.add("ĐỊA CHỈ");
        header.add("EMAIL");
        model = new MyTable(header, 5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list(); //Đọc từ database lên table
        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        // Chỉnh width các cột
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(centerAlign);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 220, this.DEFALUT_WIDTH - 400, 450));
        scroll.setBackground(null);

        add(scroll);

        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (tableSelectionActive) {
                    int i = tbl.getSelectedRow();
                    if (i == -1) {
                        return;
                    }
                    txtMaKH.setText(tbl.getModel().getValueAt(i, 0).toString());
                    txtTenKH.setText(tbl.getModel().getValueAt(i, 1).toString());
                    txtHoKH.setText(tbl.getModel().getValueAt(i, 2).toString());
                    txtSDT.setText(tbl.getModel().getValueAt(i, 3).toString());
                    txtAddress.setText(tbl.getModel().getValueAt(i, 4).toString());
                    txtEmail.setText(tbl.getModel().getValueAt(i, 5).toString());
                }
            }
        });
        /**
         * ********************* SORT TABLE ****************************
         */
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(50, 120, 530, 30));
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền
        //PHẦN CHỌN SEARCH
        JComboBox cmbChoice = new JComboBox();
        cmbChoice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbChoice.addItem("Mã KH");//cmbchoice index = 0
        cmbChoice.addItem("TÊN KH");//1
        cmbChoice.addItem("HỌ KH");//2
        cmbChoice.addItem("SĐT");//3
        cmbChoice.setBounds(new Rectangle(0, 0, 120, 30));
        cmbChoice.setEditable(false);

        //Phần TextField
        JTextField txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(125, 0, 400, 30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // Custem Icon search
        JLabel searchIcon = new JLabel(new ImageIcon("./src/image/search_25px.png"));
        searchIcon.setBounds(new Rectangle(485, -10, 50, 50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add tất cả vào search box
        searchBox.add(cmbChoice);
        searchBox.add(txtSearch);
        searchBox.add(searchIcon);

        //bắt sự kiện Focus vào search box
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px_focus.png")); //Đổi màu icon
                searchBox.setBorder(createLineBorder(new Color(52, 152, 219))); // Đổi màu viền
            }

            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px.png"));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex(); // lấy index sort

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        setEdit(false);
        itemView.add(searchBox);
    }

    public void cleanView() //Xóa trắng các TextField
    {
        txtMaKH.setEditable(false);

        txtMaKH.setText("");
        txtHoKH.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
        txtAddress.setText("");
        txtEmail.setText("");

    }

    public void outModel(DefaultTableModel model, ArrayList<Customer> nv) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (Customer n : nv) {
            data = new Vector();
            data.add(n.getId());//indext table = 0
            data.add(n.getFirstName());//1
            data.add(n.getLastName());//2
            data.add(n.getPhoneNumber());//3
            data.add(n.getAddress()); //4
            data.add(n.getEmail());//5 ý dòng xết
            model.addRow(data);;
        }
        tbl.setModel(model);
    }

    public void list() // Chép ArrayList lên table
    {
        try {
            if (khBLL.getListCustomer() == null) {
                khBLL.loadData();
            }
            ArrayList<Customer> c = (ArrayList<Customer>) khBLL.getListCustomer();
            model.setRowCount(0);
            outModel(model, c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không Thể Lấy Thông Tin Danh Sách Khách Hàng");
        }
    }

    private void setEdit(boolean flag) {
        txtHoKH.setEditable(flag);
        txtSDT.setEditable(flag);
        txtTenKH.setEditable(flag);
        txtEmail.setEditable(flag);
        txtAddress.setEditable(flag);
    }
}