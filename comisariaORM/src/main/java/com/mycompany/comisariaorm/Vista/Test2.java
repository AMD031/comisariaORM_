/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Vista;

import com.mycompany.comisariaorm.Modelo.Foto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.awt.image.ByteArrayImageSource;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class Test2 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

    public static void main(String[] args) {
        try {

            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            Foto i = new Foto(); // nuestra entidad
            File f = new File("C:/foto.png"); //asociamos el archivo fisico
            InputStream is = new FileInputStream(f); //lo abrimos. Lo importante es que sea un InputStream
            byte[] buffer = new byte[(int) f.length()]; //creamos el buffer
            int readers = is.read(buffer); //leemos el archivo al buffer
            i.setImagen(buffer); //lo guardamos en la entidad
            manager.persist(i);

            manager.getTransaction().commit();
            manager.close();

        } catch (Exception e) {

        }

        EntityManager manager1 = emf.createEntityManager();
        manager1.getTransaction().begin();

        Foto ent = manager1.find(Foto.class, 1l); //ubicamos una entidad
        Image image = new ToolkitImage(new ByteArrayImageSource(ent.getImagen())); //lo convertimos a Image
        JLabel label = new JLabel(new ImageIcon(image)); //creamos un JLabel con la imagen como icono
        JFrame frame = new JFrame("imagen"); //creamos el jframe
        frame.setLayout(new BorderLayout()); //.. con un Layout clasico
        frame.add(label, BorderLayout.CENTER); //.. agregamos el JLabel en el centro
  
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        frame.setSize(width / 2, height / 2);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); //y lo mostramos

        manager1.getTransaction().commit();
        manager1.close();

    }

}
