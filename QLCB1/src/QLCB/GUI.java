/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCB;

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
    String[] header ={"So TK","Ho ten","Gioi Tinh","Dia chi","Luong"};
    Vector<String> diachi = new Vector<>();
    
    private JLabel lbSoTK,lbTen,lbGT,lbDiachi,lbLuong;
    private JTextField txtSoTk,txtTen,txtLuong;
    private JComboBox cbDiachi;
    private JRadioButton rbNam,rbNu;
    private JButton btnthem,btnSua,btnXoa,btnTim;
    private JTable tb;
    private JPanel pn;
    private JScrollPane jsp;
    private DefaultTableModel model;
    private  String id;
    
    QLCB xl = new QLCB();
    public GUI(){
        lbDiachi = new JLabel("Dia chi");
        lbGT = new JLabel("Gioi tinh");
        lbLuong = new JLabel("Luong");
        lbSoTK = new JLabel("So TK");
        lbTen = new JLabel("Ho ten");
        
        txtLuong = new JTextField();
        txtSoTk = new JTextField();
        txtTen = new JTextField();
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nu");
        diachi.add("Thai Binh");
        diachi.add("Ha Noi");
        diachi.add("Vinh Phuc");
        cbDiachi = new JComboBox(diachi);
        btnthem = new JButton("Them");
        btnSua= new JButton("Sua");
        btnXoa= new JButton("Xoa");
        btnTim = new JButton("Tim Kiem");
        
        model = new DefaultTableModel(header,10);
        pn= new JPanel();
        pn.add(jsp= new JScrollPane(tb = new JTable(model)));
        
        this.lbSoTK.setBounds(20,20,100,20);
        this.lbTen.setBounds(20,50,100,20);
        this.lbGT.setBounds(20,80,100,20);
        this.lbDiachi.setBounds(20,110,100,20);
        this.lbLuong.setBounds(20,140,100,20);
        this.txtSoTk.setBounds(90,20,100,20);
        this.txtTen.setBounds(90,50,100,20);
        this.rbNam.setBounds(90,80,100,20);
        this.rbNu.setBounds(190,80,100,20);
        this.cbDiachi.setBounds(90,110,100,20);
        this.txtLuong.setBounds(90,140,100,20);
        this.btnthem.setBounds(20,200,100,30);
        this.btnSua.setBounds(120,200,100,30);
        this.btnXoa.setBounds(220,200,100,30);
        this.btnTim.setBounds(320,200,100,30);
        this.pn.setBounds(10,250,500,500);
        
        this.add(lbDiachi);
        this.add(lbGT);
        this.add(lbLuong);
        this.add(lbSoTK);
        this.add(lbTen);
        this.add(txtLuong);
        this.add(txtSoTk);
        this.add(txtTen);
        this.add(rbNu);
        this.add(rbNam);
        this.add(cbDiachi);
        this.add(btnSua);
        this.add(btnTim);
        this.add(btnXoa);
        this.add(btnthem);
        this.add(pn);
        
        this.setTitle("Can Bo");
        this.setLayout(null);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);
        hienthi();
        
        this.tb.addMouseListener(new MouseAdapter(){
        
            @Override
            public void mouseClicked(MouseEvent e){
                int tmp = tb.getSelectedRow();
                if(tmp>=0){
                    id = (String) tb.getValueAt(tmp, 0);
                    txtSoTk.setText(id);
                    txtTen.setText((String) tb.getValueAt(tmp, 1));
                    String gt = (String ) tb.getValueAt(tmp, 2);
                    if(gt.equals("Nam")){
                        rbNam.setSelected(true);
                        rbNu.setSelected(false);
                    }
                    if(gt.equals("Nu")){
                        rbNu.setSelected(true);
                        rbNam.setSelected(false);
                    }
                    
                    cbDiachi.setSelectedItem((String) tb.getValueAt(tmp, 3));
                    txtLuong.setText((String) tb.getValueAt(tmp, 4));
                    
                }
            }
        
        });
        this.btnthem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             model.setRowCount(0);
             Canbo cb = new Canbo();
             String gt = rbNam.isSelected() ? "Nam":"Nu";
             cb.setSoTK(txtSoTk.getText());
             cb.setHoten(txtTen.getText());
             cb.setGT(gt);
             cb.setDiachi(cbDiachi.getSelectedItem().toString());
             cb.setLuong(Double.valueOf(txtLuong.getText()));
             xl.insertCB(cb);
             hienthi();
            }
        });
        this.btnTim.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
               ArrayList<Canbo> cb = xl.searchCB(txtSoTk.getText());
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
        });
        this.btnXoa.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
             super.mouseClicked(e);
             xl.deleteCB(id);
             model.removeRow(tb.getSelectedRow()); 
            }
           
        });
        this.btnSua.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
             super.mouseClicked(e);
             model.setRowCount(0);
             Canbo cb = new Canbo();
             String gt = rbNam.isSelected() ? "Nam":"Nu";
             cb.setSoTK(id);
             cb.setHoten(txtTen.getText());
             cb.setGT(gt);
             cb.setDiachi(cbDiachi.getSelectedItem().toString());
             cb.setLuong(Double.valueOf(txtLuong.getText()));
             xl.updateCB(cb);
             hienthi();
            }
           
        });
    }
    public void hienthi(){
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
        GUI gui = new GUI();
    }
}
