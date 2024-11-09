
//// LOP XU LY DL
//public class QLCB implements ICanbo{
//
//    public Connection getcon() {
//        
//         
//       Connection conn = null;
//        String connectionString = "jdbc:sqlserver://HUYNCHINGG\\SQLEXPRESS;database=QLCB;user=sa;password=26072004;encrypt=true;trustServerCertificate=true;";
//        try {
//            conn = DriverManager.getConnection(connectionString);  
////            System.out.println("Ket noi thanh cong");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return  conn;
//     }
//    
//    public ArrayList<Canbo> getCB(){
//        Connection con = getcon();
//        String sql = "select * from tbCanbo";
//        ArrayList<Canbo> cb = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                Canbo canbo = new Canbo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
//                cb.add(canbo);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return cb;
//    }
//    @Override
//    public void insertCB(Canbo cb) {
//       Connection con = getcon();
//       String sql = "insert into tbCanbo(SoTK,Hoten,GT,Diachi,Luong) values(?,?,?,?,?)";
//       PreparedStatement ps = null;
//        try {
//            ps= con.prepareStatement(sql);
//            ps.setString(1, cb.getSoTK());
//            ps.setString(2, cb.getHoten());
//            ps.setString(3, cb.getGT());
//            ps.setString(4, cb.getDiachi());
//            ps.setDouble(5, cb.getLuong());
//            int i = ps.executeUpdate();
//            if(i>0){
//                System.out.println("Them thanh cong");
//            }
//            else {
//                System.out.println("Them khong thanh cong");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//       
//    }
//    public void deleteCB(String SoTK){
//        Connection con = getcon();
//        String sql = "delete from tbCanbo where SoTK=?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, SoTK);
//            ps.executeUpdate();
//        } catch (Exception e) {
//              System.out.println(e.getMessage());
//        }
//    }
//    public void updateCB(Canbo cb){
//        Connection con = getcon();
//        String sql = "update tbCanbo set Hoten=?, GT=?,Diachi=?,Luong=? where SoTk=?";
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(5, cb.getSoTK());
//            ps.setString(1, cb.getHoten());
//            ps.setString(2, cb.getGT());
//            ps.setString(3, cb.getDiachi());
//            ps.setDouble(4, cb.getLuong());
//            ps.executeUpdate();
//        } catch (Exception e) {
//             System.out.println(e.getMessage());
//        }
//    }
//    public  ArrayList<Canbo> searchCB(String Sotk){
//        Connection con = getcon();
//        String sql ="select * from tbCanbo where soTK=?";
//        ArrayList<Canbo> cb = new ArrayList<>();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1,Sotk );
//            ResultSet rs = ps.executeQuery();
//             while(rs.next()){
//                Canbo canbo = new Canbo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
//                cb.add(canbo);
//            }
//        } catch (Exception e) {
//             System.out.println(e.getMessage());
//        }
//        return cb;
//    }
//    
//    
//}
//
//    
//}
//
//
//

//// LOp Test static -Phuong thuc tinh


//// Them DL

//public class Test_insertCB {
//    public static void doInsertCB(){
//        Canbo cb = new Canbo();
//        cb.setSoTK("a6");
//        cb.setHoten("Hai");
//        cb.setGT("Nam");
//        cb.setDiachi("Ha Noi");
//        cb.setLuong(250.0);
//        ICanbo xl = new QLCB();
//        xl.insertCB(cb);
//    }
//    public static void main(String[] args) {
//        doInsertCB();
//    }
//}

//// Hien thi DL

//public class Test_findGV {
//    public static void dogetGV(){
//       Scanner sc = new Scanner(System.in);
//       XLGV xl = new XLGV();
//       xl.getCon();
//        System.out.println("Nhap Don vi: ");
//        String donvi = sc.nextLine();
//        System.out.println("Nhap SoTC");
//        int soct = sc.nextInt();
//        ArrayList<Giangvien> giangviens = xl.getGV(donvi, soct);
//        for(Giangvien gv: giangviens){
//            System.out.println("MaDD: "+gv.getMaDD());
//            System.out.println("Ho ten: "+ gv.getHoten());
//            System.out.println("Gioi Tinh: "+gv.getGT());
//            System.out.println("Don Vi: "+gv.getDonvi());
//            System.out.println("SoCT: "+gv.getSoct());
//        }
//    }
//    public static void main(String[] args) {
//        dogetGV();
//    }
//}
//
//// Lop Giao dien

