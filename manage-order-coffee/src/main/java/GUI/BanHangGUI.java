/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.CustomerBLL;
import BLL.OrderBLL;
import BLL.OrderDetailBLL;
import BLL.SanPhamBLL;
import GUI.model.Page404;
import hibernate.entities.Customer;
import hibernate.entities.Order;
import hibernate.entities.OrderDetail;
import hibernate.entities.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * @author ACER
 */
public class BanHangGUI extends JPanel implements ActionListener, KeyListener {

    private String userID;
    private int DEFALUT_WIDTH;

    //variable BUS
    private OrderBLL hdBUS = new OrderBLL();
    private SanPhamBLL spBUS = new SanPhamBLL();
    private CustomerBLL khBUS = new CustomerBLL();
    private OrderDetailBLL ctBUS = new OrderDetailBLL(1);
    private ArrayList<OrderDetail> dsct = new ArrayList<>();

    int idKey = (int) (ctBUS.getCountOrderDetail() + 1);

    //variable of JPanel
    private JTextField txtMaHD;
    private JTextField txtMaKH;
    private JTextField txtMaNV;
    private JTextField txtNgayHD;
    private JTextField txtTongTien;
    private JTextField txtMaSP;
    private JTextField txtCTSL;
    private JButton btnMaSP;
    private JTextField txtCTGia;
    private JTextField txtCTTenSP;
    private JButton btnAddCT;
    private JButton btnNewHD;
    private JButton btnConfirm;
    private DefaultTableModel model;
    private JTable tbl;
    private JLabel imgSP;
    private JPanel chiTietView;
    private JButton btnDeleteHD;
    private JButton btnEdit;
    private JButton btnRemove;
    private Page404 page;
    private JButton btnMaKH;
    private boolean flag = true;

    public BanHangGUI(int width, String userID) {
        this.userID = userID;
        DEFALUT_WIDTH = width;
        hdBUS.list();
        spBUS.loadData();
        init();
    }

    public BanHangGUI(int width) {
        DEFALUT_WIDTH = width;
        hdBUS.list();
        spBUS.loadData();
        init();
    }

    public void init() {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        /**
         * ********************* PHẦN VIEW THÔNG TIN HD
         * ****************************
         */
        JPanel hdView = new JPanel(null);
        hdView.setBackground(null);
        hdView.setBounds(new Rectangle(30, 40, this.DEFALUT_WIDTH - 350, 150));

        JLabel lbMaHD = new JLabel("Mã HD");
        lbMaHD.setFont(font0);
        lbMaHD.setBounds(0, 0, 55, 30);
        txtMaHD = new JTextField(hdBUS.remindMaHD());
        txtMaHD.setHorizontalAlignment(JTextField.CENTER);
        txtMaHD.setFont(font0);
        txtMaHD.setEnabled(false);
        txtMaHD.setBounds(new Rectangle(55, 0, 120, 30));
        txtMaHD.addKeyListener(this);
        hdView.add(lbMaHD);
        hdView.add(txtMaHD);

        JLabel lbMaKH = new JLabel("Mã KH");
        lbMaKH.setFont(font0);
        lbMaKH.setBounds(195, 0, 60, 30);
        txtMaKH = new JTextField();
        txtMaKH.setHorizontalAlignment(JTextField.CENTER);
        txtMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(255, 0, 100, 30));
        txtMaKH.setEnabled(false);
        txtMaKH.addKeyListener(this);
        hdView.add(lbMaKH);
        hdView.add(txtMaKH);
        btnMaKH = new JButton("+");
        btnMaKH.setBackground(new Color(131, 149, 167));
        btnMaKH.setBounds(new Rectangle(355, 0, 30, 30));
        btnMaKH.addActionListener(this);
        hdView.add(btnMaKH);

        JLabel lbMaNV = new JLabel("Mã NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(415, 0, 60, 30);
        txtMaNV = new JTextField();
        txtMaNV.setText(String.valueOf(1));
        txtMaNV.setHorizontalAlignment(JTextField.CENTER);
        txtMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(475, 0, 100, 30));
        txtMaNV.setEditable(false);
        txtMaNV.setText("1");
        txtMaNV.addKeyListener(this);
        hdView.add(lbMaNV);
        hdView.add(txtMaNV);

