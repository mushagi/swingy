package views.gui.Panels;

import javax.swing.*;

public class MessagesPanel extends JPanel {
    private final JTextArea textArea = new JTextArea();
    MessagesPanel() {
        init();
    }

    private void init() {

        textArea.setColumns(25);
        textArea.setRows(29);
        textArea.setCursor(null);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane);
    }

    public void add(String message) {
        textArea.append(message+ "\n");
    }
}