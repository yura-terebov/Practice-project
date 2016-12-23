/*
 * Decompiled with CFR 0_118.
 */
package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog
extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About", true);
        this.getContentPane().add((Component)new JLabel("<html><h1><i>Heroes v2.2.0</i></h1><h2> based on Army</h2><hr><h3>By Limpopo</h3></html>"), "Center");
        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDialog.this.setVisible(false);
            }
        });
        JPanel panel = new JPanel();
        panel.add(ok);
        this.getContentPane().add((Component)panel, "South");
        this.pack();
    }

}

