package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MyJavaApp {
    public static void main(String[] args) throws Exception {
        // Create a basic Jetty server object that will listen on port 8080.
        Server server = new Server(80);

        // Create a ServletContextHandler to hold the default servlet.
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add the default servlet to serve static content.
        ServletHolder holderDefault = new ServletHolder("default", new DefaultServlet());
        holderDefault.setInitParameter("resourceBase", MyJavaApp.class.getResource("/webapp").toExternalForm());
        holderDefault.setInitParameter("dirAllowed", "true");
        context.addServlet(holderDefault, "/");

        // Start the server.
        server.start();
        server.join();
    }
}