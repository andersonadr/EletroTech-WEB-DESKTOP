/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import eletro.teck.ConnectionDataBase;
import eletro.teck.telaFuncionariosCadastrados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ander
 */
public class FuncionarioDAO extends ConnectionDataBase {

    private ConnectionDataBase ConnectionDataBase;
    private Connection conn;

    public FuncionarioDAO() {
        this.ConnectionDataBase = new ConnectionDataBase();
        this.conn = ConnectionDataBase.getConnection();
    }

    public void inserirBancodeDados(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome,cpf,email,cargo,senha) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getCargo());
            stmt.setString(5, funcionario.getSenha());
            stmt.execute();
            System.out.println("Funcionário cadastrado no banco de dados!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet autenticacaoLogin(Funcionario objfuncionario) {

        conn = ConnectionDataBase.getConnection();

        try {
            String sql = "SELECT cpf, senha FROM funcionario WHERE cpf = ? AND senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionario.getCpf());
            pstm.setString(2, objfuncionario.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }

    }
    
    public List<Funcionario> ListarUsers() {
        
        String sql = "SELECT idfuncionario, nome, cpf, email, cargo, senha FROM funcionario";
        
        List<Funcionario> users = new ArrayList<Funcionario>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        // Classe para recuperar os dados do banco ** SELECT ** 
        ResultSet rset = null;
        
        try {
            
            // Criando conexao com o banco de dados 
            conn = ConnectionDataBase.getConnection();
            
            // Executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {                
                 
                Funcionario user = new Funcionario();
                
                user.setId(rset.getInt("idfuncionario"));
                user.setNome(rset.getString("nome"));
                user.setCpf(rset.getString("cpf"));
                user.setEmail(rset.getString("email"));
                user.setCargo(rset.getString("cargo"));
                user.setSenha(rset.getString("senha"));
                
                users.add(user);
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Error ao listar Usuários!!");
              
        }  finally {
            
            try {
                
                if (pstm != null) {
                    pstm.close(); 
                }
                if (conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return users;
        
    }
    
        public void ListUsuarios(telaFuncionariosCadastrados tfc) {
        DefaultTableModel model = (DefaultTableModel) tfc.jTable1.getModel();

        FuncionarioDAO funcionariodao = new FuncionarioDAO();
        for (Funcionario usuario : funcionariodao.ListarUsers()) {
            Object[] row = {
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getCargo(),
                usuario.getSenha()
            };
            model.addRow(row);
        }
    }

    public void atualizar(Funcionario user) {
        
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, email = ?, cargo = ?, senha = ? WHERE idfuncionario = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            // Criando conexao com o banco de dados 
            conn = ConnectionDataBase.getConnection();
            
            // Executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getCpf());
            pstm.setString(4, user.getCargo());
            pstm.setString(5, user.getSenha());
            
            // Buscar qual ID de usuario irá atualizar
            pstm.setInt(6, user.getId());
            
            // Executar a Query
            pstm.execute();
            
            JOptionPane.showMessageDialog(null,
                    "Usuário Atualizado com Sucesso!!", "Confirmação",
                    JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Erro ao tentar atualizar o usuário!!", "Confirmação",
                    JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            try {
                
                if (pstm != null) {
                    pstm.close(); 
                }
                if (conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public void excluir(int id) {
        
        String sql = "DELETE FROM funcionario WHERE idfuncionario  = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            // Criando conexao com o banco de dados 
            conn = ConnectionDataBase.getConnection();
            
            // Executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // Qual o Registro id deseja deletar
            pstm.setInt(1, id);
            
            pstm.execute();
            
            JOptionPane.showMessageDialog(null,
                    "Usuário excluído com Sucesso!!", "Confirmação",
                    JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
            
           JOptionPane.showMessageDialog(null,
                    "Erro ao tentar excluir o usuário!!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            try {
                
                if (pstm != null) {
                    pstm.close(); 
                }
                if (conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}

