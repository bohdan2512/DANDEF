import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Encrypt extends JFrame {

//Створення об'єктів інтерфейсної частини вікна шифрування.
       public void TextAreaTest() {
           ENCDEC proc = new ENCDEC();
           JPanel pan = new JPanel(new GridLayout(0,1,0,5));
           pan.setBorder(BorderFactory.createTitledBorder(""));
           ButtonGroup btngrp = new  ButtonGroup();
           JRadioButton ENC,DEC;
           ENC = new JRadioButton("Зашифрувати");
           pan.add(ENC);
           btngrp.add(ENC);
           ENC.setFont(new Font("Arial", Font.BOLD,16));
           ENC.setSelected(true);
           DEC = new JRadioButton("Розшифрувати");
           pan.add(DEC);
           btngrp.add(DEC);
           DEC.setFont(new Font("Arial", Font.BOLD,16));
           JPanel pan2 = new JPanel(new GridLayout(0,1,0,5));
           pan2.setBorder(BorderFactory.createTitledBorder(""));
           ButtonGroup btngrp2 = new  ButtonGroup();
           JRadioButton RU,ENG;
           RU = new JRadioButton("Російський(UA)");
           pan2.add(RU);
           RU.setFont(new Font("Arial", Font.BOLD,16));
           btngrp2.add(RU);
           ENG = new JRadioButton("Англійський");
           pan2.add(ENG);
           ENG.setFont(new Font("Arial", Font.BOLD,16));
           btngrp2.add(ENG);
           ENG.setSelected(true);
           JTextArea area1 = new JTextArea( 100, 100);
           area1.setTabSize(10);
           area1.setFont(new Font("Arial",Font.BOLD,20));
           JTextArea area2 = new JTextArea(100, 100);
           area2.setFont(new Font("Arial",Font.BOLD,20));
           area1.setLineWrap(true);
           area1.setWrapStyleWord(true);
           area2.setLineWrap(true);
           area2.setWrapStyleWord(true);
           JScrollPane area11 = new JScrollPane(area1);
           JScrollPane area22 = new JScrollPane(area2);
//Обробка кнопки "Виконати"
           JButton b1 = new JButton("Виконати");
           b1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(ENC.isSelected()){
                       String message = area1.getText();
                       if(ENG.isSelected()){
                       char m1 = 'a';
                       char m2 = 'z';
                       area2.setText(proc.getCodeString(message, m1, m2));}
                       if (RU.isSelected()){
                           char m1 = 'а';
                           char m2 = 'я';
                           area2.setText(proc.getCodeString(message, m1, m2));
                       }
                   }
                   if(DEC.isSelected()){
                       String message = area1.getText();
                       area2.setText(proc.getModiffString(message));
                   }
               }
           });

           JButton b2 = new JButton("Відкрити файл");
           JButton b3 = new JButton("Зберегти результат у файл");
           JButton b4 = new JButton("CLEAR");
           JButton b5 = new JButton("CLEAR");
           JButton b6 = new JButton("INFO");
           b1.setFont(new Font("Arial",Font.BOLD,20));
           b2.setFont(new Font("Arial",Font.BOLD,20));
           b3.setFont(new Font("Arial",Font.BOLD,20));
           b4.setFont(new Font("Arial",Font.BOLD,20));
           b5.setFont(new Font("Arial",Font.BOLD,20));
           b6.setFont(new Font("Arial",Font.BOLD, 20));
           JLabel m = new JLabel("Вхідний текст");
           m.setBounds(50,75,300,25);
           m.setFont(new Font("Arial",Font.BOLD,24));
           JLabel n = new JLabel("Результат виконання");
           JLabel rez = new JLabel("Режим роботи програми");
           JLabel alph = new JLabel("Алфавіт");
           alph.setFont(new Font("Arial",Font.BOLD,20));
           rez.setFont(new Font("Arial",Font.BOLD,16));
           n.setBounds(1050,75,300,25);
           n.setFont(new Font("Arial",Font.BOLD,24));
           this.setLayout(null);
          area11.setBounds(50,100,800,800);
           area22.setBounds(1050,100,800,800);
           b1.setBounds(880,400,140,30);
           b2.setBounds(50,900,230,25);
           b4.setBounds(280,900,100,25);
           b5.setBounds(1370,900,100,25);
           b6.setBounds(890,550,120,30);
           b3.setBounds(1050,900,320,25);
           pan.setBounds(875,300,150,80);
           pan2.setBounds(873,450,153,80);
           rez.setBounds(850,270,200,30);
           alph.setBounds(890,425,150,30);
           //Додавання всіх елементів на вікно.
this.add(area11);this.add(area22);this.add(m);this.add(n);this.add(b1);this.add(b2);this.add(b3);this.add(pan);this.add(pan2);this.add(rez);this.add(alph);this.add(b4);this.add(b5);this.add(b6);
//Обробка допоміжних кнопок вікна шифрування
           b2.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   JFileChooser fileopen = new JFileChooser();
                   int ret = fileopen.showDialog(null, "Відкрити файл");
                   if (ret == JFileChooser.APPROVE_OPTION)
                   {
                       File file = fileopen.getSelectedFile();
                       try {
                           BufferedReader br = new BufferedReader(
                                   new FileReader(file));
                           String s = br.readLine();
                           String str = "";
                           while(s != null){
                               str += s + "\n";
                               s = br.readLine();

                           }
                           area1.setText(str);
                       }
                       catch(IOException ex){
                           System.out.println(ex.getMessage());
                       }
                   }
               }
           });

           b3.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   JFileChooser fileopen = new JFileChooser();
                   int ret = fileopen.showDialog(null, "Відкрити файл");
                   if (ret == JFileChooser.APPROVE_OPTION) {
                       File file = fileopen.getSelectedFile();
                       BufferedWriter writer = null;
                       String s;
                       try
                       {
                           s = area2.getText();
                           writer = new BufferedWriter( new FileWriter( file));
                           writer.write(s);

                       }
                       catch ( IOException ex)
                       {
                       }
                       finally
                       {
                           try
                           {
                               if ( writer != null)
                                   writer.close( );
                           }
                           catch ( IOException ex)
                           {
                           }
                       }
                   }
               }
           });

           b4.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   area1.setText("");
               }
           });

           b5.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   area2.setText("");
               }
           });

           b6.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   WndInf wnd3 = new WndInf("Task");
                   wnd3.add(new DrawInfo());
                   wnd3.setBounds(400,200,1300,250);
                   wnd3.setResizable(false);
               }
           });
           setTitle("ENCRYPT");
           setSize(400, 300);
           setVisible(true);
           //setResizable(false);
           setExtendedState(MAXIMIZED_BOTH);

       }

}
