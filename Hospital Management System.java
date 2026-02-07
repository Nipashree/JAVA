import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class HospitalManagementSystem extends JFrame {
    private DefaultTableModel patientModel;
    private DefaultTableModel doctorModel;

    public HospitalManagementSystem() {
        setTitle("Hospital Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Patients", createPatientPanel());
        tabs.add("Doctors", createDoctorPanel());

        add(tabs);
        setVisible(true);
    }

    private JPanel createPatientPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField diseaseField = new JTextField();

        form.add(new JLabel("Patient ID:"));
        form.add(idField);

        form.add(new JLabel("Name:"));
        form.add(nameField);

        form.add(new JLabel("Age:"));
        form.add(ageField);

        form.add(new JLabel("Disease:"));
        form.add(diseaseField);

        JButton addButton = new JButton("Add Patient");
        form.add(addButton);

        panel.add(form, BorderLayout.NORTH);

        String[] columns = {"ID", "Name", "Age", "Disease"};
        patientModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(patientModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String age = ageField.getText().trim();
            String disease = diseaseField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || age.isEmpty() || disease.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all patient fields.");
                return;
            }

            patientModel.addRow(new Object[]{id, name, age, disease});
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            diseaseField.setText("");
        });

        return panel;
    }

    private JPanel createDoctorPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField specField = new JTextField();

        form.add(new JLabel("Doctor ID:"));
        form.add(idField);

        form.add(new JLabel("Name:"));
        form.add(nameField);

        form.add(new JLabel("Specialty:"));
        form.add(specField);

        JButton addButton = new JButton("Add Doctor");
        form.add(addButton);

        panel.add(form, BorderLayout.NORTH);

        String[] columns = {"ID", "Name", "Specialty"};
        doctorModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(doctorModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String specialty = specField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || specialty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all doctor fields.");
                return;
            }

            doctorModel.addRow(new Object[]{id, name, specialty});
            idField.setText("");
            nameField.setText("");
            specField.setText("");
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HospitalManagementSystem::new);
    }
}
