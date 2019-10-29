package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class UsuarioDAO {
    
    private static final Database db = new Database();
    
    public static int salvarUsuario(Usuario u) {
        int id = 0;
        
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO "
                    + " tbl_usuario(nome, email, senha, cpf, fk_setor, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            
            query.setString(1, u.getNome());
            query.setString(2, u.getEmail());
            query.setString(3, u.getSenha());
            query.setString(4, u.getCpf());
            query.setInt(5, u.getSetor());
            query.setInt(6, 0);
            
            query.executeUpdate();
            
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return id;
        }
        
        return id;
    }
    
    public static boolean alterarUsuario(Usuario u) {
        String senha = "";
        Connection conn = db.obterConexao();
        try {
            if (u.getSenha() != null) {
                senha = "senha = ?,";
            }

            PreparedStatement query = conn.prepareStatement("UPDATE"
                    + " tbl_usuario SET nome = ?, email = ?, " + senha + " cpf = ?, fk_setor = ?"
                    + " WHERE id_usuario = ?;");

            query.setString(1, u.getNome());
            query.setString(2, u.getEmail());
            if (u.getSenha() != null) {
                query.setString(3, u.getSenha());
                query.setString(4, u.getCpf());
                query.setInt(5, u.getSetor());
                query.setInt(6, u.getCodigo());
            } else {
                query.setString(3, u.getCpf());
                query.setInt(4, u.getSetor());
                query.setInt(5, u.getCodigo());
            }

            query.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public static boolean excluirUsuario(int uCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_usuario SET status = 1 WHERE id_usuario = ?");
            
            query.setInt(1, uCodigo);
            
            query.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public static ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT u.id_usuario, u.nome, u.email, u.senha, u.cpf, u.fk_setor, s.nome_setor"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_setor AS s ON u.fk_setor = s.id_setor"
                    + " WHERE u.status = 0;");
            
            ResultSet rs = query.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6)
                    );
                    user.setNomeSetor(rs.getString(7));
                    usuarios.add(user);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return usuarios;
    }
    
    public static Usuario getUsuario(int codigoUsuario) {
        Usuario usuarios = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT u.id_usuario, u.nome, u.email, u.senha, u.cpf, u.fk_setor, s.nome_setor"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_setor AS s ON u.fk_setor = s.id_setor"
                    + " WHERE u.id_usuario  = ? AND u.status = 0 ;");
            
            query.setInt(1, codigoUsuario);
            ResultSet rs = query.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6));
                    user.setNomeSetor(rs.getString(7));
                    usuarios = user;
                }
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return usuarios;
    }
    
    public static ArrayList<Usuario> getSetoresCadastro() {
        ArrayList<Usuario> setores = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_setor, nome_setor FROM tbl_setor;");
            
            ResultSet rs = query.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setSetor(rs.getInt(1));
                    user.setNomeSetor(rs.getString(2));
                    setores.add(user);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return setores;
    }
    
    public static boolean getLogin(String email, String senha) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_usuario WHERE email= ? AND senha = ? AND status = 0;");
            query.setString(1, email);
            query.setString(2, senha);
            
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return false;
    }
    
    public static Usuario getInfoSessao(String uEmail) {
        Usuario sessao = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT u.id_usuario, u.nome, s.nome_setor"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_setor AS s ON u.fk_setor = s.id_setor"
                    + " WHERE email = ?;");
            
            query.setString(1, uEmail);
            
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                sessao = new Usuario();
                sessao.setCodigo(rs.getInt(1));
                sessao.setNome(rs.getString(2));
                sessao.setNomeSetor(rs.getString(3));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return sessao;
    }
    
    public static int salvarEndereco(Usuario u) {
        int id = 0;
        
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_endereco(logradouro, numero, bairro, cidade, estado, cep, tipo)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            
            query.setString(1, u.getLogradouro());
            query.setInt(2, u.getNumero());
            query.setString(3, u.getBairro());
            query.setString(4, u.getCidade());
            query.setString(5, u.getEstado());
            query.setString(6, u.getCep());
            query.setString(7, u.getTipoEndereco());
            
            query.executeUpdate();
            
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return id;
        }
        
        return id;
    }
    
    public static boolean salvarRelacaoEnderecoUsuario(Usuario u) {
        int id = 0;
        
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_endereco_usuario(id_usuario, id_endereco)"
                    + " VALUES (?, ?);");
            
            query.setInt(1, u.getCodigo());
            query.setInt(2, u.getCodigoEndereco());
            
            query.executeUpdate();
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public static Usuario getEnderecoUser(int codigoUsuario) {
        Usuario endereco = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " e.id_endereco,"
                    + " e.logradouro,"
                    + " e.numero,"
                    + " e.bairro,"
                    + " e.cidade,"
                    + " e.estado,"
                    + " e.cep,"
                    + " e.tipo"
                    + " FROM tbl_endereco AS e"
                    + " INNER JOIN tbl_endereco_usuario AS eu"
                    + " ON e.id_endereco = eu.id_endereco"
                    + " INNER JOIN tbl_usuario AS u"
                    + " ON eu.id_usuario = u.id_usuario"
                    + " WHERE u.id_usuario = ?;");
            
            query.setInt(1, codigoUsuario);
            ResultSet rs = query.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Usuario e = new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                    );
                    endereco = e;
                    endereco.setCodigoEndereco(e.getCodigo());
                }
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return endereco;
    }
    
    public static boolean alterarEndereco(Usuario u) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_endereco"
                    + " SET logradouro = ? , numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, tipo = ? WHERE id_endereco = ?;");
            
            query.setString(1, u.getLogradouro());
            query.setInt(2, u.getNumero());
            query.setString(3, u.getBairro());
            query.setString(4, u.getCidade());
            query.setString(5, u.getEstado());
            query.setString(6, u.getCep());
            query.setString(7, u.getTipoEndereco());
            query.setInt(8, u.getCodigo());
            
            query.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
}
