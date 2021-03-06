/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumni;

import static alumni.AdminBlog.value;
import static alumni.AdminBlog.value2;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshada
 */
public class EventDisplay extends javax.swing.JFrame {

    /**
     * Creates new form EventDisplay
     */
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    static String event__id;
    public EventDisplay() {
         this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        
        con=DBconnect.connect();
        	
		
                String col[]={"ID","Name","Date","Venue","Department","Aim","Time"};
		DefaultTableModel dtm=new DefaultTableModel(null,col);
		JTable jt=new JTable(dtm);
               // jt.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
              Font font = new Font("Calibri", Font.PLAIN,20);
                jt.setFont(font);
                jt.getAutoResizeMode();
                jt.setRowHeight(20);
		//jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jsp=new JScrollPane(jt);
		this.add(jsp);
                jt.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ev){
                    if(ev.getClickCount()==1)
                    {
                        int column=0;
                        int row=jt.getSelectedRow();
                        event__id=jt.getModel().getValueAt(row,column).toString();
                       
                        EventsUpdate st=new EventsUpdate();
                        st.setVisible(true);
                       
                    }
                }
                });
                 jsp.setBounds(50, 50, 1500, 1500);
		try
		{
			ps=con.prepareStatement("select * from events");
		
                        rs=ps.executeQuery();
			  while(rs.next())
			  {
                              String s1=rs.getString("time");
                              String s2=rs.getString("c");
                              String s3=s1.concat(s2);
				dtm.addRow(new Object[] {rs.getInt("event_id"),rs.getString("name"),rs.getString("date"),rs.getString("venue"),rs.getString("dept"),rs.getString("aim"),s3});//,rs.getString("enroll_no"),rs.getString("address"),rs.getString("mobile_no"),rs.getString("dept")});
			  } 
                          
                         
           
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jb_back.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jb_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumni/Images/return_arrow.png"))); // NOI18N
        jb_back.setText("Back");
        jb_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1057, Short.MAX_VALUE)
                .addComponent(jb_back, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(jb_back)
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_backActionPerformed
        // TODO add your handling code here:
        // AlumniBlog ab=new AlumniBlog();
        Events ab=new Events();
        ab.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jb_backActionPerformed

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
            java.util.logging.Logger.getLogger(EventDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_back;
    // End of variables declaration//GEN-END:variables
}
