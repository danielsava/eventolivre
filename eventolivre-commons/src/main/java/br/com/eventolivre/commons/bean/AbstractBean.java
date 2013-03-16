package br.com.eventolivre.commons.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author otavio
 */
public class AbstractBean implements Serializable {

    
    private static final long serialVersionUID = 958520337356026828L;

    static {
        Locale.setDefault(new Locale("pt", "BR"));
    }

    protected void adicionarMensagemAviso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null));
    }

    protected void adicionarMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
    }

    protected void adicionarMensagemInfo(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }

    protected HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    protected ExternalContext getExternalContext() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext();
        
    }

    protected void adicionarObjetoSessao(String chave, Object valor) {

        getSession().setAttribute(chave, valor);
    }

    protected Object getObjetoSessao(String chave) {

        return getSession().getAttribute(chave);
    }

    protected void removerbjetoSessao(String chave) {

        getSession().removeAttribute(chave);

    }

    
 protected void irPagina(String url)   {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
