package pl.biltec;

import java.io.IOException;

public class KeyMouseConsole {

	public static void main(String[] args) throws IOException, InterruptedException {
		String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
		int i = Runtime.getRuntime().exec(cmd).waitFor();

		System.out.printf("WCIŚNIĘTE=" + i);

	}
}

