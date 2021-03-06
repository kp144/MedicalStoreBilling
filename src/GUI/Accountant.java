/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Accountant.java
 *
 * Created on Nov 4, 2009, 4:24:18 PM
 */

package GUI;
import Business.CustomerManage;
import Business.OrderManage;
import Business.UserManage;
import Data.msbsOrders;
import Data.msbsUser;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
/**
 *
 * @author Administrator
 */
public class Accountant extends javax.swing.JFrame {

    /** Creates new form Accountant */
    public Accountant() {
        initComponents();
        mnSystem.setMnemonic('S');
        mnHelp.setMnemonic('H');
        miLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        lbName.setText(Login.userLogged.getNameLogin());
        getTodayTransfer();
    }

    public void getTodayTransfer() {
        Vector<msbsOrders> allOrder = new Vector<msbsOrders>();
        allOrder = new OrderManage().getOrdersByStatus(0);
        DefaultTableModel modelCompList = new DefaultTableModel();
        modelCompList.addColumn("Order Code");
        modelCompList.addColumn("Status");
        modelCompList.addColumn("Customer");
        modelCompList.addColumn("Seller");
        modelCompList.addColumn("Date Order");
        modelCompList.addColumn("Expired Date");
        modelCompList.addColumn("Total Cost");
        modelCompList.addColumn("Paid Money");
        Date current = new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(current);
        int totalBill = 0;
        for (msbsOrders od : allOrder) {
//            if ((custMn.getCustomerByCode(od.getCustomerCode()).getCustomerName()).toLowerCase().matches(".*" + custName + ".*") &&
//                    (custMn.getCustomerByCode(od.getCustomerCode()).getCustomerType()).toLowerCase().matches(".*" + type.toLowerCase() + ".*")) {
            if (df.format(od.getExpiredTime()).equals(today)) {

                Vector newData = new Vector();
                newData.add(od.getOrderCode());
                newData.add("WARNING!!!");
                newData.add(new CustomerManage().getCustomerByCode(od.getCustomerCode()).getCustomerName());
                newData.add(new UserManage().getUserByCode(od.getUserCode()).getFullName());
                newData.add(od.getOrderDate());
                newData.add(od.getExpiredTime());
                newData.add((double) od.getTotal());
                newData.add(od.getPaidMoney());
                modelCompList.addRow(newData);
                totalBill++;
//            }
            }


        }
        tblReminder.setModel(modelCompList);
        
        tblReminder.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblReminder.getColumnModel().getColumn(0).setMinWidth(0);
        tblReminder.getColumnModel().getColumn(0).setMaxWidth(0);
        lblTotalBills.setText(String.valueOf(totalBill));
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReminder = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblTotalBills = new javax.swing.JLabel();
        tbnCompDetails = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnSystem = new javax.swing.JMenu();
        miLogOut = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        mnHelp = new javax.swing.JMenu();
        miHelp = new javax.swing.JMenuItem();
        miAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACCOUNTANT - MSBS");
        setLocationByPlatform(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/accountant.png"))); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 11));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        try{
            jPanel1 = new ReportCreateModule();
        }catch(UnsupportedLookAndFeelException e){}

        jTabbedPane1.addTab("  Report", new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/report.png")), jPanel1); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Today Transfer ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 51, 102))); // NOI18N

        tblReminder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer", "Seller", "Order Date", "Expired Date", "Total Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReminder.getTableHeader().setReorderingAllowed(false);
        tblReminder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblReminderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblReminder);

        jLabel5.setText("Total Bills: ");

        lblTotalBills.setText("0");

        tbnCompDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/edit.png"))); // NOI18N
        tbnCompDetails.setText("Bills Details");
        tbnCompDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnCompDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalBills, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 637, Short.MAX_VALUE)
                .addComponent(tbnCompDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTotalBills)
                    .addComponent(tbnCompDetails)))
        );

        jTabbedPane2.addTab("Today Transfer", new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/today_icon.png")), jPanel6); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        jPanel2 = new PaymentModule();

        jTabbedPane2.addTab("All Order", new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/BillList.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Order", new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/Drug-basket-48.png")), jPanel4); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        jPanel3 = new PurchaseModule();

        jTabbedPane1.addTab("Purchasal", new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/property_details_48.png")), jPanel3); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Angsana New", 1, 24));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/welcome.png"))); // NOI18N

        lbName.setFont(new java.awt.Font("Monotype Corsiva", 1, 18));
        lbName.setForeground(new java.awt.Color(0, 51, 102));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("ChangePass");
        jButton1.setToolTipText("Change your password here");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        mnSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/systemicon.png"))); // NOI18N
        mnSystem.setText("System");

        miLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/logout.png"))); // NOI18N
        miLogOut.setText("Logout");
        miLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogOutActionPerformed(evt);
            }
        });
        mnSystem.add(miLogOut);

        miExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/exit.png"))); // NOI18N
        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mnSystem.add(miExit);

        jMenuBar1.add(mnSystem);

        mnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/help.png"))); // NOI18N
        mnHelp.setText("Help");
        mnHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/information.png"))); // NOI18N
        miHelp.setText("Help Topics");
        miHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHelpActionPerformed(evt);
            }
        });
        mnHelp.add(miHelp);

        miAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/about.png"))); // NOI18N
        miAbout.setText("About Us");
        miAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutActionPerformed(evt);
            }
        });
        mnHelp.add(miAbout);

        jMenuBar1.add(mnHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Do you want exit !!!");
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
}//GEN-LAST:event_miExitActionPerformed

    private void miLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login login = null;
        try {
            login = new Login();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        login.setVisible(true);
}//GEN-LAST:event_miLogOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UserManage userMn = new UserManage();
        user = userMn.getUserByCode(userMn.getCodeByName(Login.userLogged.getNameLogin()));
        ChangePasswordForm chgPassForm = new ChangePasswordForm(this.frmParent,true,user);
        chgPassForm.setLocationRelativeTo(this);
        chgPassForm.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

    private void miAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutActionPerformed
        // TODO add your handling code here:
        AboutUsForm ab = new AboutUsForm(this.frmParent,true);
        ab.setLocationRelativeTo(this);
        ab.setVisible(true);
}//GEN-LAST:event_miAboutActionPerformed

    private void miHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHelpActionPerformed
        // TODO add your handling code here:

        Runtime rt = Runtime.getRuntime();
        try {
            String filePath = "msbsUserGuide.chm";
            rt.exec("hh.exe "+filePath);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Cannot load help file!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miHelpActionPerformed

    private void tblReminderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReminderMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() > 1) {
            tblReminder.removeEditor();
            ViewOrderDetailForm tardyDetails = new ViewOrderDetailForm(frmParent, true, new OrderManage().getOrdersByOrderCode(String.valueOf(tblReminder.getValueAt(tblReminder.getSelectedRow(), 0))),"");
            tardyDetails.setLocationRelativeTo(this);
            tardyDetails.setVisible(true);

        }
}//GEN-LAST:event_tblReminderMousePressed

    private void tbnCompDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnCompDetailsActionPerformed
        // TODO add your handling code here:
        if (tblReminder.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Select a bill in Bills List to view details! ");
        } else if (tblReminder.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(this, "Do not select more one bill !");
        } else {
            ViewOrderDetailForm tardyDetails = new ViewOrderDetailForm(frmParent, true, new OrderManage().getOrdersByOrderCode(String.valueOf(tblReminder.getValueAt(tblReminder.getSelectedRow(), 0))),"");
            tardyDetails.setLocationRelativeTo(this);
            tardyDetails.setVisible(true);
        }
}//GEN-LAST:event_tbnCompDetailsActionPerformed

    /**
    * @param args the command line arguments
    */
    private JFrame frmParent;
    private msbsUser user;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lblTotalBills;
    private javax.swing.JMenuItem miAbout;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miHelp;
    private javax.swing.JMenuItem miLogOut;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenu mnSystem;
    private javax.swing.JTable tblReminder;
    private javax.swing.JButton tbnCompDetails;
    // End of variables declaration//GEN-END:variables

}
 class FreeChart {

    private static JFreeChart createChart(XYDataset dataset,String title)
    {

            JFreeChart chart = ChartFactory.createTimeSeriesChart(
                title,  // title
                "Date",             // x-axis label
                "Quantity",   // y-axis label
                dataset,            // data
                true,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
            );

            chart.setBackgroundPaint(Color.white);

            XYPlot plot = (XYPlot) chart.getPlot();
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);
            plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
            plot.setDomainCrosshairVisible(true);
            plot.setRangeCrosshairVisible(true);

            XYItemRenderer r = plot.getRenderer();
            if (r instanceof XYLineAndShapeRenderer)
            {
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
                renderer.setBaseShapesVisible(true);
                renderer.setBaseShapesFilled(true);
                renderer.setDrawSeriesLineAsPath(true);
            }

            DateAxis axis = (DateAxis) plot.getDomainAxis();
            axis.setDateFormatOverride(new SimpleDateFormat("dd"));

            return chart;
    }

    private static XYDataset createDataset(ArrayList<ArrayList>arr)
    {
        ArrayList<Integer> ar = null;
        TimeSeries s0 = new TimeSeries("", Day.class);
        for(int i=0;i<arr.size();i++)
        {
            ar=arr.get(i);
            int day = ar.get(0);
            int month = ar.get(1);
            int year = ar.get(2);
            int value = ar.get(3);
            Day date = new Day(day, month, year);
            s0.add(date,value);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s0);

        return dataset;
    }

    public static JPanel createDemoPanel(ArrayList<ArrayList> arr,String title)
    {
        JFreeChart chart = createChart(createDataset(arr),title);
        return new ChartPanel(chart);
    }
}