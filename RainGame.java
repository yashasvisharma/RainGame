/**
 * @author ysharma4, jnieto6
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 0, level = 0;
		String text = "";
		long startTime =System.currentTimeMillis();
		
		Zen.setFont("Helvetica-64");
		while (Zen.isRunning()) {
			if(Zen.getZenHeight() <= 480){
			if (text.length() == 0) 
			{
				x = 0;
				y = Zen.getZenHeight() / 2;
				dx += 0;
				dy += 2;
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score += 3000 / elapsed;
				level += 1;	
			}
			}
			else{
				Zen.drawText("Game Over", 200,200);
			}
			Zen.setColor(0, 0, 0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(255, 255, 255);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: " + level,10,50);
			Zen.drawText("Score: " + score,10,100);
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			Zen.flipBuffer();
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length()); // all except first character
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds

		}
	}

}