        JLabel lbTongTien = new JLabel("Tổng Tiền (VNĐ)");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(625, 0, 120, 30);
        txtTongTien = new JTextField("0");
        txtTongTien.setEditable(false);
        txtTongTien.setHorizontalAlignment(JTextField.CENTER);
        txtTongTien.setFont(font0);
        txtTongTien.setBounds(new Rectangle(745, 0, 150, 30));
        hdView.add(lbTongTien);
        hdView.add(txtTongTien);

        JLabel lbNgayHD = new JLabel("Ngày Lập HD");
        lbNgayHD.setFont(font0);
        lbNgayHD.setBounds(0, 50, 100, 30);
        txtNgayHD = new JTextField();
        txtNgayHD.setEditable(false);
        txtNgayHD.setHorizontalAlignment(JTextField.CENTER);
        txtNgayHD.setFont(font0);
        txtNgayHD.setBounds(new Rectangle(90, 50, 350, 30));
        hdView.add(lbNgayHD);
        hdView.add(txtNgayHD);

        btnNewHD = new JButton("Tạo hóa đơn");
        btnNewHD.setFont(font0);
        btnNewHD.setBackground(new Color(131, 149, 167));
        btnNewHD.setBounds(new Rectangle(500, 50, 200, 30));
        btnNewHD.addActionListener(this);
        hdView.add(btnNewHD);

        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setFont(font0);
        btnConfirm.addActionListener(this);
        btnConfirm.setVisible(false);
        btnConfirm.setBackground(new Color(131, 149, 167));
        btnConfirm.setBounds(new Rectangle(500, 50, 150, 30));
        hdView.add(btnConfirm);

        btnDeleteHD = new JButton("Hủy hóa đơn");
        btnDeleteHD.setFont(font0);
        btnDeleteHD.setBounds(new Rectangle(700, 50, 150, 30));
        btnDeleteHD.setBackground(new Color(131, 149, 167));
        btnDeleteHD.addActionListener(this);
        btnDeleteHD.setVisible(false);
        hdView.add(btnDeleteHD);

        JSeparator sepHD = new JSeparator(0);
        sepHD.setBounds(new Rectangle(0, 120, this.DEFALUT_WIDTH - 350, 3));
        hdView.add(sepHD);

        add(hdView);
        /**
         * ********************* PHẦN VIEW THÔNG TIN CHI TIẾT
         * ****************************
         */
        page = new Page404(WIDTH, "Tạo hóa đơn");
        page.setBounds(new Rectangle(50, 0, DEFALUT_WIDTH - 60, 500));
        add(page);

        chiTietView = new JPanel(null);
        chiTietView.setVisible(false);
        chiTietView.setBackground(null);
        chiTietView.setBounds(new Rectangle(30, 190, DEFALUT_WIDTH - 60, 500));

