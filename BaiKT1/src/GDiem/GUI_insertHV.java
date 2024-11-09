/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class GUI_insertHV extends JFrame{
    private XLDiem xl;
    private JTextField txtMa, txtHoten, txtdiem;
    private JComboBox cbLop;
    private JButton bttThem;
    private JTable tb;
    public GUI_insertHV(){
        xl = new XLDiem();
        setTitle("Học viên");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel pn = new JPanel();
        pn.setLayout(new GridLayout(4,2));
        
        pn.add(new JLabel("Mã học viên"));
        txtMa = new JTextField(10);
        pn.add(txtMa);
        pn.add(new JLabel("Họ tên"));
        txtHoten = new JTextField(10);
        pn.add(txtHoten);
        pn.add(new JLabel("Lớp"));
        cbLop = new JComboBox<>(new String[] {"62TH1","62PM1","62PM2"});
        pn.add(cbLop);
        pn.add(new JLabel("Điểm"));
        txtdiem = new JTextField(10);
        pn.add(txtdiem);
        JPanel pn1 = new JPanel();
        bttThem = new JButton("Thêm học viên");
        pn1.add(bttThem);
//        bttThem.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerforms(ActionEvent e){
//                String MaHV = txtMa.getText();
//                String Hoten = txtHoten.getText();
//                String Lop = cbLop.getSelectedItem();
//                float Diem = Float.float16ToFloat(txtdiem.getText());
//                xl.insertHV(new Hocvien(MaHV,Hoten,Lop,Diem));
//                
//            }
//    )
//        
//    }
        ArrayList<Hocvien> dsHV = xl.getHV();
        String[] columns = {"Mã học viên","Họ Tên","Lớp","Điểm","Kết quả"};
        String[][] data = new String[dsHV.size()][5];
        for(int i=0;i<dsHV.size();i++){
            Hocvien hv = dsHV.get(i);
            data[i][0] = hv.getMaHV();
            data[i][1] = hv.getHoten();
            data[i][2] = hv.getLop();
            data[i][3] = hv.getLop();
            data[i][4] = hv.Ketqua();
        }
        tb = new JTable(data,columns);
        JScrollPane sp = new JScrollPane(tb);
        setLayout(new BorderLayout());
        
        add(sp,BorderLayout.CENTER);
        add(pn,BorderLayout.NORTH);
        add(pn1);
        add(bttThem);
        setVisible(true);
    }
    
}
