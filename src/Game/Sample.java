package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Sample {
  public static void main(String[] args) {
    JFrame f1=new JFrame();
    JPanel p1=new JPanel();
    p1.setPreferredSize(new Dimension(1000,500));
    f1.add(p1);
    f1.pack();
    Graphics g=p1.getGraphics();
    f1.setVisible(true);
    Image back=null;
    Image cloud=null;
    Image fTree=null;
    Image bTree=null;
    Image grass=null;
    try {
      back=ImageIO.read(Sample.class.getResource("../images/back1.png"));
      cloud=ImageIO.read(Sample.class.getResource("../images/clouds.png"));
      bTree=ImageIO.read(Sample.class.getResource("../images/back_trees.png"));
      fTree=ImageIO.read(Sample.class.getResource("../images/front_trees.png"));
      grass=ImageIO.read(Sample.class.getResource("../images/ground.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Image cloud1=cloud;
    Image cloud2=cloud;
    Image bTree1=bTree;
    Image bTree2=bTree;
    Image fTree1=fTree;
    Image fTree2=fTree;
    Image grass1=grass;
    Image grass2=grass;
    int cx1=0;
    int cx2=1000;
    int fx1=0;
    int fx2=1000;
    int bx1=0;
    int bx2=1000;
    int gx1=0;
    int gx2=1000;

    while(true){
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      g.drawImage(back,0,0,null);
      g.drawImage(cloud1,cx1,0,null);
      g.drawImage(cloud2,cx2,0,null);
      g.drawImage(bTree1,bx1,0,null);
      g.drawImage(bTree2,bx2,0,null);
      g.drawImage(fTree1,fx1,0,null);
      g.drawImage(fTree2,fx2,0,null);
      g.drawImage(grass1,gx1,0,null);
      g.drawImage(grass2,gx2,0,null);
      gx1-=30;
      gx2-=30;
      if(gx1<=-1000)
        gx1=1000;
      if(gx2<=-1000)
        gx2=1000;

      fx1-=25;
      fx2-=25;
      if(fx1<=-1000)
        fx1=1000;
      if(fx2<=-1000)
        fx2=1000;

      bx1-=20;
      bx2-=20;
      if(bx1<=-1000)
        bx1=1000;
      if(bx2<=-1000)
        bx2=1000;

      cx1-=15;
      cx2-=15;
      if(cx1<=-1000)
        cx1=1000;
      if(cx2<=-1000)
        cx2=1000;
    }
  }
}
