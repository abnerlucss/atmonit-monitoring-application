package br.com.monilog.atmonit.view.systemtray;

import br.com.monilog.atmonit.view.Log;
import br.com.monilog.atmonit.view.StringsJframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrayClass {
    static TrayIcon trayIcon;

    public TrayClass(Image image) {

        TrayClass.show(image);
    }

    public static void show(Image image) {
        if (!SystemTray.isSupported()) {
            System.exit(0);
        }

//        Image icon = createIcon("br/com/monilog/atmonit/view/systemtray/icon.png", "Atmonit");

        PopupMenu popupMenu = new PopupMenu();

        trayIcon = new TrayIcon(image);
        trayIcon.setToolTip("Atmonit");

        MenuItem exit = new MenuItem("Sair");

        popupMenu.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                try {
                    Log.logClose();
                } catch (IOException ex) {
                    Logger.getLogger(TrayClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        trayIcon.setPopupMenu(popupMenu);
        final SystemTray tray = SystemTray.getSystemTray();

        try {
            tray.add(trayIcon);
        } catch (Exception e) {

        }
    }

    protected static Image createIcon(String path, String desc) {
        URL imageURL = TrayClass.class.getResource(path);
        return (new ImageIcon(imageURL, desc)).getImage();
    }
}
