package view;

import dao.PinguimDAO;
import model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Estagiario;


public class ListPenguinsPage extends javax.swing.JFrame {

    private Component textArea;

  public ListPenguinsPage() {
       setTitle("Listar Pinguins");
        setSize(600, 870);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize DAO and fetch data
        PinguimDAO dao = new PinguimDAO();
        List<Funcionario> funcionarios = dao.listarFuncionarios();
        List<Estagiario> estagiarios = dao.listarEstagiarios();

        // TextArea for displaying data
        JTextArea textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        
        // If no Funcionario or Estagiario records were found, show a message
        if ((funcionarios == null || funcionarios.isEmpty()) && (estagiarios == null || estagiarios.isEmpty())) {
            textArea.setText("Nenhum Pinguim cadastrado.");
        } else {
            // Check if there are any Funcionario records
            if (funcionarios != null && !funcionarios.isEmpty()) {
                for (Funcionario f : funcionarios) {
                    textArea.append("Funcionario\n");
                    textArea.append("Nome: " + f.getNome() + "\n");
                    textArea.append("Registro: " + f.getRegistro() + "\n");
                    textArea.append("Salário (Peixes): " + f.getSalarioPeixes() + "\n\n");
                }
            }

            // Check if there are any Estagiario records
            if (estagiarios != null && !estagiarios.isEmpty()) {
                for (Estagiario e : estagiarios) {
                    textArea.append("Estagiario\n");
                    textArea.append("Nome: " + e.getNome() + "\n");
                    textArea.append("Registro: " + e.getRegistro() + "\n");
                    textArea.append("Salário (Peixes): " + e.getSalarioPeixes() + "\n\n");
                }
            }
        }

        // Wrap TextArea in a ScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add ScrollPane to the frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Pack and make visible
        pack();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    JScrollPane scrollPane = new JScrollPane(textArea);

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListPenguinsPage().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
