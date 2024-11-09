/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class GUI extends  JFrame{
    private JLabel lbMa,lbTenS,lbNamXB,lbGiaB;
    private JTextField txtMa,txtTenS,txtGiaB;
    private JComboBox cbNamXB;
    private JButton btnXoa;
    private JTable tb;
    private JPanel pn;
    private JScrollPane jsp;
    private  DefaultTableModel model ;
    private  String id;
   
    
    XLSach xl = new XLSach();
    String[] header = {"Ma Sach","Ten Sach","Nam XB","Gia Ban ","Thanh Tien"};
    Vector<String> namsx = new Vector<>();
    
    public GUI(){
        lbGiaB = new JLabel("Gia Ban");
        lbMa = new JLabel("Ma Sach");
        lbNamXB = new JLabel("Nam XB");
        lbTenS = new JLabel("Ten Sach");
        
        txtGiaB = new JTextField();
        txtMa = new JTextField();
        txtTenS = new JTextField();
        namsx.add("2019");
        namsx.add("2020");
        namsx.add("2021");
        cbNamXB = new JComboBox(namsx);
        btnXoa = new JButton("Xoa");
        
        model = new DefaultTableModel(header,10);
        pn= new JPanel();
        pn.add(jsp= new JScrollPane(tb= new JTable(model)));
        
        this.lbMa.setBounds(20,20,100,20);
        this.lbTenS.setBounds(20,50,100,20);
        this.lbNamXB.setBounds(20,80,100,20);
        this.lbGiaB.setBounds(20,110,100,20);
        this.txtMa.setBounds(90,20,100,20);
        this.txtTenS.setBounds(90,50,100,20);
        this.cbNamXB.setBounds(90,80,100,20);
        this.txtGiaB.setBounds(90,110,100,20);
        this.btnXoa.setBounds(90,150,100,20);
        this.pn.setBounds(10,200,500,500);
        
        
        this.add(lbMa);
        this.add(lbGiaB);
        this.add(lbNamXB);
        this.add(lbTenS);
        this.add(txtGiaB);
        this.add(txtMa);
        this.add(txtTenS);
        this.add(cbNamXB);
        this.add(btnXoa);
        this.add(pn);
        
        this.setTitle("Quan Ly Sach");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setVisible(true);
        Hienthi();
        
//        this.tb.addMouseListener(new MouseAdapter(){
//        
//            public void mouseClicked(MouseEvent e){
//                int tmp = tb.getSelectedRow();
//                if(tmp>=0){
//                    id= (String) tb.getValueAt(tmp, 0);
//                    txtMa.setText(id);
//                    txtTenS.setText((String) tb.getValueAt(tmp, 1));
//                    cbNamXB.setSelectedItem();
//                    txtGiaB.setText((String) tb.getValueAt(tmp, 3));
//                }
//            }
//        });
//        this.btnXoa.addMouseListener(new MouseAdapter(){
//        
//            public void mouseClicked(MouseEvent e){
//                super.mouseClicked(e);
//                xl.deleteSA(namxb);
//                model.removeRow(tb.getSelectedRow());
//            }
//            });
        this.btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int nam = Integer.parseInt(cbNamXB.getSelectedItem().toString());
                xl.deleteSA(nam);
                Hienthi();
            }
        });
    }
    public void Hienthi(){
        ArrayList<Sach> sach = xl.getSA();
        model.setRowCount(0);
        for(int i=0;i<sach.size();i++){
            String[] row={
                sach.get(i).getMas(),
                sach.get(i).getTenS(),
                String.valueOf(sach.get(i).getNamSX()),
                sach.get(i).getGiaB().toString(),
                sach.get(i).Thanhtien().toString(),
            };
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
