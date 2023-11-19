	package br.com.fiap.fintech2.dao;
	
	import java.sql.*;
	import java.util.ArrayList; // Importação corrigida
import java.util.List;

import br.com.fiap.fintech2.factory.ConnectionFactory;
	import br.com.fiap.fintech2.model.Despesa2;
	
	public class Despesa2DAO extends ConnectionFactory {
	    static String sql = null;
	    static PreparedStatement stmt;
	    //VERIFICA SE ID EXISTE
	    public boolean userExists(int idUser) {
	        try {
	            abrirBanco();
	            sql = "SELECT COUNT(*) FROM TBL_LOGIN WHERE ID_USER = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, idUser);
	            ResultSet rs = stmt.executeQuery();
	            rs.next();
	            boolean exists = rs.getInt(1) > 0;
	            fecharBanco();
	            return exists;
	        } catch (SQLException e) {
	            System.out.println("Erro ao verificar a existência do usuário: ");
	            e.printStackTrace();
	            return false;
	        }
	    }
	    // CRUD
	    // INSERIR
	    public void inserirDespesa2(Despesa2 despesa2) {
	        if (!userExists(despesa2.getIdUser())) {
	            System.out.println("Erro: ID_USER não existe.");
	            return;
	        } else {
	        try {
	            abrirBanco();
	            sql = "INSERT INTO T_DESPESA2 (ID_DESPESA2, NOME_DESPESA2, VL_DESPESA2, DS_DESPESA2, ID_USER) VALUES (SQ_DESPESA2.nextval,?,?,?,?)";
	            stmt = conn.prepareStatement(sql);
	            // Setar os parametros
	            stmt.setString(1, despesa2.getNome_despesa2());
	            stmt.setString(2, despesa2.getVl_despesa2());
	            stmt.setString(3, despesa2.getDs_despesa2());
	            stmt.setInt(4, despesa2.getIdUser());
	            stmt.execute(); // Executar a linha de comando
	            fecharBanco();

	        } catch (SQLException e) {
	            System.out.println("Erro ao inserir a Despesa2:  ");
	            e.printStackTrace();
	        }
	      }
	    }
	
	
	    // DELETAR
	    public boolean deletarDespesa2(Despesa2 despesa2, int id_user) {
	        if (!userExists(id_user)) {
	            System.out.println("Erro: ID_USER não existe.");
	            return false;
	        } else {
	            try {
	                abrirBanco();
	                sql = "DELETE FROM T_DESPESA2 WHERE ID_DESPESA2 = ? AND ID_USER = ?";
	                stmt = conn.prepareStatement(sql);
	                stmt.setInt(1, despesa2.getId_despesa2());
	                stmt.setInt(2, id_user);
	                int rowsAffected = stmt.executeUpdate();
	                fecharBanco();
	                return rowsAffected > 0;
	            } catch (SQLException e) {
	                System.out.println("Erro ao deletar a Despesa2: ");
	                e.printStackTrace();
	                return false;
	            }
	        }
	    }
	
	    // ALTERAR
	    public void alterarDespesa2(Despesa2 despesa2, int id_user) {
	        try {
	            abrirBanco();
	            sql = "UPDATE T_DESPESA2 SET NOME_DESPESA2 = ?, VL_DESPESA2 = ?, DS_DESPESA2 = ? WHERE ID_DESPESA2 = ? AND ID_USER = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, despesa2.getNome_despesa2());
	            stmt.setString(2, despesa2.getVl_despesa2());
	            stmt.setString(3, despesa2.getDs_despesa2());
	            stmt.setInt(4, despesa2.getId_despesa2());
	            stmt.setInt(5, id_user);
	            
	            
	            System.out.println("ID da despesa: " + despesa2.getId_despesa2());
	            System.out.println("Nome da despesa: " + despesa2.getNome_despesa2());
	            System.out.println("Valor da despesa: " + despesa2.getVl_despesa2());
	            System.out.println("Descriçao da despesa: " + despesa2.getDs_despesa2());
	            // Execute the update statement
	            int rowsAffected = stmt.executeUpdate();

	            // Check if the update was successful
	            if (rowsAffected > 0) {
	            	// Commit the changes
		            conn.commit();
	                System.out.println("Despesa2 atualizada com sucesso!");
	            } else {
	                System.out.println("Nenhuma linha foi atualizada. ID não encontrado ou nenhum valor foi modificado.");
	            }

	            
	        } catch (SQLException e) {
	            System.out.println("Erro ao alterar a Despesa2: ");
	            e.printStackTrace();
	        } finally {
	            fecharBanco();
	        }
	    }
	
	    // LISTAR
		 public ArrayList<Despesa2> getDespesas2(int idUser) throws SQLException {
		        String query = "SELECT T_DESPESA2.*, TBL_LOGIN.NM_USER FROM T_DESPESA2 JOIN TBL_LOGIN ON T_DESPESA2.ID_USER = TBL_LOGIN.ID_USER WHERE T_DESPESA2.ID_USER = ?";
		        ArrayList<Despesa2> despesas2 = new ArrayList<>();
		        
		        abrirBanco();
		        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
		            pstmt.setInt(1, idUser);
		            try (ResultSet res = pstmt.executeQuery()) {
		                while (res.next()) {
		                    Despesa2 despesa2 = new Despesa2();
		                    despesa2.setId_despesa2(res.getInt("ID_DESPESA2"));
		                    despesa2.setNome_despesa2(res.getString("NOME_DESPESA2"));
		                    despesa2.setVl_despesa2(res.getString("VL_DESPESA2"));
		                    despesa2.setDs_despesa2(res.getString("DS_DESPESA2"));
		                    despesa2.setIdUser(res.getInt("ID_USER"));
		                    despesa2.setNomeUser(res.getString("NM_USER"));
		                    despesas2.add(despesa2);
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            fecharBanco();
		        }

		        return despesas2;
		    }

	    
	    //pegar por id 
	    public Despesa2 getDespesa2ById(int id) throws SQLException {
	        String query = "SELECT * FROM T_DESPESA2 WHERE ID_DESPESA2 = ?";
	        Despesa2 despesa2 = null;

	        abrirBanco();
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, id);

	            try (ResultSet res = stmt.executeQuery()) {
	                if (res.next()) {
	                    despesa2 = new Despesa2();
	                    despesa2.setId_despesa2(res.getInt("ID_DESPESA2"));
	                    despesa2.setNome_despesa2(res.getString("NOME_DESPESA2"));
	                    despesa2.setVl_despesa2(res.getString("VL_DESPESA2"));
	                    despesa2.setDs_despesa2(res.getString("DS_DESPESA2"));
	                }
	            }
	        } finally {
	            fecharBanco();
	        }

	        return despesa2;
	    }
	    
	    //pegar despesas
	    public List<Despesa2> getDespesasUsuario(int idUser) throws SQLException {
	        List<Despesa2> despesas = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {
	            ConnectionFactory connectionFactory = new ConnectionFactory();
	            connection = connectionFactory.getConnection();

	            String query = "SELECT * FROM T_DESPESA2 WHERE id_user = ?";
	            statement = connection.prepareStatement(query);
	            statement.setInt(1, idUser);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                int idDespesa2 = resultSet.getInt("ID_DESPESA2");
	                String nomeDespesa2 = resultSet.getString("NOME_DESPESA2");
	                String valorDespesa2 = resultSet.getString("VL_DESPESA2");
	                String dsDespesa2 = resultSet.getString("DS_DESPESA2");
	                

	                Despesa2 despesa = new Despesa2();
	                despesa.setId_despesa2(idDespesa2);
	                despesa.setNome_despesa2(nomeDespesa2);
	                despesa.setVl_despesa2(valorDespesa2);
	                despesa.setDs_despesa2(dsDespesa2);

	                despesas.add(despesa);
	           
	            }
	        } finally {
	            // Feche as conexões e recursos
	            ConnectionFactory.fecharBanco();
	        }

	        return despesas;
	    }
	}
