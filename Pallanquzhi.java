package pallanguzhi;
import pallanguzhi.Rules;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Color;
public class Pallanguzhi {
 static final CardLayout cdl = new CardLayout();
 static JToggleButton jtb[] = new JToggleButton[14];
 static JPanel mainPanel, gamePanel, cardPanel;
 static boolean running;
 static final CoreGame player_a = new CoreGame(), player_b = new CoreGame();
 static int soliCount = 5;
 static int gamerID;
 static JButton playerAButton;
 static JButton playerBButton;
 // Label creation
 static final JLabel header = new JLabel(),
 playerALabel[] = new JLabel[2],
 playerBLabel[] = new JLabel[2];
 static JLabel handPointer[] = new JLabel[14];
 static int[] getButtonNumbers(JToggleButton jtb[]) {
 int grid[] = new int[14];
 for (int i = 0; i < 14; i++) {
 grid[i] = Integer.parseInt(jtb[i].getText());
 }
 return grid;
 }
 static void showPanel() {
 JFrame jf = new JFrame("Pallanguzhi");
 mainPanel = new JPanel();
 gamePanel = new JPanel();
 cardPanel = new JPanel();
 mainPanel.setBackground(Color.BLACK);
 // gamePanel=new JPanel( new ImageIcon("images/pall.png").getImage());
 gamePanel.setBackground(Color.PINK);
 // Layout Creation
 BorderLayout bl = new BorderLayout();
 GridBagLayout gbl = new GridBagLayout();
 GridBagConstraints gbc = new GridBagConstraints();
 // Setting Layout
 cardPanel.setLayout(cdl);
 mainPanel.setLayout(bl);
 gamePanel.setLayout(gbl);
 cardPanel.add(gamePanel, "GamePanel");
 // play details
 playerALabel[0] = new JLabel("<html><font size='10'color=#ff5555><u><i><b> PLAYER A SCORE </u></i></b></html>");

playerALabel[1] = new JLabel("<html><font size='10' color=#ff5555> 0 </html>");
 // playerALabel[0].setVerticalAlignment(JLabel.TOP);
 playerBLabel[0] = new JLabel("<html><font size='10' color=#ff5555><u><i><b> PLAYER B SCORE </u></i></b></html>");
 
playerBLabel[1] = new JLabel("<html><font size='10' color=#ff5555> 0 </html>");
 // Up or down Button style
 playerAButton = new JButton("<html><font size='10' color=#5538ff><i><b> PLAY </i></b></html>");
 playerAButton.setBackground(Color.getHSBColor(184, 100, 50));
 playerBButton = new JButton("<html><font size='10' color=#5538ff><i><b> PLAY </i></b></html>");
 playerBButton.setBackground(Color.getHSBColor(184, 100, 50));
 // Player A Control
 gbc.weightx = 50;
 gbc.weighty = 10;
 gamePanel.add(header, gbc);
 // label player score a
 gbc.gridx = -1;
 gbc.gridy = -6;
 gamePanel.add(playerALabel[0], gbc);
 // label player a 0
 gbc.gridx = -2;
 gbc.gridy = -4;
 gamePanel.add(playerALabel[1], gbc);
 
// player a play button
 gbc.gridx = -2;
 gbc.gridy = -5;
 gamePanel.add(playerAButton, gbc);
 for (int i = 0; i < 7; i++) {
 gbc.gridx = i;
 gbc.gridy = 1;
 gamePanel.add(handPointer[i], gbc);
 gbc.gridx = i;
 gbc.gridy = 2;
 gamePanel.add(jtb[i], gbc);
 }
 
// Player B Control
 gbc.gridx = 1;
 gbc.gridy = 7;
 gamePanel.add(playerBLabel[0], gbc);
 // label player score a
 gbc.gridx = 5;
 gbc.gridy = 7;
 gamePanel.add(playerBLabel[1], gbc);
 // label player a 0
 gbc.gridx = 3;
 gbc.gridy = 7;
 gamePanel.add(playerBButton, gbc);
 for (int i = 0; i < 7; i++) {
 gbc.gridx = i;
 
 gbc.gridy = 3;
 gamePanel.add(jtb[13 - i], gbc);
 gbc.gridx = i;
 gbc.gridy = 4;
 gamePanel.add(handPointer[13 - i], gbc);
 }
 // Adding game panel to main panel
 mainPanel.add(cardPanel, BorderLayout.CENTER);
 cdl.show(cardPanel, "GamePanel");
 // Adding main panel to Frame
 jf.add(mainPanel);
 ButtonControls.playerAControl(playerAButton);
 ButtonControls.playerBControl(playerBButton);
 jf.setSize(1000, 600);
 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 jf.setVisible(true);
 }
 public static void main(String[] args) {
 Rules.initBtn(soliCount);
 Rules.initHand();
 showPanel();
 }
}