//        this.tb.addMouseListener(new MouseAdapter(){
//        
//            @Override
//            public void mouseClicked(MouseEvent e){
//                int tmp = tb.getSelectedRow();
//                if(tmp>=0){
//                    id = (String) tb.getValueAt(tmp, 0);
//                    txtSoTk.setText(id);
//                    txtTen.setText((String) tb.getValueAt(tmp, 1));
//                    String gt = (String ) tb.getValueAt(tmp, 2);
//                    if(gt.equals("Nam")){
//                        rbNam.setSelected(true);
//                        rbNu.setSelected(false);
//                    }
//                    if(gt.equals("Nu")){
//                        rbNu.setSelected(true);
//                        rbNam.setSelected(false);
//                    }
//                    
//                    cbDiachi.setSelectedItem((String) tb.getValueAt(tmp, 3));
//                    txtLuong.setText((String) tb.getValueAt(tmp, 4));
//                    
//                }
//            }
//        
//        });
//        this.btnthem.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//             model.setRowCount(0);
//             Canbo cb = new Canbo();
//             String gt = rbNam.isSelected() ? "Nam":"Nu";
//             cb.setSoTK(txtSoTk.getText());
//             cb.setHoten(txtTen.getText());
//             cb.setGT(gt);
//             cb.setDiachi(cbDiachi.getSelectedItem().toString());
//             cb.setLuong(Double.valueOf(txtLuong.getText()));
//             xl.insertCB(cb);
//             hienthi();
//            }
//        });
//        this.btnTim.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                model.setRowCount(0);
//               ArrayList<Canbo> cb = xl.searchCB(txtSoTk.getText());
//                for(int i=0;i<cb.size();i++){
//            String[] row ={
//              cb.get(i).getSoTK(),
//                cb.get(i).getHoten(),
//                cb.get(i).getGT(),
//                cb.get(i).getDiachi(),
//                cb.get(i).getLuong().toString(),
//            };
//            model.addRow(row);
//        }
//            }
//        });
//        this.btnXoa.addMouseListener(new MouseAdapter(){
//        public void mouseClicked(MouseEvent e){
//             super.mouseClicked(e);
//             xl.deleteCB(id);
//             model.removeRow(tb.getSelectedRow()); 
//            }
//           
//        });
//              this.btnXoa.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int nam = Integer.parseInt(cbNamXB.getSelectedItem().toString());
//                xl.deleteSA(nam);
//                Hienthi();
//            }
//        });
//        this.btnSua.addMouseListener(new MouseAdapter(){
//        public void mouseClicked(MouseEvent e){

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//             super.mouseClicked(e);
//             model.setRowCount(0);
//             Canbo cb = new Canbo();
//             String gt = rbNam.isSelected() ? "Nam":"Nu";
//             cb.setSoTK(id);
//             cb.setHoten(txtTen.getText());
//             cb.setGT(gt);
//             cb.setDiachi(cbDiachi.getSelectedItem().toString());
//             cb.setLuong(Double.valueOf(txtLuong.getText()));
//             xl.updateCB(cb);
//             hienthi();
//            }
//           
//        });
//    }
//    public void hienthi(){
//        ArrayList<Canbo> cb = xl.getCB();
//        model.setRowCount(0);
//        for(int i=0;i<cb.size();i++){
//            String[] row ={
//              cb.get(i).getSoTK(),
//                cb.get(i).getHoten(),
//                cb.get(i).getGT(),
//                cb.get(i).getDiachi(),
//                  String.valueOf(sach.get(i).getNamSX()),// khi la kieu int
//                cb.get(i).getLuong().toString(),
//            };
//            model.addRow(row);
//        }
//    }

