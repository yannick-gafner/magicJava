package apiTest;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Request req = new Request("https://api.magicthegathering.io/v1/cards?");
		System.out.println(req.sendRequest("name=By%20Gnome%20Means"));
	}
}