///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import BUS.PhieuNhapHangBUS;
//import BUS.ct_PhieuNhapHangBUS;
//import DTO.PhieuNhapHangDTO;
//import com.kingaspx.toast.util.Toast;
//import com.toedter.calendar.JDateChooser;
//import java.awt.Choice;
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Rectangle;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Vector;
//import static javax.swing.BorderFactory.createLineBorder;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSeparator;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//
///**
// *
// * @author ACER
// */
//public class NhapHangGUI extends JPanel implements ActionListener {
//
//    private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
//    private ct_PhieuNhapHangBUS ctBUS = new ct_PhieuNhapHangBUS();
//    private int DEFAULT_WIDTH;
//
//    private JLabel lbMaPNH, lbMaNCC, lbMaNV, lbNgayHD, lbTongTien;
//    private JTextField txtMaPNH, txtMaNCC, txtMaNV, txtNgayHD, txtTongTien;
//    private JDateChooser dateChoice;
//
//    private JButton btnView, btnAdd;
//
//    private JButton btnMaNCC, btnMaNV, btnClear, btnReFresh;
//
//    private JTable tbl;
//    private DefaultTableModel model;
//
//    private Choice monthChoice, yearChoice;
//    private JTextField txtMinPrice, txtMaxPrice, txtMaPN;
//
//    public NhapHangGUI(int width) {
//        this.DEFAULT_WIDTH = width;
//        init();
//    }
//
//    public void init() {
//        setLayout(null);
//        setBackground(null);
//        setBounds(new Rectangle(50, 0, this.DEFAULT_WIDTH - 220, 1000));
//        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
//        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
//
//        /**
//         * ********************* PHẦN VIEW THÔNG TIN
//         * ****************************
//         */
//        JPanel itemView = new JPanel(null);
//        itemView.setBackground(null);
//        itemView.setBounds(new Rectangle(30, 40, this.DEFAULT_WIDTH - 200, 120));
//
//        lbMaPNH = new JLabel("Mã PN");
//        lbMaPNH.setFont(font1);
//        lbMaPNH.setBounds(0, 0, 55, 30);
//        txtMaPNH = new JTextField();
//        txtMaPNH.setFont(font0);
//        txtMaPNH.setBounds(new Rectangle(80, 0, 60, 30));
//        txtMaPNH.setEnabled(false);
//        itemView.add(lbMaPNH);
//        itemView.add(txtMaPNH);
//
//        lbMaNCC = new JLabel("Mã NCC");
//        lbMaNCC.setFont(font0);
//        lbMaNCC.setBounds(155, 0, 50, 30);
//        txtMaNCC = new JTextField();
//        txtMaNCC.setFont(font0);
//        txtMaNCC.setBounds(new Rectangle(215, 0, 50, 30));
//        txtMaNCC.setEditable(false);
//
//        btnMaNCC = new JButton("...");
//        btnMaNCC.setBackground(new Color(131, 149, 167));
//        btnMaNCC.setBounds(new Rectangle(265, 0, 30, 30));
//        btnMaNCC.addActionListener(this);
//        itemView.add(btnMaNCC);
//        itemView.add(lbMaNCC);
//        itemView.add(txtMaNCC);
//
//        lbMaNV = new JLabel("Mã NV");
//        lbMaNV.setFont(font0);
//        lbMaNV.setBounds(325, 0, 60, 30);
//        txtMaNV = new JTextField();
//        txtMaNV.setFont(font0);
//        txtMaNV.setBounds(new Rectangle(375, 0, 50, 30));
//        txtMaNV.setEditable(false);
//
//        btnMaNV = new JButton("...");
//        btnMaNV.setBackground(new Color(131, 149, 167));
//        btnMaNV.setBounds(new Rectangle(425, 0, 30, 30));
//        btnMaNV.addActionListener(this);
//        itemView.add(btnMaNV);
//        itemView.add(lbMaNV);
//        itemView.add(txtMaNV);
//
//        lbNgayHD = new JLabel("Ngày Nhập");
//        lbNgayHD.setFont(font0);
//        lbNgayHD.setBounds(0, 40, 70, 30);
//        txtNgayHD = new JTextField();
//        txtNgayHD.setFont(font0);
//        txtNgayHD.setBounds(new Rectangle(80, 40, 375, 30));
//        txtNgayHD.setEditable(false);
//        itemView.add(lbNgayHD);
//        itemView.add(txtNgayHD);
//
//        dateChoice = new JDateChooser();
//        dateChoice.setBounds(new Rectangle(80, 40, 375, 30));
//        dateChoice.setVisible(false);
//        itemView.add(dateChoice);
//
//        lbTongTien = new JLabel("Tổng Tiền");
//        lbTongTien.setFont(font0);
//        lbTongTien.setBounds(0, 80, 60, 30);
//        txtTongTien = new JTextField();
//        txtTongTien.setFont(font0);
//        txtTongTien.setBounds(new Rectangle(80, 80, 375, 30));
//        txtTongTien.setEditable(false);
//        itemView.add(lbTongTien);
//        itemView.add(txtTongTien);
//
//        JSeparator sepHD = new JSeparator(0);
//        sepHD.setBounds(new Rectangle(0, 180, this.DEFAULT_WIDTH - 350, 3));
//        add(sepHD);
//
//        add(itemView);
//
//        /**
//         * ************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL
//         * *******************
//         */
//        Font font2 = new Font("Sogoe UI", Font.PLAIN, 25);
//
//        btnAdd = new JButton("THÊM");
//        btnAdd.setFont(font2);
//        btnAdd.setForeground(Color.WHITE);
//        btnAdd.setBounds(new Rectangle(500, 0, 200, 50));
//        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        btnView = new JButton("CHI TIẾT PN");
//        btnView.setFont(font2);
//        btnView.setForeground(Color.WHITE);
//        btnView.setBounds(new Rectangle(500, 60, 200, 50));
//        btnView.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        btnClear = new JButton("Làm mới dữ liệu");
//        btnClear.setBounds(new Rectangle(740, 5, 150, 40));
//        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnClear.addActionListener(this);
//
//        btnReFresh = new JButton("Làm mới bảng");
//        btnReFresh.setBounds(new Rectangle(740, 68, 150, 40));
//        btnReFresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnReFresh.addActionListener(this);
//
//        //màu nền
//        Color color = new Color(255, 218, 121);
//        btnAdd.setBackground(color);
//        btnView.setBackground(color);
//        btnClear.setBackground(color);
//        btnReFresh.setBackground(color);
//
//        //viền
//        btnAdd.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//        btnView.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//        btnClear.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
//        btnReFresh.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
//
//        itemView.add(btnClear);
//        itemView.add(btnReFresh);
//        itemView.add(btnAdd);
//        itemView.add(btnView);
//
//        btnAdd.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (!txtMaPNH.getText().equals("")) {
//                    new Toast.ToastWarning("Vui lòng làm mới lại dữ liệu trước khi chọn !!!", Toast.SHORT_DELAY);
//                    return;
//                }
//                int maNCC, maNV;
//                try {
//                    maNCC = Integer.parseInt(txtMaNCC.getText().trim());
//                    maNV = Integer.parseInt(txtMaNV.getText().trim());
//                } catch (NumberFormatException exception) {
//                    new Toast.ToastWarning("Vui lòng chọn đầy đủ nhân viên hoặc nhà cung cấp để nhập hàng !!!", Toast.SHORT_DELAY);
//                    return;
//                }
//                CT_NhapHangGUI chitiet = new CT_NhapHangGUI(maNV, maNCC);
//                pnhBUS.addDTO(chitiet.getDTOContent());
//                cleanView();
//            }
//        });
//
//        // Xem Chi Tiết HD              
//        btnView.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (txtMaPNH.getText().equals("")) {
//                    new Toast.ToastWarning("Vui lòng chọn phiếu nhập hàng cần xem !!!", Toast.SHORT_DELAY);
//                    return;
//                }
//                CT_NhapHangGUI chitiet = new CT_NhapHangGUI(txtMaPNH.getText());
//            }
//        });
//
//        btnReFresh.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                outModel(model, (ArrayList<PhieuNhapHangDTO>) pnhBUS.getPnhBUS());
//            }
//        });
//
//        /**
//         * **************** TẠO MODEL VÀ HEADER
//         * ********************************************
//         */
//        Vector header = new Vector();
//        header.add("Mă Phiếu Nhập");
//        header.add("Mă Nhà cung cấp");
//        header.add("Mã Nhân Viên");
//        header.add("Ngày Nhập");
//        header.add("Tổng Tiền");
//        model = new MyTable(header, 5);
//        tbl = new JTable(model);
//        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
//        tbl.setRowSorter(rowSorter);
//        list(); //Đọc từ database lên table 
//
//        /**
//         * ************** TẠO TABLE
//         * ***********************************************************
//         */
//        // Chỉnh width các cột 
//        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
//        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
//        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
//        tbl.getColumnModel().getColumn(4).setPreferredWidth(40);
//
//        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
//        centerAlign.setHorizontalAlignment(JLabel.CENTER);
//        tbl.getColumnModel().getColumn(4).setCellRenderer(centerAlign);
//
//        // Custom table
//        tbl.setFocusable(false);
//        tbl.setIntercellSpacing(new Dimension(0, 0));
//        tbl.getTableHeader().setFont(font1);
//        tbl.setRowHeight(30);
//        tbl.setShowVerticalLines(false);
//        tbl.getTableHeader().setOpaque(false);
//        tbl.setFillsViewportHeight(true);
//        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
//        tbl.getTableHeader().setForeground(Color.WHITE);
//        tbl.setSelectionBackground(new Color(52, 152, 219));
//
//        // Add table vào ScrollPane
//        JScrollPane scroll = new JScrollPane(tbl);
//        scroll.setBounds(new Rectangle(30, 270, this.DEFAULT_WIDTH - 400, 400));
//        scroll.setBackground(null);
//
//        add(scroll);
//
//        //Nhấp vào dòng nào là đẩy data lên textfield
//        tbl.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                int i = tbl.getSelectedRow();
//                if (i == -1) {
//                    return;
//                }
//                if (tbl.getRowSorter() != null) {
//                    i = tbl.getRowSorter().convertRowIndexToModel(i);
//                }
//                txtMaPNH.setText(tbl.getModel().getValueAt(i, 0).toString());
//                try {
//                    txtMaNCC.setText(tbl.getModel().getValueAt(i, 1).toString());
//                } catch (NullPointerException ex) {
//                    txtMaNCC.setText("");
//                }
//                txtMaNV.setText(tbl.getModel().getValueAt(i, 2).toString());
//                txtNgayHD.setText(tbl.getModel().getValueAt(i, 3).toString());
//                txtTongTien.setText(tbl.getModel().getValueAt(i, 4).toString());
//            }
//        });
//        /**
//         * ********************* SORT TABLE ****************************
//         */
//        JPanel sort = new JPanel(null);
//        sort.setBackground(null);
//        sort.setBounds(30, 170, this.DEFAULT_WIDTH - 400, 140);
//
//        /**
//         * ****** SORT THỜI GIAN *************
//         */
//        JLabel sortTime = new JLabel("Thời gian :");
//        sortTime.setFont(font0);
//        sortTime.setBounds(0, 40, 80, 30);
//        sort.add(sortTime);
//        // Choice Tháng
//        int month = Calendar.getInstance().get(Calendar.MONTH);// Lấy tháng hiện tại
//        monthChoice = new Choice();
//        monthChoice.setFont(font0);
//        monthChoice.add("Không");
//        for (int i = 1; i <= 12; i++) {
//            monthChoice.add("Tháng " + i);
//        }
//        monthChoice.select(0);
//        monthChoice.setBounds(new Rectangle(80, 42, 90, 40));
//        sort.add(monthChoice);
//        // Choice Năm
//        int year = Calendar.getInstance().get(Calendar.YEAR);//Lấy năm hiện tại
//        yearChoice = new Choice();
//        yearChoice.setFont(font0);
//        yearChoice.add("Không");
//        for (int i = year; i >= 1999; i--) {
//            yearChoice.add(String.valueOf(i));
//        }
//        yearChoice.select(0);
//        yearChoice.setBounds(new Rectangle(170, 42, 80, 40));
//        sort.add(yearChoice);
//
//        /**
//         * ********** SORT THEO GIÁ **************
//         */
//        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
//        sortPrice.setFont(font0);
//        sortPrice.setBounds(300, 40, 80, 30);
//        sort.add(sortPrice);
//
//        txtMinPrice = new JTextField();
//        txtMinPrice.setFont(font0);
//        txtMinPrice.setBounds(new Rectangle(380, 42, 100, 26));
//        txtMinPrice.setInputVerifier(new MyInputVerifier());
//        sort.add(txtMinPrice);
//
//        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
//        sepPrice.setBounds(490, 56, 10, 6);
//        sort.add(sepPrice);
//
//        txtMaxPrice = new JTextField();
//        txtMaxPrice.setFont(font0);
//        txtMaxPrice.setBounds(new Rectangle(510, 42, 100, 26));
//        txtMaxPrice.setInputVerifier(new MyInputVerifier());
//        sort.add(txtMaxPrice);
//        /**
//         * ********** SORT MÃ SP **************
//         */
//        JLabel sortPN = new JLabel("Mã PN :");
//        sortPN.setFont(font0);
//        sortPN.setBounds(650, 40, 60, 30);
//        sort.add(sortPN);
//
//        txtMaPN = new JTextField();
//        txtMaPN.setFont(font0);
//        txtMaPN.setBounds(new Rectangle(700, 42, 100, 26));
//        txtMaPN.setInputVerifier(new MyInputVerifier());
//        sort.add(txtMaPN);
////        /******************************************/
//        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
//        btnSearch.setBounds(new Rectangle(840, 20, 63, 63));
//        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnSearch.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                txtTongTien.requestFocus();
//                search();
//            }
//        });
//        sort.add(btnSearch);
//
//        add(sort);
//
//    }
//
//    public void search() {
//        int maPNH = txtMaPN.getText().equals("") ? 0 : Integer.parseInt(txtMaPN.getText());
//        int mm = monthChoice.getSelectedIndex() - 1;
//        int yyyy;
//        try {
//            yyyy = Integer.parseInt(yearChoice.getSelectedItem());
//        } catch (NumberFormatException ex) {
//            yyyy = 0;
//        }
//        double max = txtMaxPrice.getText().equals("") ? 99999999 : Double.parseDouble(txtMaxPrice.getText());
//        double min = txtMinPrice.getText().equals("") ? 0 : Double.parseDouble(txtMinPrice.getText());
//
//        outModel(model, pnhBUS.search(mm, yyyy, max, min, maPNH));
//    }
//
//    public void cleanView() {
//        txtMaPNH.setText("");
//        txtMaNCC.setText("");
//        txtMaNV.setText("");
//        txtNgayHD.setText("");
//        txtTongTien.setText("");
//    }
//
//    public void outModel(DefaultTableModel model, ArrayList<PhieuNhapHangDTO> hd) {     //xuat tu arraylist len table
//        Vector data;
//        model.setRowCount(0);
//        for (PhieuNhapHangDTO h : hd) {
//            data = new Vector();
//            data.add(h.getId_PNH());
//            data.add(h.getId_NCC());
//            data.add(h.getId_NV());
//            data.add(h.getDate_add());
//            data.add(h.getTotal_money());
//            model.addRow(data);
//        }
//        tbl.setModel(model);
//    }
//
//    public void list() // Chép ArrayList lên table
//    {
//        if (pnhBUS.getPnhBUS() == null) {
//            pnhBUS.list();
//        }
//        ArrayList<PhieuNhapHangDTO> hd = (ArrayList<PhieuNhapHangDTO>) pnhBUS.getPnhBUS();
//        model.setRowCount(0);
//        outModel(model, hd);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnMaNV) // Suggest Nhan Vien
//        {
//            if (!txtMaNV.getText().equals("") && !txtMaNCC.getText().equals("")) {
//                return;
//            }
//            SuggestNhanVien rm = new SuggestNhanVien();
//            String s = rm.getTextFieldContent();
//            txtMaNV.setText(s);
//        }
//
//        if (e.getSource() == btnMaNCC) // Suggest Nha cung cap
//        {
//            if (!txtMaNCC.getText().equals("") && !txtMaNV.getText().equals("")) {
//                return;
//            }
//            SuggestNhaCungCap rm = new SuggestNhaCungCap();
//            String s = rm.getTextFieldContent();
//            txtMaNCC.setText(s);
//        }
//
//        if (e.getSource() == btnClear) // Suggest Nha cung cap
//        {
//            cleanView();
//        }
//    }
//}
