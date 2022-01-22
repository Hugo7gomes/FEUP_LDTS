package superMario;

import superMario.gameStates.GameStateManager;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Game {
    private Screen screen;
    private int TERMINALCOLS = 147;
    private int TERMINALROWS = 40;
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
            throw new UncheckedIOException(e);

        }
    }


    public void run(){
        int FPS = 45;
        int frameTime = 1000 / FPS;
        while(true){
            long startTime = System.currentTimeMillis();
            try {
                update();
                draw();
                gsm.notifyCurrentState(screen.pollInput());
                long elapsedTime = System.currentTimeMillis() - startTime;
                long sleepTime = frameTime - elapsedTime;
                if(sleepTime > 0)
                    Thread.sleep(sleepTime);
            } catch (IOException | InterruptedException e) {
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
        gsm.getGameStates().get(gsm.getCurrentState()).update();
    }


}
