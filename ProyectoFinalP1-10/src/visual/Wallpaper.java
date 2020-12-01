package visual;

public class Wallpaper extends Thread {
	public void run() {
		while (true) {
			try {
				Principal.wallpaperone();
				Wallpaper.sleep(60000);
				Principal.wallpapertwo();
				Wallpaper.sleep(60000);
				Principal.wallpaperthree();
				Wallpaper.sleep(60000);
				Principal.wallpaperfour();
				Wallpaper.sleep(60000);
				Principal.wallpaperfive();
				Wallpaper.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
