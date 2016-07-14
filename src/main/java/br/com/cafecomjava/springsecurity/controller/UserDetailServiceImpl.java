package br.com.cafecomjava.springsecurity.controller;

import Mapeamento.Funcionario;
import RN.FuncionarioRN;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import br.com.cafecomjava.springsecurity.dto.UserDetailsImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "processo")
@SessionScoped
public class UserDetailServiceImpl implements UserDetailsService {

    private Funcionario func;
    private FuncionarioRN funcRN;
    private String nome;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("ID_USUARIO", username);
        
        funcRN = new FuncionarioRN();
        func = new Funcionario();
        func = funcRN.buscarFornecedorPorNome(username, username);
        setNome(username);
        if (username.equalsIgnoreCase(func.getUsufunc())) {
            UserDetailsImpl user = new UserDetailsImpl();
            user.setUserName(username);
            user.setPassword(func.getSenhafunc());
            user.addAuthority("ROLE_USER");
            return user;
        }
        throw new UsernameNotFoundException("Usuario não encontrado");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
