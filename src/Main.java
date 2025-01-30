import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the window when user clicks on X
        window.setResizable(false);
        window.setTitle("2D Adventure Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); //causes the window to be sized to fit the size of its sub components that is the game panel

        window.setLocationRelativeTo(null);  //window will be displayed at the center
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
