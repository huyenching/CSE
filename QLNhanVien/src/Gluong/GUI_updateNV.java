/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gluong;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class GUI_updateNV extends JFrame{
    private JTextField txtMa,txtHoten, txtLuong;
    private JComboBox cbDiachi;
    private JButton bttTimkiem, bttCapnhat;
    private XLLuong xl;
    public GUI_updateNV(){
         xl = new XLLuong();
        setTitle("Du An Luong");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        ArrayList<Nhanvien> nv = xl.getNVbyMa();
//        String[] columns = {"Mã Nhân viên", "Họ tên", "Địa chỉ", "Luong"};
//        String[][] data = new String[nv.size()][4];
//        
//        for (int i = 0; i < nv.size(); i++) {
//            Nhanvien nvien = nv.get(i);
//            data[i][0] = nvien.getMaNV();
//            data[i][1] = nvien.getHoten();
//            data[i][2] = nvien.getDiachi();
//            data[i][3] = nvien.getLuong();
//        }
       
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,2));
        
        panel1.add(new JLabel("Mã nhân viên"));
        txtMa= new JTextField(10);
        panel1.add(txtMa);
        
        panel1.add(new JLabel("Tên nhân viên"));
        txtHoten= new JTextField(10);
        panel1.add(txtHoten);
        
        panel1.add(new JLabel("Địa chỉ"));
        cbDiachi= new JComboBox<>(new String[]{"Hải Phòng","Thái Bình","Nam Định"});
        panel1.add(cbDiachi);
        
        panel1.add(new JLabel("Lương"));
        txtLuong= new JTextField(10);
        panel1.add(txtLuong);
        
        bttTimkiem = new JButton("Tìm kiếm");
        panel1.add(bttTimkiem);
        
        bttCapnhat = new JButton("Cập nhật nhân viên");
        panel1.add(bttCapnhat);
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        panel2.add(bttTimkiem);
        panel2.add(bttCapnhat);
        add(panel2);
    }
    public static void main(String[] args) {
        GUI_updateNV frame = new GUI_updateNV();
        frame.setVisible(true);
    }
}
