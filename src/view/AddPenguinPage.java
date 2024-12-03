package view;

import dao.PinguimDAO;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.Estagiario;

public class AddPenguinPage extends javax.swing.JFrame {

    public AddPenguinPage() {
         initComponents();  
        setTitle("Adicionar Funcionário");
        setSize(600, 870);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false);  

        setPlaceholders();
          restrictToNumbers(txtAge);
        restrictToNumbers(txtHeight);
        restrictToNumbers(txtRegister);
        restrictToNumbers(txtPayment);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        lbAge = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbHeight = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbPayment = new javax.swing.JLabel();
        lbRegister = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtRegister = new javax.swing.JTextField();
        bntSave = new javax.swing.JButton();
        txtPayment = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbPhone1 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        lbName1 = new javax.swing.JLabel();
        fTxtPhone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbName.setText("Nome:");

        lbAge.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbAge.setText("Idade");

        lbAddress.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbAddress.setText("Endereço");

        lbHeight.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbHeight.setText("Altura");

        lbGender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbGender.setText("Sexo");

        lbPayment.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbPayment.setText("Salário(Peixes)");

        lbRegister.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbRegister.setText("Registro");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtAge.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtHeight.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtRegister.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        bntSave.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bntSave.setText("Salvar");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        txtPayment.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "estagiário", "funcionário" }));

        lbPhone1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbPhone1.setText("Telefone");

        cbGender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "Prefiro não falar" }));

        lbName1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lbName1.setText("Novo Pinguim");

        try {
            fTxtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fTxtPhone.setToolTipText("");
        fTxtPhone.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lbPhone1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHeight)
                                    .addComponent(lbRegister)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbPayment)
                                        .addComponent(lbAge, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbGender, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbName, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(215, 215, 215))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lbName1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbName1)
                .addGap(29, 29, 29)
                .addComponent(lbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAddress)
                .addGap(1, 1, 1)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lbHeight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPhone1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
      try {
        String nome = txtName.getText();
        int idade = getValidInt(txtAge.getText(), "Idade");
        String endereco = txtAddress.getText();
        String sexo = cbGender.getSelectedItem().toString(); 
        float altura = getValidFloat(txtHeight.getText(), "Altura");
        String telefone = fTxtPhone.getText();
        int registro = getValidInt(txtRegister.getText(), "Código de Registro");
        int salarioPeixes = getValidInt(txtPayment.getText(), "Salário");

        PinguimDAO dao = new PinguimDAO();
        
        if (jComboBox1.getSelectedItem().equals("funcionário")) {
            Funcionario funcionario = new Funcionario(0, nome, idade, endereco, sexo, altura, telefone, registro, salarioPeixes);
            dao.adicionarFuncionario(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
        } else if (jComboBox1.getSelectedItem().equals("estagiário")) {
            Estagiario estagiario = new Estagiario(0, nome, idade, endereco, sexo, altura, telefone, registro, salarioPeixes);
            dao.adicionarEstagiario(estagiario);
            JOptionPane.showMessageDialog(null, "Estagiário adicionado com sucesso!");
        }
        
        dispose();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Erro: Verifique os dados numéricos.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + e.getMessage());
    }
    }//GEN-LAST:event_bntSaveActionPerformed
  private int getValidInt(String input, String fieldName) throws NumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("O campo " + fieldName + " deve ser um número inteiro válido.");
        }
    }

    // Method to validate and parse a float (for fields like height)
    private float getValidFloat(String input, String fieldName) throws NumberFormatException {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("O campo " + fieldName + " deve ser um número válido.");
        }
    }
     private void setPlaceholders() {
        // Set placeholders for all text fields
        setPlaceholder(txtName, "Nome");
        setPlaceholder(txtAge, "Idade");
        setPlaceholder(txtAddress, "Endereço");
        setPlaceholder(txtHeight, "Altura");
        setPlaceholder(txtRegister, "Cod. Registro");
        setPlaceholder(txtPayment, "Salário");

        // Set placeholder for formatted phone field
        setPlaceholder(fTxtPhone, "(00)00000-0000");
    }

    // Helper method to add placeholder to text fields
    private void setPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);  // Set the placeholder text
        field.setForeground(java.awt.Color.GRAY);  // Set color to gray for placeholder text

        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                // Remove placeholder text when the field gets focus
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(java.awt.Color.BLACK);  // Set text color to black
                }
            }

            public void focusLost(FocusEvent e) {
                // Restore placeholder text if the field is empty
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(java.awt.Color.GRAY);  // Set text color back to gray
                }
            }
        });
    }
     private void restrictToNumbers(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Check if the character is a digit or a control key (like backspace)
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();  // Ignore the key press if it's not a valid number
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSave;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JFormattedTextField fTxtPhone;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbAge;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHeight;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbPayment;
    private javax.swing.JLabel lbPhone1;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPayment;
    private javax.swing.JTextField txtRegister;
    // End of variables declaration//GEN-END:variables
}
