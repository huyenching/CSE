/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Gui extends JFrame{
    String[] header ={"Ma SV","Ho Ten","Lop","Diem","Ket Qua"};
    Vector<String> lop = new Vector<>();
    private JLabel lbMaSV,lbHoten,lbLop,lbDiem;
    private JTextField txtMa,txtTen,txtdiem;
    private JComboBox cbLop;
    private JButton btnthem,btnSua,btnXoa,btnTim;
    private JTable tb;
    private  DefaultTableModel model;
    private  JPanel pn ;
    private JScrollPane jsp ;
    private String id;
    
    XLDiem xl = new XLDiem();
    
    public  Gui(){
    lbMaSV= new JLabel("Mã SV");
    lbHoten= new JLabel("Họ tên");
    lbLop = new JLabel("Lớp");
    lbDiem = new JLabel("Điểm");
    
    lop.add("62TH1");
    lop.add("62PM1");
    lop.add("62PM2");
    txtMa = new JTextField();
    txtTen = new JTextField();
    txtdiem = new JTextField();
    cbLop = new JComboBox(lop);
    
    btnthem = new JButton("Thêm");
    btnSua = new JButton("Sửa");
    btnXoa = new JButton("Xóa");
    btnTim = new JButton("Tìm kiếm");
    
    model = new DefaultTableModel(header, 10);
    
    pn = new JPanel();
    pn.add(jsp = new JScrollPane(tb = new JTable(model)));
    
    
    this.lbMaSV.setBounds(20,20,100,20);
    this.lbHoten.setBounds(20,50,100,20);
    this.lbLop.setBounds(20,80,100,20);
    this.lbDiem.setBounds(20,110,100,20);
    this.txtMa.setBounds(90,20,100,20);
    this.txtTen.setBounds(90,50,100,20);
    this.cbLop.setBounds(90,80,100,20);
    this.txtdiem.setBounds(90,110,100,20);
    this.btnthem.setBounds(20,150,100,30);
    this.btnSua.setBounds(120,150,100,30);
    this.btnXoa.setBounds(220,150,100,30);
    this.btnTim.setBounds(320,150,100,30);
    
    this.pn.setBounds(20,200,800,800);
    this.jsp.setPreferredSize(new Dimension(800,800));
    
    this.add(lbDiem);
    this.add(lbHoten);
    this.add(lbLop);
    this.add(lbMaSV);
    this.add(txtMa);
    this.add(txtTen);
    this.add(txtdiem);
    this.add(cbLop);
    this.add(btnSua);
    this.add(btnTim);
    this.add(btnXoa);
    this.add(btnthem);
    this.add(pn);
    
    this.setTitle("DADiem");
    this.setLayout(null);
    this.setSize(800, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    Hienthi();
    
     this.tb.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int tmp = tb.getSelectedRow();// lay hang

               if (tmp >=0){
                   id = (String) tb.getValueAt(tmp , 0); // cot dau tien trong hang
                   txtMa.setText(id);
                   txtTen.setText( (String) tb.getValueAt(tmp , 1));
                   cbLop.setSelectedItem(tb.getValueAt(tmp, 2)) ;
                   txtdiem.setText((String) tb.getValueAt(tmp , 3));
                  
                   System.out.println(id);
               }
           }
       });
     this.btnthem.addActionListener(new ActionListener(){
    

        @Override
        public void actionPerformed(ActionEvent e) {
         model.setRowCount(0);
         Hocvien hv = new Hocvien();
         hv.setMaHV(txtMa.getText());
         hv.setHoten(txtTen.getText());
         hv.setLop(cbLop.getSelectedItem().toString());
         hv.setDiem(Double.parseDouble(txtdiem.getText()));
         xl.insertHV(hv);
         Hienthi();
        }
     });
     this.btnXoa.addMouseListener(new MouseAdapter(){
     @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               xl.deleteHV(id);
               model.removeRow(tb.getSelectedRow());
           }
     });
     this.btnTim.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Hocvien> hv = null;
            try {
                hv = xl.searchHV(txtMa.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.setRowCount(0);
            for(int i=0;i<hv.size();i++){
               String[] row ={
                hv.get(i).getMaHV(),
                hv.get(i).getHoten(),
                hv.get(i).getLop(),
                hv.get(i).getDiem().toString(),
                
            };
            model.addRow(row);
            }
        }
     
     });
     this.btnSua.addMouseListener(new MouseAdapter(){
     @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               model.setRowCount(0);
               Hocvien hv = new Hocvien();
               hv.setMaHV(id);
               hv.setHoten(txtTen.getText());
               hv.setLop(cbLop.getSelectedItem().toString());
               hv.setDiem(Double.parseDouble(txtdiem.getText()));
               xl.updateHV(hv);
               Hienthi();
           }
     });
}
    public void Hienthi(){
        ArrayList<Hocvien> hv =xl.getHV();
        model.setRowCount(0);
        for(int i=0;i<hv.size();i++){
            String[] row ={
                hv.get(i).getMaHV(),
                hv.get(i).getHoten(),
                hv.get(i).getLop(),
                hv.get(i).getDiem().toString(),
                hv.get(i).Ketqua(),
            };
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        Gui gui= new Gui();
    }
   
}
