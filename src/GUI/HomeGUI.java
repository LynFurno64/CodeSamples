package GUI;

import GUI.AddClientsGUI;
import GUI.AppointmentGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 * @author Ché Alexander
 */
public class HomeGUI extends JFrame {

    // Variables declaration
    static JButton addclient, appointment, browse;
    static JPanel center, east, west, north, south;
    static JLabel title, text, text1, text2, text3;

    //Creates new form HomeGUI
    public HomeGUI() {
        initComponents();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form in a thread*/
        java.awt.EventQueue.invokeLater(() -> {
            HomeGUI start = new HomeGUI();
            centreFrame(start);
            start.setVisible(true);
        });
    }

    public static void centreFrame(HomeGUI fr) {
        // Get size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w, h, x, y;
        w = fr.getSize().width;
        h = fr.getSize().height;
        x = (dim.width - w) / 2;
        y = (dim.height - h) / 2;
        // Move the Window
        fr.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new JLabel("Home");
        north = new JPanel();
        south = new JPanel();
        east = new JPanel();
        west = new JPanel();
        center = new JPanel();
        text = new JLabel("Welcome to the GUI Demo");
        text1 = new JLabel("Browsing the Database");
        text2 = new JLabel("Adding Customer Database");
        text3 = new JLabel("Appointment Forms");
        browse = new JButton("Database Browse");
        addclient = new JButton("Customer SignUp");
        appointment = new JButton("Appointment Forms");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Page");

        north.setBackground(new Color(102, 255, 255));
        north.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        north.setForeground(new Color(0, 0, 0));

        title.setBackground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", 1, 24)); // NOI18N
        title.setForeground(new Color(0, 0, 0));
        north.add(title);

        getContentPane().add(north, BorderLayout.PAGE_START);

        east.setBackground(new Color(204, 255, 255));
        getContentPane().add(east, BorderLayout.LINE_END);

        west.setBackground(new Color(204, 255, 255));
        getContentPane().add(west, BorderLayout.LINE_START);

        center.setBackground(new Color(204, 204, 204));
        center.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createTitledBorder("")));
        center.setForeground(new Color(255, 255, 255));

        text.setFont(new Font("Arial", 1, 18)); // NOI18N
        text.setForeground(new Color(0, 0, 0));

        text2.setFont(new Font("Arial", 0, 18)); // NOI18N
        text2.setForeground(new Color(0, 0, 0));

        text3.setFont(new Font("Arial", 0, 18)); // NOI18N
        text3.setForeground(new Color(0, 0, 0));

        text1.setFont(new Font("Arial", 0, 18)); // NOI18N
        text1.setForeground(new Color(0, 0, 0));

        browse.setBackground(new Color(204, 204, 204));
        browse.setFont(new Font("Arial", 1, 14)); // NOI18N
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        addclient.setBackground(new Color(204, 204, 204));
        addclient.setFont(new Font("Arial", 1, 14)); // NOI18N
        addclient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addclientActionPerformed(evt);
            }
        });

        appointment.setBackground(new Color(204, 204, 204));
        appointment.setFont(new Font("Arial", 1, 14)); // NOI18N
        appointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appointmentActionPerformed(evt);
            }
        });

        GroupLayout centerLayout = new GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
                centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(centerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(text)
                                        .addGroup(centerLayout.createSequentialGroup()
                                                .addGroup(centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(text2)
                                                        .addComponent(text3)
                                                        .addComponent(text1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(appointment, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                        .addComponent(addclient, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                        .addComponent(browse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        centerLayout.setVerticalGroup(
                centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(centerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(text)
                                .addGap(18, 18, 18)
                                .addGroup(centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(text2)
                                        .addComponent(addclient))
                                .addGap(18, 18, 18)
                                .addGroup(centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(text3)
                                        .addComponent(appointment))
                                .addGap(18, 18, 18)
                                .addGroup(centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(browse))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(center, BorderLayout.CENTER);

        south.setBackground(new Color(204, 255, 255));
        getContentPane().add(south, BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addclientActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        new AddClientsGUI().setVisible(true);
    }//addclientActionPerformed

    private void appointmentActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        new AppointmentGUI().setVisible(true);
    }//appointmentActionPerformed

    private void browseActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }//browseActionPerformed
}
