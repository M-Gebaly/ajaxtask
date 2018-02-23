/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lisner;

import Servelts.LoginServelt;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

/**
 * Web application lifecycle listener.
 *
 * @author M.Gebaly
 */
public class ContextDBConnect implements ServletContextListener {
    Connection conn;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Sample","app","app");
            sce.getServletContext().setAttribute("conn", conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
