package component;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {
    public static void menuBar(){
        Frame frame=new Frame("Menu");
        frame.setBounds(100,100,500,500);
        frame.setVisible(true);

        MenuBar menuBar=new MenuBar();
        java.awt.Menu menu=new java.awt.Menu("Menu");
        PopupMenu popupMenu=new PopupMenu();

        MenuItem menuItem1=new MenuItem("Menu Item1");
        menuItem1.addActionListener(e->{
            System.out.println("Menu Item1 clicked");
        });
        MenuItem menuItem2=new MenuItem("Menu Item2");
        CheckboxMenuItem menuItem3=new CheckboxMenuItem("Menu Item3");
        menuItem3.addActionListener(e->{
            System.out.println("Menu Item3 clicked");
        });
        menuItem3.setShortcut(new MenuShortcut('U'));
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        MenuItem menuItem4=new MenuItem("Menu Item4");
        MenuItem menuItem5=new CheckboxMenuItem("Menu Item5");
        popupMenu.add(menuItem4);
        popupMenu.add(menuItem5);
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON3){
                    popupMenu.show(frame,e.getX(),e.getY());
                }
            }
        });

        menuBar.add(menu);

        frame.add(popupMenu);
        frame.setMenuBar(menuBar);
    }
}
