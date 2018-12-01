package MVC;

public class EndScreenModel extends Model{
	//if win is true set state to end
	public void checkEnd() {
		if (win == true) {
			View.State = View.STATE.END;
		}
	}
}
