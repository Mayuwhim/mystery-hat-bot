/* Written by Hoioidoi (Mayuwhim)
 * August 08, 2023
 * da amazing bunker simulator Forcefield Hat Bot V2
 * Please use with AHK program!
 */

package bot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class ForcefieldHatBot {
	
	final static int[] COLS = {723,753,783,813,816,1103,1133,1163,1193,1196}; //bingo square pixels x pos (CHANGE IF NECESSARY)
	final static int[] ROWS = {503,505,535,593,595}; //bingo square pixels y pos (CHANGE IF NECESSARY)
	
	//{499,501,531,589,591} W11 y positions
	//{503,505,535,593,595} W10 y positions
	
	//board positions you check for (can be modified)
	final static int[][][] STATES = {
			{
				{0,0,0,0,0},
				{0,0,1,0,0},
				{0,1,1,1,0},
				{0,0,1,0,0},
				{0,0,1,0,0}
			},
			{
				{0,0,1,0,0},
				{0,1,1,1,0},
				{0,0,1,0,0},
				{0,0,1,0,0},
				{0,0,1,0,0}
			},
			{
				{0,0,0,0,0},
				{0,1,0,0,0},
				{1,1,1,0,0},
				{0,1,0,0,0},
				{0,1,0,0,0}
			},
			{
				{0,0,0,0,0},
				{0,0,0,1,0},
				{0,0,1,1,1},
				{0,0,0,1,0},
				{0,0,0,1,0}
			},
			{
				{0,1,0,1,0},
				{0,0,1,0,0},
				{0,0,1,0,0},
				{0,0,1,0,0},
				{0,0,0,0,0}
			},
			{
				{0,0,1,0,1},
				{0,0,0,1,0},
				{0,0,1,0,0},
				{0,1,0,0,0},
				{0,0,0,0,0}
			},
			{
				{1,0,0,0,1},
				{0,1,0,1,0},
				{0,0,1,0,0},
				{0,1,0,0,0},
				{1,0,0,0,0}
			},
			{
				{1,0,0,0,1},
				{0,1,0,1,0},
				{0,0,1,0,0},
				{0,0,1,0,0},
				{0,0,1,0,0}
			}
	};
	
	public static void main(String[] args) throws AWTException {
		//init termination hotkey
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// IDK HOW THIS ERROR WOULD OCCUR BUT IF IT DOES KILL THE PROGRAM I GUESS
			e.printStackTrace();
			System.exit(0);
		}
		GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
			@Override
			public void nativeKeyTyped(NativeKeyEvent e) {}

			@Override
			public void nativeKeyPressed(NativeKeyEvent e) {}

			@Override
			public void nativeKeyReleased(NativeKeyEvent e) {
				//hotkey is currently P, feel free to change (but you will need to change AHK script close hotkey too)
				if (e.getKeyCode() == 25) {
					System.out.println("diesofcringe");
					System.exit(0);
				}
			}
		});
		
		
		Robot bot = new Robot();
		
		//Focus Roblox window
		bot.mouseMove(1900,727);
		bot.delay(500);
		for (int i = 0; i<5; i++) {
			click(bot);
			bot.delay(200);
		}
		
		L(bot); //Activates AHK script to reset board
		
		bot.delay(45000);
		
		while(true) {
			boolean[][][] c = new boolean[5][5][2];
			
			//get state of bingo squares
			for (int i = 0; i<5; i++) {
				for (int j = 0; j<5; j++) {
					c[i][j][0] = bean(bot.getPixelColor(COLS[j], ROWS[i]));
				}
			}
			for (int i = 0; i<5; i++) {
				for (int j = 0; j<5; j++) {
					c[i][j][1] = bean(bot.getPixelColor(COLS[j+5], ROWS[i]));
				}
			}
			
			boolean resetNow = true;
			//check for possible states left
			for (int i = 0; i<STATES.length; i++) {
				if (!checkThing(c, STATES[i], 0) || !checkThing(c, STATES[i], 1)) {
					resetNow = false;
					break;
				}
			}
			
			if (resetNow) {
				System.out.println("RESET");
				L(bot);
				bot.delay(45000);
			} else {
				System.out.println("no reset");
				bot.delay(1000);
			}
			
		}
		
	}
	
	static boolean bean(Color c) {
		/* Check pixel color for state:
		 * If the G and R values is similar, it is a shade of gray, or not filled in
		 * This is because bingo win effects shade the screen a little so can't check for 1 color
		 */
		if (c.getGreen()-c.getRed() < c.getGreen()*0.1) {
			return false;
		}
		return true;
	}
	
	static boolean checkThing(boolean[][][] c, int[][] x, int num) {
		//checks for individual board state, true means that state cannot be achieved anymore with current position
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				if (x[i][j] == 0) {
					if (c[i][j][num]) return true;
				}
			}
		}
		
		return false;
	}
	
	static void L(Robot bot) {
		bot.keyPress(112);
		bot.delay(20);
		bot.keyRelease(112);
	    bot.delay(20);
	}
	
	static void click(Robot bot) {
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.delay(20);
	    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    bot.delay(20);
	}

}
