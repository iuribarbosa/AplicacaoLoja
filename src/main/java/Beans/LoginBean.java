/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Mapeamento.Funcionario;
import RN.FuncionarioRN;
import Util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServlet;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "login")
@ViewScoped
public class LoginBean extends HttpServlet{

    private String senha;
    private String user;
    private FuncionarioRN funcRN;
    private Funcionario func;

    public void logar() {
        funcRN = new FuncionarioRN();
        if (funcRN.verificarConexao(user, senha)) {
            RequestContext.getCurrentInstance().execute("location.href='home.xhtml'");
            FacesUtil.exibirMensagemSucesso("Bem vindo");
        } else {
            RequestContext.getCurrentInstance().execute("alert('Usuário ou senha incorreta')");
        }
    }

    
    //Gets e sets

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

}
