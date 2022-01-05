import GameState.GameStateManager;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game implements Runnable{
    private Screen screen;
    private int TERMINALCOLS = 147;
    private int TERMINALROWS = 40;
    private boolean isRunnig;
    private GameStateManager gsm;

    public Game(){
        gsm = new GameStateManager();
        try {
            DefaultTerminalFactory factory = new DefaultTerminalFactory();
            factory.setInitialTerminalSize(new TerminalSize(TERMINALCOLS, TERMINALROWS));
            Terminal terminal = factory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void run(){
        while(true){
            try {
                update();
                draw();
                gsm.notifyCurrentState(screen.pollInput());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw() throws IOException {
        screen.clear();
        gsm.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void update(){

    }


}
