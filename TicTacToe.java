import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class TicTacToe implements ActionListener 
{
    
    private Random random = new Random();
    private JFrame frame  = new JFrame();
    private JPanel panelTitre  = new JPanel();
    private JPanel panelButton = new JPanel();
    private JLabel textfield   = new JLabel();
    private JButton[] tabButton= new JButton[9];
    private boolean player1Turn;
    private boolean player2Turn;

    
    public TicTacToe()
    {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 800);
        this.frame.getContentPane().setBackground(new Color(200,150,40));
        this.frame.setLayout(new BorderLayout());
        this.frame.setVisible(true);

        this.textfield.setBackground(new Color(25,25,25));
        this.textfield.setForeground(new Color(255,198,40));
        this.textfield.setFont(new Font("Ink Free", Font.BOLD,75));
        this.textfield.setHorizontalAlignment(JLabel.CENTER);
        this.textfield.setText("TIC-TAC-TOE");
        this.textfield.setOpaque(true);

        this.panelTitre.setLayout(new BorderLayout());
        this.panelTitre.setBounds(0,0,800,100);

        this.panelButton.setLayout(new GridLayout(3,3));
        this.panelButton.setBackground(new Color(250,230,130));

        for( int cpt=0; cpt < 9; cpt++)
        {
            this.tabButton[cpt] = new JButton();
            this.panelButton.add(this.tabButton[cpt], BorderLayout.CENTER);
            this.tabButton[cpt].setFont(new Font("MV Boli",Font.BOLD, 120 ));
            this.tabButton[cpt].setFocusable(false);
            this.tabButton[cpt].setBackground(new Color(240, 220, 110));
            this.tabButton[cpt].addActionListener(this);
        }

        this.panelTitre.add(this.textfield);
        this.frame.add(this.panelTitre, BorderLayout.NORTH);
        this.frame.add(this.panelButton);

        this.firstTurn();
    }

    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2)==0)
        {
            player1Turn = true;
            this.textfield.setText("Joueur X");
        } 
        else
        {
            player1Turn = false;
            this.textfield.setText("Joueur O");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int cpt=0; cpt < 9; cpt++)
        {
            if (e.getSource()==this.tabButton[cpt])
            {
                if (this.player1Turn)
                {
                    if (this.tabButton[cpt].getText()=="")
                    {
                        this.tabButton[cpt].setForeground(new Color(132,240,113));
                        this.tabButton[cpt].setText("X");
                        this.player1Turn=false;
                        this.textfield.setText("Joueur O");
                        this.check();
                    };
                }
                else
                {
                    if (this.tabButton[cpt].getText()=="")
                    {
                        this.tabButton[cpt].setForeground(new Color(113,195,240));
                        this.tabButton[cpt].setText("O");
                        this.player1Turn=true;
                        this.textfield.setText("Joueur X");
                        this.check();
                    }
                }
            }
        }
        
    }

   

    public void check()
    {
        //Si X gagne
        //ligne 1
        if ((this.tabButton[0].getText()=="X") && 
            (this.tabButton[1].getText()=="X") && 
            (this.tabButton[2].getText()=="X"))
        {
            this.xWins(0,1,2);
        }

        //ligne 2
        if ((this.tabButton[3].getText()=="X") && 
            (this.tabButton[4].getText()=="X") && 
            (this.tabButton[5].getText()=="X"))
        {
            this.xWins(3,4,5);
        }

        //ligne 3
        if ((this.tabButton[6].getText()=="X") && 
            (this.tabButton[7].getText()=="X") && 
            (this.tabButton[8].getText()=="X"))
        {
            this.xWins(6,7,8);
        }

        //colonne 1
        if ((this.tabButton[0].getText()=="X") && 
            (this.tabButton[3].getText()=="X") && 
            (this.tabButton[6].getText()=="X"))
        {
            this.xWins(0,3,6);
        }

        //colonne 2
        if ((this.tabButton[1].getText()=="X") && 
            (this.tabButton[4].getText()=="X") && 
            (this.tabButton[7].getText()=="X"))
        {
            this.xWins(1,4,7);
        }

        //colonne 3
        if ((this.tabButton[2].getText()=="X") && 
            (this.tabButton[5].getText()=="X") && 
            (this.tabButton[8].getText()=="X"))
        {
            this.xWins(2,5,8);
        }

        //diagonale 1
        if ((this.tabButton[0].getText()=="X") && 
            (this.tabButton[4].getText()=="X") && 
            (this.tabButton[8].getText()=="X"))
        {
            this.xWins(0,4,8);
        }

        //diagonale 2
        if ((this.tabButton[2].getText()=="X") && 
            (this.tabButton[4].getText()=="X") && 
            (this.tabButton[6].getText()=="X"))
        {
            this.xWins(2,4,6);
        }


        //Si O gagne
        //ligne 1
        if ((this.tabButton[0].getText()=="O") && 
            (this.tabButton[1].getText()=="O") && 
            (this.tabButton[2].getText()=="O"))
        {
            this.oWins(0,1,2);
        }

        //ligne 2
        if ((this.tabButton[3].getText()=="O") && 
            (this.tabButton[4].getText()=="O") && 
            (this.tabButton[5].getText()=="O"))
        {
            this.oWins(3,4,5);
        }

        //ligne 3
        if ((this.tabButton[6].getText()=="O") && 
            (this.tabButton[7].getText()=="O") && 
            (this.tabButton[8].getText()=="O"))
        {
            this.oWins(6,7,8);
        }

        //colonne 1
        if ((this.tabButton[0].getText()=="O") && 
            (this.tabButton[3].getText()=="O") && 
            (this.tabButton[6].getText()=="O"))
        {
            this.oWins(0,3,6);
        }

        //colonne 2
        if ((this.tabButton[1].getText()=="O") && 
            (this.tabButton[4].getText()=="O") && 
            (this.tabButton[7].getText()=="O"))
        {
            this.oWins(1,4,7);
        }

        //colonne 3
        if ((this.tabButton[2].getText()=="O") && 
            (this.tabButton[5].getText()=="O") && 
            (this.tabButton[8].getText()=="O"))
        {
            this.oWins(2,5,8);
        }

        //diagonale 1
        if ((this.tabButton[0].getText()=="O") && 
            (this.tabButton[4].getText()=="O") && 
            (this.tabButton[8].getText()=="O"))
        {
            this.oWins(0,4,8);
        }

        //diagonale 2
        if ((this.tabButton[2].getText()=="O") && 
            (this.tabButton[4].getText()=="O") && 
            (this.tabButton[6].getText()=="O"))
        {
            this.oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c)
    {
        this.tabButton[a].setBackground(new Color(113,240,157));
        this.tabButton[b].setBackground(new Color(113,240,157));
        this.tabButton[c].setBackground(new Color(113,240,157));

        for (int cpt=0;cpt<9;cpt++)
        {
            this.tabButton[cpt].setEnabled(false);
        }

        this.textfield.setText("X a gagne");

    }

    public void oWins(int a, int b, int c)
    {
        this.tabButton[a].setBackground(new Color(113,240,221));
        this.tabButton[b].setBackground(new Color(113,240,221));
        this.tabButton[c].setBackground(new Color(113,240,221));

        for (int cpt=0;cpt<9;cpt++)
        {
            this.tabButton[cpt].setEnabled(false);
        }

        this.textfield.setText("O a gagne");
    }


}
