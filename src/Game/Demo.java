package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

public class Demo implements KeyListener {
  private static int yCord=285;
  private static int yVel=0;
  private static int yAcc=0;
  private static int logYCord=70;
  private static int xVal=1100;
  private static boolean started=false;
  private static boolean paused=false;
  private static boolean lost=false;
  private static int hurdle1XCord;
  private static int hurdle2XCord;
  private static int hurdle1YCord;
  private static int hurdle2YCord;
  private static int hurdle3YCord;
  private static int hurdle4YCord;
  private static int score=0;
  private static Font font1=new Font("Kristen ITC",Font.BOLD,22);
  private static Font font2=new Font("Kristen ITC",Font.BOLD,18);
  public static void main(String[] args) {
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    panel.setPreferredSize(new Dimension(1000,500));
    frame.add(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    Graphics g=panel.getGraphics();
    panel.setFocusable(true);
    panel.requestFocus();
    Demo p=new Demo();
    panel.addKeyListener(p);
    Image back=null;
    Image back1=null;
    Image p1=null;
    Image p2=null;
    Image p3=null;
    Image p4=null;
    Image p5=null;
    Image p6=null;
    Image p7=null;
    Image p8=null;
    Image log=null;
    Image fork=null;
    Image forkHandle=null;
    Image branch=null;
    Image controls=null;
    try {
      back=ImageIO.read(Demo.class.getResource("../images/back.png"));
      back1=ImageIO.read(Demo.class.getResource("../images/back.png"));
      p1=ImageIO.read(Demo.class.getResource("../images/pappu_1.png"));
      p2=ImageIO.read(Demo.class.getResource("../images/pappu_2.png"));
      p3=ImageIO.read(Demo.class.getResource("../images/pappu_3.png"));
      p4=ImageIO.read(Demo.class.getResource("../images/pappu_4.png"));
      p5=ImageIO.read(Demo.class.getResource("../images/pappu_5.png"));
      p6=ImageIO.read(Demo.class.getResource("../images/pappu_6.png"));
      p7=ImageIO.read(Demo.class.getResource("../images/pappu_7.png"));
      p8=ImageIO.read(Demo.class.getResource("../images/pappu_8.png"));
      forkHandle=ImageIO.read(Demo.class.getResource("../images/fork_handle.png"));
      branch=ImageIO.read(Demo.class.getResource("../images/branch.png"));
      fork=ImageIO.read(Demo.class.getResource("../images/fork_head.png"));
      log=ImageIO.read(Demo.class.getResource("../images/log.png"));
      controls=ImageIO.read(Demo.class.getResource("../images/controls.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    int backxcord=0;
    int back1xcord=1000;
    int count=0;
    Image hurdle[]={branch,branch,branch,branch};
    Image imageArray[]={p1,p2,p3,p4,p5,p6,p7,p8};
    Demo.hurdle1XCord=1000;
    Demo.hurdle2XCord=1500;
    Demo.hurdle1YCord = -300;
    Demo.hurdle2YCord=350;
    Demo.hurdle3YCord=-400;
    Demo.hurdle4YCord=250;
    Random ran=new Random();
    int decide;
    Rectangle hurdle1Rect=new Rectangle(31,500);
    Rectangle hurdle2Rect=new Rectangle(31,500);
    Rectangle hurdle3Rect=new Rectangle(31,500);
    Rectangle hurdle4Rect=new Rectangle(31,500);
    Rectangle playerRect=new Rectangle(60,60);
    while(true) {
      try {
        Thread.sleep(70);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if(Demo.paused)
      {
        g.setColor(Color.RED);
        g.setFont(font1);
        g.drawString("Game Paused !",400,230);
        g.drawString("Press SpaceBar to continue !!",310,265);
        continue;
      }

      if(Demo.lost){
        g.setColor(Color.RED);
        g.setFont(font1);
        g.drawString("Game Over !",400,230);
        g.drawString("Press Enter to Restart !!",310,265);
        continue;
      }

      count=(count+1)%8;
      g.drawImage(back, backxcord, 0, null);
      g.drawImage(back1, back1xcord, 0, null);
      g.drawImage(log,Demo.logYCord,330,null);
      g.drawImage(hurdle[0],Demo.hurdle1XCord,Demo.hurdle1YCord,null);
      g.drawImage(hurdle[1],Demo.hurdle1XCord,Demo.hurdle2YCord,null);
      g.drawImage(hurdle[2],Demo.hurdle2XCord,Demo.hurdle3YCord,null);
      g.drawImage(hurdle[3],Demo.hurdle2XCord,Demo.hurdle4YCord,null);
      g.drawImage(imageArray[count],63,Demo.yCord,null);


      if(!Demo.started)
      {
        g.drawImage(controls,400,227,null);
        continue;
      }
      hurdle1Rect.x=hurdle1XCord;
      hurdle2Rect.x=hurdle1XCord;
      hurdle3Rect.x=hurdle2XCord;
      hurdle4Rect.x=hurdle2XCord;
      hurdle1Rect.y=hurdle1YCord;
      hurdle2Rect.y=hurdle2YCord;
      hurdle3Rect.y=hurdle3YCord;
      hurdle4Rect.y=hurdle4YCord;
      playerRect.x=63;
      playerRect.y=Demo.yCord;
      if(playerRect.intersects(hurdle1Rect)||playerRect.intersects(hurdle2Rect)||playerRect.intersects(hurdle3Rect)||playerRect.intersects(hurdle4Rect))
      Demo.lost=true;
      Demo.hurdle1XCord-=20;
      Demo.hurdle2XCord-=20;

      if(Demo.hurdle1XCord<=-33){
        Demo.hurdle1XCord=1000;
        decide=ran.nextInt(250)+150;
        Demo.hurdle1YCord=-1*decide;
        Demo.hurdle2YCord=Demo.hurdle1YCord+650;
      }
      if(Demo.hurdle2XCord<=-33){
        Demo.hurdle2XCord=1000;
        decide=ran.nextInt(250)+150;
        Demo.hurdle3YCord=-1*decide;
        Demo.hurdle4YCord=Demo.hurdle3YCord+650;
      }
      g.setColor(Color.BLACK);
      g.setFont(font2);
      g.drawString("Your Score : "+Demo.score,400,50);
      Demo.score++;

      Demo.yCord+=Demo.yVel;
      Demo.yVel+=Demo.yAcc;

      if(yCord>560||yCord<-60){
        Demo.lost=true;
      }

      if(Demo.logYCord>-79)
        Demo.logYCord-=10;
      xVal=xVal-15;
      if(xVal<0)
        xVal=1100;


      backxcord-=20;
      if(backxcord<=-1000)
        backxcord=1000;
      if(back1xcord<=-1000)
        back1xcord=1000;
      back1xcord-=20;

    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_UP&&!Demo.paused&&!Demo.lost){
      Demo.started=true;
      Demo.yVel=-20;
      Demo.yAcc=4;
    }
    if(e.getKeyCode()==KeyEvent.VK_SPACE&&Demo.started&&!Demo.lost)
      Demo.paused=!Demo.paused;
    if(e.getKeyCode()==KeyEvent.VK_ENTER&&Demo.lost)
    {
      Demo.lost=false;
      Demo.started=false;
      Demo.yCord=285;
      Demo.hurdle1XCord=1000;
      Demo.hurdle2XCord=1500;
      Demo.hurdle1YCord = -300;
      Demo.hurdle2YCord=400;
      Demo.hurdle3YCord=-400;
      Demo.hurdle4YCord=300;
      Demo.logYCord=70;
      Demo.score=0;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}