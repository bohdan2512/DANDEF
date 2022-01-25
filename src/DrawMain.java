import java.awt.*;

public class DrawMain extends Canvas {
    public void paint(Graphics g){
        Image im = Toolkit.getDefaultToolkit().getImage("giphy (1).gif");//Анімація на фоні головного вікна
        g.drawImage(im,0,0,getWidth(),getHeight(),this);
    }
}
