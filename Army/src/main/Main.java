package main;

import java.awt.*;
import static spells.Spells.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

import static unit.Classes.*;
import board.Board;
import exeption.FielBusyException;
import exeption.InvalidParamException;
import exeption.NotEnoughManaException;
import exeption.UnitIsDeadException;
import spells.Spells;
import unit.spellcaster.Warlock;
import unit.spellcaster.Warlock.Skelet;
import unit.spellcaster.Spellcaster;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GameBoardFrame frame = new GameBoardFrame();
				frame.setTitle("Heroes v2.2.0");
				frame.setIconImage(new ImageIcon(Main.class.getResource("/image/Icon/icon.png")).getImage());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
	}

	public static class GameBoardFrame extends JFrame {
		private int DEFAULT_WIDTH = 1024;
		private int DEFAULT_HEIGHT = 800;
		private JPanel buttonPanel;
		private ButtonGroup group;
		public Skelet skeleton;
		public boolean warlockAtcive = false;
		public static JTextArea text;
		public JTextArea aboutUnit;
		private AboutDialog dialog;
		private RegulationsDialog regulation;
		
		public GameBoardFrame() {
			BorderLayout bl = new BorderLayout();
			setLayout(bl);
			
			
			// конструктор меню
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			JMenu mainMenu = new JMenu("Main");
			menuBar.add(mainMenu);
		
			JMenuItem aboutItem = new JMenuItem("About");
			aboutItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					int height = getHeight();
					
					if ( dialog == null ) {
						dialog = new AboutDialog(GameBoardFrame.this);
						dialog.setLocation((int) (height / 1.5), height / 4);
						dialog.setSize(200, 200);
						dialog.setVisible(true);
					} else {
						dialog.setVisible(true);
					}
				}
			});
			mainMenu.add(aboutItem);
			
			JMenuItem regulationsItem = new JMenuItem("Regulations");
			regulationsItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					
					if ( regulation == null ) {
						regulation = new RegulationsDialog(GameBoardFrame.this);
						regulation.setVisible(true);
					} else {
						regulation.setVisible(true);
					}
				}
			});
			mainMenu.add(regulationsItem);
			

			JLabel lbl = new JLabel("Game Board");
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			add(lbl);

			bl.addLayoutComponent(lbl, BorderLayout.NORTH);

			buttonPanel = new JPanel();
			group = new ButtonGroup();

			Border etched = BorderFactory.createEtchedBorder();
			Border titled = BorderFactory.createTitledBorder(etched, "All spells");

			buttonPanel.setBorder(titled);

			addRadioButton(new ImageIcon(Main.class.getResource("/image/spells/FireBall.png")), "Fireball", FIREBALL);
			addRadioButton(new ImageIcon(Main.class.getResource("/image/spells/Healing.png")), "Healing", HEAL);
			addRadioButton(new ImageIcon(Main.class.getResource("/image/spells/Sacredfire.png")), "SacredFire", SACREDFIRE);
			buttonPanel.setVisible(false);
			add(buttonPanel, BorderLayout.SOUTH);
			
			
			
			text = new JTextArea("Game Console \n", 1, 21);
			JScrollPane scroll = new JScrollPane(text);
			text.setEditable(false);
			scroll.setAutoscrolls(true);
			text.setCaretPosition(text.getDocument().getLength());
			add(scroll);

			bl.addLayoutComponent(scroll, BorderLayout.WEST);
			
			
			aboutUnit = new JTextArea();
			aboutUnit.setFont(new Font("Monospaced", Font.BOLD, 13));
			aboutUnit.setEditable(false);
			aboutUnit.setVisible(false);
			add(aboutUnit);
			
			bl.addLayoutComponent(aboutUnit, BorderLayout.EAST);
			

			DrawComponent dc = new DrawComponent();
			dc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int x = (int) ((e.getX() - dc.x) / (dc.fieldWidth / 8));
					int y = (int) ((e.getY() - dc.y) / (dc.fieldHeight / 8));
					int distance;

					if (e.getButton() == MouseEvent.BUTTON1) {
						if ( Board.selectMagesSpell != null ) {
							distance = Board.distance(Board.selectMagesSpell, x, y);

							if ( Spellcaster.RADIUSALLSPELLS >= distance && Board.board[x][y] != null) {
								try {
									if ( Spellcaster.activeSpell != null ) {
										((Spellcaster) Board.board[(int) Board.selectMagesSpell.getX()][(int) Board.selectMagesSpell.getY()]).cast(Spellcaster.activeSpell, Board.board[x][y]);
										text.append(Board.board[(int) Board.selectMagesSpell.getX()][(int) Board.selectMagesSpell.getY()].getName() + " cast spell: " + Board.board[x][y].getName()	+ "\n");
										Board.selectMagesSpell = null;
										buttonPanel.setVisible(false);
										
										if ( Board.board[x][y].getState().hp == 0 ) {
											Board.board[x][y] = null;
										}
										
										dc.repaint();
									}
								} catch (Exception e1) {
									text.append("I can not do this\n");
								}
							} else {
								text.append("Spell has a small radius\n");
							}
						} else if (Board.selectedWarlockSpell != null) {
								distance = Board.distance(Board.selectedWarlockSpell, x, y);
								if (distance == 1 && Board.board[x][y] == null) {
									try {
										skeleton = ((Warlock) Board.board[(int) Board.selectedWarlockSpell
												.getX()][(int) Board.selectedWarlockSpell.getY()]).summon();
									} catch (NotEnoughManaException | FielBusyException | InvalidParamException e1) {
										text.setSelectedTextColor(Color.RED);
										text.append("Empty mana\n");
										return;
									}
									if (skeleton != null) {
										Board.board[x][y] = skeleton;
										Board.selectedWarlockSpell = null;
										text.append("Skelet create\n");
										dc.repaint();
									} else {
										text.append("You already have a skeleton\n");
									}
	
								} else {
									text.append("Spell has a small radius\n");
								}
							} else if (Board.selectedUnit == null ) {
								if (Board.board[x][y] == null) {
									text.append("You have not selected unit\n");
								} else {
									aboutUnit.setText(Board.board[x][y].getAboutUnit());
									aboutUnit.setVisible(true);
									Board.selectedUnit = new Point(x, y);
									dc.repaint();
								}
							} else {
								distance = Board.distance(Board.selectedUnit, x, y);
								if (x == Board.selectedUnit.getX() && y == Board.selectedUnit.getY()) {
									aboutUnit.setVisible(false);
									Board.selectedUnit = null;
									dc.repaint();
								} else if (Board.board[x][y] == null) {
									if (Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit.getY()]
											.getStep() >= distance) {
										Board.board[x][y] = Board.board[(int) Board.selectedUnit
												.getX()][(int) Board.selectedUnit.getY()];
										Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit
												.getY()] = null;
										Board.selectedUnit = null;
										
										aboutUnit.setVisible(false);
										dc.repaint();
									} else {
										text.append("Step so small\n");
									}
								} else {
									if (Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit.getY()]
											.getAbility().getRadiusAttack() >= distance) {
										try {
											text.append(
													Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit
															.getY()].getName() + " attack: " + Board.board[x][y].getName()
															+ "\n");
											text.append(
													Board.board[x][y].getName() + ": -"
															+ Board.board[(int) Board.selectedUnit
																	.getX()][(int) Board.selectedUnit.getY()].getAbility()
																			.getDamage()
															+ "hp\n");
	
											int nowHp = Board.board[(int) Board.selectedUnit
													.getX()][(int) Board.selectedUnit.getY()].getState().hp;
	
											Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit.getY()]
													.attack(Board.board[x][y]);
	
											if (Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit
													.getY()].getState().hp != nowHp) {
												text.append(Board.board[(int) Board.selectedUnit
														.getX()][(int) Board.selectedUnit.getY()].getName() + ": -"
														+ (Board.board[x][y].getAbility().getDamage() / 2) + "hp\n");
											}
	
											if (Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit
													.getY()].getState().hp == 0) {
												text.append(Board.board[(int) Board.selectedUnit
														.getX()][(int) Board.selectedUnit.getY()].getName() + " is Dead\n");
												Board.board[(int) Board.selectedUnit.getX()][(int) Board.selectedUnit
														.getY()] = null;
											}
											Board.selectedUnit = null;
											aboutUnit.setVisible(false);
											dc.repaint();
										} catch (UnitIsDeadException e1) {
											text.append(Board.board[x][y].getName() + " is Dead\n");
											Board.board[x][y] = null;
											Board.selectedUnit = null;
											dc.repaint();
										}
									} else {
										text.append("Small radius attack\n");
									}
								}
	
							}
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						if (Board.board[x][y] != null) {

							if (Board.board[x][y].getUnit_class() == WARLOCK && Board.selectMagesSpell == null) {
								if (Board.selectedWarlockSpell == null) {
									Board.selectedWarlockSpell = new Point(x, y);
									dc.repaint();
								} else if (x == Board.selectedWarlockSpell.getX() && y == Board.selectedWarlockSpell.getY()) {
									Board.selectedWarlockSpell = null;
									dc.repaint();
								}
							} else if (Board.board[x][y] instanceof Spellcaster && Board.selectedWarlockSpell == null ) {
								if (Board.selectMagesSpell == null) {
									Board.selectMagesSpell = new Point(x, y);
									buttonPanel.setVisible(true);
									dc.repaint();
								} else if (x == Board.selectMagesSpell.getX() && y == Board.selectMagesSpell.getY()) {
										Board.selectMagesSpell = null;
										buttonPanel.setVisible(false);
										dc.repaint();
									}
							}

							if (Board.board[x][y].getUnit_class() == WEREWOLF) {
								Board.board[x][y].transform();
								dc.repaint();
							}
						} else if (Board.board[x][y] == null && Board.selectMagesSpell != null) {
							text.append("select target\n");
						}
					}
				}

			});
			add(dc);
			bl.addLayoutComponent(dc, BorderLayout.CENTER);
			dc.setBackground(Color.BLACK);

			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}

		public void addRadioButton(ImageIcon buttonImage, String buttonName, Spells nameSpell) {
			JRadioButton button = new JRadioButton(buttonName, buttonImage, false);
			group.add(button);
			buttonPanel.add(button);

			ActionListener listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Spellcaster.activeSpell = nameSpell;
					text.append("Select " + buttonName + " spell\n");
				}
			};
			button.addActionListener(listener);
		}
	}

	static class DrawComponent extends JComponent {

		private double x = 0.0;
		private double y = 0.0;
		private double fieldWidth = 0.0;
		private double fieldHeight = 0.0;

		public static final int DEFAULT_WIDTH = 400;
		public static final int DEFAULT_HEIGHT = 400;
		public static final Image image = new ImageIcon(Main.class.getResource("/image/backGround/grass_1.jpg"))
				.getImage();

		public void paintComponent(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;

			int width = getWidth();
			int height = getHeight();

			fieldWidth = height - (height / 4);
			fieldHeight = fieldWidth;

			x = (width - fieldWidth) / 2;
			y = (height - fieldHeight) / 2;

			double cellWidth = fieldWidth / 8;
			double cellHeight = cellWidth;

			g2.setColor(new Color(153, 153, 153));
			g2.fillRect(0, 0, width, height);

			g2.drawImage(image, (int) x, (int) y, (int) fieldWidth + 1, (int) fieldHeight + 1, this);

			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(2));

			for (int i = 0; i < 9; i++) {
				g2.drawLine((int) (x + cellWidth * i), (int) y, (int) (x + cellHeight * i), (int) (y + fieldHeight));
				g2.drawLine((int) (x), (int) (y + cellHeight * i), (int) (x + fieldWidth), (int) (y + cellHeight * i));
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (Board.board[i][j] != null) {
						int unitX = (int) (x + cellWidth * i + 1);
						int unitY = (int) (y + cellHeight * j + 1);
						Rectangle2D rect;
						Image imageUnit = Board.board[i][j].getUnitImage();
						Font sansbold14 = new Font("SansSerif", Font.BOLD, 14);
						g2.setFont(sansbold14);

						if (Board.selectedUnit != null) {
							if (i == (int) Board.selectedUnit.getX() && j == (int) Board.selectedUnit.getY()) {
								g2.setColor(Color.yellow);
								g2.setStroke(new BasicStroke(4));
								g2.draw(new Rectangle2D.Double(unitX, unitY, cellWidth - 4, cellHeight - 4));
							}
						}

						if (Board.selectedWarlockSpell != null) {
							if (i == (int) Board.selectedWarlockSpell.getX()
									&& j == (int) Board.selectedWarlockSpell.getY()) {
								g2.setColor(Color.black);
								g2.setStroke(new BasicStroke(4));
								g2.draw(new Rectangle2D.Double(unitX, unitY, cellWidth - 4, cellHeight - 4));
							}
						}

						if (Board.selectMagesSpell != null) {
							if (i == (int) Board.selectMagesSpell.getX() && j == (int) Board.selectMagesSpell.getY()) {
								g2.setColor(Color.BLUE);
								g2.setStroke(new BasicStroke(4));
								g2.draw(new Rectangle2D.Double(unitX, unitY, cellWidth - 4, cellHeight - 4));
							}
						}

						{
							int procent = (Board.board[i][j].getState().hp * 100) / Board.board[i][j].getState().maxhp;
							int hpBar = ((int) cellWidth * procent) / 100;

							rect = new Rectangle2D.Double(unitX, unitY, hpBar, cellHeight / 8);
							g2.setColor(Color.RED);
							g2.fill(rect);
						}

						if (Board.board[i][j] instanceof Spellcaster) {
							int procent = (Board.board[i][j].getState().mana * 100)
									/ Board.board[i][j].getState().maxmana;
							int manaBar = ((int) cellWidth * procent) / 100;

							rect = new Rectangle2D.Double(unitX, unitY + 9, manaBar, cellHeight / 8);
							g2.setColor(Color.BLUE);
							g2.fill(rect);
							g2.setColor(Color.WHITE);
							g2.drawString("mp " + Board.board[i][j].getState().mana + "/"
									+ Board.board[i][j].getState().maxmana, unitX, unitY + 20);
						}

						{
							g2.setColor(Color.WHITE);
							g2.drawString(
									"hp " + Board.board[i][j].getState().hp + "/" + Board.board[i][j].getState().maxhp,
									unitX, unitY + 10);
						}
						g2.drawImage(imageUnit, unitX, unitY + 15, (int) cellWidth, (int) cellHeight - 13, this);

					}
				}
			}
		}
	}
}