        imgSP = new JLabel();
        imgSP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(155, 155, 155)));
        imgSP.setBounds(new Rectangle(0, 0, 280, 230));
        imgSP.setHorizontalAlignment(JLabel.CENTER);
        chiTietView.add(imgSP);

        JLabel lbMaSP = new JLabel("Mã SP");
        lbMaSP.setFont(font0);
        lbMaSP.setBounds(0, 240, 55, 30);
        txtMaSP = new JTextField();
        txtMaSP.setHorizontalAlignment(JTextField.CENTER);
        txtMaSP.setFont(font0);
        txtMaSP.setBounds(new Rectangle(60, 240, 70, 30));
        txtMaSP.setEditable(false);
        txtMaSP.addKeyListener(this);

        chiTietView.add(lbMaSP);
        chiTietView.add(txtMaSP);

        btnMaSP = new JButton("+");
        btnMaSP.setBounds(new Rectangle(130, 240, 30, 30));
        btnMaSP.setBackground(new Color(131, 149, 167));
        btnMaSP.addActionListener(this);
        chiTietView.add(btnMaSP);

        JLabel lbCTTenSP = new JLabel("Tên SP");
        lbCTTenSP.setFont(font0);
        lbCTTenSP.setBounds(0, 280, 50, 30);
        txtCTTenSP = new JTextField();
        txtCTTenSP.setEditable(false);
        txtCTTenSP.setHorizontalAlignment(JTextField.CENTER);
        txtCTTenSP.setFont(font0);
        txtCTTenSP.setBounds(new Rectangle(60, 280, 220, 30));
        txtCTTenSP.setEditable(false);
        chiTietView.add(lbCTTenSP);
        chiTietView.add(txtCTTenSP);

        JLabel lbCTGia = new JLabel("Đơn giá");
        lbCTGia.setFont(font0);
        lbCTGia.setBounds(0, 320, 60, 30);
        txtCTGia = new JTextField();
        txtCTGia.setEditable(false);
        txtCTGia.setHorizontalAlignment(JTextField.CENTER);
        txtCTGia.setFont(font0);
        txtCTGia.setBounds(new Rectangle(60, 320, 220, 30));
        txtCTGia.setEditable(false);
        chiTietView.add(lbCTGia);
        chiTietView.add(txtCTGia);

        JLabel lbCTSL = new JLabel("Số lượng");
        lbCTSL.setFont(font0);
        lbCTSL.setBounds(170, 240, 60, 30);
        txtCTSL = new JTextField();
        txtCTSL.setHorizontalAlignment(JTextField.CENTER);
        txtCTSL.setFont(font0);
        txtCTSL.addKeyListener(this);
        txtCTSL.setBounds(new Rectangle(230, 240, 50, 30));
        txtCTSL.setInputVerifier(new MyInputVerifier());
        chiTietView.add(lbCTSL);
        chiTietView.add(txtCTSL);

        btnAddCT = new JButton("Thêm");
        btnAddCT.setFont(font0);
        btnAddCT.addActionListener(this);
        btnAddCT.setBackground(new Color(131, 149, 167));
        btnAddCT.setBounds(new Rectangle(0, 360, 80, 30));
        chiTietView.add(btnAddCT);

        btnEdit = new JButton("Sửa");
        btnEdit.setFont(font0);
        btnEdit.addActionListener(this);
        btnEdit.setBackground(new Color(131, 149, 167));
        btnEdit.setBounds(new Rectangle(300, 420, 150, 40));
        chiTietView.add(btnEdit);

        btnRemove = new JButton("Xóa sản phẩm");
        btnRemove.setFont(font0);
        btnRemove.addActionListener(this);
        btnRemove.setBackground(new Color(131, 149, 167));
        btnRemove.setBounds(new Rectangle(500, 420, 150, 40));
        chiTietView.add(btnRemove);

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
        header.add("Số lượng");
        header.add("Thành Tiền");
        model = new MyTable(header, 0) {
            public Class getColumnClass(int column) {
                switch (column) {
                    case 2:
                        return Float.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Float.class;
                    default:
                        return String.class;
                }
            }

        };
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        // Chỉnh width các cột
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(20);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(30);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(1).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(4).setCellRenderer(centerAlign);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
//        tbl.getTableHeader().setBackground(new Color(232, 57, 99));
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(300, 0, this.DEFALUT_WIDTH - 650, 400));
        scroll.setBackground(null);

        chiTietView.add(scroll);
        add(chiTietView);
        setVisible(true);
    }

    public void outModel(DefaultTableModel model, ArrayList<OrderDetail> ds) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (OrderDetail sp : ds) {
            data = new Vector();
            data.add(sp.getProduct().getId());
            data.add(sp.getName());
            data.add(sp.getPrice());
            data.add(sp.getAmount());
            data.add(sp.getPrice() * sp.getAmount());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public float sumHD() {
        float sum = 0;
        for (OrderDetail sp : dsct) {
            int sl = sp.getAmount();
            float gia = sp.getPrice();
            sum += sl * gia;
        }
        return sum;
    }

    public void blockHD(boolean flag) {
        txtMaHD.setEditable(flag);
        txtMaKH.setEditable(flag);
        txtMaNV.setEditable(flag);
        txtNgayHD.setEditable(flag);
    }

    public void clear(boolean flag) {
        if (flag) {
            // PHẦN HÓA ĐƠN
            txtMaHD.setText(hdBUS.remindMaHD());
            txtMaKH.setText("");
            txtMaNV.setText("");
//            if( userID != null ) txtMaNV.setText(userID);
            txtTongTien.setText("0");
            txtNgayHD.setText("");

            //PHẦN CHITIET
            dsct.removeAll(dsct);
            txtMaSP.setText("");
            txtCTTenSP.setText("");
            txtCTSL.setText("");
            txtCTGia.setText("");
            imgSP.setIcon(null);

            model.getDataVector().removeAllElements(); //Xóa trằng table
        }
    }

    public void reset(boolean flag) {
        btnNewHD.setVisible(flag);
        btnConfirm.setVisible(!flag);
        btnDeleteHD.setVisible(!flag);
        clear(flag);
        blockHD(flag);

        chiTietView.setVisible(!flag);
        page.setVisible(flag);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMaKH) // Suggest Nhan Vien
        {
            if (flag) {
                SuggestKhachHang rm = new SuggestKhachHang();
                String s = rm.getTextFieldContent();
                txtMaKH.setText(s);
            }
        }
        if (e.getSource().equals(btnMaSP)) // Suggest San Pham
        {
            // Lấy data và gắn lên TextField vs Hình
            SuggestSanPham rm = new SuggestSanPham(txtMaSP.getText());
            String[] s = rm.getTextFieldContent().split("%");
            txtMaSP.setText(s[0]);
            txtCTTenSP.setText(s[1]);
            txtCTGia.setText(s[2]);
            Image newImage;
            try {
                newImage = new ImageIcon("./src/main/java/image/SanPham/" + s[3]).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
            } catch (NullPointerException E) {
                newImage = new ImageIcon("./src/main/java/image/SanPham/NoImage.jpg").getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
            }
            imgSP.setIcon(new ImageIcon(newImage));

            //Chỉnh Focus vào txtCTSL
            txtCTSL.requestFocus();
        }
        if (e.getSource().equals(btnAddCT)) // Thêm Sản Phẩm
        {
            int sl = 0;
            try {
                sl = Math.abs(Integer.parseInt(txtCTSL.getText()));
            } catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra số lượng

            float gia = Float.parseFloat(txtCTGia.getText());

            //Kiểm tra đã có trong giỏ chưa
            boolean flag = true;
            for (OrderDetail sp : dsct) {
                if (Integer.parseInt(txtMaSP.getText()) == (sp.getProduct().getId())) {
                    sp.setAmount(sp.getAmount() + Integer.parseInt(txtCTSL.getText()));

                    flag = false;
                    txtMaSP.setText(null);
                    txtCTSL.setText(null);
                    txtCTTenSP.setText(null);
                    txtCTGia.setText(null);
                    imgSP.setIcon(null);
                    break;
                }
            }
            outModel(model, dsct);
            if (flag) {

                Order order = new OrderBLL().getOrderById(Integer.parseInt(txtMaHD.getText()));
                Product product = new SanPhamBLL().getProductById(Integer.parseInt(txtMaSP.getText()));

                dsct.add(new OrderDetail(idKey, order, product, txtCTTenSP.getText(), sl, gia));
                idKey++;

//                for (OrderDetail od : dsct) {
//                    System.out.println(od);
//                }
                txtMaSP.setText(null);
                txtCTSL.setText(null);
                txtCTTenSP.setText(null);
                txtCTGia.setText(null);
                imgSP.setIcon(null);
            }
            outModel(model, dsct);
            txtTongTien.setText(String.valueOf(sumHD()));
        }

        if (e.getSource().equals(btnNewHD)) // Tạo hóa đơn
        {
            Date date = Timestamp.valueOf(LocalDateTime.now());
            if (txtMaHD.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã hóa đơn", "Thông báo", 0);
                txtMaHD.requestFocus();
                return;
            } else if (hdBUS.check(txtMaHD.getText())) {
                JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại", "Thông báo", 2);
                txtMaHD.requestFocus();
                txtMaHD.setText(hdBUS.remindMaHD());
                return;
            }

            if (txtMaKH.getText().isEmpty()) {
                txtMaKH.setText("1");
            }

            if (txtMaNV.getText().isEmpty()) {
                txtMaNV.setText("1");
            }

            txtNgayHD.setText(date.toString());
            reset(false);
            flag = false;
            txtMaSP.requestFocus();

//          ----------  Khởi tạo hóa đơn  -----------
              int maHD = Integer.parseInt(txtMaHD.getText().trim());
            int maKH = Integer.parseInt(txtMaKH.getText().trim());
            int maNV = Integer.parseInt(txtMaNV.getText().trim());
            Timestamp stamp = Timestamp.valueOf(txtNgayHD.getText());
            Date ngayHD = new Date(stamp.getTime());
            float tongTien = Float.parseFloat(txtTongTien.getText());
            Customer customer = khBUS.getCustomerById(maKH);
            List<OrderDetail> orderDetail = ctBUS.getCt_hdBLL();
            Order hd = new Order(maHD, tongTien, ngayHD, maNV, customer, orderDetail);
            hdBUS.insertOrder(hd);
        }

        if (e.getSource().equals(btnDeleteHD)) //Hủy HD
        {
            flag = true;
            reset(true);
        }

         if (e.getSource().equals(btnConfirm)) //Xác nhận
        {
            if (dsct.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm", "Thông báo", 0);
                return;
            }

            for (OrderDetail ct : dsct) {
                ctBUS.insertOrderDetail(ct);
            }
            int maKH = Integer.parseInt(txtMaKH.getText().trim());
            int maNV = Integer.parseInt(txtMaNV.getText().trim());
            Timestamp stamp = Timestamp.valueOf(txtNgayHD.getText());
            Date ngayHD = new Date(stamp.getTime());
            float tongTien = Float.parseFloat(txtTongTien.getText());
            Customer customer = khBUS.getCustomerById(maKH);
            List<OrderDetail> orderDetail = ctBUS.getCt_hdBLL();

            Order hd = new Order(Integer.parseInt(txtMaHD.getText()), tongTien, ngayHD, maNV, customer, orderDetail);
            hdBUS.updatetOrder(hd);
            JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công !!!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            flag = true;
            reset(true);
        }
        if (e.getSource().equals(btnEdit)) //Sửa sl trong Chitiet sp
        {
            try {
                int i = tbl.getSelectedRow();
                if (tbl.getRowSorter() != null) {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                String masp = tbl.getModel().getValueAt(i, 0).toString();
                int sl = Math.abs(Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm :")));
                for (OrderDetail ct : dsct) {
                    if (ct.getProduct().getId() == Integer.parseInt(masp)) {
                        ct.setAmount(sl);
                    }
                }
                outModel(model, dsct);
            } catch (IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm");
            }
            txtTongTien.setText(String.valueOf(sumHD()));
        }
        if (e.getSource().equals(btnRemove)) // Xóa SP trong CT SP
        {
            try {
                int i = tbl.getSelectedRow();
                if (tbl.getRowSorter() != null) {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                dsct.remove(i);
                model.removeRow(i);
                txtTongTien.setText(String.valueOf(sumHD()));
            } catch (IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm cần xóa");
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object a = e.getSource();
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (a.equals(txtMaHD) || a.equals(txtMaKH) || a.equals(txtMaNV)) //Enter TXT ở Hóa Đơn
            {
                btnNewHD.doClick();
            } else if (a.equals(txtMaSP)) //Enter MASP
            {
                try {
                    Product sp = spBUS.getProductById(Integer.parseInt(txtMaSP.getText()));
                    Image img = new ImageIcon("./src/main/java/image/SanPham/" + sp.getImage()).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                    imgSP.setIcon(new ImageIcon(img));
                    txtCTTenSP.setText(sp.getName());
                    txtCTGia.setText(String.valueOf(sp.getPrice()));
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại");
                }
            } else if (a.equals(txtCTSL)) //Enter SL
            {
                btnAddCT.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
