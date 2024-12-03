package view;

import dao.PinguimDAO;
import model.Funcionario;
import model.Estagiario;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPenguinsPage extends javax.swing.JFrame {

    private Component textArea;
     private JTable table;
    private DefaultTableModel tableModel;


    
    public ListPenguinsPage() {
    setTitle("Listar Pinguins");
    setSize(800, 670);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Create top panel for title and separator
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    JLabel titleLabel = new JLabel("Salários Pinguins", JLabel.CENTER);
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
    titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add space around title

    // Separator line
    JSeparator separator = new JSeparator();
    topPanel.add(titleLabel, BorderLayout.NORTH);
    topPanel.add(separator, BorderLayout.CENTER);

    // Initialize DAO and fetch data
    PinguimDAO dao = new PinguimDAO();
    List<Funcionario> funcionarios = dao.listarFuncionarios();
    List<Estagiario> estagiarios = dao.listarEstagiarios();

    // If no pinguins are detected, show an alert
    if ((funcionarios == null || funcionarios.isEmpty()) && (estagiarios == null || estagiarios.isEmpty())) {
        JOptionPane.showMessageDialog(this, "Nenhum Pinguim cadastrado.", "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    // Create table columns and data
    String[] columns = {"Cod","Nome", "Idade", "Registro", "Salário (Peixes)", "Tipo", "Ação"};
    Object[][] data = new Object[funcionarios.size() + estagiarios.size()][7]; // Added one extra column for the object

    // Fill the data array with funcionarios and estagiarios data
    int rowIndex = 0;

    // Populate the data for Funcionario
    for (Funcionario f : funcionarios) {
        // Display only the properties of the Funcionario object in the table
        data[rowIndex] = new Object[]{f.getId(),f.getNome(), f.getIdade(), f.getRegistro(), f.getSalarioPeixes(), "Funcionario", new JButton("Delete")};
        rowIndex++;
    }

    // Populate the data for Estagiario
    for (Estagiario e : estagiarios) {
        // Display only the properties of the Estagiario object in the table
        data[rowIndex] = new Object[]{e.getId(),e.getNome(), e.getIdade(), e.getRegistro(), e.getSalarioPeixes(), "Estagiario", new JButton("Delete")};
        rowIndex++;
    }

    // Create table model and set data
    tableModel = new DefaultTableModel(data, columns) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 6;
        }
    };

    table = new JTable(tableModel);


    TableColumnModel columnModel = table.getColumnModel();
    columnModel.getColumn(6).setCellRenderer(new ButtonRenderer());
    columnModel.getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));


    table.setRowHeight(30);
    table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    table.setGridColor(Color.GRAY);
    table.setShowGrid(true);
    table.setIntercellSpacing(new Dimension(0, 0));


    JScrollPane scrollPane = new JScrollPane(table);

    // Organize layout: top panel with title and separator, and table below
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(topPanel, BorderLayout.NORTH);
    getContentPane().add(scrollPane, BorderLayout.CENTER);

   
    setLocationRelativeTo(null); 
}
private class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
    public ButtonRenderer() {
        setText("Delete");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

private class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private int row;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                row = table.getSelectedRow();

                if (row >= 0) {

                    Object obj = table.getModel().getValueAt(row, 5);
                    Object idToDelete = table.getModel().getValueAt(row, 0);
                    int id = -1;

                    if (obj == "Funcionario") {

                        id = (int) idToDelete; 
                    } else if (obj == "Estagiario") {
                        
                        id = (int) idToDelete; 
                    }

                    PinguimDAO dao = new PinguimDAO();
                    try {
                        dao.deletarPingu(id); 


                        ((DefaultTableModel) table.getModel()).removeRow(row); 
                        JOptionPane.showMessageDialog(null, "Pinguim deletado com sucesso! ID: " + id);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar pinguim: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Pinguim selecionado para deletar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setText("Salários ");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jLabel1)
                .addContainerGap(296, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    JScrollPane scrollPane = new JScrollPane(textArea);

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListPenguinsPage().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
