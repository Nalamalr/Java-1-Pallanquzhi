package pallanguzhi;
import pallanguzhi.Rules;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
public class ButtonControls extends Pallanguzhi implements ActionListener {
 static int count = 0;
 static void bottomDisable() {
 for (int i = 7; i < 14; i++) {
 if (jtb[i].isEnabled()) {
 jtb[i].setEnabled(false);
 }
 }
 }
 static void bottomEnable() {
 for (int i = 7; i < 14; i++) {
 if (!jtb[i].isEnabled()) {
 
 jtb[i].setEnabled(true);
 }
 }
 }
 static void playerAControl(JButton jbtn) {
 jbtn.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent ae) {
 int[] ar = new int[14];
 ArrayList tracker = new ArrayList(), currentState = new ArrayList();
 ar = getButtonNumbers(jtb);
 for (int i = 0; i < 7; i++) {
 if (jtb[i].isSelected()) {
 jtb[i].setSelected(false);
 ar = player_a.gamePlay(ar, i);
 tracker = player_a.returnList();
 currentState = player_a.returnState();
 player_a.printGrid(ar);
 System.out.println(player_a.score);
 Runnable ma = new MovementAnimation(jtb, handPointer, tracker, 
currentState);
 Thread t = new Thread(ma);
 t.start();
 playerALabel[1].setText("" + player_a.score);
 if (Rules.endOfGameReport(ar) == 1) {
 JOptionPane.showMessageDialog(mainPanel, "Game over! 
Player A");
 player_a.score = 0;
 player_b.score = 0;
 playerALabel[1].setText("" + player_a.score);
 playerBLabel[1].setText("" + player_b.score);
 }
 break;
 }
 }
 int move;
 switch (gamerID) {
 case 3:
 ar = getButtonNumbers(jtb);
 move = Kani.thinkMove(ar, 1);
 System.out.println("Move given " + move);
 ar = player_b.gamePlay(ar, move);
 player_b.printGrid(ar);
 for (int j = 0; j < 14; j++) {
 jtb[j].setText("" + ar[j]);
 }
 playerBLabel[1].setText("" + player_b.score);
 break;
 }
 }
 };
 }
 static void playerBControl(JButton jbtn) {
 jbtn.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent ae) {
 int[] ar = new int[14];
 ar = getButtonNumbers(jtb);
 ArrayList tracker = new ArrayList(), currentState = new ArrayList();
 for (int i = 7; i < 14; i++) 
 {
 if (jtb[i].isSelected()) 
 {
 jtb[i].setSelected(false);
 ar = player_b.gamePlay(ar, i);
 tracker = player_b.returnList();
 currentState = player_b.returnState();
 player_b.printGrid(ar);
 System.out.println(player_b.score);
 Runnable ma = new MovementAnimation(jtb, handPointer, tracker, 
currentState);
 Thread t = new Thread(ma);
 t.start();
 playerBLabel[1].setText("" + player_b.score);
 if (Rules.endOfGameReport(ar) == 2) {
 JOptionPane.showMessageDialog(mainPanel, "Game over! 
Player B");
 player_a.score = 0;
 player_b.score = 0;
 playerALabel[1].setText("" + player_a.score);
 playerBLabel[1].setText("" + player_b.score);
 }
 break;
 }
 }
 }
 };
 }
 @Override
 public void actionPerformed(ActionEvent e) {
 throw new UnsupportedOperationException("Not supported yet.");
 }
}

