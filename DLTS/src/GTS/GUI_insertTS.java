/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GTS;

import com.microsoft.sqlserver.jdbc.JaasConfiguration;
import com.sun.net.httpserver.Headers;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PC
 */
public class GUI_insertTS extends JFrame{
    String[] header = {"Số báo danh","Họ tên","Giới tính","Ngành học","Tổng điểm"};
    Vector<String> nganhH = new Vector<>();
    
    XLTS xlts= new XLTS();
    private JLabel lbl_Sobd,lbl_hoTen,lbl_gt,lbl_nganhH,lbl_tongD;
    
    private JTextField txtSobd, txtHoten ,txtTongD;
    private JComboBox cbNganhH;
    private JRadioButton rdGTNu,rdGTNam;
    private JButton bttThem;
    private JTable tb;
    private DefaultTableModel model = new DefaultTableModel(header,0);
    private JPanel panel ;
    private JScrollPane sc;
    
    private ButtonGroup bg;
    
    public GUI_insertTS(){
       
        bg = new ButtonGroup();
        bg.add(rdGTNu);
        bg.add(rdGTNam);
        
        JPanel panel = new JPanel();

        lbl_Sobd = new JLabel("Số báo danh");
        lbl_hoTen = new JLabel("Họ tên");
        lbl_gt = new JLabel("Giới tính");
        lbl_nganhH = new JLabel("Ngành học");
        lbl_tongD = new JLabel("Tổng điểm");
        
        
        txtSobd = new JTextField();
        txtHoten = new JTextField();
        txtTongD = new JTextField();
        cbNganhH = new JComboBox();
        rdGTNam = new JRadioButton("Nam");
        rdGTNu  =new JRadioButton("Nứ");
        nganhH.add("Công trình thủy");
        nganhH.add("Trí tuệ nhân tạo");
        nganhH.add("An ninh mạng");
        
        bttThem = new JButton("Thêm thí sinh");
        
        cbNganhH = new JComboBox(nganhH);
        
        panel.add(sc = new JScrollPane(tb = new JTable(model)));
        
        this.setLayout(null);
        
        lbl_Sobd.setBounds(20,20,100,20);
        lbl_hoTen.setBounds(20,50,100,20);
        lbl_gt.setBounds(20,80,100,20);
        lbl_nganhH.setBounds(20,110,100,20);
        lbl_tongD.setBounds(20,140,100,20);
        
        txtHoten.setBounds(140,50,200,20);
        txtSobd.setBounds(140,20,200,20);
        txtTongD.setBounds(140,140,200,20);
        
        cbNganhH.setBounds(140,110,200,20);
        rdGTNam.setBounds(140,80,50,20);
        rdGTNu.setBounds(200,80,50,20);
        
        bttThem.setBounds(20,170,100,30);
        
        panel.setBounds(20,200,500,500);
        
        this.add(lbl_Sobd);
        this.add(lbl_hoTen);
        this.add(lbl_gt);
        this.add(lbl_nganhH);
        this.add(lbl_tongD);
        this.add(bttThem);
        this.add(txtHoten);
        this.add(txtSobd);
        this.add(txtTongD);
        this.add(cbNganhH);
        this.add(rdGTNam);
        this.add(rdGTNu);
        this.add(panel);
        
        setTitle("Quản lý thí sinh");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
       
        this.bttThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thisinh thisinh = new Thisinh();
                
                thisinh.setSoBD(txtSobd.getText());
                thisinh.setHoten(txtHoten.getText());
                thisinh.setNganhH(cbNganhH.getSelectedItem().toString());
                thisinh.setTongD(Double.parseDouble(txtTongD.getText()));
                
                if(rdGTNam.isSelected()){
                    thisinh.setGT("Nam");
                }
                else{
                    thisinh.setGT("Nữ");
                }
                
                xlts.insertTS(thisinh);
                model.setRowCount(0);
                hienThi();
                
                
            }
        
            
            
        });
        
        
       hienThi();
        
       
    }
    
    
    public void hienThi(){
        ArrayList<Thisinh> thisinhs = xlts.getTS();
        for(int i =0;i<thisinhs.size();i++){
            String[] row = {
                thisinhs.get(i).getSoBD(),
                thisinhs.get(i).getHoten(),
                thisinhs.get(i).getGT(),
                thisinhs.get(i).getNganhH(),
                thisinhs.get(i).getTongD().toString()
            };
            model.addRow(row);
        }
        
    }
    
 
}
