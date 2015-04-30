/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.twitter;

import com.cruta.hecas.generales.JSFUtil;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;    
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author avbravo
 */
@Named(value = "myTwitter")
@SessionScoped
public class MyTwitter implements Serializable{
private Twitter mi_twier;
    /**
     * Creates a new instance of MyTwitter
     */
    public MyTwitter() {
    }
    public String enviar(){
        Tweet();
    return null;
    }
    
     public String enviar(String mensaje){
        Tweet(mensaje);
    return null;
    }
     public void Tweet(){
try{

        System.out.println("voy a enviar");
       Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
 
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("4W5InvFtHgtZAQBa6QQeQFWlA")
                .setOAuthConsumerSecret("t3nCC1RKhAcqjZPoHmF4Osa2VzY9kTBt0d4XAn00H49jXHtfgT")
                .setOAuthAccessToken("15616431-NXjouNhzTBYQYQqRHPJnMKakh0RyZSHvhss7RYrTm")
                .setOAuthAccessTokenSecret("gC1hIbqXOU8QYjjcyYKL8P2uW2wVzSu3X5TfBO3iMqdo2");
        twitter = new TwitterFactory(cb.build()).getInstance();
 
        Paging pagina = new Paging();
 
        Status tweetEscrito = twitter.updateStatus("Holas desde hecas");      
        System.out.println("twett enviado");
 }catch(Exception ex)    {
    JSFUtil.errorDialog("Tweet()", ex.getLocalizedMessage());
    System.out.println("error() "+ex.getLocalizedMessage());
}
    }
     
       public void Tweet(String mensaje){
try{

       
       Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("4W5InvFtHgtZAQBa6QQeQFWlA")
                .setOAuthConsumerSecret("t3nCC1RKhAcqjZPoHmF4Osa2VzY9kTBt0d4XAn00H49jXHtfgT")
                .setOAuthAccessToken("15616431-NXjouNhzTBYQYQqRHPJnMKakh0RyZSHvhss7RYrTm")
                .setOAuthAccessTokenSecret("gC1hIbqXOU8QYjjcyYKL8P2uW2wVzSu3X5TfBO3iMqdo2");
        twitter = new TwitterFactory(cb.build()).getInstance();
 
        Paging pagina = new Paging();
 
        Status tweetEscrito = twitter.updateStatus(mensaje);      
        System.out.println("twett enviado");
 }catch(Exception ex)    {
    JSFUtil.errorDialog("Tweet()", ex.getLocalizedMessage());
    System.out.println("tweet() "+ex.getLocalizedMessage());
}
    }
}
