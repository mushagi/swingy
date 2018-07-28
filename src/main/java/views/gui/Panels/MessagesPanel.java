package views.gui.Panels;

import javax.swing.*;

class MessagesPanel extends JScrollPane {
    private final JTextArea textArea = new JTextArea();
    public MessagesPanel() {
        this.setBackground(new java.awt.Color(1,150,4));
        init();
    }

    private void init() {
        textArea.setColumns(20);
        textArea.setRows(30);
        textArea.setCursor(null);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.add(textArea);
    }

    public void add(String message) {
        textArea.append(message+ "\n");
    }
}