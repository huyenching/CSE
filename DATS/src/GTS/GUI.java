/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GTS;

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
    String[] header = {"So BD","Ho Ten","Gioi tinh","Nganh Hoc","Tong Diem","Hoc Bong"};
    Vector<String> Nganh = new Vector();
    
    private JLabel lbSoBd,lbHoten,lbGT,lbNganhH,lbTongD;
    private JTextField txtSoBD,txtHoten,txtTongD;
    private JRadioButton rbNam,rbNu;
    private JComboBox cbNganhH;
    private  JButton btnThem,btnSua,btnXoa,btnTim;
    private JTable tb;
    private  JPanel pn;
    private JScrollPane jsp ;
    private  DefaultTableModel model ;
    
    private String id;
    
    XLTS xl = new XLTS();
    public GUI(){
        lbGT = new JLabel("Gioi Tinh");
        lbHoten = new JLabel("Ho ten");
        lbNganhH = new JLabel("Nganh Hoc");
        lbSoBd = new JLabel("So BD");
        lbTongD = new JLabel("Tong Diem");
        
        Nganh.add("KTPM");
        Nganh.add("HTTT");
        Nganh.add("TTNT");
        Nganh.add("CNTT");
        txtHoten = new JTextField();
        txtSoBD = new JTextField();
        txtTongD = new JTextField();
        cbNganhH = new JComboBox(Nganh);
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nu");
        btnThem = new JButton("Them ");
        btnSua= new JButton("Sua ");
        btnTim= new JButton("Tim kiem ");
        btnXoa= new JButton("Xoa");
        
        model = new DefaultTableModel(header,10);
        pn = new JPanel();
        pn.add(jsp = new JScrollPane(tb = new JTable(model)));
        
        this.lbSoBd.setBounds(20,20,100,20);
        this.lbHoten.setBounds(20,50,100,20);
        this.lbGT.setBounds(20,80,100,20);
        this.lbNganhH.setBounds(20,110,100,20);
        this.lbTongD.setBounds(20,140,100,20);
        this.txtSoBD.setBounds(90,20,100,20);
        this.txtHoten.setBounds(90,50,100,20);
        this.rbNam.setBounds(90,80,100,20);
        this.rbNu.setBounds(190,80,100,20);
        this.cbNganhH.setBounds(90,110,100,20);
        this.txtTongD.setBounds(90,140,100,20);
        this.btnThem.setBounds(20,180,100,30);
        this.btnSua.setBounds(120,180,100,30);
        this.btnXoa.setBounds(220,180,100,30);
        this.btnTim.setBounds(320,180,100,30);
        this.pn.setBounds(10,230,500,500);
        
        this.add(lbGT);
        this.add(lbHoten);
        this.add(lbNganhH);
        this.add(lbSoBd);
        this.add(lbTongD);
        this.add(txtHoten);
        this.add(txtSoBD);
        this.add(txtTongD);
        this.add(rbNam);
        this.add(rbNu);
        this.add(cbNganhH);
        this.add(btnThem);
        this.add(btnSua);
        this.add(btnTim);
        this.add(btnXoa);
        this.add(pn);
        
        this.setTitle("Thi sinh");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Hienthi();
        this.tb.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int tmp = tb.getSelectedRow();// lay hang

               if (tmp >=0){
                   id = (String) tb.getValueAt(tmp , 0); // cot dau tien trong hang
                   txtSoBD.setText(id);
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

                   cbNganhH.setSelectedItem((String) tb.getValueAt(tmp , 3));
                   txtTongD.setText((String) tb.getValueAt(tmp , 4));
                   System.out.println(id);
               }
           }
       });
        this.btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                Thisinh ts = new Thisinh();
                String gt = rbNam.isSelected() ? "Nam":"Nu";
                ts.setSoBD(txtSoBD.getText());
                ts.setHoten(txtHoten.getText());
                ts.setGT(gt);
                ts.setNganhH(cbNganhH.getSelectedItem().toString());
                ts.setTongD(Double.valueOf(txtTongD.getText()));
                xl.insertTS(ts);
                Hienthi();
            }
        });
        this.btnTim.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             ArrayList<Thisinh> ts = xl.SearchTS(txtSoBD.getText());
             model.setRowCount(0);
             for(int i=0;i<ts.size();i++){
            String[] row ={
                ts.get(i).getSoBD(),
                ts.get(i).getHoten(),
                ts.get(i).getGT(),
                ts.get(i).getNganhH(),
                ts.get(i).getTongD().toString(),
                ts.get(i).HocBong(),
            };
            model.addRow(row);
        }
            }
        });
        this.btnXoa.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                xl.deleteTS(id);
                model.removeRow(tb.getSelectedRow());
            }
        });
        this.btnSua.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                model.setRowCount(0);
                 Thisinh ts = new Thisinh();
                String gt = rbNam.isSelected() ? "Nam":"Nu";
                ts.setSoBD(txtSoBD.getText());
                ts.setHoten(txtHoten.getText());
                ts.setGT(gt);
                ts.setNganhH(cbNganhH.getSelectedItem().toString());
                ts.setTongD(Double.valueOf(txtTongD.getText()));
                xl.UpdateTS(ts);
                Hienthi();
            }
        });
    }
    public void Hienthi(){
        ArrayList<Thisinh> ts = xl.getTS();
        model.setRowCount(0);
        for(int i=0;i<ts.size();i++){
            String[] row ={
                ts.get(i).getSoBD(),
                ts.get(i).getHoten(),
                ts.get(i).getGT(),
                ts.get(i).getNganhH(),
                ts.get(i).getTongD().toString(),
                ts.get(i).HocBong(),
            };
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
