/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Silicon
 */
public class TableChanged implements TableModelListener{

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        System.out.println(column);
        if (column == 7) {            
            TableModel model = (TableModel) e.getSource();
            String columnName = model.getColumnName(column);
            Boolean checked = (Boolean) model.getValueAt(row, column);
            System.out.println(checked);
            
                 System.out.println(row+"   "+column);
            if (checked==true) {
                Connection con;
               ResultSet rs;
               PreparedStatement ps;
               con = DBconnect.connect();
                try {
                  
                    System.out.println((String) model.getValueAt(row, 1));
                    ps = con.prepareStatement("INSERT INTO event_stud(event_id,stud_name,stud_id,event_name) VALUES(?,?,?,?)");
                    ps.setInt(1, (int) model.getValueAt(row, 0));
                    
                    ps.setString(2,AlumniLogin.a_n);
                    ps.setString(3,AlumniLogin.a_enroll);
                    ps.setString(4, (String) model.getValueAt(row, 1));
                   //int index=  
                           ps.executeUpdate();
                   //System.out.println(index);
                   //(String)new AlumniLogin().getName()(String)new AlumniLogin().getEnroll()
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TableChanged.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            } 
           else if (checked==false) {
                Connection con;
               ResultSet rs;
               PreparedStatement ps;
               con = DBconnect.connect();
                try {
                  
                    //System.out.println((String) model.getValueAt(row, 1));
                    ps = con.prepareStatement("DELETE from event_stud where stud_id=? AND event_id=?");
                    ps.setString(1,AlumniLogin.a_enroll);
                    int i=(int)model.getValueAt(row,0);
                   
                     ps.setInt(2,(int)model.getValueAt(row,0));
                    
           
                   //int index=  
                           ps.executeUpdate();
                   //System.out.println(index);
                   //(String)new AlumniLogin().getName()(String)new AlumniLogin().getEnroll()
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TableChanged.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }else {
                System.out.println(columnName + ": " + false);
            }
        }
    }
    
}
