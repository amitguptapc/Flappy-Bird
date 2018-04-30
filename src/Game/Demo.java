package Game;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

public class Demo implements KeyListener {
  private static int yCord = 285;
  private static int yVel = 0;
  private static int yAcc = 0;
  private static int logYCord = 70;
  private static int xVal = 1100;
  private static boolean started = false;
  private static boolean paused = false;
  private static boolean lost = false;
  private static int hurdle1XCord,hurdle1YCord,hurdle2XCord,hurdle2YCord,hurdle3XCord,hurdle4XCord,hurdle3YCord,hurdle4YCord;
  private static int starXCord=1000;
  private static int starYCord,coinYCord,coinXCord;
  private static int score = 0;
  private static int counter=60;
  private static boolean isPlayerVisible=true,coinDisplay,starVisible;
  private static Image hurdle[] = new Image[4];
  private static Rectangle hurdle1Rect, hurdle2Rect, hurdle3Rect, hurdle4Rect,starRect,coinRect;
  private static Image branch;
  private static Font font1 = new Font("Kristen ITC", Font.BOLD, 22);
  private static Font font2 = new Font("Kristen ITC", Font.BOLD, 18);
  private static Font font3 = new Font("Kristen ITC", Font.PLAIN, 16);

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(1000, 500));
    frame.add(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    Graphics g = panel.getGraphics();
    panel.setFocusable(true);
    panel.requestFocus();
    Demo p = new Demo();
    panel.addKeyListener(p);
    Image back;
    back = null;
    Image back1 = null;
    Image p1 = null;
    Image p2 = null;
    Image p3 = null;
    Image p4 = null;
    Image p5 = null;
    Image p6 = null;
    Image p7 = null;
    Image p8 = null;
    Image pt1 = null;
    Image pt2 = null;
    Image pt3 = null;
    Image pt4 = null;
    Image pt5 = null;
    Image pt6 = null;
    Image pt7 = null;
    Image pt8 = null;
    Image log = null;
    Image fork = null;
    Image forkRev = null;
    Image forkHandle = null;
    Image forkHandleRev = null;
    Image controls = null;
    Image star = null;
    Image coin1 = null;
    Image coin2 = null;
    Image coin3 = null;
    Image coin4 = null;


    try {
      back = ImageIO.read(Demo.class.getResource("../images/back.png"));
      back1 = ImageIO.read(Demo.class.getResource("../images/back.png"));
      p1 = ImageIO.read(Demo.class.getResource("../images/pappu_1.png"));
      p2 = ImageIO.read(Demo.class.getResource("../images/pappu_2.png"));
      p3 = ImageIO.read(Demo.class.getResource("../images/pappu_3.png"));
      p4 = ImageIO.read(Demo.class.getResource("../images/pappu_4.png"));
      p5 = ImageIO.read(Demo.class.getResource("../images/pappu_5.png"));
      p6 = ImageIO.read(Demo.class.getResource("../images/pappu_6.png"));
      p7 = ImageIO.read(Demo.class.getResource("../images/pappu_7.png"));
      p8 = ImageIO.read(Demo.class.getResource("../images/pappu_8.png"));
      pt1 = ImageIO.read(Demo.class.getResource("../images/pappu1.png"));
      pt2 = ImageIO.read(Demo.class.getResource("../images/pappu2.png"));
      pt3 = ImageIO.read(Demo.class.getResource("../images/pappu3.png"));
      pt4 = ImageIO.read(Demo.class.getResource("../images/pappu4.png"));
      pt5 = ImageIO.read(Demo.class.getResource("../images/pappu5.png"));
      pt6 = ImageIO.read(Demo.class.getResource("../images/pappu6.png"));
      pt7 = ImageIO.read(Demo.class.getResource("../images/pappu7.png"));
      pt8 = ImageIO.read(Demo.class.getResource("../images/pappu8.png"));
      star = ImageIO.read(Demo.class.getResource("../images/star.png"));
      coin1 = ImageIO.read(Demo.class.getResource("../images/coin1.png"));
      coin2 = ImageIO.read(Demo.class.getResource("../images/coin2.png"));
      coin3 = ImageIO.read(Demo.class.getResource("../images/coin3.png"));
      coin4 = ImageIO.read(Demo.class.getResource("../images/coin4.png"));
      forkHandle = ImageIO.read(Demo.class.getResource("../images/fork_handle.png"));
      forkHandleRev = ImageIO.read(Demo.class.getResource("../images/fork_handlerev.png"));
      Demo.branch = ImageIO.read(Demo.class.getResource("../images/branch.png"));
      fork = ImageIO.read(Demo.class.getResource("../images/fork_head.png"));
      forkRev = ImageIO.read(Demo.class.getResource("../images/fork_headrev.png"));
      log = ImageIO.read(Demo.class.getResource("../images/log.png"));
      controls = ImageIO.read(Demo.class.getResource("../images/controls.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    int backxcord = 0;
    int back1xcord = 1000;
    int count = 0;

    hurdle[0] = branch;
    hurdle[1] = branch;
    hurdle[2] = branch;
    hurdle[3] = branch;
    starVisible=false;
    Image imageArray[] = {p1, p2, p3, p4, p5, p6, p7, p8};
    Image tImageArray[] = {pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8};
    Image coinArray[] = {coin1,coin2,coin3,coin4};
    int scoreArray[]={50,100,200,500};
    Demo.hurdle1XCord = 1000;
    Demo.hurdle2XCord = 1000;
    Demo.hurdle3XCord = 1500;
    Demo.hurdle4XCord = 1500;
    Demo.hurdle1YCord = -300;
    Demo.hurdle2YCord = 350;
    Demo.hurdle3YCord = -400;
    Demo.hurdle4YCord = 250;
    starRect=new Rectangle(41,39);
    coinRect=new Rectangle(30,30);
    Random ran = new Random();
    boolean forkOrBranch;
    boolean upOrDown;
    coinDisplay=false;
    int length,whichCoin=0;
    Image coinShown=null;
    hurdle1Rect = new Rectangle(Demo.hurdle1XCord, Demo.hurdle1YCord, 31, 500);
    hurdle2Rect = new Rectangle(Demo.hurdle2XCord, Demo.hurdle2YCord, 31, 500);
    hurdle3Rect = new Rectangle(Demo.hurdle3XCord, Demo.hurdle3YCord, 31, 500);
    hurdle4Rect = new Rectangle(Demo.hurdle4XCord, Demo.hurdle4YCord, 31, 500);
    Rectangle playerRect = new Rectangle(60, 60);
    while (true) {
      try {
        Thread.sleep(70);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (Demo.paused) {
        g.setColor(Color.RED);
        g.setFont(font1);
        g.drawString("Game Paused !", 400, 230);
        g.drawString("Press SpaceBar to continue !!", 310, 265);
        continue;
      }

      if (Demo.lost) {
        g.setColor(Color.RED);
        g.setFont(font1);
        g.drawString("Game Over !", 400, 230);
        g.drawString("Press Enter to Restart !!", 310, 265);
        continue;
      }

      count = (count + 1) % 8;

      g.drawImage(back, backxcord, 0, null);
      g.drawImage(back1, back1xcord, 0, null);
      g.drawImage(log, Demo.logYCord, 330, null);
      g.drawImage(Demo.hurdle[0], Demo.hurdle1XCord, Demo.hurdle1YCord, null);
      g.drawImage(Demo.hurdle[1], Demo.hurdle2XCord, Demo.hurdle2YCord, null);
      g.drawImage(Demo.hurdle[2], Demo.hurdle3XCord, Demo.hurdle3YCord, null);
      g.drawImage(Demo.hurdle[3], Demo.hurdle4XCord, Demo.hurdle4YCord, null);
      if(ran.nextInt(20)==4&&Demo.hurdle1XCord>=700&&Demo.hurdle1XCord<=800&&!starVisible&&Demo.isPlayerVisible) {
        starVisible=true;
        Demo.starYCord=ran.nextInt(200)+100;
        Demo.starXCord=1000;
      }
      playerRect.x = 63;
      playerRect.y = Demo.yCord;
      if(starVisible){
        g.drawImage(star,Demo.starXCord,Demo.starYCord,null);
        Demo.starRect.x=Demo.starXCord;
        Demo.starRect.y=Demo.starYCord;
      }
      if(starRect.intersects(playerRect)&&starVisible){
        starVisible=false;
        starRect.x=1000;
        starRect.y=1000;
        Demo.isPlayerVisible=false;
      }
      if(!Demo.isPlayerVisible){
        g.setColor(Color.RED);
        g.setFont(font3);
        counter--;
        g.drawString("Powered UP : " +counter, 850, 30);
      }
      if(counter<=0){
        Demo.isPlayerVisible=true;
        counter=60;
      }


      if(ran.nextInt(20)==4&&Demo.hurdle3XCord>=700&&Demo.hurdle3XCord<=800&&!coinDisplay) {
        Demo.coinYCord=ran.nextInt(200)+100;
        Demo.coinXCord=1000;
        whichCoin=ran.nextInt(4);
        coinDisplay=true;
        coinShown=coinArray[whichCoin];
      }

      if(coinDisplay){
        g.drawImage(coinShown,Demo.coinXCord,Demo.coinYCord,null);
        Demo.coinRect.x=Demo.coinXCord;
        Demo.coinRect.y=Demo.coinYCord;
      }

      if(playerRect.intersects(coinRect)&&coinDisplay){
        coinDisplay=false;
        score+=scoreArray[whichCoin];
      }

      Demo.coinXCord-=20;
      if(Demo.coinXCord<=-30)
      {
        coinDisplay=false;
      }


      if(Demo.isPlayerVisible)
        g.drawImage(imageArray[count], 63, Demo.yCord, null);
      else
        g.drawImage(tImageArray[count], 63, Demo.yCord, null);

      if (!Demo.started) {
        g.drawImage(controls, 400, 227, null);
        continue;
      }


      if (Demo.hurdle1XCord <= -33 && Demo.hurdle2XCord <= 33) {
        forkOrBranch = ran.nextBoolean();
        if (!forkOrBranch) {
          Demo.hurdle[0] = branch;
          Demo.hurdle[1] = branch;
          hurdle1Rect.height = hurdle2Rect.height = 500;
          hurdle1Rect.width = hurdle2Rect.width = 31;
          Demo.hurdle1XCord = 1000;
          Demo.hurdle2XCord = 1000;
          length = ran.nextInt(250) + 150;
          Demo.hurdle1YCord = -1 * length;
          Demo.hurdle2YCord = Demo.hurdle1YCord + 650;
        } else {
          upOrDown = ran.nextBoolean();
          hurdle1Rect.height = 312;
          hurdle1Rect.width = 22;
          hurdle2Rect.height = 59;
          hurdle2Rect.width = 33;
          if (upOrDown) {
            Demo.hurdle[0] = forkHandleRev;
            Demo.hurdle[1] = forkRev;
            length = ran.nextInt(112) + 60;
            Demo.hurdle1YCord = -1 * length;
            Demo.hurdle2YCord = Demo.hurdle1YCord + 312;
            Demo.hurdle1XCord = 1005;
            Demo.hurdle2XCord = 1000;
          } else {
            Demo.hurdle[0] = forkHandle;
            Demo.hurdle[1] = fork;
            length = ran.nextInt(150) + 250;
            Demo.hurdle1YCord = length;
            Demo.hurdle2YCord = Demo.hurdle1YCord - 59;
            Demo.hurdle1XCord = 1005;
            Demo.hurdle2XCord = 998;
          }

        }
      }
      if (Demo.hurdle3XCord <= -33 && Demo.hurdle4XCord <= 33) {
        forkOrBranch = ran.nextBoolean();
        if (forkOrBranch) {
          Demo.hurdle[2] = branch;
          Demo.hurdle[3] = branch;
          hurdle3Rect.height = hurdle4Rect.height = 500;
          hurdle3Rect.width = hurdle4Rect.width = 31;
          Demo.hurdle3XCord = 1000;
          Demo.hurdle4XCord = 1000;
          length = ran.nextInt(250) + 150;
          Demo.hurdle3YCord = -1 * length;
          Demo.hurdle4YCord = Demo.hurdle3YCord + 650;
        } else {
          upOrDown = ran.nextBoolean();
          hurdle3Rect.height = 312;
          hurdle3Rect.width = 22;
          hurdle4Rect.height = 59;
          hurdle4Rect.width = 33;
          if (upOrDown) {
            Demo.hurdle[2] = forkHandleRev;
            Demo.hurdle[3] = forkRev;
            length = ran.nextInt(112) + 60;
            Demo.hurdle3YCord = -1 * length;
            Demo.hurdle4YCord = Demo.hurdle3YCord + 312;
            Demo.hurdle3XCord = 1005;
            Demo.hurdle4XCord = 1000;
          } else {
            Demo.hurdle[2] = forkHandle;
            Demo.hurdle[3] = fork;
            length = ran.nextInt(150) + 250;
            Demo.hurdle3YCord = length;
            Demo.hurdle4YCord = Demo.hurdle3YCord - 59;
            Demo.hurdle3XCord = 1005;
            Demo.hurdle4XCord = 998;
          }
        }
      }

      hurdle1Rect.x = Demo.hurdle1XCord;
      hurdle2Rect.x = Demo.hurdle2XCord;
      hurdle3Rect.x = Demo.hurdle3XCord;
      hurdle4Rect.x = Demo.hurdle4XCord;
      hurdle1Rect.y = Demo.hurdle1YCord;
      hurdle2Rect.y = Demo.hurdle2YCord;
      hurdle3Rect.y = Demo.hurdle3YCord;
      hurdle4Rect.y = Demo.hurdle4YCord;

      if ((playerRect.intersects(hurdle1Rect) || playerRect.intersects(hurdle2Rect) || playerRect.intersects(hurdle3Rect) || playerRect.intersects(hurdle4Rect))&&Demo.isPlayerVisible)
        Demo.lost = true;

      g.setColor(Color.BLACK);
      g.setFont(font2);
      g.drawString("Your Score : " + Demo.score, 30, 40);
      Demo.score++;

      starXCord-=20;
      if(starXCord<-40)
        starVisible=false;
      Demo.yCord += Demo.yVel;
      Demo.yVel += Demo.yAcc;

      Demo.hurdle1XCord -= 20;
      Demo.hurdle2XCord -= 20;
      Demo.hurdle3XCord -= 20;
      Demo.hurdle4XCord -= 20;

      if (yCord > 560 || yCord < -60) {
        Demo.lost = true;
      }

      if (Demo.logYCord > -79)
        Demo.logYCord -= 20;
      xVal = xVal - 15;
      if (xVal < 0)
        xVal = 1100;


      backxcord -= 20;
      if (backxcord <= -1000)
        backxcord = 1000;
      if (back1xcord <= -1000)
        back1xcord = 1000;
      back1xcord -= 20;

    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP && !Demo.paused && !Demo.lost) {
      Demo.started = true;
      Demo.yVel = -20;
      Demo.yAcc = 4;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE && Demo.started && !Demo.lost)
      Demo.paused = !Demo.paused;
    if (e.getKeyCode() == KeyEvent.VK_ENTER && Demo.lost) {
      Demo.lost = false;
      Demo.started = false;
      Demo.yCord = 285;
      Demo.hurdle1XCord = 1000;
      Demo.hurdle2XCord = 1000;
      Demo.hurdle3XCord = 1500;
      Demo.hurdle4XCord = 1500;
      Demo.hurdle1YCord = -300;
      Demo.hurdle2YCord = 400;

      Demo.hurdle3YCord = -400;
      Demo.hurdle4YCord = 300;
      Demo.hurdle[0] = branch;
      Demo.hurdle[1] = branch;
      Demo.hurdle[2] = branch;
      Demo.hurdle[3] = branch;
      Demo.logYCord = 70;
      Demo.score = 0;
      Demo.isPlayerVisible=true;
      Demo.coinDisplay=false;
      Demo.starVisible=false;
      hurdle1Rect = new Rectangle(Demo.hurdle1XCord, Demo.hurdle1YCord, 31, 500);
      hurdle2Rect = new Rectangle(Demo.hurdle2XCord, Demo.hurdle2YCord, 31, 500);
      hurdle3Rect = new Rectangle(Demo.hurdle3XCord, Demo.hurdle3YCord, 31, 500);
      hurdle4Rect = new Rectangle(Demo.hurdle4XCord, Demo.hurdle4YCord, 31, 500);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}