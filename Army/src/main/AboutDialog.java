package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AboutDialog extends JDialog {

	public AboutDialog(JFrame owner) {
		super(owner, "About", true);
		
		
		getContentPane().add(new JLabel("<html><h1><i>Heroes v2.2.0</i></h1><h2> based on Army</h2><hr>"
				+ "<h3>By Limpopo</h3></html>"), BorderLayout.CENTER);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		JPanel panel = new JPanel();
		panel.add(ok);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		pack();
	}
}
