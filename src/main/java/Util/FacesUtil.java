

package Util;

import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FacesUtil {
	
   
	public static String getRequestParameter(String name) {
		return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
        
        public static void exibirMensagemSucesso(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_INFO, mensagem);
	}

	public static void exibirMensagemAlerta(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_WARN, mensagem);
	}
	
	public static void exibirMensagemErro(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_ERROR, mensagem);
	}
	
	private static void exibirMensagem(FacesMessage.Severity severity, String mensagem) {
		FacesMessage facesMessage = new FacesMessage(severity, "INFORMAÇÕES!", mensagem);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public static Map getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}
	
	public static ServletContext getServletContext() {
		return (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
	}
	
	public static HttpServletRequest getServletRequest() {
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public static HttpServletResponse getServletResponse() {
		return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}
		
        
        public static String textoAleatorio(int numLetras) {
            String codigoverificacao = "";
            long milis = new java.util.GregorianCalendar().getTimeInMillis();
            Random r = new Random(milis);
            int i = 0;
            while ( i < numLetras){
                char c = (char)r.nextInt(255);
                if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
                        codigoverificacao += c;
                        i ++;
                }
            }
            return codigoverificacao;
        }

}

