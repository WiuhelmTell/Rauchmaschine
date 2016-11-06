package mvc.main;

import mvc.controller.SmokeController;

public class Main {

    static SmokeController controller;

    /**
     * Diese Klasse wird nur dazu benutzt alle nötigen
     * Komponenten zu Initialisieren und die erste
     * View anzuzeigen
     */
    public static void main(String [] args){
        controller = new SmokeController();

        controller.showView();
    }
}
