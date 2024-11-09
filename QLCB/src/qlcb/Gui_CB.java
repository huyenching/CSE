/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlcb;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Action;
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
public class Gui_CB extends JFrame{
    String[] header = {"SoTK","HoTen","GioiTinh","DiaChi","Luong"};
    
    private JLabel lbSoTK,lbTen,lbGT,lbDiaChi,lbLuong;
    private JTextField txtSoTK, txtHoten,txtDiachi,txtluong;
    private JComboBox cbNamBox,cbNuBox;
    private JTable tbJTable;
    private  JPanel pnJPanel;
    private  DefaultTableModel model ;
    private JRadioButton rbNam, rbNu;
    private  JButton btnThem, btnSua,btnXoa,btnTimkiem;
    private JScrollPane jsp;
    private  String id;
    XLDL xl = new XLDL();
    
    public Gui_CB(){
        
      lbSoTK = new JLabel("So TK");
      lbTen = new JLabel("Ho Ten");
      lbGT = new JLabel("Gioi Tinh");
      lbDiaChi = new JLabel("Dia Chi");
      lbLuong = new JLabel("Luong");
      
      txtSoTK = new JTextField();
      txtHoten = new JTextField();
      rbNam = new JRadioButton("Nam");
      rbNu = new JRadioButton("Nu");
      txtDiachi  = new JTextField();
      txtluong = new JTextField();
      
     btnThem = new JButton("Them");
     btnSua = new JButton("Sua");
     btnXoa = new JButton("Xoa");
     btnTimkiem = new JButton("Tim kiem");
     
     model = new DefaultTableModel(header,10);
     pnJPanel = new JPanel();
     pnJPanel.add(jsp = new JScrollPane(tbJTable = new JTable(model)));
     
     this.lbSoTK .setBounds(20,20,100,20);
     this.lbTen.setBounds(20,50,100,20);
     this.lbGT.setBounds(20,80,100,20);
     this.lbDiaChi.setBounds(20,110,100,20);
     this.lbLuong.setBounds(20,140,100,20);
     
     this.txtSoTK.setBounds(70,20,100,20);
     this.txtHoten.setBounds(70,50,100,20);
     this.rbNam.setBounds(90,80,100,20);
     this.rbNu.setBounds(200,80,100,20);
     this.txtDiachi.setBounds(70,110,100,20);
     this.txtluong.setBounds(70,140,100,20);
    

     
     this.btnThem.setBounds(20,170,100,50);
     this.btnSua.setBounds(120,170,100,50);
     this.btnXoa.setBounds(220,170,100,50);
     this.btnTimkiem.setBounds(320,170,100,50);
     
     this.pnJPanel.setBounds(20,250,800,800);
     this.jsp.setPreferredSize(new Dimension(800,800));
     
     this.add(lbSoTK);
     this.add(lbTen);
     this.add(lbGT);
     this.add(lbDiaChi);
     this.add(lbLuong);
     this.add(txtDiachi);
     this.add(txtHoten);
     this.add(txtSoTK);
     this.add(txtluong);
     this.add(rbNam);
     this.add(rbNu);
      this.add(btnThem);
     this.add(btnSua);
     this.add(btnTimkiem);
     this.add(btnXoa);
     this.add(pnJPanel);
    
        this.setTitle("QLCB");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setVisible(true);
        Hienthi();
        
       this.btnThem.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              model.setRowCount(0);
              String gioitinh = rbNam.isSelected()? "Nam": "Nu";
              Canbo cb = new Canbo();
              cb.setSoTK(txtSoTK.getText());
              cb.setHoten(txtHoten.getText());
              cb.setGT(gioitinh);
              cb.setDiachi(txtDiachi.getText());
              cb.setLuong(Double.valueOf(txtluong.getText()));
              xl.insertCB(cb);
              Hienthi();
              
          }
       
       });
        this.tbJTable.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int tmp = tbJTable.getSelectedRow();// lay hang

               if (tmp >=0){
                   id = (String) tbJTable.getValueAt(tmp , 0); // cot dau tien trong hang
                   txtSoTK.setText(id);
                   txtHoten.setText( (String) tbJTable.getValueAt(tmp , 1));
                   String gt = (String) tbJTable.getValueAt(tmp , 2);
                   if (gt.equals("Nam")){
                       rbNam.setSelected(true);
                       rbNu.setSelected(false);
                   }
                   if (gt.equals("Nu")){
                       rbNam.setSelected(false);
                       rbNu.setSelected(true);
                   }

                   txtDiachi.setText((String) tbJTable.getValueAt(tmp , 3));
                   txtluong.setText((String) tbJTable.getValueAt(tmp , 4));
                   System.out.println(id);
               }
           }
       });
       this.btnSua.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
           super.mouseClicked(e);
           model.setRowCount(0);
            String gioitinh = rbNam.isSelected()? "Nam": "Nu";
              Canbo cb = new Canbo();
              cb.setSoTK(id);
              cb.setHoten(txtHoten.getText());
              cb.setGT(gioitinh);
              cb.setDiachi(txtDiachi.getText());
              cb.setLuong(Double.valueOf(txtluong.getText()));
              xl.UpdateCB(cb);
              Hienthi();
       }
       });
        this.btnXoa.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
           super.mouseClicked(e);
           xl.deleteCB(id);
           model.removeRow(tbJTable.getSelectedRow());
        }
       });
         this.btnTimkiem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Canbo> cb = xl.SearchCB(txtSoTK.getText());
                model.setRowCount(0);
                for(int i=0;i<cb.size();i++){
                    System.out.println(cb.get(i).getSoTK() + "    " + cb.get(i).getHoten());
                    String[] row ={

                            cb.get(i).getSoTK(),
                            cb.get(i).getHoten(),
                            cb.get(i).getGT(),
                            cb.get(i).getDiachi(),
                            cb.get(i).getLuong().toString(),

                    };
                    model.addRow(row);
                }

            }

        });
    }
    public void Hienthi(){
       ArrayList<Canbo> cb = xl.getCB();
       model.setRowCount(0);
       for(int i=0;i<cb.size();i++){
           String[] row ={
               cb.get(i).getSoTK(),
               cb.get(i).getHoten(),
               cb.get(i).getGT(),
               cb.get(i).getDiachi(),
               cb.get(i).getLuong().toString(),
               
           };
           model.addRow(row);
       }
    }
    public static void main(String[] args) {
        Gui_CB gui = new Gui_CB();
    }
}
