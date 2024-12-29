package tugas8;

import org.w3c.dom.events.Event;

class Window {
    public void open() {
        System.out.println("Window Dibuka");
    }

    public void close() {
        System.out.println("Window Ditutup");
    }

    public void move() {
        System.out.println("Window Dipindahkan");
    }

    public void display() {
        System.out.println("Window Ditampilkan");
    }

    public void handleEvent(Event event) {
        System.out.println("Menangani Event dengan tipe: " + event.getEventPhase());
    }
}
