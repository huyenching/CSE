/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlthuvien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class GUI extends  JFrame{
    private JPanel pnJPanel;
    private JTable tbJTable;
    private  JTextField txtTenS, txtTacgia;
    private  JLabel lbTens,lbtg;
    private JScrollPane jsp;
    private JButton btnThem;
  
    LibraryDao xl = new LibraryDao();
    public GUI(){
        setTitle("Quan Ly sach");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        lbTens = new JLabel("Ten Sach");
        lbtg = new JLabel("Ten Tac gia");
        txtTenS = new JTextField();
        txtTacgia = new JTextField();
        btnThem = new JButton("Them sach");
        pnJPanel = new JPanel();
        
        
        this.setLayout(null);
        lbTens.setBounds(20,20,100,20);
        lbtg.setBounds(20,50,100,20);
        txtTenS.setBounds(100,20,200,20);
        txtTacgia.setBounds(100,50,200,20);
        btnThem.setBounds(100,100,100,50);
        
        this.btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Book bk = new Book();
                bk.setTenS(txtTenS.getText());
                bk.setTacGia(txtTacgia.getText());
                xl.insertSach(bk);
            }
            
        });
        
        String data[][]={};
        String column[] = {"Ten Sach","Tac gia"};
        DefaultTableModel df = new DefaultTableModel(data,column);
        tbJTable = new JTable(df);
        JScrollPane jsp = new JScrollPane(tbJTable);
        jsp.setBounds(20,200,500,500);
        hienthi(df);
        this.add(lbTens);
        this.add(lbtg);
        this.add(txtTacgia);
        this.add(txtTenS);
        this.add(btnThem);
        this.add(jsp);
       
        
        
    }
    public  void hienthi(DefaultTableModel df){
          df.setRowCount(0);
          df.fireTableDataChanged();
          LibraryDao xl = new LibraryDao();
          ArrayList<Book> books = xl.getBook();
          for(Book b : books){
              df.addRow(new String[]{b.getTenS(),b.getTacGia()});
          }
          
        
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
