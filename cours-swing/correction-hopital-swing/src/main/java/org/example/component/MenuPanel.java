package org.example.component;

import lombok.Data;
import org.example.window.FormPatientPanel;
import org.example.window.HomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Function;

@Data
public class MenuPanel {
    private JPanel mainPanel;

    private JFrame _frame;

    private JMenuBar jMenuBar;

    public  MenuPanel(JFrame frame) {
        _frame = frame;
        createMenu();
    }

    private void createMenu() {
        jMenuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Menu");

        JMenuItem homeMenu = new JMenuItem(new LinkAction("Accueil", (e) -> {
            _frame.setContentPane(new HomePanel(_frame).getMainPanel());
            _frame.revalidate();
            System.out.println("test");
            return null;
        }));

        mainMenu.add(homeMenu);
        JMenuItem formMenu = new JMenuItem(new LinkAction("formulaire", (e) -> {
            _frame.setContentPane(new FormPatientPanel(_frame).getMainPanel());
            _frame.revalidate();
            return null;
        }));

        mainMenu.add(formMenu);
        jMenuBar.add(mainMenu);
        _frame.setJMenuBar(jMenuBar);
    }
}

final class LinkAction extends AbstractAction {
    private Function<ActionEvent, Void> _function;
    public LinkAction(String menu, Function<ActionEvent, Void> function) {
        super(menu);
        _function = function;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _function.apply(e);
    }
}