///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package GUI;
//



import BLL.LoaiBLL;
import BLL.SanPhamBLL;
import BLL.OrderBLL;
import hibernate.entities.Order;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.BorderFactory.createLineBorder;

import javax.swing.JLabel;
import javax.swing.JPanel;
//import static oracle.jrockit.jfr.events.Bits.longValue;
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
  
  

/**
 *
 * @author ACER
 */
public class ThongKeGUI extends JPanel{

    private int DEFAUTL_WIDTH;
    private JLabel lbDateStart,lbDateEnd;
    private JPanel panel;
    private SanPhamBLL pro_bll=new SanPhamBLL();
    private LoaiBLL cate_bll=new LoaiBLL();
    private OrderBLL or_bll=new OrderBLL();
    private OrderBLL HD=new OrderBLL();

    
    public ThongKeGUI(int width) {
        this.DEFAUTL_WIDTH = width;
        init();
        text_loai.setText(String.valueOf(cate_bll.getCountCategory()));
        text_sanpham.setText(String.valueOf(pro_bll.getCountProduct()));
        text_donhang.setText(String.valueOf(or_bll.getCountOrder()));
        text_doanhthu.setText(String.valueOf(or_bll.getTotalRevenue())+" VND");
        setDataToChart(panelLineChart);
        
        
        
    }
    
    void setDataToChart(JPanel jp){
        
        List<Order> listOrder=(ArrayList<Order>) HD.getListOrder();
        if(listOrder!=null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(Order item : listOrder){
                dataset.addValue(item.getTotalPrice(),"Total",item.getCreatedDate());
            }
        
        
      
        
        //create chart
        JFreeChart chart = ChartFactory.createLineChart("THỐNG KÊ DOANH THU","Thời Gian","Doanh Thu (VND)",dataset);
        
        ChartPanel  chpn=new ChartPanel(chart);
        chpn.setPreferredSize(new Dimension(jp.getWidth(),450));
        
        jp.removeAll();
        jp.setLayout(new CardLayout());
        jp.add(chpn);
        jp.validate();
        jp.repaint();
    }
    }
    
    public void init(){   
    setSize(DEFAUTL_WIDTH, 700);
    setBackground(new Color(247, 241, 227));
    setLayout(null);
    
    Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
		
    panel = new JPanel();
    panel.setBounds(350, 65, 700, 450);
    panel.setBackground(new Color(247, 241, 227));
    
    jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        text_loai = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        text_donhang = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        text_doanhthu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        text_sanpham = new javax.swing.JLabel();
        panelLineChart = new javax.swing.JPanel();

        jButton1.setBackground(new java.awt.Color(115, 185, 66));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Đơn Hàng");
        jButton1.setAlignmentY(0.0F);
        jButton1.setAutoscrolls(true);
        jButton1.setBorderPainted(false);
        jButton1.setHideActionText(true);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(50, 14, 2, 14));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(104, 195, 241));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sản Phẩm");
        jButton3.setAlignmentY(0.0F);
        jButton3.setAutoscrolls(true);
        jButton3.setBorderPainted(false);
        jButton3.setHideActionText(true);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(50, 14, 2, 14));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 152, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Doanh Thu");
        jButton4.setAlignmentY(0.0F);
        jButton4.setAutoscrolls(true);
        jButton4.setBorderPainted(false);
        jButton4.setHideActionText(true);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(50, 14, 2, 14));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 85, 83));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Loại");
        jButton5.setAlignmentY(0.0F);
        jButton5.setAutoscrolls(true);
        jButton5.setBorderPainted(false);
        jButton5.setHideActionText(true);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMargin(new java.awt.Insets(50, 14, 2, 14));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 85, 83));

        text_loai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_loai.setForeground(new java.awt.Color(255, 255, 255));
        text_loai.setText("loai");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(text_loai)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_loai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(115, 185, 66));

        text_donhang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_donhang.setForeground(new java.awt.Color(255, 255, 255));
        text_donhang.setText("loai");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(text_donhang)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_donhang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 152, 153));

        text_doanhthu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_doanhthu.setForeground(new java.awt.Color(255, 255, 255));
        text_doanhthu.setText("loai");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(text_doanhthu)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_doanhthu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(104, 195, 241));

        text_sanpham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_sanpham.setForeground(new java.awt.Color(255, 255, 255));
        text_sanpham.setText("loai");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(text_sanpham)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_sanpham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLineChartLayout = new javax.swing.GroupLayout(panelLineChart);
        panelLineChart.setLayout(panelLineChartLayout);
        panelLineChartLayout.setHorizontalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLineChartLayout.setVerticalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JLabel text_doanhthu;
    private javax.swing.JLabel text_donhang;
    private javax.swing.JLabel text_loai;
    private javax.swing.JLabel text_sanpham;
    // End of variables declaration 
    
//    public void hienthichart(){
//        final long startTime = System.currentTimeMillis();
//            DefaultCategoryDataset dcd = new DefaultCategoryDataset();
//            LocalDate startDate = Instant.ofEpochMilli(txtDateStart.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//            LocalDate endDate = Instant.ofEpochMilli(txtDateEnd.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//            
//            //validation
//            if(endDate.isBefore(startDate)){
//                new Toast.ToastWarning("Ngày nhập không hợp lệ !!!", Toast.SHORT_DELAY);
//                return;
//            }
//
//            List<ThongKeDTO> tks = tkBUS.getChartByTime(startDate,endDate);
//            for(ThongKeDTO tk : tks){
//                dcd.setValue(tk.getDoanhThu(), "doanhthu", tk.getNameSP());
//                System.out.println(tk.getNameSP());
//            }
//            JFreeChart jchart = ChartFactory.createBarChart("Doanh Thu Bán Hàng", "Tên Sản Phẩm", "Doanh thu", dcd, PlotOrientation.VERTICAL, true, true, false);
//            ChartPanel chartPanel = new ChartPanel(jchart);
//
//            panel.removeAll();
//            panel.add(chartPanel);
//            final long endTime = System.currentTimeMillis();
//            System.out.println("Total execution time: " + (endTime - startTime));
////                add(chartPanel);
//    }
}
 