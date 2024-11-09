/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import com.sun.net.httpserver.Headers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class GUI_insertHV extends JFrame{
    private JLabel lbMa,lbTen,lblop,lbdiem;
    private JTextField txtMa,txtten,txtdiem;
    private JComboBox cbLop;
    private JButton btnThem,btnSua;
    private JTable tb;
    private JScrollPane sc;

    
    XLDiem xl = new XLDiem();
    String[] header = {"Ma hoc vien","Ho ten","lop","diem"};
    Vector<String> lop = new Vector<>();
    private DefaultTableModel model = new DefaultTableModel(header,0);
    public GUI_insertHV(){
        setTitle("Dự án điểm");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        lbMa = new JLabel("Mã Hoc viên");
        lbTen = new JLabel("Tên học viên");
        lblop = new JLabel("Lớp");
        lbdiem = new JLabel("Điểm");
        
        txtMa = new JTextField();
        txtten = new JTextField();
        cbLop = new JComboBox(lop);
        txtdiem= new JTextField();
        
        lop.add("63KTPM2");
        lop.add("63KTPM1");
        lop.add("63KTPM3");
        
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        JPanel pn = new JPanel();
        pn.add(sc = new JScrollPane(tb = new JTable(model)));
        this.setLayout(null);
        lbMa.setBounds(20,20,100,20);
        lbTen.setBounds(20,50,100,20);
        lblop.setBounds(20,80,100,20);
        lbdiem.setBounds(20,110,100,20);
        
        txtMa.setBounds(140, 20,200,20);
        txtten.setBounds(140, 50,200,20);
        cbLop.setBounds(140, 80,200,20);
        txtdiem.setBounds(140, 110,200,20);
        btnThem.setBounds(160, 150, 90, 20);
        btnSua.setBounds(250, 150, 90, 20);
        pn.setBounds(20, 200, 500, 500);
       
        this.btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Hocvien hvien = new Hocvien();
                hvien.setMaHV(txtMa.getText());
                hvien.setHoten(txtten.getText());
                hvien.setLop(cbLop.getSelectedItem().toString());
                hvien.setDiem(Double.parseDouble(txtdiem.getText()));
                
                
                try {
                    xl.insertHV(hvien);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_insertHV.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                model.setRowCount(0);
                Hienthi();
            }
       
        });
        
        this.btnSua.addMouseListener(new MouseAdapter(){
        
        });
        
        this.add(lbMa);
        this.add(lbTen);
        this.add(lblop);
        this.add(lbdiem);
        this.add(txtMa);
        this.add(txtten);
        this.add(txtdiem);
        this.add(cbLop);
        this.add(btnThem);
        this.add(btnSua);
        this.add(pn);
        
        Hienthi();
    }
    public void Hienthi(){
        ArrayList<Hocvien> hv = xl.getHV();
        for(int i=0;i<hv.size();i++){
            String[] row ={
                hv.get(i).getMaHV(),
                hv.get(i).getHoten(),
                hv.get(i).getLop(),
                hv.get(i).getDiem().toString()
            };
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        GUI_insertHV gui = new GUI_insertHV();
    }
}
