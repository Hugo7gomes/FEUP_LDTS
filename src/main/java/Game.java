import GameState.GameStateManager;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.gui2.Interactable;
import com.googlecode.lanterna.gui2.TextGUI;
import com.googlecode.lanterna.gui2.TextGUIThread;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Game implements Runnable{
    private Screen screen;
    private int TERMINALCOLS = 190;
    private int TERMINALROWS = 50;
    private boolean isRunnig;
    private GameStateManager gsm;

    public Game(){
        try {
            gsm = new GameStateManager();
            TerminalSize terminalSize = new TerminalSize(TERMINALCOLS, TERMINALROWS);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
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
