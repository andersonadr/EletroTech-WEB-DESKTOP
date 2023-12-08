/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eletro.teck;

import Classes.Agendamento;
import Classes.AgendamentoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class telaOS1 extends javax.swing.JFrame {

    Agendamento agendamento = new Agendamento();
    AgendamentoDAO agendamentodao = new AgendamentoDAO();
    telaEditarOS1 editOS = new telaEditarOS1();
            
    public telaOS1() {
        initComponents();
                
        agendamentodao.ListUsuarios(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDEM DE SERVIÇO");

        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idagendamento", "nome", "telefone", "endereco", "nomeTecnico", "data", "escolha", "pagamento", "descricao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1171, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                
                telaMenu menu = new telaMenu();
                menu.show();
                setVisible(true);
                dispose();
                
     }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    int selecionar = jTable1.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String[] options = { "EDITAR", "DELETAR", "VISUALISAR" };
    int selection = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÂO", "O QUE DESEJA FAZER?                                                                                                                                                                                       ", 
                                                      0, 3, null, options, options[0]);
    if (selection == 0) {
          
        editOS.jLabel2.setText(model.getValueAt(selecionar, 0).toString());
        editOS.jTextField1.setText(model.getValueAt(selecionar, 1).toString());
        editOS.jTextField2.setText(model.getValueAt(selecionar, 2).toString());
        editOS.jTextField3.setText(model.getValueAt(selecionar, 3).toString());
        editOS.jComboBox1.setSelectedItem(model.getValueAt(selecionar, 4).toString());
        editOS.jTextField4.setText(model.getValueAt(selecionar, 5).toString());
        editOS.jComboBox2.setSelectedItem(model.getValueAt(selecionar, 6).toString());
        editOS.jComboBox3.setSelectedItem(model.getValueAt(selecionar, 7).toString());
        editOS.jTextField5.setText(model.getValueAt(selecionar, 8).toString());

        agendamento.setIdagendamento(Integer.parseInt(model.getValueAt(selecionar, 0).toString()));
        
        editOS.setVisible(true);
        dispose();

    }
    if (selection == 1) { 
    int i = jTable1.getSelectedRow();
               
    if (agendamento.getIdagendamento() > 0) {
         
         int opt = JOptionPane.showConfirmDialog(null,
                 "Tem certeza que deseja excluir este usuário?",
                 "Confirmação", JOptionPane.YES_NO_OPTION);
         
         if (opt == 0) {
             
             agendamentodao.excluir(i);
             model.removeRow(i);
             model.fireTableDataChanged();
             
         } else {
             
            editOS.show();
            setVisible(true);
            dispose(); 
         }
        
      } else {
         
         JOptionPane.showMessageDialog(null,
                 "Você não selecionou um usuário para editar!!",
                 "ERROR", JOptionPane.ERROR_MESSAGE);
         
     }
    }
    if (selection == 2) { 
        telaDetalheOS2 telaos2 = new telaDetalheOS2();
        telaos2.txtid.setText(model.getValueAt(selecionar, 0).toString());
        telaos2.txtnome.setText(model.getValueAt(selecionar, 1).toString());
        telaos2.txttelefone.setText(model.getValueAt(selecionar, 2).toString());
        telaos2.txtendereco.setText(model.getValueAt(selecionar, 3).toString());
        telaos2.txtntecnico.setText(model.getValueAt(selecionar, 4).toString());
        telaos2.txtdata.setText(model.getValueAt(selecionar, 5).toString());
        telaos2.txttipovisita.setText(model.getValueAt(selecionar, 6).toString());
        telaos2.txtpagamento.setText(model.getValueAt(selecionar, 7).toString());
        telaos2.txtdescricao.setText(model.getValueAt(selecionar, 8).toString());
        
        telaos2.setVisible(true);
        dispose();
            }
        }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaOS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaOS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaOS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaOS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaOS1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
