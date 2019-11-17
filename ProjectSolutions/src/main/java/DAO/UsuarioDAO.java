package DAO;

import Model.Pagamento;
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
                query.setInt(6, u.getCodigoUsuario());
            } else {
                query.setString(3, u.getCpf());
                query.setInt(4, u.getSetor());
                query.setInt(5, u.getCodigoUsuario());
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
            PreparedStatement query = conn.prepareStatement("SELECT u.id_usuario, u.nome, u.cpf, u.fk_setor, s.nome_setor"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_setor AS s ON u.fk_setor = s.id_setor"
                    + " WHERE email = ?;");

            query.setString(1, uEmail);

            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                sessao = new Usuario();
                sessao.setCodigoUsuario(rs.getInt(1));
                sessao.setNome(rs.getString(2));
                sessao.setCpf(rs.getString(3));
                sessao.setSetor(rs.getInt(4));
                sessao.setNomeSetor(rs.getString(5));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return sessao;
    }

    public static ArrayList<Pagamento> getPagamentosDisponiveis(boolean isCadastroPerfil) {
        Connection conn = db.obterConexao();
        ArrayList<Pagamento> pagamentos = new ArrayList();

        String complemento = isCadastroPerfil ? "Limit 2" : "";
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_info_pagamentos " + complemento);

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pagamento pag = new Pagamento(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                    pagamentos.add(pag);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pagamentos;
    }

    public static ArrayList<Pagamento> getPagamentosCadastrados(int codigoCliente) {
        Connection conn = db.obterConexao();
        ArrayList<Pagamento> pagamentos = new ArrayList();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " pu.id_pagamento, pu.numero_pagamento,"
                    + " pu.nome_titular, pu.data_vencimento, ip.nome"
                    + " FROM tbl_pagamento_usuario AS pu"
                    + " INNER JOIN tbl_info_pagamentos AS ip"
                    + " ON pu.fk_info_pagamento = ip.id_info_pagamento"
                    + " WHERE pu.fk_usuario = ?");
            query.setInt(1, codigoCliente);

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pagamento pag = new Pagamento();
                    pag.setId(rs.getInt(1));
                    int i = 0;
                    String numCartaoAux = "";
                    while (i < rs.getString(2).length()) {
                        if (i > 11) {
                            char c = rs.getString(2).charAt(i);
                            numCartaoAux += String.valueOf(c);
                        }
                        i++;
                    }
                    pag.setNumeroPagamento(numCartaoAux);
                    pag.setNomeTitular(rs.getString(3));
                    pag.setDataVencimento(rs.getString(4));
                    pag.setTipoPagamento(rs.getString(5));

                    pagamentos.add(pag);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pagamentos;
    }

    public static ArrayList<Pagamento> getPagamentosCheckout(int codigoCliente) {
        Connection conn = db.obterConexao();
        ArrayList<Pagamento> pagamentos = new ArrayList();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " pu.id_pagamento, pu.numero_pagamento, pu.nome_titular, pu.data_vencimento, ip.nome"
                    + " FROM tbl_pagamento_usuario AS pu"
                    + " INNER JOIN tbl_info_pagamentos AS ip"
                    + " ON pu.fk_info_pagamento = ip.id_info_pagamento"
                    + " WHERE pu.fk_info_pagamento != 3"
                    + " AND pu.fk_usuario = ?;");
            query.setInt(1, codigoCliente);

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pagamento pag = new Pagamento();
                    pag.setId(rs.getInt(1));
                    int i = 0;
                    String numCartaoAux = "";
                    while (i < rs.getString(2).length()) {
                        if (i > 11) {
                            char c = rs.getString(2).charAt(i);
                            numCartaoAux += String.valueOf(c);
                        }
                        i++;
                    }
                    pag.setNumeroPagamento(numCartaoAux);
                    pag.setNomeTitular(rs.getString(3));
                    pag.setDataVencimento(rs.getString(4));
                    pag.setTipoPagamento(rs.getString(5));

                    pagamentos.add(pag);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pagamentos;
    }

    public static boolean salvarMetodoPagamento(Pagamento pag, int codUsuario) {
        Connection conn = db.obterConexao();

        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO tbl_pagamento_usuario"
                    + " (numero_pagamento, nome_titular, data_vencimento, codigo_segurança, fk_info_pagamento, fk_usuario)"
                    + " values"
                    + " (?, ?, ?, ?, ?, ?);");

            query.setString(1, pag.getNumeroPagamento());
            query.setString(2, pag.getNomeTitular());
            query.setString(3, pag.getDataVencimento());
            query.setString(4, pag.getCodigoSegurança());
            query.setInt(5, pag.getId());
            query.setInt(6, codUsuario);

            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static int salvarBoletoPagamento(Pagamento p) {
        Connection conn = db.obterConexao();
        int id = 0;

        try {
            PreparedStatement query = conn.prepareStatement(
                    "INSERT INTO tbl_pagamento_usuario(numero_pagamento, fk_info_pagamento, fk_usuario) VALUES (?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);

            query.setString(1, p.getNumeroPagamento());
            query.setInt(2, p.getIdInfoPagamento());
            query.setInt(3, p.getIdUsuario());

            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return id;
        }

        return id;
    }
}
