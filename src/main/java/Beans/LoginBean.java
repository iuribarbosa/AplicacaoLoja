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
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

@ManagedBean(name = "login")
@ViewScoped
public class LoginBean extends HttpServlet{

    private String senha;
    private String user;
    private FuncionarioRN funcRN;
    private Funcionario func;

    public void logar() {
        try {
            RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            FacesUtil.exibirMensagemErro(ex.getMessage());
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
