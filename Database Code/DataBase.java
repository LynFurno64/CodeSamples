import GUI.HomeGUI;
import methods.Notice;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import java.util.Vector;


public class DataBase extends JFrame {
    final static String CUSTOMERPANEL = "Customer";
    final static String APPOINTPANEL = "All Appointment";
    final static String VALIDPANEL = "Valid Appointment";
    final static int extraWindowWidth = 100;
    public JComboBox comboCustomer, comboAppoint;
    Notice note = new Notice();
    private JTable customerTable, appointTable, validTable;
    private Object[] data;
    private DefaultTableModel model;
    private Connection conn;
    private JTextField t, t1;

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        DataBase demo = new DataBase();
        demo.addComponentToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        centerFrame(frame);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        //</editor-fold>
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void centerFrame(JFrame fr) {
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
    }// centerFrame

    public void addComponentToPane(Container pane) {
        //Add Panels to the BorderLayout in Card 1
        JPanel north = new JPanel();
        north.setBackground(new Color(102, 255, 255));
        north.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        JPanel south = new JPanel();
        south.setBackground(new Color(204, 255, 255));
        south.setLayout(new FlowLayout());

        //Add Panels to the BorderLayout in Card 2
        JPanel north1 = new JPanel();
        north1.setBackground(new Color(102, 255, 255));
        north1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        JPanel south1 = new JPanel();
        south1.setBackground(new Color(204, 255, 255));
        south1.setLayout(new FlowLayout());

        //Add Panels to the BorderLayout in Card 3
        JPanel north2 = new JPanel();
        north2.setBackground(new Color(102, 255, 255));
        north2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        JPanel south2 = new JPanel();
        south2.setBackground(new Color(204, 255, 255));
        south2.setLayout(new FlowLayout());

        //create Combobox Customer
        String[] combo1 = new String[]{" ", "ID", "Name", "Surname", "Sex", "Birthday", "Address", "Country", "Province", "Postal Code", "Cell Number", "Home Number", "Email"};
        comboCustomer = new JComboBox<>(combo1);
        comboCustomer.setBounds(10, 10, 100, 25);
        comboCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboCustomerActionPerformed(e);
            }
        });
        north.add(comboCustomer);
        //create Combobox All Appointment
        String[] combo2 = new String[]{" ", "ID", "Name", "Number", "Email", "Date", "Time"};
        comboAppoint = new JComboBox<>(combo2);
        comboAppoint.setBounds(10, 10, 100, 25);
        comboAppoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboAppointActionPerformed(e);
            }
        });
        north1.add(comboAppoint);


        //create text in Card 1
        t = new JTextField(20);
        t.setBounds(130, 10, 120, 25);
        north.add(t);
        //create text in Card 2
        t1 = new JTextField(20);
        t1.setBounds(130, 10, 120, 25);
        north1.add(t1);
        //create text in Card 3


        //create button in Card 1
        JButton b = new JButton("Browse");
        b.setBounds(270, 10, 100, 25);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed(e);
            }
        });
        north.add(b);
        //create button in Card 2
        JButton b1 = new JButton("Browse");
        b1.setBounds(270, 10, 100, 25);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        north1.add(b1);
        //create button in Card 3
        JButton b2 = new JButton("Browse");
        b2.setBounds(270, 10, 100, 25);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        south2.add(b2);

        //headers for the table Customer
        String[] columns0 = new String[]{"ID", "Name", "Surname", "Sex", "Birthday", "Address", "Country", "Province", "Postal Code", "Cell Number", "Home Number", "Email", "Password"};
        TableModel tableModel0 = new DefaultTableModel(columns0, 0);
        customerTable = new JTable(tableModel0);
        customerTable.setRowHeight(25);
        JScrollPane scrollPane0 = new JScrollPane(customerTable);
        scrollPane0.setPreferredSize(new Dimension(1000, 400));
        scrollPane0.setBounds(10, 60, 360, 350);

        //headers for the table All Appointment
        String[] columns1 = new String[]{"ID", "Name", "Number", "Email", "Date", "Time", "Reason", "Question"};
        TableModel tableModel1 = new DefaultTableModel(columns1, 0);
        appointTable = new JTable(tableModel1);
        appointTable.setRowHeight(25);
        JScrollPane scrollPane1 = new JScrollPane(appointTable);
        scrollPane1.setBounds(10, 60, 360, 350);

        //headers for the table Valid Id
        String[] columns2 = new String[]{"ID", "Name", "Cell Number", "Home Number", "Email", "Date", "Time", "Reason"};
        TableModel tableModel2 = new DefaultTableModel(columns2, 0);
        validTable = new JTable(tableModel2);
        validTable.setRowHeight(25);
        JScrollPane scrollPane2 = new JScrollPane(validTable);
        scrollPane2.setBounds(10, 60, 360, 350);

        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel card1 = new JPanel(new BorderLayout()) {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        card1.add("North", north);
        card1.add(scrollPane0);
        card1.add("South", south);

        JPanel card2 = new JPanel(new BorderLayout());
        card2.add("North", north1);
        card2.add(scrollPane1);
        card2.add("South", south1);

        JPanel card3 = new JPanel(new BorderLayout());
        card3.add("North", north2);
        card3.add(scrollPane2);
        card3.add("South", south2);

        tabbedPane.addTab(CUSTOMERPANEL, card1);
        tabbedPane.addTab(APPOINTPANEL, card2);
        tabbedPane.addTab(VALIDPANEL, card3);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    private void button1ActionPerformed(ActionEvent e) {
        Vector<Appointment> cus_rec = getData1();
        model = (DefaultTableModel) appointTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < cus_rec.size(); i++) {
            data = new Object[]{cus_rec.elementAt(i).ID, cus_rec.elementAt(i).fullname, cus_rec.elementAt(i).ph_num, cus_rec.elementAt(i).email,
                    cus_rec.elementAt(i).date, cus_rec.elementAt(i).time, cus_rec.elementAt(i).reason, cus_rec.elementAt(i).yesno};
            model.addRow(data);
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        Vector<Valid> cus_rec = getData2();
        model = (DefaultTableModel) validTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < cus_rec.size(); i++) {
            data = new Object[]{cus_rec.elementAt(i).id, cus_rec.elementAt(i).name, cus_rec.elementAt(i).cell, cus_rec.elementAt(i).home,
                    cus_rec.elementAt(i).email, cus_rec.elementAt(i).date, cus_rec.elementAt(i).time, cus_rec.elementAt(i).reason};
            model.addRow(data);
        }
    }

    private void buttonActionPerformed(ActionEvent e) {
        Vector<Customer> cus_rec = getData();
        model = (DefaultTableModel) customerTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < cus_rec.size(); i++) {
            data = new Object[]{cus_rec.elementAt(i).id, cus_rec.elementAt(i).name, cus_rec.elementAt(i).surname, cus_rec.elementAt(i).gender,
                    cus_rec.elementAt(i).birthday, cus_rec.elementAt(i).address, cus_rec.elementAt(i).country, cus_rec.elementAt(i).province,
                    cus_rec.elementAt(i).zip_code, cus_rec.elementAt(i).cell_num, cus_rec.elementAt(i).home_num, cus_rec.elementAt(i).email, cus_rec.elementAt(i).password};
            model.addRow(data);
        }
    }

    private void comboCustomerActionPerformed(ActionEvent e) {
    }

    private void comboAppointActionPerformed(ActionEvent e) {
    }

    public Vector<Customer> getData() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2001assign2", "2001assign2", "assign2");

            if (conn != null) {
                String fieldname = Objects.requireNonNull(comboCustomer.getSelectedItem()).toString();
                String textvalue = t.getText();
                System.out.println("fieldname= " + fieldname);
                System.out.println("textvalue= " + textvalue);

                String query;
                if (fieldname.equals("ID") || fieldname.equals("Name") || fieldname.equals("Surname") || fieldname.equals("Sex")
                        || fieldname.equals("Birthday") || fieldname.equals("Address") || fieldname.equals("Country") || fieldname.equals("Province")
                        || fieldname.equals("Postal Code") || fieldname.equals("Cell Number") || fieldname.equals("Home Number") || fieldname.equals("Email")) {
                    if (textvalue.equals("")) {
                        note.notExist();
                        query = "SELECT * FROM addclient";
                    } else {
                        query = "SELECT * FROM addclient WHERE " + fieldname + " LIKE '%" + textvalue + "%'"; // our SQL SELECT query.
                    }
                } else {
                    query = "SELECT * FROM addclient"; // our SQL SELECT query.
                }

                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY); // create the java statement and make the cursor move back and forward
                ResultSet rs = st.executeQuery(query);// execute the query, and get a java resultset

                Vector<Customer> vec = new Vector<>();

                if (!rs.next()) {
                    note.notExist();
                }
                rs.previous();
                while (rs.next()) // iterate through the java resultset
                {
                    String id = rs.getString("ID");
                    String name = rs.getString("Name");
                    String surname = rs.getString("Surname");
                    String gender = rs.getString("Sex");
                    String birthday = rs.getString("Birthday");
                    String address = rs.getString("Address");
                    String country = rs.getString("Country");
                    String province = rs.getString("Province");
                    String zip_code = rs.getString("Postal_Code");
                    String cell = rs.getString("Cell_Number");
                    String home = rs.getString("Home_Number");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    vec.addElement(new Customer(id, name, surname, gender, birthday, address, country, province, zip_code, cell, home, email, password));
                }
                st.close();
                return vec;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public Vector<Appointment> getData1() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2001assign2", "2001assign2", "assign2");

            if (conn != null) {
                String fieldname = Objects.requireNonNull(comboAppoint.getSelectedItem()).toString();
                String textvalue = t1.getText();
                System.out.println("fieldname= " + fieldname);
                System.out.println("textvalue= " + textvalue);

                String query;
                if (fieldname.equals("ID") || fieldname.equals("Name") || fieldname.equals("Number") || fieldname.equals("Email")
                        || fieldname.equals("Date") || fieldname.equals("Time")) {
                    if (textvalue.equals("")) {
                        note.notExist();
                        query = "SELECT * FROM appointment";
                    } else {
                        query = "SELECT * FROM appointment WHERE " + fieldname + " LIKE '%" + textvalue + "%'"; // our SQL SELECT query.
                    }
                } else {
                    query = "SELECT * FROM appointment"; // our SQL SELECT query.
                }

                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY); // create the java statement and make the cursor move back and forward
                ResultSet rs = st.executeQuery(query);// execute the query, and get a java resultset

                Vector<Appointment> vec = new Vector<>();

                if (!rs.next()) {
                    note.notExist();
                }
                rs.previous();
                while (rs.next()) // iterate through the java resultset
                {
                    String id = rs.getString(1);
                    String fullname = rs.getString(2);
                    String phone = rs.getString(3);
                    String email = rs.getString(4);
                    String date = rs.getString(5);
                    String time = rs.getString(6);
                    String reason = rs.getString(7);
                    String question = rs.getString(8);
                    vec.addElement(new Appointment(id, fullname, phone, email, date, time, reason, question));
                }
                st.close();
                return vec;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public Vector<Valid> getData2() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2001assign2", "2001assign2", "assign2");

            if (conn != null) {

                String query = "SELECT addclient.ID, appointment.Name, appointment.Number, addclient.Home_Number, appointment.Email, appointment.Date, appointment.Time, appointment.Reason \n" +
                        "FROM addclient\n" +
                        "INNER JOIN appointment\n" +
                        "ON addclient.ID= appointment.ID;"; // our SQL SELECT query.

                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY); // create the java statement and make the cursor move back and forward
                ResultSet rs = st.executeQuery(query);// execute the query, and get a java resultset

                Vector<Valid> vec = new Vector<>();

                if (!rs.next()) {
                    note.notExist();
                }
                rs.previous();
                while (rs.next()) // iterate through the java resultset
                {
                    String id = rs.getString("ID");
                    String name = rs.getString("Name");
                    String number = rs.getString("Number");
                    String home = rs.getString("Home_Number");
                    String email = rs.getString("Email");
                    String date = rs.getString("Date");
                    String time = rs.getString("Time");
                    String reason = rs.getString("Reason");

                    vec.addElement(new Valid(id, name, number, home, email, date, time, reason));
                }
                st.close();
                return vec;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    static class Customer {
        public String name, surname, gender, email, password, birthday;
        public String cell_num, home_num;
        public String address, province, zip_code, country, id;

        public Customer(String i, String n, String s, String g, String b, String a, String c, String prov, String z, String cn, String hn, String e, String p) {
            id = i;
            name = n;
            surname = s;
            gender = g;
            birthday = b;
            address = a;
            country = c;
            province = prov;
            zip_code = z;
            cell_num = cn;
            home_num = hn;
            email = e;
            password = p;
        }
    }

    static class Appointment {
        public String fullname, ph_num, email, yesno, reason, time, date, ID;

        public Appointment(String i, String fn, String pn, String e, String d, String t, String r, String q) {
            ID = i;
            fullname = fn;
            ph_num = pn;
            email = e;
            date = d;
            time = t;
            reason = r;
            yesno = q;
        }
    }

    static class Valid {
        public String id, name, cell, home, email, date, time, reason;

        public Valid(String i, String n, String c, String h, String e, String d, String t, String r) {
            id = i;
            name = n;
            cell = c;
            home = h;
            email = e;
            date = d;
            time = t;
            reason = r;
        }
    }
}
