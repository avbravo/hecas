/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.json;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author avbravo
 */
@Named(value = "lectorJSON")
@Dependent
public class LectorJSON {

    /**
     * Creates a new instance of LectorJSON
     */
    public LectorJSON() {
    }

    public String lector() {
//        try {

//            URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
//        InputStream is = url.openStream();
//        
//                    JsonParser parser = Json.createParser(is)) {
//                while (parser.hasNext()) {
//                    Event e = parser.next();
//                    if (e == Event.KEY_NAME) {
//                        switch (parser.getString()) {
//                            case "name":
//                                parser.next();
//                                System.out.print(parser.getString());
//                                System.out.print(": ");
//                                break;
//                            case "message":
//                                parser.next();
//                                System.out.println(parser.getString());
//                                System.out.println("---------");
//                                break;
//                        }
//                    }
//                }
//
//             }
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(LectorJSON.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
 }