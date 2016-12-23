/*
 * Decompiled with CFR 0_118.
 */
package main;

import abilities.Ability;
import board.Board;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.NotEnoughManaException;
import exeption.UnitIsDeadException;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import main.AboutDialog;
import main.RegulationsDialog;
import spells.Spells;
import state.State;
import unit.Classes;
import unit.Unit;
import unit.spellcaster.Spellcaster;
import unit.spellcaster.Warlock;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                GameBoardFrame frame = new GameBoardFrame();
                frame.setTitle("Heroes v2.2.0");
                frame.setIconImage(new ImageIcon(Main.class.getResource("/image/Icon/icon.png")).getImage());
                frame.setDefaultCloseOperation(3);
                frame.setExtendedState(6);
                frame.setVisible(true);
            }
        });
    }

    static class DrawComponent
    extends JComponent {
        private double x = 0.0;
        private double y = 0.0;
        private double fieldWidth = 0.0;
        private double fieldHeight = 0.0;
        public static final int DEFAULT_WIDTH = 400;
        public static final int DEFAULT_HEIGHT = 400;
        public static final Image image = new ImageIcon(Main.class.getResource("/image/backGround/grass_1.jpg")).getImage();

        DrawComponent() {
        }

        @Override
        public void paintComponent(Graphics g) {
            double cellWidth;
            Graphics2D g2 = (Graphics2D)g;
            int width = this.getWidth();
            int height = this.getHeight();
            this.fieldHeight = this.fieldWidth = (double)(height - height / 4);
            this.x = ((double)width - this.fieldWidth) / 2.0;
            this.y = ((double)height - this.fieldHeight) / 2.0;
            double cellHeight = cellWidth = this.fieldWidth / 8.0;
            g2.setColor(new Color(153, 153, 153));
            g2.fillRect(0, 0, width, height);
            g2.drawImage(image, (int)this.x, (int)this.y, (int)this.fieldWidth + 1, (int)this.fieldHeight + 1, this);
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2.0f));
            int i = 0;
            while (i < 9) {
                g2.drawLine((int)(this.x + cellWidth * (double)i), (int)this.y, (int)(this.x + cellHeight * (double)i), (int)(this.y + this.fieldHeight));
                g2.drawLine((int)this.x, (int)(this.y + cellHeight * (double)i), (int)(this.x + this.fieldWidth), (int)(this.y + cellHeight * (double)i));
                ++i;
            }
            i = 0;
            while (i < 8) {
                int j = 0;
                while (j < 8) {
                    if (Board.board[i][j] != null) {
                        int unitX = (int)(this.x + cellWidth * (double)i + 1.0);
                        int unitY = (int)(this.y + cellHeight * (double)j + 1.0);
                        Image imageUnit = Board.board[i][j].getUnitImage();
                        Font sansbold14 = new Font("SansSerif", 1, 14);
                        g2.setFont(sansbold14);
                        if (Board.selectedUnit != null && i == (int)Board.selectedUnit.getX() && j == (int)Board.selectedUnit.getY()) {
                            g2.setColor(Color.yellow);
                            g2.setStroke(new BasicStroke(4.0f));
                            g2.draw(new Rectangle2D.Double(unitX, unitY, cellWidth - 4.0, cellHeight - 4.0));
                        }
                        if (Board.selectedWarlockSpell != null && i == (int)Board.selectedWarlockSpell.getX() && j == (int)Board.selectedWarlockSpell.getY()) {
                            g2.setColor(Color.black);
                            g2.setStroke(new BasicStroke(4.0f));
                            g2.draw(new Rectangle2D.Double(unitX, unitY, cellWidth - 4.0, cellHeight - 4.0));
                        }
                        if (Board.selectMagesSpell != null && i == (int)Board.selectMagesSpell.getX() && j == (int)Board.selectMagesSpell.getY()) {
                            g2.setColor(Color.BLUE);
                            g2.setStroke(new BasicStroke(4.0f));
                            g2.draw(new Rectangle2D.Double(unitX, unitY, cellWidth - 4.0, cellHeight - 4.0));
                        }
                        int procent = Board.board[i][j].getState().hp * 100 / Board.board[i][j].getState().maxhp;
                        int hpBar = (int)cellWidth * procent / 100;
                        Rectangle2D.Double rect = new Rectangle2D.Double(unitX, unitY, hpBar, cellHeight / 8.0);
                        g2.setColor(Color.RED);
                        g2.fill(rect);
                        if (Board.board[i][j] instanceof Spellcaster) {
                            procent = Board.board[i][j].getState().mana * 100 / Board.board[i][j].getState().maxmana;
                            int manaBar = (int)cellWidth * procent / 100;
                            rect = new Rectangle2D.Double(unitX, unitY + 9, manaBar, cellHeight / 8.0);
                            g2.setColor(Color.BLUE);
                            g2.fill(rect);
                            g2.setColor(Color.WHITE);
                            g2.drawString("mp " + Board.board[i][j].getState().mana + "/" + Board.board[i][j].getState().maxmana, unitX, unitY + 20);
                        }
                        g2.setColor(Color.WHITE);
                        g2.drawString("hp " + Board.board[i][j].getState().hp + "/" + Board.board[i][j].getState().maxhp, unitX, unitY + 10);
                        g2.drawImage(imageUnit, unitX, unitY + 15, (int)cellWidth, (int)cellHeight - 13, this);
                    }
                    ++j;
                }
                ++i;
            }
        }
    }

    public static class GameBoardFrame
    extends JFrame {
        private int DEFAULT_WIDTH = 1024;
        private int DEFAULT_HEIGHT = 800;
        private JPanel buttonPanel;
        private ButtonGroup group;
        public Warlock.Skelet skeleton;
        public boolean warlockAtcive = false;
        public static JTextArea text;
        public JTextArea aboutUnit;
        private AboutDialog dialog;
        private RegulationsDialog regulation;

        public GameBoardFrame() {
            BorderLayout bl = new BorderLayout();
            this.setLayout(bl);
            JMenuBar menuBar = new JMenuBar();
            this.setJMenuBar(menuBar);
            JMenu mainMenu = new JMenu("Main");
            menuBar.add(mainMenu);
            JMenuItem aboutItem = new JMenuItem("About");
            aboutItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent event) {
                    int height = GameBoardFrame.this.getHeight();
                    if (GameBoardFrame.this.dialog == null) {
                        GameBoardFrame.access$1(GameBoardFrame.this, new AboutDialog(GameBoardFrame.this));
                        GameBoardFrame.this.dialog.setLocation((int)((double)height / 1.5), height / 4);
                        GameBoardFrame.this.dialog.setSize(200, 200);
                        GameBoardFrame.this.dialog.setVisible(true);
                    } else {
                        GameBoardFrame.this.dialog.setVisible(true);
                    }
                }
            });
            mainMenu.add(aboutItem);
            JMenuItem regulationsItem = new JMenuItem("Regulations");
            regulationsItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent event) {
                    if (GameBoardFrame.this.regulation == null) {
                        GameBoardFrame.access$3(GameBoardFrame.this, new RegulationsDialog(GameBoardFrame.this));
                        GameBoardFrame.this.regulation.setVisible(true);
                    } else {
                        GameBoardFrame.this.regulation.setVisible(true);
                    }
                }
            });
            mainMenu.add(regulationsItem);
            JLabel lbl = new JLabel("Game Board");
            lbl.setHorizontalAlignment(0);
            this.add(lbl);
            bl.addLayoutComponent(lbl, "North");
            this.buttonPanel = new JPanel();
            this.group = new ButtonGroup();
            Border etched = BorderFactory.createEtchedBorder();
            TitledBorder titled = BorderFactory.createTitledBorder(etched, "All spells");
            this.buttonPanel.setBorder(titled);
            this.addRadioButton(new ImageIcon(Main.class.getResource("/image/spells/FireBall.png")), "Fireball", Spells.FIREBALL);
            this.addRadioButton(new ImageIcon(Main.class.getResource("/image/spells/Healing.png")), "Healing", Spells.HEAL);
            this.addRadioButton(new ImageIcon(Main.class.getResource("/image/spells/Sacredfire.png")), "SacredFire", Spells.SACREDFIRE);
            this.buttonPanel.setVisible(false);
            this.add((Component)this.buttonPanel, "South");
            text = new JTextArea("Game Console \n", 1, 21);
            JScrollPane scroll = new JScrollPane(text);
            text.setEditable(false);
            scroll.setAutoscrolls(true);
            text.setCaretPosition(text.getDocument().getLength());
            this.add(scroll);
            bl.addLayoutComponent(scroll, "West");
            this.aboutUnit = new JTextArea();
            this.aboutUnit.setFont(new Font("Monospaced", 1, 13));
            this.aboutUnit.setEditable(false);
            this.aboutUnit.setVisible(false);
            this.add(this.aboutUnit);
            bl.addLayoutComponent(this.aboutUnit, "East");
            final DrawComponent dc = new DrawComponent();
            dc.addMouseListener(new MouseAdapter(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = (int)(((double)e.getX() - dc.x) / (dc.fieldWidth / 8.0));
                    int y = (int)(((double)e.getY() - dc.y) / (dc.fieldHeight / 8.0));
                    if (e.getButton() == 1) {
                        if (Board.selectMagesSpell != null) {
                            int distance = Board.distance(Board.selectMagesSpell, x, y);
                            if (3 >= distance && Board.board[x][y] != null) {
                                try {
                                    if (Spellcaster.activeSpell != null) {
                                        ((Spellcaster)Board.board[(int)Board.selectMagesSpell.getX()][(int)Board.selectMagesSpell.getY()]).cast(Spellcaster.activeSpell, Board.board[x][y]);
                                        GameBoardFrame.text.append(String.valueOf(Board.board[(int)Board.selectMagesSpell.getX()][(int)Board.selectMagesSpell.getY()].getName()) + " cast spell: " + Board.board[x][y].getName() + "\n");
                                        Board.selectMagesSpell = null;
                                        GameBoardFrame.this.buttonPanel.setVisible(false);
                                        if (Board.board[x][y].getState().hp == 0) {
                                            Board.board[x][y] = null;
                                        }
                                        dc.repaint();
                                    }
                                }
                                catch (Exception e1) {
                                    GameBoardFrame.text.append("I can not do this\n");
                                }
                            } else {
                                GameBoardFrame.text.append("Spell has a small radius\n");
                            }
                        } else if (Board.selectedWarlockSpell != null) {
                            int distance = Board.distance(Board.selectedWarlockSpell, x, y);
                            if (distance == 1 && Board.board[x][y] == null) {
                                try {
                                    GameBoardFrame.this.skeleton = ((Warlock)Board.board[(int)Board.selectedWarlockSpell.getX()][(int)Board.selectedWarlockSpell.getY()]).summon();
                                }
                                catch (FielBusyException | InvalidParamException | NotEnoughManaException e1) {
                                    GameBoardFrame.text.setSelectedTextColor(Color.RED);
                                    GameBoardFrame.text.append("Empty mana\n");
                                    return;
                                }
                                if (GameBoardFrame.this.skeleton != null) {
                                    Board.board[x][y] = GameBoardFrame.this.skeleton;
                                    Board.selectedWarlockSpell = null;
                                    GameBoardFrame.text.append("Skelet create\n");
                                    dc.repaint();
                                } else {
                                    GameBoardFrame.text.append("You already have a skeleton\n");
                                }
                            } else {
                                GameBoardFrame.text.append("Spell has a small radius\n");
                            }
                        } else if (Board.selectedUnit == null) {
                            if (Board.board[x][y] == null) {
                                GameBoardFrame.text.append("You have not selected unit\n");
                            } else {
                                GameBoardFrame.this.aboutUnit.setText(Board.board[x][y].getAboutUnit());
                                GameBoardFrame.this.aboutUnit.setVisible(true);
                                Board.selectedUnit = new Point(x, y);
                                dc.repaint();
                            }
                        } else {
                            int distance = Board.distance(Board.selectedUnit, x, y);
                            if ((double)x == Board.selectedUnit.getX() && (double)y == Board.selectedUnit.getY()) {
                                GameBoardFrame.this.aboutUnit.setVisible(false);
                                Board.selectedUnit = null;
                                dc.repaint();
                            } else if (Board.board[x][y] == null) {
                                if (Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getStep() >= distance) {
                                    Board.board[x][y] = Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()];
                                    Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()] = null;
                                    Board.selectedUnit = null;
                                    GameBoardFrame.this.aboutUnit.setVisible(false);
                                    dc.repaint();
                                } else {
                                    GameBoardFrame.text.append("Step so small\n");
                                }
                            } else if (Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getAbility().getRadiusAttack() >= distance) {
                                try {
                                    GameBoardFrame.text.append(String.valueOf(Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getName()) + " attack: " + Board.board[x][y].getName() + "\n");
                                    GameBoardFrame.text.append(String.valueOf(Board.board[x][y].getName()) + ": -" + Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getAbility().getDamage() + "hp\n");
                                    int nowHp = Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getState().hp;
                                    Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].attack(Board.board[x][y]);
                                    if (Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getState().hp != nowHp) {
                                        GameBoardFrame.text.append(String.valueOf(Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getName()) + ": -" + Board.board[x][y].getAbility().getDamage() / 2 + "hp\n");
                                    }
                                    if (Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getState().hp == 0) {
                                        GameBoardFrame.text.append(String.valueOf(Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()].getName()) + " is Dead\n");
                                        Board.board[(int)Board.selectedUnit.getX()][(int)Board.selectedUnit.getY()] = null;
                                    }
                                    Board.selectedUnit = null;
                                    GameBoardFrame.this.aboutUnit.setVisible(false);
                                    dc.repaint();
                                }
                                catch (UnitIsDeadException e1) {
                                    GameBoardFrame.text.append(String.valueOf(Board.board[x][y].getName()) + " is Dead\n");
                                    Board.board[x][y] = null;
                                    Board.selectedUnit = null;
                                    dc.repaint();
                                }
                            } else {
                                GameBoardFrame.text.append("Small radius attack\n");
                            }
                        }
                    } else if (e.getButton() == 3) {
                        if (Board.board[x][y] != null) {
                            if (Board.board[x][y].getUnit_class() == Classes.WARLOCK && Board.selectMagesSpell == null) {
                                if (Board.selectedWarlockSpell == null) {
                                    Board.selectedWarlockSpell = new Point(x, y);
                                    dc.repaint();
                                } else if ((double)x == Board.selectedWarlockSpell.getX() && (double)y == Board.selectedWarlockSpell.getY()) {
                                    Board.selectedWarlockSpell = null;
                                    dc.repaint();
                                }
                            } else if (Board.board[x][y] instanceof Spellcaster && Board.selectedWarlockSpell == null) {
                                if (Board.selectMagesSpell == null) {
                                    Board.selectMagesSpell = new Point(x, y);
                                    GameBoardFrame.this.buttonPanel.setVisible(true);
                                    dc.repaint();
                                } else if ((double)x == Board.selectMagesSpell.getX() && (double)y == Board.selectMagesSpell.getY()) {
                                    Board.selectMagesSpell = null;
                                    GameBoardFrame.this.buttonPanel.setVisible(false);
                                    dc.repaint();
                                }
                            }
                            if (Board.board[x][y].getUnit_class() == Classes.WEREWOLF) {
                                Board.board[x][y].transform();
                                dc.repaint();
                            }
                        } else if (Board.board[x][y] == null && Board.selectMagesSpell != null) {
                            GameBoardFrame.text.append("select target\n");
                        }
                    }
                }
            });
            this.add(dc);
            bl.addLayoutComponent(dc, "Center");
            dc.setBackground(Color.BLACK);
            this.setSize(this.DEFAULT_WIDTH, this.DEFAULT_HEIGHT);
        }

        public void addRadioButton(ImageIcon buttonImage, final String buttonName, final Spells nameSpell) {
            JRadioButton button = new JRadioButton(buttonName, buttonImage, false);
            this.group.add(button);
            this.buttonPanel.add(button);
            ActionListener listener = new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    Spellcaster.activeSpell = nameSpell;
                    GameBoardFrame.text.append("Select " + buttonName + " spell\n");
                }
            };
            button.addActionListener(listener);
        }

        static /* synthetic */ void access$1(GameBoardFrame gameBoardFrame, AboutDialog aboutDialog) {
            gameBoardFrame.dialog = aboutDialog;
        }

        static /* synthetic */ void access$3(GameBoardFrame gameBoardFrame, RegulationsDialog regulationsDialog) {
            gameBoardFrame.regulation = regulationsDialog;
        }

    }

}

