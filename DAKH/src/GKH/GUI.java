/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GKH;

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
    String[] header ={"So TK","Ho Ten","Gioi Tinh","Dia chi","So Du"};
    Vector<String> diachi = new Vector<>();
    
    private JLabel lbSoTk,lbHoten,lbGT,lbSodu,lbdiachi;
    private JTextField txtSoTK,txtHoten,txtSodu;
    private JComboBox cbDiachi;
    private JRadioButton rbNam,rbNu;
    private JButton btnThem,btnsua,btnXoa,btnTimKiem;
    private JTable tb;
    private JPanel pn;
    private DefaultTableModel model;
    private JScrollPane jsp;
    XLKH xl = new XLKH();
    private String id;
    public GUI(){
        lbGT = new JLabel("Gioi tinh");
        lbHoten = new JLabel("Ho ten");
        lbSoTk = new JLabel("So TK");
        lbdiachi = new JLabel("Dia chi");
        lbSodu = new JLabel("So Du");
        
        txtHoten = new JTextField();
        txtSoTK = new JTextField();
        txtSodu = new JTextField();
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nu");
        diachi.add("Ha Noi");
        diachi.add("Thai Binh");
        diachi.add("Vinh Phuc");
        cbDiachi = new JComboBox(diachi);
        btnThem = new JButton("Them");
        btnTimKiem = new JButton("Tim Kiem");
        btnXoa = new JButton("Xoa");
        btnsua = new JButton("Sua");
        
        model = new DefaultTableModel(header,10);
        pn= new JPanel();
        pn.add(jsp= new JScrollPane(tb= new JTable(model)));
        
        this.lbSoTk.setBounds(20,20,100,20);
        this.lbHoten.setBounds(20,50,100,20);
        this.lbGT.setBounds(20,80,100,20);
        this.lbdiachi.setBounds(20,110,100,20);
        this.lbSodu.setBounds(20,140,100,20);
        this.txtSoTK.setBounds(90,20,100,20);
        this.txtHoten.setBounds(90,50,100,20);
        this.rbNam.setBounds(90,80,100,20);
        this.rbNu.setBounds(200,80,100,20);
        this.cbDiachi.setBounds(90,110,100,20);
        this.txtSodu.setBounds(90,140,100,20);
        this.btnThem.setBounds(20,170,100,30);
        this.btnsua.setBounds(120,170,100,30);
        this.btnXoa.setBounds(220,170,100,30);
        this.btnTimKiem.setBounds(320,170,100,30);
        this.pn.setBounds(20,250,500,500);
        
        this.add(lbGT);
        this.add(lbHoten);
        this.add(lbSoTk);
        this.add(lbSodu);
        this.add(lbdiachi);
        this.add(txtHoten);
        this.add(txtSoTK);
        this.add(txtSodu);
        this.add(rbNam);
        this.add(rbNu);
        this.add(cbDiachi);
        this.add(btnThem);
        this.add(btnTimKiem);
        this.add(btnXoa);
        this.add(btnsua);
        this.add(pn);
        
        this.setTitle("Du Lieu Khach Hang");
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
                   txtSoTK.setText(id);
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

                   cbDiachi.setSelectedItem(tb.getValueAt(tmp , 3));
                   txtSodu.setText((String) tb.getValueAt(tmp , 4));
                   System.out.println(id);
               }
           }
       });
        this.btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String gt = rbNam.isSelected() ?"Nam":"Nu";
                Khachhang kh = new Khachhang();
                kh.setSoTK(txtSoTK.getText());
                kh.setHoten(txtHoten.getText());
                kh.setGT(gt);
                kh.setDiachi(cbDiachi.getSelectedItem().toString());
                kh.setSodu(Double.parseDouble(txtSodu.getText()));
                xl.insertKH(kh);
                Hienthi();
            }
        });
        this.btnsua.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
           super.mouseClicked(e);
           model.setRowCount(0);
                String gt = rbNam.isSelected() ?"Nam":"Nu";
                Khachhang kh = new Khachhang();
                kh.setSoTK(id);
                kh.setHoten(txtHoten.getText());
                kh.setGT(gt);
                kh.setDiachi(cbDiachi.getSelectedItem().toString());
                kh.setSodu(Double.valueOf(txtSodu.getText()));
                xl.updateKH(kh);
                Hienthi();
        }
        });
        this.btnXoa.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
           super.mouseClicked(e);
                Khachhang kh = new Khachhang();
                xl.deleteKH(id);
                model.removeRow(tb.getSelectedRow());
        }
        }
        );
        this.btnTimKiem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            ArrayList<Khachhang> kh = xl.getbySTK(txtSoTK.getText());
             model.setRowCount(0);
            for(int i=0;i<kh.size();i++){
                String[] row={
                    kh.get(i).getSoTK(),
                    kh.get(i).getHoten(),
                    kh.get(i).getGT(),
                    kh.get(i).getDiachi(),
                    kh.get(i).getSodu().toString(),
                };
                model.addRow(row);
            }
            }
        });
    }
    public void Hienthi(){
        ArrayList<Khachhang> kh = xl.getKH();
        model.setRowCount(0);
        for(int i=0;i<kh.size();i++){
            String[] row={
                kh.get(i).getSoTK(),
                kh.get(i).getHoten(),
                kh.get(i).getGT(),
                kh.get(i).getDiachi(),
                kh.get(i).getSodu().toString(),
            };
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
