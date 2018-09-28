package controllers;

import models.Game;
import utils.IO;

public class RandomPutController extends Controller{

	protected RandomPutController(Game game) {
		super(game);
	}


	public char[] put() {
		new IO().readString("Pulse intro para continuar");
		return this.createRandomCode();
	}

}
