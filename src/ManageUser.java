/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;  
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;  



public class ManageUser extends javax.swing.JFrame {
        private Connection connection;


    /**
     * Creates new form ManageUser
     */
    public ManageUser() {
        initComponents();
            try {
                connection=DatabaseConnector.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        refreshUserTable();
    }
 private void refreshUserTable() {
       DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();  // userTable is the JTable
    model.setRowCount(0);  // Clear the current table data

    String sql = "SELECT * FROM userdetails";  // SQL to fetch all user data

    try (Connection con = DatabaseConnector.getConnection(); 
         Statement stmt = con.createStatement(); 
         ResultSet rs = stmt.executeQuery(sql)) {

        // Loop through the result set and populate the table
        while (rs.next()) {
            Object[] row = new Object[5];
            row[0] = rs.getInt("UID"); 
            row[1] = rs.getString("UName");  // Assuming column names are UName, UContactNo, Username, UPassword
            row[2] = rs.getString("UContactNo");
            row[3] = rs.getString("Username");
            row[4] = rs.getString("UPassword");
            model.addRow(row);  // Add the row to the table model
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
 
   private boolean isUsernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM userdetails WHERE Username = ?";  // SQL query to check username

        try (Connection con = DatabaseConnector.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, username);  // Set the username parameter

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);  // Get the count of rows with the username
                    return count > 0;  // Return true if the username already exists, false otherwise
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error checking username: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;  // If no matching username was found
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tfContactNo = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Contact No.", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setText("Contact No.");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 90, 20));

        tfContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactNoActionPerformed(evt);
            }
        });
        jPanel2.add(tfContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 260, -1));

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        jPanel2.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 260, -1));

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 260, -1));

        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 90, 20));

        jLabelName.setText("Name");
        jPanel2.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 90, 20));

        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 90, 20));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 0, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setText("Manage User");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 192, -1));

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 260, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/swiftlogosmall.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactNoActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
      String name = tfName.getText();  // Get name from input field
        String contactNo = tfContactNo.getText();  // Get contact number from input field
        String username = tfUsername.getText();  // Get username from input field
        String password = tfPassword.getText();  // Get password from password field

        // Step 2: Validate the inputs (You can add more validation here)
        if (name.isEmpty() || contactNo.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
          if (isUsernameExists(username)) {
        JOptionPane.showMessageDialog(this, "Username already exists. Please choose another one.", "Username Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

          String sql = "INSERT INTO userdetails (UName, UContactNo, Username, UPassword) VALUES (?, ?, ?, ?)";

        // Step 4: Connect to the database and execute the query
        try (Connection con = DatabaseConnector.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set values to the prepared statement placeholders
            pst.setString(1, name);
            pst.setString(2, contactNo);
            pst.setString(3, username);
            pst.setString(4, password);  // It's a good idea to hash the password before saving it

            // Execute the query
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "User saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshUserTable();  
                   
            tfName.setText("");
            tfContactNo.setText("");
            tfUsername.setText("");
            tfPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error saving user", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
                             
        
    }//GEN-LAST:event_btnSaveActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // Get user inputs from the fields
       int selectedRow = tblUsers.getSelectedRow();
        
        // Check if any row is selected
        if (selectedRow != -1) {
            // Get the UID (assumed to be in the first column of the table)
            int selectedUID = (int) tblUsers.getValueAt(selectedRow, 0); 
            
            // Get the updated values from text fields
            String name = tfName.getText();
            String contactNo = tfContactNo.getText();
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            
            // Validate inputs
            if (name.isEmpty() || contactNo.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(ManageUser.this, "All fields must be filled out!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
              String hashedPassword = PasswordUtils.hashPassword(password);

            
            // SQL query to update user details
            String sql = "UPDATE userdetails SET UName = ?, UContactNo = ?, Username = ?, UPassword = ? WHERE UID = ?";
            
            try (PreparedStatement pst = connection.prepareStatement(sql)) {
                // Set the updated values to the prepared statement
                pst.setString(1, name);
                pst.setString(2, contactNo);
                pst.setString(3, username);
                pst.setString(4, password); // Ideally, you would hash the password before saving it
                pst.setInt(5, selectedUID);
                
                // Execute the query and check the result
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(ManageUser.this, "User updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    refreshUserTable(); // Refresh the table after update
                    
                tfName.setText("");
                tfContactNo.setText("");
                tfUsername.setText("");
                tfPassword.setText("");
                } else {
                    JOptionPane.showMessageDialog(ManageUser.this, "Error updating user", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(ManageUser.this, "Error updating user: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(ManageUser.this, "Please select a user first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
           int selectedRow = tblUsers.getSelectedRow();
        
        // Check if any row is selected
        if (selectedRow != -1) {
            // Get the UID (assumed to be in the first column of the table)
            int selectedUID = (int) tblUsers.getValueAt(selectedRow, 0); 
            
            // SQL query to delete the user
            String sql = "DELETE FROM userdetails WHERE UID = ?";
            
            try (PreparedStatement pst = connection.prepareStatement(sql)) {
                // Set the UID to the prepared statement
                pst.setInt(1, selectedUID);
                
                // Execute the query and check the result
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(ManageUser.this, "User deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    refreshUserTable(); // Refresh the table after deletion
                } else {
                    JOptionPane.showMessageDialog(ManageUser.this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(ManageUser.this, "Error deleting user: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(ManageUser.this, "Please select a user first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    
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
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField tfContactNo;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}