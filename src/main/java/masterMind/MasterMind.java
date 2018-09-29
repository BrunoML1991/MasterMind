package masterMind;

import controllers.OperationController;
import controllers.local.LogicLocal;
import views.ConsoleView;

public class MasterMind {

	private Logic logic;
	private View view;

	public MasterMind(Logic logic, View view) {
		this.logic = logic;
		this.view = view;
	}

	public void play() {
		OperationController controller;
		do {
			controller = logic.getController();
			if (controller != null) {
				view.interact(controller);
			}
		} while (controller != null);

	}

	public static void main(String[] args) {
		new MasterMind(new LogicLocal(),new ConsoleView()).play();
	}

}
