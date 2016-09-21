package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Image;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class RegulationsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;


	public RegulationsDialog(JFrame owner) {
		super(owner, "Regulations", true);
		setBounds(350, 100, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		
		JLabel label = new JLabel("Управление");
		label.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		
		JLabel label_4 = new JLabel("Характеристики персонажей");
		label_4.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		
		JLabel Soldier = new JLabel();
		ImageIcon imageIcon = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Soldier.png"));	 // load the image to a imageIcon
		Image newimg = imageIcon.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		Soldier.setIcon(new ImageIcon(newimg));
		
		JTextArea txtrSoldier = new JTextArea();
		txtrSoldier.setBackground(UIManager.getColor("Button.background"));
		txtrSoldier.setForeground(Color.BLACK);
		txtrSoldier.setEditable(false);
		txtrSoldier.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrSoldier.setRows(4);
		txtrSoldier.setText("Soldier:\r\nЗдоровье 100\r\nСила атаки 30\r\nШаг 3\r\nРадиус атаки 1\r\n");
		
		JLabel Rogue = new JLabel();
		ImageIcon imageIconRogue = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Rogue.png"));	 // load the image to a imageIcon
		Image newimgRogue = imageIconRogue.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		Rogue.setIcon(new ImageIcon(newimgRogue));
		
		JTextArea txtrRogue = new JTextArea();
		txtrRogue.setBackground(UIManager.getColor("Button.background"));
		txtrRogue.setEditable(false);
		txtrRogue.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrRogue.setText("Rogue:\nЗдоровье 100\nСила атаки 30\nШаг 3\nРадиус атаки 1\nОсобености:\nне действует\nконтр атака");
		
		JLabel Berserk = new JLabel();
		ImageIcon imageIconBerserk = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Berserk.png"));	 // load the image to a imageIcon
		Image newimgBerserk = imageIconBerserk.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		Berserk.setIcon(new ImageIcon(newimgBerserk));
		
		JTextArea txtrBerserk = new JTextArea();
		txtrBerserk.setBackground(UIManager.getColor("Button.background"));
		txtrBerserk.setEditable(false);
		txtrBerserk.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrBerserk.setText("Berserk:\nЗдоровье 100\nСила атаки 30\nШаг 3\nРадиус атаки 1\nОсобености:\nна героя не\nдействует магия");
		
		JLabel Vampire = new JLabel();
		ImageIcon imageIconVampire = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Vampire.png"));	 // load the image to a imageIcon
		Image newimgVampire = imageIconVampire.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Vampire.setIcon(new ImageIcon(newimgVampire));
		
		JTextArea txtrVampire = new JTextArea();
		txtrVampire.setBackground(UIManager.getColor("Button.background"));
		txtrVampire.setEditable(false);
		txtrVampire.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrVampire.setText("Vampire:\nЗдоровье 100\nСила атаки 25\nШаг 3\nРадиус атаки 1\nОсобености:\nпри атаке / контратаке\nпотребляет часть\nжизненных сил противника");
		
		JLabel Werewolf = new JLabel();
		ImageIcon imageIconWerewolf = new ImageIcon(RegulationsDialog.class.getResource("/image/units/WerewolfNoTransform.png"));	 // load the image to a imageIcon
		Image newimgWerewolf = imageIconWerewolf.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Werewolf.setIcon(new ImageIcon(newimgWerewolf));
		
		JTextArea txtrWerewolf = new JTextArea();
		txtrWerewolf.setBackground(UIManager.getColor("Button.background"));
		txtrWerewolf.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrWerewolf.setEditable(false);
		txtrWerewolf.setText("Werewolf:\nЗдоровье 100\nСила атаки 20\nШаг 3\nРадиус атаки 1\nОсобености:\nумеет превращаться\nв волка");
		
		JLabel Wizard = new JLabel();
		ImageIcon imageIconWizard = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Wizard.png"));	 // load the image to a imageIcon
		Image newimgWizard = imageIconWizard.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Wizard.setIcon(new ImageIcon(newimgWizard));
		
		JTextArea txtrWizard = new JTextArea();
		txtrWizard.setBackground(UIManager.getColor("Button.background"));
		txtrWizard.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrWizard.setEditable(false);
		txtrWizard.setText("Wizard:\nЗдоровье 60\nМана 100\nСила атаки 16\nШаг 2\nРадиус атаки 1\nЗаклинание:\nбоевой маг\nfireball: 30\nheal: 15");
		
		JLabel Healer = new JLabel();
		ImageIcon imageIconHealer = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Healer.png"));	 // load the image to a imageIcon
		Image newimgHealer = imageIconHealer.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Healer.setIcon(new ImageIcon(newimgHealer));
		
		JTextArea txtrHealer = new JTextArea();
		txtrHealer.setBackground(UIManager.getColor("Button.background"));
		txtrHealer.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrHealer.setEditable(false);
		txtrHealer.setText("Healer:\nЗдоровье 60\nМана 100\nСила атаки 16\nШаг 2\nРадиус атаки 1\nЗаклинание:\nне боевой маг\nfireball: 15\nheal: 30");
		
		JLabel Priest = new JLabel();
		ImageIcon imageIconPriest = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Priest.png"));	 // load the image to a imageIcon
		Image newimgPriest = imageIconPriest.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Priest.setIcon(new ImageIcon(newimgPriest));
		
		JTextArea txtrPriest = new JTextArea();
		txtrPriest.setBackground(UIManager.getColor("Button.background"));
		txtrPriest.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPriest.setEditable(false);
		txtrPriest.setText("Priest:\r\nЗдоровье 60\r\nМана 100\r\nСила атаки 16\r\nШаг 2\r\nРадиус атаки 1\r\nЗаклинание:\r\nне боевой маг\r\nsacredfire: 15\r\nheal: 30\r\nнаносит x2 урон нежити\r\n(Vampire, Necromancer)");
		
		JLabel Warlock = new JLabel();
		ImageIcon imageIconWarlock = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Warlock.png"));	 // load the image to a imageIcon
		Image newimgWarlock = imageIconWarlock.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Warlock.setIcon(new ImageIcon(newimgWarlock));
		
		JTextArea txtrWarlock = new JTextArea();
		txtrWarlock.setBackground(UIManager.getColor("Button.background"));
		txtrWarlock.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrWarlock.setEditable(false);
		txtrWarlock.setText("Warlock:\nЗдоровье 60\nМана 100\nСила атаки 16\nШаг 2\nРадиус атаки 1\nЗаклинание:\nПризывает Скелета");
		
		JLabel Necromancer = new JLabel();
		ImageIcon imageIconNecromancer = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Necromancer.png"));	 // load the image to a imageIcon
		Image newimgNecromancer = imageIconNecromancer.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Necromancer.setIcon(new ImageIcon(newimgNecromancer));
		
		JTextArea txtrNecromancer = new JTextArea();
		txtrNecromancer.setBackground(UIManager.getColor("Button.background"));
		txtrNecromancer.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrNecromancer.setEditable(false);
		txtrNecromancer.setText("Necromancer:\r\nЗдоровье 60\r\nМана 100\r\nСила атаки 16\r\nШаг 2\r\nРадиус атаки 1\r\nЗаклинание:\r\nбоевой маг\r\nfireball: 30\r\nесли герой атакует цель\r\nпосле сметри он\r\nвосстанавливает \r\nжизни герою");
		
		JLabel Archer = new JLabel();
		ImageIcon imageIconArcher = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Archer.png"));	 // load the image to a imageIcon
		Image newimgArcher = imageIconArcher.getImage().getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		Archer.setIcon(new ImageIcon(newimgArcher));
		
		JTextArea txtrArcher = new JTextArea();
		txtrArcher.setBackground(UIManager.getColor("Button.background"));
		txtrArcher.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrArcher.setEditable(false);
		txtrArcher.setText("Archer:\nЗдоровье 100\nСила атаки 30\nШаг 2\nРадиус атаки 3\nОсобености:\nлучник умеет\nстрелять на растоянии");
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		textArea.setText("- Передвежение происходит нажатием левой клавиши мыши на Героя\r\n- Если Герой имеет ману, у него есть спобоность к заклинанием, чтобы воспользываться ими, нажмите правой клавишой мыши\r\n на Героя и выбирете заклинание\r\n- маги могут как лечить себя так и атаковать, будьте осторожней (это касаеться заклинаний)\r\n- Game console: отображает все дейсвтия в игре\r\n- Все заклинании требуют 25 ед. маны и радиус 3.\r\n- Вампир может сделать вампиром другого юнита (исключение Werewolf)\r\n- Оборотень может сделать оборотнем другого юнита (исключение Vampire)");
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(Vampire)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addComponent(Wizard)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtrWizard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(Healer)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtrHealer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(Priest))
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addComponent(Archer)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtrArcher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrPriest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(Warlock)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtrWarlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Necromancer)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrNecromancer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(txtrVampire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Werewolf)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrWerewolf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(Soldier)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtrSoldier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Rogue)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtrRogue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Berserk, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtrBerserk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(19)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(495)
							.addComponent(label)))
					.addContainerGap(568, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(label)
					.addGap(16)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Vampire)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(Soldier)
								.addComponent(txtrSoldier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Rogue)
								.addComponent(txtrRogue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Berserk, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrBerserk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrVampire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Werewolf)
								.addComponent(txtrWerewolf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(Warlock)
								.addComponent(Necromancer)
								.addComponent(txtrWarlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrPriest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Priest)
								.addComponent(txtrHealer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrNecromancer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtrWizard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Wizard)
										.addComponent(Healer))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtrArcher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Archer))))))
					.addGap(76))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			buttonPane.setLayout(new BorderLayout(0, 0));
			buttonPane.add(okButton);
		}
	}
}
