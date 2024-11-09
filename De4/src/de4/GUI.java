/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class GUI extends JFrame{
    private JLabel lbIDDH,lbTenKH,lbIDKH,lbTenSP,lbGia,lbHan;
    private JTextField txtIDDH, txtIDKH, txtTenKH,txtTenSP,txtGia,txtHan;
    private JPanel pn;
    private JTable tb;
    private JButton btnSua;
    private JScrollPane scrollPane;
    XLDonHang xl = new XLDonHang();
//    String[] header ={"IDDH","IDKH","Ten KH","Ten Sp","Gia","Han"};
//    private DefaultTableModel model = new DefaultTableModel(header,0);
    public GUI(){
        
        lbIDDH = new JLabel("ID Don Hang");
        lbIDKH = new JLabel("ID Khach Hang");
        lbTenKH = new JLabel("Ten Kh");
        lbTenSP = new JLabel("Ten SP");
        lbGia = new JLabel("Gia SP");
        lbHan = new JLabel("Han sd");
        
        txtIDDH = new JTextField();
        txtIDKH= new JTextField();
        txtTenKH= new JTextField();
        txtTenSP= new JTextField();
        txtGia = new JTextField();
        txtHan= new JTextField();
        
        btnSua = new JButton("Sua DH");
        
        
        this.setLayout(null);
        lbIDDH.setBounds(20, 20,100,20);
        lbIDKH.setBounds(20, 50,100,20);
        lbTenKH.setBounds(20, 80,100,20);
        lbTenSP.setBounds(20, 110,100,20);
        lbGia.setBounds(20, 140,100,20);
        lbHan.setBounds(20, 170,100,20);
        
        txtIDDH.setBounds(150,20,200,20);
        txtIDKH.setBounds(150,50,200,20);
        txtTenKH.setBounds(150,80,200,20);
        txtTenSP.setBounds(150,110,200,20);
        txtGia.setBounds(150,140,200,20);
        txtHan.setBounds(150,170,200,20);
        btnSua.setBounds(200, 200,100,50);
       
         String data[][]={};
        String column[]={"IDDH","IDKH","Ten KH","Ten Sp","Gia","Han"};
        DefaultTableModel df = new DefaultTableModel(data,column);
        tb = new JTable(df);
        JScrollPane jsp = new JScrollPane(tb);
        jsp.setBounds(100,250, 500, 500);
        Hienthi(df);
        
        this.btnSua.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               int row = tb.getSelectedRow();
               txtIDDH.setText(df.getValueAt(row, 0).toString());
               txtIDKH.setText(df.getValueAt(row, 1).toString());
               txtTenKH.setText(df.getValueAt(row, 2).toString());
               txtTenSP.setText(df.getValueAt(row, 3).toString());
               txtGia.setText(df.getValueAt(row, 4).toString());
               txtHan.setText(df.getValueAt(row, 5).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
       btnSua.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                df.setRowCount(0);
                Customer cs = new Customer();
                cs.setIDKH(txtIDKH.getText());
                cs.setTenKH(txtTenKH.getText());
                try {
                    xl.UpdateKhachHang(cs);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
       });
        
         this.add(lbIDDH);
        this.add(lbGia);
        this.add(lbHan);
        this.add(lbIDKH);
        this.add(lbTenKH);
        this.add(lbTenSP);
        this.add(txtGia);
        this.add(txtIDDH);
        this.add(txtHan);
        this.add(txtIDKH);
        this.add(txtTenKH);
        this.add(txtTenSP);
        this.add(btnSua);
        this.add(jsp);
        setTitle("Don Hang");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void Hienthi(DefaultTableModel df){
        df.setRowCount(0);
        df.fireTableDataChanged();;
        XLDonHang xl = new XLDonHang();
        xl.getConn();
        ArrayList<Order> od = xl.getOrder();
        for(Order order :od ){
            df.addRow(new String[] {order.getIDDH(),order.getCustomer().getIDKH(),order.getCustomer().getTenKH(),order.getItems().get(0).getTenSP(),String.valueOf(order.getItems().get(0).getGiaSP()),order.getItems().get(0).getDate()});
        }
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}

