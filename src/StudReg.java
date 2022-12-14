import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class StudReg extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    public StudReg() {
        initComponents();
        setExtendedState(getExtendedState() | StudReg.MAXIMIZED_BOTH);
        Increment();
        txtId.requestFocus();  
    }
    public void Increment()
    {
         Connection conn;
         try{
           int id = 0;
           ResultSet rs;
           
           String query;
           Class.forName("oracle.jdbc.driver.OracleDriver"); 
           conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mvw@123"); 
           Statement st=conn.createStatement();
           query="select MAX(id) as s from Student";
           rs=st.executeQuery(query);
           while(rs.next())
            {
               
                   id =rs.getInt("s")+1;
               
               
               txtId.setText(Integer.toString(id));
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    public void Insert()
   {
       PreparedStatement pst;
       try
       {
          String query;
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mvw@123");
          query="insert into Student values(?,?,?,?,?,?)";
          pst=conn.prepareStatement(query);
          pst.setString(1, txtId.getText());
          pst.setString(2, txtName.getText());
          pst.setString(3, txtAddress.getText());
          
          
          pst.setString(4, txtMob.getText());
          pst.setString(5, txtClass.getText());
         // pst.setDate(6, new java.sql.Date((DOB.getDate().getTime())));
          
          pst.setString(6, gender);
          
          pst.execute();
          JOptionPane.showMessageDialog(null,"Student Record Saved");
          txtName.setText(null);
          txtAddress.setText(null);
          txtClass.setText(null);
          txtMob.setText(null);
          pst.close();
          conn.close();
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
           System.out.print(e);
       }
   }
    public void Update()
   {
    
    try{
          String query;
           Class.forName("oracle.jdbc.driver.OracleDriver"); 
           conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mvw@123");  
        
            query="UPDATE Student SET Id='"+ txtId.getText() +"',Name='"+ txtName.getText() +"',Address='"+ txtAddress.getText() +"',Mob='"+ txtMob.getText() +"',Class='"+ txtClass.getText() +"',Gender='"+ gender +"' WHERE ID="+ txtId.getText() +"";
            pst=conn.prepareStatement(query);
            pst.executeUpdate();
             pst.close();
             conn.close();
           JOptionPane.showMessageDialog(null,"Record Updated Successfully");
      } catch(Exception e)
      {
         JOptionPane.showMessageDialog(null,e); 
      } 
    }
    public void Delete()
    {
        try
        {
            String query;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mvw@123");
            Statement stmt=conn.createStatement();
            query="DELETE FROM Student WHERE Id="+ txtId.getText() +"";
            stmt.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Record Deleted");
            txtName.setText(null);
            txtAddress.setText(null);
            txtClass.setText(null);
            txtMob.setText(null);   
            stmt.close();
            conn.close();

        } catch(Exception e)
      {
         JOptionPane.showMessageDialog(null,e); 
      } 
    }
    private String gender;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtClass = new javax.swing.JTextField();
        txtMob = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        rdFemale = new javax.swing.JRadioButton();
        rdMale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Address");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 160, 100, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Class");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 300, 80, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mobile No");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 360, 110, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 100, 90, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 420, 90, 22);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Id");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 40, 90, 20);

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(txtName);
        txtName.setBounds(290, 90, 320, 40);

        txtClass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassActionPerformed(evt);
            }
        });
        jPanel1.add(txtClass);
        txtClass.setBounds(290, 290, 320, 40);

        txtMob.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(txtMob);
        txtMob.setBounds(290, 350, 320, 40);

        txtId.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(txtId);
        txtId.setBounds(290, 30, 320, 40);

        Add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel1.add(Add);
        Add.setBounds(200, 530, 110, 50);

        Update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update);
        Update.setBounds(360, 530, 130, 50);

        Delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete);
        Delete.setBounds(520, 530, 120, 50);

        Search.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel1.add(Search);
        Search.setBounds(40, 470, 130, 50);

        Cancel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel);
        Cancel.setBounds(630, 460, 130, 50);

        rdFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdFemale);
        rdFemale.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        rdFemale.setText("Female");
        rdFemale.setActionCommand("female");
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });
        jPanel1.add(rdFemale);
        rdFemale.setBounds(420, 420, 90, 27);

        rdMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdMale);
        rdMale.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        rdMale.setText("Male");
        rdMale.setActionCommand("male");
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });
        jPanel1.add(rdMale);
        rdMale.setBounds(300, 420, 70, 27);

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(290, 150, 320, 120);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(570, 250, 820, 600);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setText("Student Registraion Form");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(800, 180, 440, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\Manasi\\Image\\23-238361_blue-moon-wallpaper-over-the-river-hd-background.jpg")); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-100, -20, 2080, 1260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        gender = "Male" ;     // TODO add your handling code here:
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        gender = "Female" ;         // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        Insert() ;        // TODO add your handling code here:
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        Update();        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try
        {
        
         String query;
          Class.forName("oracle.jdbc.driver.OracleDriver"); 
        
         conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mvw@123");
       
         query="select * from Student WHERE Id="+ txtId.getText() +"";  
      
               pst=conn.prepareStatement(query);
               rs=pst.executeQuery();
         
         while(rs.next())
         {
         txtId.setText(rs.getString("Id"));
         txtName.setText(rs.getString("Name"));
         txtAddress.setText(rs.getString("Address"));
         txtClass.setText(rs.getString("Class"));
         txtMob.setText(rs.getString("Mob"));
         
         
         String gender=rs.getString("Gender");
         if(gender.equals("Male"))
        {
               rdMale.setSelected(true);
               
         }else
         {
                  rdFemale.setSelected(true);
              
         }
         JOptionPane.showMessageDialog(null,"Search Completed");
         }
         
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
             
            JOptionPane.showMessageDialog(null,"Not Found!");
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        txtName.setText(null);
        txtAddress.setText(null);
        txtClass.setText(null);
        txtMob.setText(null);       
    }//GEN-LAST:event_CancelActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Delete();        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

    private void txtClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Search;
    private javax.swing.JButton Update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMob;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
