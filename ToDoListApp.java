import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListApp {
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Backend Logic
        ArrayList<String> tasks = new ArrayList<>();

        // Create UI Components
        JTextField taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark as Complete");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        // Layout
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Adding ActionListener for the buttons
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                listModel.addElement(task);
                taskInput.setText("");
            }
        });

    
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
                listModel.remove(selectedIndex);
            }
        });

        
        completeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedTask = tasks.get(selectedIndex);
                tasks.set(selectedIndex, selectedTask + " (Completed)");
                listModel.set(selectedIndex, selectedTask + " (Completed)");
            }
        });

        // Show Frame
        frame.setVisible(true);
    }
}
