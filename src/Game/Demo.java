package Game;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Demo implements KeyListener {
  private static int yCord = 285;
  private static int yVel = 0;
  private static int yAcc = 0;
  private static int logYCord = 70;
  private static int xVal = 1100;
  private static int intruderXCord=500;
  private static int intruderYCord=500;
  private static int intruderYVel;
  private static int intruderYAcc;
  private static boolean started = false;
  private static boolean paused = false;
  private static boolean lost = false;
  private static int hurdle1XCord,hurdle1YCord,hurdle2XCord,hurdle2YCord,hurdle3XCord,hurdle4XCord,hurdle3YCord,hurdle4YCord;
  private static boolean hurdle1Visible,hurdle2Visible,hurdle3Visible,hurdle4Visible;
  private static int starXCord=1000;
  private static int starYCord,coinYCord,coinXCord,berriesYCord,berriesXCord;
  private static int[] cloneXCord = new int[3];
  private static int[] cloneYCord = new int[3];
  private static int score = 0;
  private static int counter=60;
  private static boolean isPlayerVisible=true,coinDisplay,starVisible,berriesVisible,clonesActive,intruderVisible;
  private static Image[] hurdle = new Image[4];
  private static Rectangle intruderRect;
  private static Rectangle hurdle1Rect, hurdle2Rect, hurdle3Rect, hurdle4Rect,starRect,coinRect,berriesRect,clone1Rect,clone2Rect,clone3Rect;
  private static Image branch;
  private static Image intruderShown;
  private static java.applet.AudioClip coinAudio;
  private static java.applet.AudioClip starAudio;
  private static java.applet.AudioClip berryAudio;
  private static java.applet.AudioClip flapAudio;
  private static java.applet.AudioClip themeAudio;
  private static java.applet.AudioClip hitAudio,jumpAudio;
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
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setResizable(false);
    Graphics g = panel.getGraphics();
    panel.setFocusable(true);
    panel.requestFocus();
    Demo p = new Demo();
    panel.addKeyListener(p);
    Image back = null;
    Image cloud = null;
    Image fTree = null;
    Image bTree = null;
    Image grass = null;
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
    Image berries = null;
    Image happyPakia = null;
    Image sadPakia = null;
    Image angryPakia = null;
    Demo.berriesVisible = false;
    Demo.clonesActive = false;
    Demo.hurdle1Visible = Demo.hurdle2Visible = Demo.hurdle3Visible = Demo.hurdle4Visible = true;
    int intruderNumber;
    int cx1 = 0;
    int cx2 = 1000;
    int fx1 = 0;
    int fx2 = 1000;
    int bx1 = 0;
    int bx2 = 1000;
    int gx1 = 0;
    int gx2 = 1000;
    try {
      back = ImageIO.read(Demo.class.getResource("../images/back1.png"));
      cloud = ImageIO.read(Demo.class.getResource("../images/clouds.png"));
      bTree = ImageIO.read(Demo.class.getResource("../images/back_trees.png"));
      fTree = ImageIO.read(Demo.class.getResource("../images/front_trees.png"));
      grass = ImageIO.read(Demo.class.getResource("../images/ground.png"));
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
      berries = ImageIO.read(Demo.class.getResource("../images/berries.png"));
      forkHandle = ImageIO.read(Demo.class.getResource("../images/fork_handle.png"));
      forkHandleRev = ImageIO.read(Demo.class.getResource("../images/fork_handlerev.png"));
      Demo.branch = ImageIO.read(Demo.class.getResource("../images/branch.png"));
      fork = ImageIO.read(Demo.class.getResource("../images/fork_head.png"));
      forkRev = ImageIO.read(Demo.class.getResource("../images/fork_headrev.png"));
      log = ImageIO.read(Demo.class.getResource("../images/log.png"));
      controls = ImageIO.read(Demo.class.getResource("../images/controls.png"));
      happyPakia = ImageIO.read(Demo.class.getResource("../images/happy_pakia.png"));
      sadPakia = ImageIO.read(Demo.class.getResource("../images/sad_pakia.png"));
      angryPakia = ImageIO.read(Demo.class.getResource("../images/angry_pakia.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Image cloud1 = cloud;
    Image cloud2 = cloud;
    Image bTree1 = bTree;
    Image bTree2 = bTree;
    Image fTree1 = fTree;
    Image fTree2 = fTree;
    Image grass1 = grass;
    Image grass2 = grass;
    coinAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/coin.wav"));
    starAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/star.wav"));
    flapAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/flap.wav"));
    berryAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/berry.wav"));
    themeAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/theme.wav"));
    hitAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/hit.wav"));
    jumpAudio = Applet.newAudioClip(Demo.class.getResource("../sounds/jump.wav"));

    int count = 0;
    Demo.themeAudio.loop();
    hurdle[0] = branch;
    hurdle[1] = branch;
    hurdle[2] = branch;
    hurdle[3] = branch;
    starVisible = false;
    //Image imageArray[] = {p1, p2, p3, p4, p5, p6, p7, p8};
    ArrayList<Image> imageArray = new ArrayList<>();
    imageArray.add(p1);
    imageArray.add(p2);
    imageArray.add(p3);
    imageArray.add(p4);
    imageArray.add(p5);
    imageArray.add(p6);
    imageArray.add(p7);
    imageArray.add(p8);
    Image[] tImageArray = {pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8};
    Image[] coinArray = {coin1, coin2, coin3, coin4};
    Image[] intrudersImage = {happyPakia, angryPakia, sadPakia};
    int[] scoreArray = {100, 200, 500, 1000};

    Demo.hurdle1XCord = 1000;
    Demo.hurdle2XCord = 1000;
    Demo.hurdle3XCord = 1500;
    Demo.hurdle4XCord = 1500;
    Demo.hurdle1YCord = -300;
    Demo.hurdle2YCord = 350;
    Demo.hurdle3YCord = -400;
    Demo.hurdle4YCord = 250;
    starRect = new Rectangle(41, 39);
    coinRect = new Rectangle(30, 30);
    berriesRect = new Rectangle(30, 42);
    clone1Rect = new Rectangle(60, 60);
    clone2Rect = new Rectangle(60, 60);
    clone3Rect = new Rectangle(60, 60);
    intruderRect = new Rectangle(52, 51);
    Random ran = new Random();
    boolean forkOrBranch;
    boolean upOrDown;
    coinDisplay = false;
    Demo.intruderVisible = false;
    int length, whichCoin = 0, decider;
    Image coinShown = null;
    hurdle1Rect = new Rectangle(Demo.hurdle1XCord, Demo.hurdle1YCord, 31, 500);
    hurdle2Rect = new Rectangle(Demo.hurdle2XCord, Demo.hurdle2YCord, 31, 500);
    hurdle3Rect = new Rectangle(Demo.hurdle3XCord, Demo.hurdle3YCord, 31, 500);
    hurdle4Rect = new Rectangle(Demo.hurdle4XCord, Demo.hurdle4YCord, 31, 500);
    Rectangle playerRect = new Rectangle(60, 60);


    Image bigImage = new BufferedImage(1000, 500, BufferedImage.TYPE_INT_RGB);
    Graphics imageGraphics = bigImage.getGraphics();

    while (true) {
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      g.drawImage(bigImage, 0, 0, null);
      if (Demo.paused) {
        imageGraphics.setColor(Color.RED);
        imageGraphics.setFont(font1);
        imageGraphics.drawString("Game Paused !", 400, 230);
        imageGraphics.drawString("Press SpaceBar to continue !!", 310, 265);
        continue;
      }

      if (Demo.lost) {
        imageGraphics.setColor(Color.RED);
        imageGraphics.setFont(font1);
        imageGraphics.drawString("Game Over !", 400, 230);
        imageGraphics.drawString("Press Enter to Restart !!", 310, 265);
        continue;
      }

      count = (count + 1) % 8;

      imageGraphics.drawImage(back,0,0,null);
      imageGraphics.drawImage(cloud1,cx1,0,null);
      imageGraphics.drawImage(cloud2,cx2,0,null);
      imageGraphics.drawImage(bTree1,bx1,0,null);
      imageGraphics.drawImage(bTree2,bx2,0,null);
      imageGraphics.drawImage(fTree1,fx1,0,null);
      imageGraphics.drawImage(fTree2,fx2,0,null);
      imageGraphics.drawImage(grass1,gx1,0,null);
      imageGraphics.drawImage(grass2,gx2,0,null);
      imageGraphics.drawImage(log, Demo.logYCord, 330, null);


      if (hurdle1Visible) {
        hurdle1Rect.x = Demo.hurdle1XCord;
        hurdle1Rect.y = Demo.hurdle1YCord;
        imageGraphics.drawImage(Demo.hurdle[0], Demo.hurdle1XCord, Demo.hurdle1YCord, null);
      }
      if (hurdle2Visible) {
        hurdle2Rect.x = Demo.hurdle2XCord;
        hurdle2Rect.y = Demo.hurdle2YCord;
        imageGraphics.drawImage(Demo.hurdle[1], Demo.hurdle2XCord, Demo.hurdle2YCord, null);
      }
      if (hurdle3Visible) {
        hurdle3Rect.x = Demo.hurdle3XCord;
        hurdle3Rect.y = Demo.hurdle3YCord;
        imageGraphics.drawImage(Demo.hurdle[2], Demo.hurdle3XCord, Demo.hurdle3YCord, null);
      }
      if (hurdle4Visible) {
        hurdle4Rect.x = Demo.hurdle4XCord;
        hurdle4Rect.y = Demo.hurdle4YCord;
        imageGraphics.drawImage(Demo.hurdle[3], Demo.hurdle4XCord, Demo.hurdle4YCord, null);
      }




      if (ran.nextInt(10) == 5 && Demo.hurdle1XCord >= 700 && Demo.hurdle1XCord <= 800 && !starVisible && Demo.isPlayerVisible) {
        starVisible = true;
        Demo.starYCord = ran.nextInt(200) + 100;
        Demo.starXCord = 1000;
      }
      playerRect.x = 63;
      playerRect.y = Demo.yCord;
      if (starVisible) {
        imageGraphics.drawImage(star, Demo.starXCord, Demo.starYCord, null);
        Demo.starRect.x = Demo.starXCord;
        Demo.starRect.y = Demo.starYCord;
      }
      if (starRect.intersects(playerRect) && starVisible) {
        Demo.starAudio.play();
        starVisible = false;
        starRect.x = 1000;
        starRect.y = 1000;
        Demo.isPlayerVisible = false;
      }
      if (!Demo.isPlayerVisible) {
        imageGraphics.setColor(Color.RED);
        imageGraphics.setFont(font3);
        counter--;
        imageGraphics.drawString("Powered UP : " + counter, 850, 30);
      }
      if (counter <= 0) {
        Demo.isPlayerVisible = true;
        counter = 60;
      }


      if (Demo.hurdle3XCord >= 700 && Demo.hurdle3XCord <= 800 && (!coinDisplay && !berriesVisible)) {
        decider = ran.nextInt(10);
        if (decider == 4 && !coinDisplay) {
          Demo.coinYCord = ran.nextInt(200) + 100;
          Demo.coinXCord = 1000;
          whichCoin = ran.nextInt(4);
          coinDisplay = true;
          coinShown = coinArray[whichCoin];
        } else if (decider == 8 && !berriesVisible) {
          Demo.berriesYCord = ran.nextInt(200) + 100;
          Demo.berriesXCord = 1000;
          berriesVisible = true;
        }
      }

      if (coinDisplay) {
        imageGraphics.drawImage(coinShown, Demo.coinXCord, Demo.coinYCord, null);
        Demo.coinRect.x = Demo.coinXCord;
        Demo.coinRect.y = Demo.coinYCord;
      }
      if (berriesVisible) {
        imageGraphics.drawImage(berries, Demo.berriesXCord, Demo.berriesYCord, null);
        Demo.berriesRect.x = Demo.berriesXCord;
        Demo.berriesRect.y = Demo.berriesYCord;
      }

      if (playerRect.intersects(coinRect) && coinDisplay) {
        Demo.coinAudio.play();
        coinDisplay = false;
        score += scoreArray[whichCoin];
      }


      if (playerRect.intersects(berriesRect) && berriesVisible) {
        Demo.berryAudio.play();
        berriesVisible = false;
        clonesActive = true;
        cloneXCord[0] = cloneXCord[1] = cloneXCord[2] = Demo.berriesXCord;
        cloneYCord[0] = cloneYCord[1] = cloneYCord[2] = Demo.berriesYCord;
      }

      Demo.coinXCord -= 15;
      if (Demo.coinXCord <= -30) {
        coinDisplay = false;
      }
      Demo.berriesXCord -= 15;
      if (Demo.berriesXCord <= -30) {
        berriesVisible = false;
      }


      if (Demo.clonesActive) {
        imageGraphics.drawImage(imageArray.get(count), cloneXCord[0], cloneYCord[0], null);
        imageGraphics.drawImage(imageArray.get(count), cloneXCord[1], cloneYCord[1], null);
        imageGraphics.drawImage(imageArray.get(count), cloneXCord[2], cloneYCord[2], null);
        Demo.clone1Rect.x = cloneXCord[0];
        Demo.clone2Rect.x = cloneXCord[1];
        Demo.clone3Rect.x = cloneXCord[2];
        Demo.clone1Rect.y = cloneYCord[0];
        Demo.clone2Rect.y = cloneYCord[1];
        Demo.clone3Rect.y = cloneYCord[2];
      }
      if (clonesActive) {
        cloneXCord[0] += 30;
        cloneXCord[1] += 30;
        cloneXCord[2] += 30;
        cloneYCord[1] += 10;
        cloneYCord[2] -= 10;
      }
      if (cloneXCord[0] >= 1000) {
        clonesActive = false;
      }

      if (Demo.isPlayerVisible)
        imageGraphics.drawImage(imageArray.get(count), 63, Demo.yCord, null);
      else
        imageGraphics.drawImage(tImageArray[count], 63, Demo.yCord, null);

      if (!Demo.started) {
        imageGraphics.drawImage(controls, 400, 227, null);
        continue;
      }

      if (ran.nextInt(100) == 9 && !Demo.intruderVisible) {
        Demo.intruderVisible = true;
        intruderNumber = ran.nextInt(3);
        Demo.jumpAudio.play();
        Demo.intruderShown = intrudersImage[intruderNumber];
        Demo.intruderYVel = -25;
        Demo.intruderYAcc = 1;
        Demo.intruderXCord = 500;
        Demo.intruderYCord = 500;
      }

      if (Demo.intruderVisible) {
        imageGraphics.drawImage(intruderShown, Demo.intruderXCord, Demo.intruderYCord, null);
        Demo.intruderYCord += Demo.intruderYVel;
        Demo.intruderYVel += Demo.intruderYAcc;
        Demo.intruderRect.x = Demo.intruderXCord;
        Demo.intruderRect.y = Demo.intruderYCord;
        Demo.intruderXCord += -20;
      }

      if (Demo.intruderXCord <= -52 && Demo.intruderVisible) {
        Demo.intruderVisible = false;
      }

      if (intruderRect.intersects(playerRect) && intruderVisible && Demo.isPlayerVisible) {
        Demo.hitAudio.play();
        Demo.lost = true;
      }

      if (Demo.hurdle1XCord <= -33 && Demo.hurdle2XCord <= 33) {
        hurdle1Visible = true;
        hurdle2Visible = true;
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
        hurdle3Visible = true;
        hurdle4Visible = true;
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


      if ((playerRect.intersects(hurdle1Rect) || playerRect.intersects(hurdle2Rect) || playerRect.intersects(hurdle3Rect) || playerRect.intersects(hurdle4Rect)) && Demo.isPlayerVisible) {
        Demo.hitAudio.play();
        Demo.lost = true;
      }

      if (clonesActive) {
        if ((clone1Rect.intersects(hurdle1Rect) || clone2Rect.intersects(hurdle1Rect) || clone3Rect.intersects(hurdle1Rect)))
          hurdle1Visible = hurdle2Visible = false;
        if ((clone1Rect.intersects(hurdle2Rect) || clone2Rect.intersects(hurdle2Rect) || clone3Rect.intersects(hurdle2Rect)))
          hurdle1Visible = hurdle2Visible = false;
        if ((clone1Rect.intersects(hurdle3Rect) || clone2Rect.intersects(hurdle3Rect) || clone3Rect.intersects(hurdle3Rect)))
          hurdle4Visible = hurdle3Visible = false;
        if ((clone1Rect.intersects(hurdle4Rect) || clone2Rect.intersects(hurdle4Rect) || clone3Rect.intersects(hurdle4Rect)))
          hurdle3Visible = hurdle4Visible = false;
        if ((clone1Rect.intersects(intruderRect) || clone2Rect.intersects(intruderRect) || clone3Rect.intersects(intruderRect)))
          intruderVisible = false;
      }
      imageGraphics.setColor(Color.BLACK);
      imageGraphics.setFont(font2);
      imageGraphics.drawString("Your Score : " + Demo.score, 30, 40);
      Demo.score++;

      starXCord -= 15;
      if (starXCord < -40)
        starVisible = false;
      Demo.yCord += Demo.yVel;
      Demo.yVel += Demo.yAcc;

      Demo.hurdle1XCord -= 15;
      Demo.hurdle2XCord -= 15;
      Demo.hurdle3XCord -= 15;
      Demo.hurdle4XCord -= 15;

      if (yCord > 560 || yCord < -60) {
        Demo.lost = true;
      }

      if (Demo.logYCord > -79)
        Demo.logYCord -= 20;
      xVal = xVal - 15;
      if (xVal < 0)
        xVal = 1100;


      gx1-=40;
      gx2-=40;
      if(gx1<=-1000)
        gx1=1000;
      if(gx2<=-1000)
        gx2=1000;

      fx1-=20;
      fx2-=20;
      if(fx1<=-1000)
        fx1=1000;
      if(fx2<=-1000)
        fx2=1000;

      bx1-=10;
      bx2-=10;
      if(bx1<=-1000)
        bx1=1000;
      if(bx2<=-1000)
        bx2=1000;

      cx1-=5;
      cx2-=5;
      if(cx1<=-1000)
        cx1=1000;
      if(cx2<=-1000)
        cx2=1000;
    }
  }


  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP && !Demo.paused && !Demo.lost) {
      Demo.flapAudio.play();
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
      Demo.hurdle1Visible=Demo.hurdle2Visible=Demo.hurdle3Visible=Demo.hurdle4Visible=true;
      Demo.clonesActive=false;
      Demo.intruderVisible=false;
      berriesVisible=false;
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