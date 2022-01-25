import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyWin extends JFrame {
    DrawMain dn;
//Контент головного вікна
    MyWin(String s){
        super(s);
        Sound.playSound("start.aiff");//Фраза звукового асистента
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,600,400);
        setVisible(true);


        JButton b1 = new JButton("START");
        b1.setBackground(Color.blue);
       b1.setForeground(Color.white);
        JPanel pn = new JPanel();
        pn.setLayout(new GridLayout(1,0));
        pn.add(b1);
        this.setLayout(new BorderLayout());
        this.add(new DrawMain(),BorderLayout.CENTER);
        this.add(pn,BorderLayout.SOUTH);
//Обробка кнопки START
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound.playSound("main.aiff");//Фраза звукового асистента
                Encrypt n = new Encrypt();
                n.setBounds(250,150,700,600);
                n.TextAreaTest();
            }
        });

        dn = new DrawMain();
        this.add(dn);
//Меню бар, його елементи і їх обробка
            JMenuBar mb = new JMenuBar();
            setJMenuBar(mb);
            JMenu mFile = new JMenu("ABOUT");
            JMenuItem mExit = new JMenuItem("Quit"),
                    mAuthor = new JMenuItem("Author"),
                    mTask = new JMenuItem("Task");
            mExit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Sound.playSound("stop.aiff");System.exit(0);//Фраза звукового асистента
                }
            });
            mAuthor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Sound.playSound("author.aiff");//Фраза звукового асистента
                    WndInf wnd2 = new WndInf("Author");
                    wnd2.add(new DrawAuthor());
                    wnd2.setBounds(250,150,790,200);
                    wnd2.setResizable(false);
                }
            });
            mTask.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Sound.playSound("task.aiff");//Фраза звукового асистента
                    WndInf wnd3 = new WndInf("Task");
                    wnd3.add(new DrawInfo());
                    wnd3.setBounds(400,200,1300,250);
                    wnd3.setResizable(false);
                }
            });
            mFile.add(mExit);
            mFile.add(mAuthor);
            mFile.add(mTask);
            mb.add(mFile);
//Випадаюче меню, його елементи і їх обробка
JPopupMenu popup = new JPopupMenu();
        JMenuItem task, author;
        popup.add(author = new JMenuItem("Author", new ImageIcon("1.gif")));
        popup.add(task = new JMenuItem("Task", new ImageIcon("1.gif")));
        //item.setHorizontalTextPosition(JMenuItem.RIGHT);
        //item.addActionListener(menuListener);
        task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound.playSound("task.aiff");//Фраза звукового асистента
                WndInf wnd3 = new WndInf("Task");
                wnd3.add(new DrawInfo());
                wnd3.setBounds(400,200,1300,250);
                wnd3.setResizable(false);
            }

        });
        author.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sound.playSound("author.aiff");//Фраза звукового асистента
                WndInf wnd2 = new WndInf("Автор");
                wnd2.add(new DrawAuthor());
                wnd2.setBounds(250,150,790,200);
                wnd2.setResizable(false);
            }
        });

            dn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {


                    if( SwingUtilities.isRightMouseButton (e) )
                   popup.show(dn, e.getX(), e.getY());
                }
            });

       }

}
