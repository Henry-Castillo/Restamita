package control;

import javax.swing.JProgressBar;

public class Load extends Thread {

    JProgressBar progreso;

    public Load(JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }

    @Override
    public void run() {
        int i = 0;
        for (i = 1; i <= 100; i++) {
            progreso.setValue(i);
            pausa(30);
        }
    }

    public void pausa(int mlSeg) {
        try {
            Thread.sleep(mlSeg);
        } catch (InterruptedException e) {
        }
    }
}
