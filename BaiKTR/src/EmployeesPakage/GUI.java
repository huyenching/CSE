/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeesPakage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class GUI extends JFrame{
    private JLabel lbMaNV,lbHoten,lbPhong,lbGT,lbHSL;
    private JTextField txtMANV,txtHoten,txtHSL;
    private JComboBox cbPhong;
    private JRadioButton rbNam,rbNu;
    private  JButton btnFind;
    private JTable tb;
    private JScrollPane jsp ;
    private JPanel pn;
    private DefaultTableModel model;
    private String Phong;
    private String GT;
    String[] header = {"Ma NV","Ho Ten","Phong","GT","HSL","Luong"};
    Vector<String> phong = new Vector<>();
    
    EmployeesProcess xl = new EmployeesProcess();
    public GUI(){
        lbGT = new JLabel("Gioi Tinh");
        lbHSL = new JLabel("HSL");
        lbHoten = new JLabel("Ho Ten");
        lbMaNV = new JLabel("Ma NV");
        lbPhong = new JLabel("Phong");
        
        phong.add("Kinh Doanh");
        phong.add("Hanh Chinh");
        phong.add("Ke toan");
        
        txtMANV = new JTextField();
        txtHoten = new JTextField();
        txtHSL = new JTextField();
        cbPhong = new JComboBox(phong);
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nu");
        btnFind = new JButton("Find");
        model = new DefaultTableModel(header,10);
        pn= new JPanel();
        pn.add(jsp = new JScrollPane(tb = new JTable(model)));
        
        
        this.lbMaNV.setBounds(20,20,100,20);
        this.lbHoten.setBounds(20,50,100,20);
        this.lbPhong.setBounds(20,80,100,20);
        this.lbGT.setBounds(20,110,100,20);
        this.lbHSL.setBounds(20,140,100,20);
        this.txtMANV.setBounds(90,20,100,20);
        this.txtHoten.setBounds(90,50,100,20);
        this.cbPhong.setBounds(90,80,100,20);
        this.rbNam.setBounds(90,110,100,20);
        this.rbNu.setBounds(190,110,100,20);
        this.txtHSL.setBounds(90,140,100,20);
        this.btnFind.setBounds(80,180,100,30);
        this.pn.setBounds(10,230,500,500);
        
        this.add(lbGT);
        this.add(lbHSL);
        this.add(lbHoten);
        this.add(lbMaNV);
        this.add(lbPhong);
        this.add(txtHSL);
        this.add(txtHoten);
        this.add(txtMANV);
        this.add(cbPhong);
        this.add(rbNam);
        this.add(rbNu);
        this.add(btnFind);
        this.add(pn);
        
        this.setTitle("Employees");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Hienthi();
        
        this.btnFind.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
            String gt = rbNam.isSelected() ? "Nam" : "Nu";
            ArrayList<Employees> em = xl.getNV(cbPhong.getSelectedItem().toString(),gt);
                for(int i=0;i<em.size();i++){
            String[] row ={
                em.get(i).getMaNV(),
                em.get(i).getHoten(),
                em.get(i).getPhong(),
                em.get(i).getGT(),
                em.get(i).getHSL().toString(),
                em.get(i).TinhLuong().toString(),
            };
            model.addRow(row);
            }
            }
        });
        
        
    }
   
    public void Hienthi(){
        ArrayList<Employees> em = xl.getNVab();
        model.setRowCount(0);
        
        for(int i=0;i<em.size();i++){
            String[] row = {
                em.get(i).getMaNV(),
                em.get(i).getHoten(),
                em.get(i).getPhong(),
                em.get(i).getGT(),
                em.get(i).getHSL().toString(),
                em.get(i).TinhLuong().toString(),
            };
            model.addRow(row);
        }
       
   
        
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
    
}
