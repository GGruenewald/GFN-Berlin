/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstform;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class TestForm {

    JFrame form = new JFrame();
    private JPanel contentpanel = new JPanel();
    private JButton button1 = new JButton("Test 1");
    private JButton button2 = new JButton("Test 2");
    private JTextField textfield1 = new JTextField();
    JLabel label1 = new JLabel();
    private JComboBox<String> combobox1 = new JComboBox<>();
    private JMenuBar menubar = new JMenuBar();
    private JMenu filemenu = new JMenu("Datei");
    private JMenuItem newformmenitem = new JMenuItem("öffne Form");
    private JMenuItem exitmenitem = new JMenuItem("beenden");

    private JCheckBox testcomponente = new JCheckBox();

    public TestForm() {
        createForm();
        createMenu();
        //form.add(contentpanel);
        form.setContentPane(contentpanel);

        form.setVisible(true);
    }

    private void createMenu() {
        form.setJMenuBar(menubar);
        filemenu.setMnemonic('D');
        menubar.add(filemenu);
        filemenu.add(newformmenitem);
        filemenu.addSeparator();
        
        //Icon ico = new ImageIcon("c:\\test\\close.png");
        Icon ico = null;
        String imagepath = "resources/close.png";
        java.net.URL icourl = this.getClass().getResource(imagepath);
        if (icourl != null) ico = new ImageIcon(icourl);
        
        exitmenitem.setIcon(ico);
        filemenu.add(exitmenitem);
        exitmenitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newformmenitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TestForm tf = new TestForm();
            }
        });
    }

    private void createForm() {
        form.setSize(400, 300);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setTitle("Mein erstes Formular");
        form.setLocation(50, 50);
        Image myicon = new ImageIcon("c:\\test\\close.png").getImage();
        form.setIconImage(myicon);

        contentpanel.setLayout(null);
        button1.setSize(80, 25);
        button1.setLocation(10, 10);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedButton1();

            }
        });

        button2.setSize(80, 25);
        button2.setLocation(10, 40);
        textfield1.setSize(100, 25);
        textfield1.setLocation(100, 10);
        label1.setSize(100, 25);
        label1.setLocation(100, 40);
        label1.setText("Dies ist ein Label");
        Color color = new Color(0xff, 0x00, 0xff);
        label1.setForeground(color);
        combobox1.setSize(100, 25);
        combobox1.setLocation(10, 70);
        for (int i = 1; i <= 10; i++) {
            combobox1.addItem("Wert " + i);
        }
        combobox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JOptionPane.showMessageDialog(form, "Sie haben "
                        + combobox1.getSelectedItem().toString() + " gewählt");
            }
        });

        testcomponente.setSize(100, 25);
        testcomponente.setLocation(10, 100);
        testcomponente.setText("chech it");

        contentpanel.add(button1);
        contentpanel.add(button2);
        contentpanel.add(textfield1);
        contentpanel.add(label1);
        contentpanel.add(combobox1);
        contentpanel.add(testcomponente);

//        for (int i = 1; i < 10; i++) {
//            JButton b = new JButton("Button " + i);
//            contentpanel.add(b);
//        }
    }

    private void clickedButton1() {
        button2.setText("Will auch");
        contentpanel.setBackground(Color.yellow);
    }

}

class MyActionListener implements ActionListener {

    private TestForm form;

    public MyActionListener(TestForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        form.label1.setText("Button geklickt");
    }

}
