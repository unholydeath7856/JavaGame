import java.util.TimerTask;

public class GameTimeTasks extends TimerTask {
	//60 seconds in 1 minutes 60 mins in 1 hour time starts at 6am
	public int gameTime = 6 * 60 * 60;
	public int day = 1;
	public int displayDay = 1;
	public int month = 1;
	public int displayMonth = 7;
	public int year = 8;
	
	private Game game;
	
	public GameTimeTasks(Game game) {
		this.game = game;
	}
	
	public void run() {
		advanceTime();
		
	}
	
	private void advanceTime() {
		gameTime += 120;
		//86400
		if (gameTime >= 86400 ) {
			gameTime = 0;
			day++;
			displayDay++;
			switch(displayMonth) {
			case 1:
				if (day % 31 == 0)
				{
					displayDay = 1;
					displayMonth++;
					month++;
				}
				break;
			case 2:
				if (day % 28 == 0 && year % 4 != 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				} else if (day % 29 == 0) {
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 3:
				if (day % 31 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 4:
				if (day % 30 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 5:
				if (day % 31 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 6:
				if (day % 30 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 7:
				if (day % 31 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 8:
				if (day % 31 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 9:
				if (day % 30 == 0)
				{
					month++;
					displayDay = 1;
					displayMonth++;
				}
				break;
			case 10:
				if (day % 31 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 11:
				if (day % 30 == 0)
				{
					displayDay = 1;
					month++;
					displayMonth++;
				}
				break;
			case 12:
				if (day % 31 == 0)
				{
					displayMonth++;
					displayDay = 1;
					month++;
					displayMonth = 1;
					year++;
				}
				break;
			default:
				break;
			}
		}
		this.game.onTime(gameTime);
	}
}
