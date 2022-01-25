import java.awt.*;

public class DrawAuthor extends Canvas {
//Контент вікна Author
    public void paint(Graphics g){
        Image im = Toolkit.getDefaultToolkit().getImage("Author.jpg");
        g.drawImage(im,590,0,170,180,this);
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,16));
        g.drawString("Автор роботи: bohdan2512",10,20);
        g.drawString("Група - ----",10,40);
        g.drawString("Факультет - ІТКІ",10,60);
        g.drawString("За підтрмкою, чи побажаннями писати на пошту - example@gmail.com",10,80);
    }
}
