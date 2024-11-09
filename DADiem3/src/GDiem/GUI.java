/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

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
public class GUI extends JFrame{
    String[] header ={"Ma HV","Ho Ten","Lop","Diem","Ket qua"};
    Vector<String> lop = new Vector<>();
    
    private JLabel lbMa,lbTen,lbLop,lbDiem;
    private JTextField txtMa,txtTen,txtdiem;
    private JComboBox cbLop;
    private JButton btnthem;
    private  JTable tb;
    private JPanel pn;
    private  JScrollPane jsp;
    private DefaultTableModel model;
    private  String id;
    XLDiem xl = new XLDiem();
    public GUI(){
        lbDiem = new JLabel("Diem");
        lbLop = new JLabel("Lop");
        lbMa = new JLabel("Ma HV");
        lbTen = new JLabel("Ho Ten");
        
        lop.add("62TH1");
        lop.add("62TH3");
        lop.add("64KTPM4");
        
        txtMa = new JTextField();
        txtTen = new JTextField();
        txtdiem = new JTextField();
        cbLop = new JComboBox(lop);
        btnthem = new JButton("Them");
        model = new DefaultTableModel(header,10);
        pn= new JPanel();
        pn.add(jsp = new JScrollPane(tb = new JTable(model)));
        
        
        this.lbMa.setBounds(20,20,100,20);
        this.lbTen.setBounds(20,50,100,20);
        this.lbLop.setBounds(20,80,100,20);
        this.lbDiem.setBounds(20,110,100,20);
        this.txtMa.setBounds(90,20,100,20);
        this.txtTen.setBounds(90,50,100,20);
        this.cbLop.setBounds(90,80,100,20);
        this.txtdiem.setBounds(90,110,100,20);
        this.btnthem.setBounds(20,200,100,20);
        this.pn.setBounds(10,250,500,500);
        
        this.add(lbMa);
        this.add(lbDiem);
        this.add(lbLop);
        this.add(lbTen);
        this.add(txtMa);
        this.add(txtTen);
        this.add(txtdiem);
        this.add(cbLop);
        this.add(btnthem);
        this.add(pn);
        
        this.setTitle("Hoc Vien");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        setVisible(true);
        Hienthi();
        this.tb.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent e){
                int tmp= tb.getSelectedRow();
                if(tmp>=0){
                    id= (String) tb.getValueAt(tmp, 0);
                    txtMa.setText(id);
                    txtTen.setText((String) tb.getValueAt(tmp, 1));
                    cbLop.setSelectedItem((String) tb.getValueAt(tmp, 2));
                    txtdiem.setText((String) tb.getValueAt(tmp, 3));
                }
            }
        
        });
        this.btnthem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               Hocvien hv = new Hocvien();
               model.setRowCount(0);
               hv.setMaHV(txtMa.getText());
               hv.setHoten(txtTen.getText());
               hv.setLop(cbLop.getSelectedItem().toString());
               hv.setDiem(Double.valueOf(txtdiem.getText()));
               xl.InsertHV(hv);
               Hienthi();
            }
        });
        
    }
    public void Hienthi(){
        ArrayList<Hocvien> hv = xl.getHV();
        model.setRowCount(0);
        for(int i=0;i<hv.size();i++){
            String[] row={
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
        GUI gui = new GUI();
    }
}
