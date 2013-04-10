package br.com.eventolivre.service.email;

import java.io.UnsupportedEncodingException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

/**
 * Essa interface é utilizada para criar a mensagem
 * @author otaviojava
 */
public interface GerarMensagem {
   
    /**
     * método base para criar a mensagem de email
     * @return a mesangem recém criada
     */
    Message criarMensagem(Session mailSession)throws UnsupportedEncodingException,MessagingException;
}
