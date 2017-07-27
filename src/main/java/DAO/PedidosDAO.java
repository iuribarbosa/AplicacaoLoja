/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Pedidos;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class PedidosDAO implements PedidosDAOListener{
    private Session sessao;

    
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    
    
    @Override
    public void salvar(Pedidos al){
        this.sessao.save(al);
    }
    
    
    
    
    
    @Override
    public void alterar(Pedidos al){
        this.sessao.update(al);
    }
    
    
    
    
    
    @Override
    public void excluir(Pedidos al){
        this.sessao.delete(al);
    }
    
    
    
    
    
    @Override
    public List<Pedidos> listarSemFiltro(){
        return this.sessao.createCriteria(Pedidos.class).list();
    }
    
    
    
    
    
    @Override
    public Pedidos consultar(int ID){
        return (Pedidos) this.sessao.get(Pedidos.class,ID);
    }
    
    @Override
    public Pedidos consultarListaID(int id, int tipo) {
        String hql = "select t from Pedidos t where t.idPedido like :nomeA and t.tipo = :tipo";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setInteger("nomeA", id);
        consulta.setInteger("tipo", tipo);
        return (Pedidos) consulta.uniqueResult();
    }
    @Override
    public List<Pedidos> listarComFiltro(int id) {
        String hql = "select t from Pedidos t where t.tipo like :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setInteger("nomeA", id);
        return (List<Pedidos>) consulta.list();
    }
    @Override
    public double listarPorMês(String ano, String mes, String dia) {
        String retorno = "('"+ano+"-"+mes+"-"+dia+"')";
        String hql = "select SUM(t.total) from Pedidos t where t.data between "+ retorno +" and ('"+ano+"-"+mes+"-31') and t.tipo like 1";
        Query consulta = this.sessao.createQuery(hql);
        return (double)consulta.uniqueResult();
    }
    @Override
    public double listarPorAno(String ano) {
        String hql = "select SUM(t.total) from Pedidos t where t.data between ('"+ano+"-01-01') and ('"+ano+"-12-31') and t.tipo like 1";
        Query consulta = this.sessao.createQuery(hql);
        return (double)consulta.uniqueResult();
    }
    @Override
    public double listarPorMêsTotal(String ano, String mes) {
        String hql = "select SUM(t.total) from Pedidos t where t.data between ('"+ano+"-"+mes+"-01') and ('"+ano+"-"+mes+"-31') and t.tipo like 1";
        Query consulta = this.sessao.createQuery(hql);
        if(consulta.uniqueResult() == null){
            return 0;
        }else{
        return (double)consulta.uniqueResult();
        }
    }
    @Override
    public double listarPorMêsAV(String ano, String mes) {
        String hql = "select SUM(t.total) from Pedidos t where t.data between ('"+ano+"-"+mes+"-01') and ('"+ano+"-"+mes+"-31') and t.tipo like 1 and t.formaPagamento = 1";
        Query consulta = this.sessao.createQuery(hql);
        if(consulta.uniqueResult() == null){
            return 0;
        }else{
        return (double)consulta.uniqueResult();
        }
    }
    @Override
    public double listarPorMêsAP(String ano, String mes) {
        String hql = "select SUM(t.total) from Pedidos t where t.data between ('"+ano+"-"+mes+"-01') and ('"+ano+"-"+mes+"-31') and t.tipo like 1 and t.formaPagamento = 2";
        Query consulta = this.sessao.createQuery(hql);
        if(consulta.uniqueResult() == null){
            return 0;
        }else{
        return (double)consulta.uniqueResult();
        }
    }
    @Override
    public double listarPorDia(String ano, String mes, String dia) {
        String retorno = "('"+ano+"-"+mes+"-"+dia+" 00:00:00')";
        String retornoFim = "('"+ano+"-"+mes+"-"+dia+" 23:59:59')";
        String hql = "select SUM(t.total) from Pedidos t where t.data between "+ retorno +" and "+ retornoFim +" and t.tipo like 1";
        Query consulta = this.sessao.createQuery(hql);
        if(consulta.uniqueResult() == null){
            return 0;
        }else{
        return (double)consulta.uniqueResult();
        }
    }
    @Override
    public double listarPorDiaAP(String ano, String mes, String dia) {
        String retorno = "('"+ano+"-"+mes+"-"+dia+" 00:00:00')";
        String retornoFim = "('"+ano+"-"+mes+"-"+dia+" 23:59:59')";
        String hql = "select SUM(t.total) from Pedidos t where t.data between "+ retorno +" and "+ retornoFim +" and t.tipo like 1 and t.formaPagamento = 2";
        Query consulta = this.sessao.createQuery(hql);
        if(consulta.uniqueResult() == null){
            return 0;
        }else{
        return (double)consulta.uniqueResult();
        }
    }
    @Override
    public double listarPorDiaAV(String ano, String mes, String dia) {
        String retorno = "('"+ano+"-"+mes+"-"+dia+" 00:00:00')";
        String retornoFim = "('"+ano+"-"+mes+"-"+dia+" 23:59:59')";
        String hql = "select SUM(t.total) from Pedidos t where t.data between "+ retorno +" and "+ retornoFim +" and t.tipo like 1 and t.formaPagamento = 1";
        Query consulta = this.sessao.createQuery(hql);
        if(consulta.uniqueResult() == null){
            return 0;
        }else{
        return (double)consulta.uniqueResult();
        }
    }
    
    @Override
    public Pedidos buscarData(Date data) {
        String hql = "select t from Pedidos t where t.data = :matA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setDate("matA", data);
        return (Pedidos) consulta.uniqueResult();
    }
    
    
    
    
    @Override
    public List<Pedidos> obterTodos() {
        return this.sessao.createCriteria(Pedidos.class).list();
    }
    
}
