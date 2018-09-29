package views;

import controllers.StartController;
import controllers.PutController;
import controllers.OperationController;
import controllers.ContinueController;
import masterMind.View;

public class ConsoleView implements View {

	private StartView startView;
	private GameView gameView;
	private ContinueView continueView;

	public ConsoleView(){
		startView = new StartView();
		gameView = new GameView();
		continueView = new ContinueView();
	}

	public void interact(OperationController controller) {
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}

	@Override
	public void visit(PutController putController) {
		gameView.interact(putController);
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}

}
