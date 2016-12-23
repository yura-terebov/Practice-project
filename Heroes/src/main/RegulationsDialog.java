/*
 * Decompiled with CFR 0_118.
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RegulationsDialog
extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JButton okButton;

    public RegulationsDialog(JFrame owner) {
        super(owner, "Regulations", true);
        this.setBounds(350, 100, 1200, 900);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add((Component)this.contentPanel, "West");
        JLabel label = new JLabel("\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435");
        label.setFont(new Font("Sitka Heading", 1, 16));
        JLabel label_4 = new JLabel("\u0425\u0430\u0440\u0430\u043a\u0442\u0435\u0440\u0438\u0441\u0442\u0438\u043a\u0438 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u0436\u0435\u0439");
        label_4.setFont(new Font("Sitka Heading", 1, 16));
        JLabel Soldier2 = new JLabel();
        ImageIcon imageIcon = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Soldier.png"));
        Image newimg = imageIcon.getImage().getScaledInstance(64, 64, 4);
        Soldier2.setIcon(new ImageIcon(newimg));
        JTextArea txtrSoldier = new JTextArea();
        txtrSoldier.setBackground(UIManager.getColor("Button.background"));
        txtrSoldier.setForeground(Color.BLACK);
        txtrSoldier.setEditable(false);
        txtrSoldier.setFont(new Font("Monospaced", 0, 13));
        txtrSoldier.setRows(4);
        txtrSoldier.setText("Soldier:\r\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100\r\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30\r\n\u0428\u0430\u0433 3\r\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\r\n");
        JLabel Rogue2 = new JLabel();
        ImageIcon imageIconRogue = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Rogue.png"));
        Image newimgRogue = imageIconRogue.getImage().getScaledInstance(64, 64, 4);
        Rogue2.setIcon(new ImageIcon(newimgRogue));
        JTextArea txtrRogue = new JTextArea();
        txtrRogue.setBackground(UIManager.getColor("Button.background"));
        txtrRogue.setEditable(false);
        txtrRogue.setFont(new Font("Monospaced", 0, 13));
        txtrRogue.setText("Rogue:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u043d\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0443\u0435\u0442\n\u043a\u043e\u043d\u0442\u0440 \u0430\u0442\u0430\u043a\u0430");
        JLabel Berserk = new JLabel();
        ImageIcon imageIconBerserk = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Berserk.png"));
        Image newimgBerserk = imageIconBerserk.getImage().getScaledInstance(64, 64, 4);
        Berserk.setIcon(new ImageIcon(newimgBerserk));
        JTextArea txtrBerserk = new JTextArea();
        txtrBerserk.setBackground(UIManager.getColor("Button.background"));
        txtrBerserk.setEditable(false);
        txtrBerserk.setFont(new Font("Monospaced", 0, 13));
        txtrBerserk.setText("Berserk:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u043d\u0430 \u0433\u0435\u0440\u043e\u044f \u043d\u0435\n\u0434\u0435\u0439\u0441\u0442\u0432\u0443\u0435\u0442 \u043c\u0430\u0433\u0438\u044f");
        JLabel Vampire2 = new JLabel();
        ImageIcon imageIconVampire = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Vampire.png"));
        Image newimgVampire = imageIconVampire.getImage().getScaledInstance(64, 64, 4);
        Vampire2.setIcon(new ImageIcon(newimgVampire));
        JTextArea txtrVampire = new JTextArea();
        txtrVampire.setBackground(UIManager.getColor("Button.background"));
        txtrVampire.setEditable(false);
        txtrVampire.setFont(new Font("Monospaced", 0, 13));
        txtrVampire.setText("Vampire:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 25\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u043f\u0440\u0438 \u0430\u0442\u0430\u043a\u0435 / \u043a\u043e\u043d\u0442\u0440\u0430\u0442\u0430\u043a\u0435\n\u043f\u043e\u0442\u0440\u0435\u0431\u043b\u044f\u0435\u0442 \u0447\u0430\u0441\u0442\u044c\n\u0436\u0438\u0437\u043d\u0435\u043d\u043d\u044b\u0445 \u0441\u0438\u043b \u043f\u0440\u043e\u0442\u0438\u0432\u043d\u0438\u043a\u0430");
        JLabel Werewolf2 = new JLabel();
        ImageIcon imageIconWerewolf = new ImageIcon(RegulationsDialog.class.getResource("/image/units/WerewolfNoTransform.png"));
        Image newimgWerewolf = imageIconWerewolf.getImage().getScaledInstance(64, 64, 4);
        Werewolf2.setIcon(new ImageIcon(newimgWerewolf));
        JTextArea txtrWerewolf = new JTextArea();
        txtrWerewolf.setBackground(UIManager.getColor("Button.background"));
        txtrWerewolf.setFont(new Font("Monospaced", 0, 13));
        txtrWerewolf.setEditable(false);
        txtrWerewolf.setText("Werewolf:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 20\n\u0428\u0430\u0433 3\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u0443\u043c\u0435\u0435\u0442 \u043f\u0440\u0435\u0432\u0440\u0430\u0449\u0430\u0442\u044c\u0441\u044f\n\u0432 \u0432\u043e\u043b\u043a\u0430");
        JLabel Wizard2 = new JLabel();
        ImageIcon imageIconWizard = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Wizard.png"));
        Image newimgWizard = imageIconWizard.getImage().getScaledInstance(64, 64, 4);
        Wizard2.setIcon(new ImageIcon(newimgWizard));
        JTextArea txtrWizard = new JTextArea();
        txtrWizard.setBackground(UIManager.getColor("Button.background"));
        txtrWizard.setFont(new Font("Monospaced", 0, 13));
        txtrWizard.setEditable(false);
        txtrWizard.setText("Wizard:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60\n\u041c\u0430\u043d\u0430 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\n\u0431\u043e\u0435\u0432\u043e\u0439 \u043c\u0430\u0433\nfireball: 30\nheal: 15");
        JLabel Healer2 = new JLabel();
        ImageIcon imageIconHealer = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Healer.png"));
        Image newimgHealer = imageIconHealer.getImage().getScaledInstance(64, 64, 4);
        Healer2.setIcon(new ImageIcon(newimgHealer));
        JTextArea txtrHealer = new JTextArea();
        txtrHealer.setBackground(UIManager.getColor("Button.background"));
        txtrHealer.setFont(new Font("Monospaced", 0, 13));
        txtrHealer.setEditable(false);
        txtrHealer.setText("Healer:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60\n\u041c\u0430\u043d\u0430 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\n\u043d\u0435 \u0431\u043e\u0435\u0432\u043e\u0439 \u043c\u0430\u0433\nfireball: 15\nheal: 30");
        JLabel Priest2 = new JLabel();
        ImageIcon imageIconPriest = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Priest.png"));
        Image newimgPriest = imageIconPriest.getImage().getScaledInstance(64, 64, 4);
        Priest2.setIcon(new ImageIcon(newimgPriest));
        JTextArea txtrPriest = new JTextArea();
        txtrPriest.setBackground(UIManager.getColor("Button.background"));
        txtrPriest.setFont(new Font("Monospaced", 0, 13));
        txtrPriest.setEditable(false);
        txtrPriest.setText("Priest:\r\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60\r\n\u041c\u0430\u043d\u0430 100\r\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16\r\n\u0428\u0430\u0433 2\r\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\r\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\r\n\u043d\u0435 \u0431\u043e\u0435\u0432\u043e\u0439 \u043c\u0430\u0433\r\nsacredfire: 15\r\nheal: 30\r\n\u043d\u0430\u043d\u043e\u0441\u0438\u0442 x2 \u0443\u0440\u043e\u043d \u043d\u0435\u0436\u0438\u0442\u0438\r\n(Vampire, Necromancer)");
        JLabel Warlock2 = new JLabel();
        ImageIcon imageIconWarlock = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Warlock.png"));
        Image newimgWarlock = imageIconWarlock.getImage().getScaledInstance(64, 64, 4);
        Warlock2.setIcon(new ImageIcon(newimgWarlock));
        JTextArea txtrWarlock = new JTextArea();
        txtrWarlock.setBackground(UIManager.getColor("Button.background"));
        txtrWarlock.setFont(new Font("Monospaced", 0, 13));
        txtrWarlock.setEditable(false);
        txtrWarlock.setText("Warlock:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60\n\u041c\u0430\u043d\u0430 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\n\u041f\u0440\u0438\u0437\u044b\u0432\u0430\u0435\u0442 \u0421\u043a\u0435\u043b\u0435\u0442\u0430");
        JLabel Necromancer2 = new JLabel();
        ImageIcon imageIconNecromancer = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Necromancer.png"));
        Image newimgNecromancer = imageIconNecromancer.getImage().getScaledInstance(64, 64, 4);
        Necromancer2.setIcon(new ImageIcon(newimgNecromancer));
        JTextArea txtrNecromancer = new JTextArea();
        txtrNecromancer.setBackground(UIManager.getColor("Button.background"));
        txtrNecromancer.setFont(new Font("Monospaced", 0, 13));
        txtrNecromancer.setEditable(false);
        txtrNecromancer.setText("Necromancer:\r\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 60\r\n\u041c\u0430\u043d\u0430 100\r\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 16\r\n\u0428\u0430\u0433 2\r\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 1\r\n\u0417\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435:\r\n\u0431\u043e\u0435\u0432\u043e\u0439 \u043c\u0430\u0433\r\nfireball: 30\r\n\u0435\u0441\u043b\u0438 \u0433\u0435\u0440\u043e\u0439 \u0430\u0442\u0430\u043a\u0443\u0435\u0442 \u0446\u0435\u043b\u044c\r\n\u043f\u043e\u0441\u043b\u0435 \u0441\u043c\u0435\u0442\u0440\u0438 \u043e\u043d\r\n\u0432\u043e\u0441\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u0442 \r\n\u0436\u0438\u0437\u043d\u0438 \u0433\u0435\u0440\u043e\u044e");
        JLabel Archer2 = new JLabel();
        ImageIcon imageIconArcher = new ImageIcon(RegulationsDialog.class.getResource("/image/units/Archer.png"));
        Image newimgArcher = imageIconArcher.getImage().getScaledInstance(64, 64, 4);
        Archer2.setIcon(new ImageIcon(newimgArcher));
        JTextArea txtrArcher = new JTextArea();
        txtrArcher.setBackground(UIManager.getColor("Button.background"));
        txtrArcher.setFont(new Font("Monospaced", 0, 13));
        txtrArcher.setEditable(false);
        txtrArcher.setText("Archer:\n\u0417\u0434\u043e\u0440\u043e\u0432\u044c\u0435 100\n\u0421\u0438\u043b\u0430 \u0430\u0442\u0430\u043a\u0438 30\n\u0428\u0430\u0433 2\n\u0420\u0430\u0434\u0438\u0443\u0441 \u0430\u0442\u0430\u043a\u0438 3\n\u041e\u0441\u043e\u0431\u0435\u043d\u043e\u0441\u0442\u0438:\n\u043b\u0443\u0447\u043d\u0438\u043a \u0443\u043c\u0435\u0435\u0442\n\u0441\u0442\u0440\u0435\u043b\u044f\u0442\u044c \u043d\u0430 \u0440\u0430\u0441\u0442\u043e\u044f\u043d\u0438\u0438");
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", 0, 14));
        textArea.setBackground(UIManager.getColor("Button.background"));
        textArea.setEditable(false);
        textArea.setText("- \u041f\u0435\u0440\u0435\u0434\u0432\u0435\u0436\u0435\u043d\u0438\u0435 \u043f\u0440\u043e\u0438\u0441\u0445\u043e\u0434\u0438\u0442 \u043d\u0430\u0436\u0430\u0442\u0438\u0435\u043c \u043b\u0435\u0432\u043e\u0439 \u043a\u043b\u0430\u0432\u0438\u0448\u0438 \u043c\u044b\u0448\u0438 \u043d\u0430 \u0413\u0435\u0440\u043e\u044f\r\n- \u0415\u0441\u043b\u0438 \u0413\u0435\u0440\u043e\u0439 \u0438\u043c\u0435\u0435\u0442 \u043c\u0430\u043d\u0443, \u0443 \u043d\u0435\u0433\u043e \u0435\u0441\u0442\u044c \u0441\u043f\u043e\u0431\u043e\u043d\u043e\u0441\u0442\u044c \u043a \u0437\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435\u043c, \u0447\u0442\u043e\u0431\u044b \u0432\u043e\u0441\u043f\u043e\u043b\u044c\u0437\u044b\u0432\u0430\u0442\u044c\u0441\u044f \u0438\u043c\u0438, \u043d\u0430\u0436\u043c\u0438\u0442\u0435 \u043f\u0440\u0430\u0432\u043e\u0439 \u043a\u043b\u0430\u0432\u0438\u0448\u043e\u0439 \u043c\u044b\u0448\u0438\r\n \u043d\u0430 \u0413\u0435\u0440\u043e\u044f \u0438 \u0432\u044b\u0431\u0438\u0440\u0435\u0442\u0435 \u0437\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0435\r\n- \u043c\u0430\u0433\u0438 \u043c\u043e\u0433\u0443\u0442 \u043a\u0430\u043a \u043b\u0435\u0447\u0438\u0442\u044c \u0441\u0435\u0431\u044f \u0442\u0430\u043a \u0438 \u0430\u0442\u0430\u043a\u043e\u0432\u0430\u0442\u044c, \u0431\u0443\u0434\u044c\u0442\u0435 \u043e\u0441\u0442\u043e\u0440\u043e\u0436\u043d\u0435\u0439 (\u044d\u0442\u043e \u043a\u0430\u0441\u0430\u0435\u0442\u044c\u0441\u044f \u0437\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0439)\r\n- Game console: \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442 \u0432\u0441\u0435 \u0434\u0435\u0439\u0441\u0432\u0442\u0438\u044f \u0432 \u0438\u0433\u0440\u0435\r\n- \u0412\u0441\u0435 \u0437\u0430\u043a\u043b\u0438\u043d\u0430\u043d\u0438\u0438 \u0442\u0440\u0435\u0431\u0443\u044e\u0442 25 \u0435\u0434. \u043c\u0430\u043d\u044b \u0438 \u0440\u0430\u0434\u0438\u0443\u0441 3.\r\n- \u0412\u0430\u043c\u043f\u0438\u0440 \u043c\u043e\u0436\u0435\u0442 \u0441\u0434\u0435\u043b\u0430\u0442\u044c \u0432\u0430\u043c\u043f\u0438\u0440\u043e\u043c \u0434\u0440\u0443\u0433\u043e\u0433\u043e \u044e\u043d\u0438\u0442\u0430 (\u0438\u0441\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 Werewolf)\r\n- \u041e\u0431\u043e\u0440\u043e\u0442\u0435\u043d\u044c \u043c\u043e\u0436\u0435\u0442 \u0441\u0434\u0435\u043b\u0430\u0442\u044c \u043e\u0431\u043e\u0440\u043e\u0442\u043d\u0435\u043c \u0434\u0440\u0443\u0433\u043e\u0433\u043e \u044e\u043d\u0438\u0442\u0430 (\u0438\u0441\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 Vampire)");
        GroupLayout gl_contentPanel = new GroupLayout(this.contentPanel);
        gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(Vampire2).addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addComponent(Wizard2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrWizard, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(Healer2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrHealer, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(Priest2)).addGroup(gl_contentPanel.createSequentialGroup().addComponent(Archer2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrArcher, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrPriest, -2, -1, -2)).addComponent(label_4, -2, 231, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addComponent(Warlock2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtrWarlock, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(Necromancer2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrNecromancer, -2, -1, -2)).addGroup(gl_contentPanel.createSequentialGroup().addComponent(txtrVampire, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(Werewolf2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrWerewolf, -2, -1, -2)))).addGroup(gl_contentPanel.createSequentialGroup().addComponent(Soldier2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrSoldier, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(Rogue2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrRogue, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(Berserk, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtrBerserk, -2, -1, -2)))).addGroup(gl_contentPanel.createSequentialGroup().addGap(19).addComponent(textArea, -2, -1, -2)).addGroup(gl_contentPanel.createSequentialGroup().addGap(495).addComponent(label))).addContainerGap(568, 32767)));
        gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addComponent(label).addGap(16).addComponent(textArea, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(label_4, -2, 21, -2).addGap(18).addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Vampire2).addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Soldier2).addComponent(txtrSoldier, -2, -1, -2).addComponent(Rogue2).addComponent(txtrRogue, -2, -1, -2).addComponent(Berserk, -2, 77, -2).addComponent(txtrBerserk, -2, -1, -2).addComponent(txtrVampire, -2, -1, -2).addComponent(Werewolf2).addComponent(txtrWerewolf, -2, -1, -2)).addGap(18).addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Warlock2).addComponent(Necromancer2).addComponent(txtrWarlock, -2, -1, -2).addComponent(txtrPriest, -2, -1, -2).addComponent(Priest2).addComponent(txtrHealer, -2, -1, -2).addComponent(txtrNecromancer, -2, -1, -2).addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(txtrWizard, -2, -1, -2).addComponent(Wizard2).addComponent(Healer2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(txtrArcher, -2, -1, -2).addComponent(Archer2)))))).addGap(76)));
        this.contentPanel.setLayout(gl_contentPanel);
        JPanel buttonPane = new JPanel();
        this.getContentPane().add((Component)buttonPane, "South");
        this.okButton = new JButton("OK");
        this.okButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                RegulationsDialog.this.setVisible(false);
            }
        });
        this.okButton.setActionCommand("OK");
        this.getRootPane().setDefaultButton(this.okButton);
        buttonPane.setLayout(new BorderLayout(0, 0));
        buttonPane.add(this.okButton);
    }

}

