/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;


import java.awt.Dimension;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Gui extends JFrame{

    String[] header = {"Ma Nv","Ho Ten","Dia Chi","Luong"};
    Vector<String> diachi = new Vector<>();
   private  JLabel lbMaNV,lbTen,lbDiachi,lbLuong;
   private JTextField txtMaNv,txtTen,txtLuong;
   private JComboBox cbDiachi;
   private JButton btnTim,btnCapNhat;
   private JTable tb;
   private  JPanel pn ;
   private DefaultTableModel model;
   private JScrollPane jsp;
   private String id;
   
   XLLuong xl = new XLLuong();
   public  Gui(){
       
       lbTen = new JLabel("Ho ten");
       lbMaNV = new JLabel("Ma NV");
       lbDiachi = new JLabel("Dia chi");
       lbLuong = new JLabel("Luong");
       
       diachi.add("Thai Binh");
       diachi.add("Ha Noi");
       diachi.add("Vinh Phuc");
       
       txtMaNv = new JTextField();
       txtTen= new JTextField();
       txtLuong= new JTextField();
       cbDiachi = new JComboBox(diachi);
       
       btnTim = new JButton("Tim kiem ");
       btnCapNhat = new JButton("Cap Nhat");
       
       model = new DefaultTableModel(header,10);
       pn = new JPanel();
       pn.add(jsp= new JScrollPane(tb = new JTable(model)));
       
       this.lbMaNV.setBounds(20,20,100,20);
       this.lbTen.setBounds(20,70,100,20);
       this.lbDiachi.setBounds(20,120,100,20);
       this.lbLuong.setBounds(20,170,100,20);
       this.txtMaNv.setBounds(90,20,100,20);
       this.txtTen.setBounds(90,70,100,20);
       this.cbDiachi.setBounds(90,120,100,20);
       this.txtLuong.setBounds(90,170,100,20);
       this.btnTim.setBounds(20,200,100,30);
       this.btnCapNhat.setBounds(150,200,100,30);
       
       this.pn.setBounds(10,250,500,500);
       this.jsp.setPreferredSize(new Dimension(500,500));
       
       
       this.add(lbDiachi);
       this.add(lbLuong);
       this.add(lbMaNV);
       this.add(lbTen);
       this.add(txtLuong);
       this.add(txtMaNv);
       this.add(txtTen);
       this.add(cbDiachi);
       this.add(btnCapNhat);
       this.add(btnTim);
       this.add(pn);
       
       this.setTitle("QL Nhan Vien");
       this.setSize(500,500);
       this.setLayout(null);
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
                   txtMaNv.setText(id);
                   txtTen.setText( (String) tb.getValueAt(tmp , 1));
                   cbDiachi.setSelectedItem(tb.getValueAt(tmp, 2)) ;
                   txtLuong.setText((String) tb.getValueAt(tmp , 3));
                  
                   System.out.println(id);
               }
           }
       });
       this.btnTim.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              ArrayList<Nhanvien> nv = xl.getNVbyMa(txtMaNv.getText());
              model.setRowCount(0);
               for(int i=0;i<nv.size();i++){
           String[] row={
               nv.get(i).getMaNV(),
               nv.get(i).getHoten(),
               nv.get(i).getDiachi(),
               nv.get(i).getLuong().toString(),
           
           };
           model.addRow(row);
       }
           }
       });
       this.btnCapNhat.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
           super.mouseClicked(e);
           model.setRowCount(0);
           Nhanvien nv = new Nhanvien();
           nv.setMaNV(id);
           nv.setHoten(txtTen.getText());
           nv.setDiachi(cbDiachi.getSelectedItem().toString());
           nv.setLuong(Double.parseDouble(txtLuong.getText()));
           xl.updateNV(nv);
           Hienthi();
       }
       });
   }
   public  void Hienthi(){
       ArrayList<Nhanvien> nv = xl.getNV();
       model.setRowCount(0);
       for(int i=0;i<nv.size();i++){
           String[] row={
               nv.get(i).getMaNV(),
               nv.get(i).getHoten(),
               nv.get(i).getDiachi().toString(),
               nv.get(i).getLuong().toString(),
           
           };
           model.addRow(row);
       }
   }
    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
