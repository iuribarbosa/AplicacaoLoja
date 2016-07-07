package br.com.cafecomjava.springsecurity.controller;

import Beans.previaPedidoBean;
import Mapeamento.Funcionario;
import RN.FuncionarioRN;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import br.com.cafecomjava.springsecurity.dto.UserDetailsImpl;
import javax.faces.bean.ManagedBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(name = "processo")
public class UserDetailServiceImpl implements UserDetailsService {
    private Funcionario func;
    private FuncionarioRN funcRN;
    private String nome;

    SecurityContext c = SecurityContextHolder.getContext();
    Authentication a = c.getAuthentication();

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        funcRN = new FuncionarioRN();
        func = new Funcionario();
        func = funcRN.buscarFornecedorPorNome(username, username);
        nome = func.getUsufunc();
        if (username.equalsIgnoreCase(func.getNomefunc())) {
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
