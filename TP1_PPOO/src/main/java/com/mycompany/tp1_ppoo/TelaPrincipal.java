//Aluno: Leonardo Araújo da Silva
//RA: R4097G-0
//turma: CC4P41
package com.mycompany.tp1_ppoo;
import java.sql.*;
import com.mycompany.TP1_PPOO.Conexao;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    
        javax.swing.table.DefaultTableCellRenderer centralizado = new javax.swing.table.DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    
        for (int i = 0; i < tblDados.getColumnCount(); i++) {
            tblDados.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
        
        // CHAMA A FUNÇÃO AQUI PARA PREENCHER A TABELA AO ABRIR O SISTEMA
        carregarTabela(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        bntCadastrar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE FUNCIONÁRIOS");

        tblDados.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Categoria", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDados);
        if (tblDados.getColumnModel().getColumnCount() > 0) {
            tblDados.getColumnModel().getColumn(0).setResizable(false);
            tblDados.getColumnModel().getColumn(1).setResizable(false);
            tblDados.getColumnModel().getColumn(2).setResizable(false);
        }

        bntCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bntCadastrar.setText("Novo Registro");
        bntCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRemover.setText("Excluir Selecionado");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSair.setText("Desconectar / Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bntCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(37, 37, 37)
                        .addComponent(btnRemover))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCadastrar)
                    .addComponent(btnRemover)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int linhaSelecionada = tblDados.getSelectedRow();

        if (linhaSelecionada >= 0) {
            String nome = tblDados.getValueAt(linhaSelecionada, 0).toString();
            
            int confirmacao = javax.swing.JOptionPane.showConfirmDialog(this, 
                    "Deseja excluir o funcionário " + nome + "?", "Atenção", javax.swing.JOptionPane.YES_NO_OPTION);
                    
            if (confirmacao == javax.swing.JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM tb_Funcionarios WHERE Nome = ?";
                
                try (Connection conn = Conexao.conectar();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                     
                    stmt.setString(1, nome);
                    stmt.executeUpdate(); // Deleta do banco
                    
                    carregarTabela(); // Atualiza a tabela na tela
                    javax.swing.JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
                    
                } catch (SQLException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um registro na tabela para excluir.");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void bntCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarActionPerformed
        TelaCadastro cadastro = new TelaCadastro(); // Usa o construtor vazio
        cadastro.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        // Este comando avisa: "Quando a tela de cadastro fechar, atualize a tabela"
        cadastro.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                carregarTabela();
            }
        });
        
        cadastro.setVisible(true);
    }//GEN-LAST:event_bntCadastrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int linhaSelecionada = tblDados.getSelectedRow();

        if (linhaSelecionada >= 0) {
            String nome = tblDados.getValueAt(linhaSelecionada, 0).toString();
            String categoria = tblDados.getValueAt(linhaSelecionada, 1).toString();
            String status = tblDados.getValueAt(linhaSelecionada, 2).toString();

            TelaEditar editar = new TelaEditar(nome, categoria, status);
            editar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            
            // Atualiza a tabela quando terminar de editar
            editar.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    carregarTabela();
                }
            });
            
            editar.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um registro na tabela para editar.");
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    public void carregarTabela() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblDados.getModel();
        modelo.setNumRows(0); // Limpa a tabela antes de preencher

        String sql = "SELECT Nome, Categoria, Status FROM tb_Funcionarios";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("Nome"),
                    rs.getString("Categoria"),
                    rs.getString("Status")
                });
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar dados do banco: " + e.getMessage());
        }
    }

    // 2. LOGO ANTES DO SEU MAIN:
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCadastrar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDados;
    // End of variables declaration//GEN-END:variables
}