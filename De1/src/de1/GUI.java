/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel pnJPanel;
    private JTable tbJTable;
    private JTextField txtTen, txtMa,txtNganh;
    private JButton btnThem,btnCapnhat;
    private JLabel lbtenJLabel,lbMa,lbNganhJLabel;
    private  JScrollPane scrollPane;
    XLDL xl = new XLDL();
    public GUI(){
        lbtenJLabel = new JLabel("Ten SV");
        lbMa = new JLabel("Ma SV");
        lbNganhJLabel = new JLabel("Nganh Hoc");
        
        txtTen = new JTextField();
        txtMa = new JTextField();
        txtNganh = new JTextField();

        btnCapnhat = new JButton("Cap Nhat");
        btnThem = new JButton("Them SV");
 
        
        this.setLayout(null);
        
        lbtenJLabel.setBounds(20, 20,100,20);
        lbMa.setBounds(20,50,100,20);
        lbNganhJLabel.setBounds(20,80,100,20);
        
        txtTen.setBounds(100, 20,200,30);
        txtMa.setBounds(100, 50,200,30);
        txtNganh.setBounds(100,80,200,30);
        btnThem.setBounds(80, 120,100,30);
        btnCapnhat.setBounds(200,120,100,30);
        
        this.btnThem.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Student sv = new Student();
                sv.setTenSV(txtTen.getText());
                sv.setMaSV(txtMa.getText());
                sv.setNganhH(txtNganh.getText());
                try{
                    xl.insertSV(sv);
                }
                catch(SQLException ex){
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
        });
        
       
        String data[][]={};
        String column[]={"Ma SV","Ten SV","Nganh Hoc"};
        DefaultTableModel df = new DefaultTableModel(data,column);
        tbJTable = new JTable(df);
        JScrollPane jsp = new JScrollPane(tbJTable);
        jsp.setBounds(20,150,500,500);
        hienthi(df);
        add(lbMa);
        add(lbtenJLabel);
        add(lbNganhJLabel);
        add(txtMa);
        add(txtNganh);
        add(txtTen);
        add(btnCapnhat);
        add(btnThem);
        add(jsp);
        //add(pn);
        
        setTitle("Sinh vien");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    public void hienthi(DefaultTableModel df){
        df.setRowCount(0);
        df.fireTableDataChanged();
        XLDL xl = new XLDL();
        xl.getConn();
        ArrayList<Student> hv = xl.getSV();
        for(Student student:hv){
            df.addRow(new String[]{student.getMaSV(), student.getTenSV(),student.getNganhH()});
            
        }
    }
}
