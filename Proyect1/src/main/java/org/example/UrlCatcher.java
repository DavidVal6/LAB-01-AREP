package org.example;
import java.net.*;
import java.io.*;

public class UrlCatcher {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://campusvirtual.escuelaing.edu.co:80/moodle/pluginfile.php/222974/mod_resource/content/0/NamesNetworkClientService.pdf");
            System.out.println("Protocolo: " + url.getProtocol());
            System.out.println("Puerto: " + Integer.toString(url.getPort()));
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File Name: " + url.getFile());
            System.out.println("Ref: " + url.getRef());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
