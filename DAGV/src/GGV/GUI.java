/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGv;

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
    String[] header = {"Ma DD","Ho Ten","Gioi tinh","Don vi","SoCT"};
    Vector<String> donvi = new Vector<>();
    
    private JLabel lbMaDD,lbHoten,lbGT,lbDonvi,lbSoct;
    private JTextField txtMaDD,txtHoten,txtSoTc;
    private JComboBox cbDonvi;
    private JRadioButton rbNam,rbNu;
    private JButton btnThem,btnSua,btnxoa,btnTim;
    private JTable tb;
    private JPanel pn;
    private JScrollPane jsp ;
    private DefaultTableModel model;
    XLGV xl = new XLGV();
    
    private  String id;
    public GUI(){
        lbDonvi = new JLabel("Don Vi");
        lbGT = new JLabel("Gioi tinh");
        lbHoten = new JLabel("Ho ten");
        lbMaDD = new JLabel("Ma DD");
        lbSoct = new JLabel("So CT");
        
        donvi.add("Thai Binh");
        donvi.add("Ha Noi");
        donvi.add("Vinh Phuc");
        
        txtHoten = new JTextField();
        txtMaDD = new JTextField();
        txtSoTc = new JTextField();
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nu");
        cbDonvi = new JComboBox(donvi);
        btnThem = new JButton("Them");
        btnSua = new JButton("Sua");
        btnxoa = new JButton("Xoa");
        btnTim = new JButton("Tim Kiem");
        
        model = new DefaultTableModel(header,10);
        pn = new JPanel();
        pn.add(jsp= new JScrollPane(tb = new JTable(model)));
        
        this.lbMaDD.setBounds(20,20,100,20);
        this.lbHoten.setBounds(20,50,100,20);
        this.lbGT.setBounds(20,80,100,20);
        this.lbDonvi.setBounds(20,110,100,20);
        this.lbSoct.setBounds(20,140,100,20);
        this.txtMaDD.setBounds(90,20,100,20);
        this.txtHoten.setBounds(90,50,100,20);
        this.rbNam.setBounds(90,80,100,20);
        this.rbNu.setBounds(180,80,100,20);
        this.cbDonvi.setBounds(90,110,100,20);
        this.txtSoTc.setBounds(90,140,100,20);
        this.btnThem.setBounds(20,170,100,30);
        this.btnSua.setBounds(120,170,100,30);
        this.btnTim.setBounds(220,170,100,30);
        this.btnxoa.setBounds(320,170,100,30);
        this.pn.setBounds(20,250,500,500);
        
        this.add(lbDonvi);
        this.add(lbGT);
        this.add(lbHoten);
        this.add(lbMaDD);
        this.add(lbSoct);
        this.add(txtHoten);
        this.add(txtMaDD);
        this.add(txtSoTc);
        this.add(rbNam);
        this.add(rbNu);
        this.add(cbDonvi);
        this.add(btnSua);
        this.add(btnThem);
        this.add(btnTim);
        this.add(btnxoa);
        this.add(pn);
        
        this.setTitle("DA Giang Vien");
        this.setLayout(null);
        this.setSize(500,500);
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
                   txtMaDD.setText(id);
                   txtHoten.setText( (String) tb.getValueAt(tmp , 1));
                   String gt = (String) tb.getValueAt(tmp , 2);
                   if (gt.equals("Nam")){
                       rbNam.setSelected(true);
                       rbNu.setSelected(false);
                   }
                   if (gt.equals("Nu")){
                       rbNam.setSelected(false);
                       rbNu.setSelected(true);
                   }

                   cbDonvi.setSelectedItem((String) tb.getValueAt(tmp , 3));
                   txtSoTc.setText((String) tb.getValueAt(tmp , 4));
                   System.out.println(id);
               }
           }
       });
         this.btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               model.setRowCount(0);
               String gt = rbNam.isSelected()? "Nam":"Nu";
               Giangvien gv = new Giangvien();
               gv.setMaDD(txtMaDD.getText());
               gv.setHoten(txtHoten.getText());
               gv.setGT(gt);
               gv.setDonvi(cbDonvi.getSelectedItem().toString());
               gv.setSoct(Integer.valueOf(txtSoTc.getText()));
               xl.insertGV(gv);
               Hienthi();
               
            }
         });
         this.btnSua.addMouseListener(new MouseAdapter(){
         @Override
         public void mouseClicked(MouseEvent e){
             super.mouseClicked(e);
             model.setRowCount(0);
             String gt = rbNam.isSelected()? "Nam":"Nu";
               Giangvien gv = new Giangvien();
               gv.setMaDD(id);
               gv.setHoten(txtHoten.getText());
               gv.setGT(gt);
               gv.setDonvi(cbDonvi.getSelectedItem().toString());
               gv.setSoct(Integer.valueOf(txtSoTc.getText()));
               xl.updateGV(gv);
               Hienthi();
         }
         });
         this.btnxoa.addMouseListener(new MouseAdapter(){
         @Override
         public void mouseClicked(MouseEvent e){
             super.mouseClicked(e);
               xl.deleteGV(id);
               model.removeRow(tb.getSelectedRow());
         }
         });
         this.btnTim.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
               ArrayList<Giangvien> gv = xl.getGV(cbDonvi.getSelectedItem().toString(), Integer.valueOf(txtSoTc.getText()));
                model.setRowCount(0);
            for(int i=0;i<gv.size();i++){
            String[] row={
                gv.get(i).getMaDD(),
                gv.get(i).getHoten(),
                gv.get(i).getGT(),
                gv.get(i).getDonvi(),
                String.valueOf(gv.get(i).getSoct()),
            };
            model.addRow(row);
        }
            }
         });
    }
    public  void Hienthi(){
        ArrayList<Giangvien> gv = xl.getHienThi();
        model.setRowCount(0);
        for(int i=0;i<gv.size();i++){
            String[] row={
                gv.get(i).getMaDD(),
                gv.get(i).getHoten(),
                gv.get(i).getGT(),
                gv.get(i).getDonvi(),
                String.valueOf(gv.get(i).getSoct()),
            };
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
