package visual;

public class Wallpaper extends Thread {
	public void run() {
		while (true) {
			try {
				Principal.wallpaperone();
				Wallpaper.sleep(120000);
				Principal.wallpapertwo();
				Wallpaper.sleep(120000);
				Principal.wallpaperthree();
				Wallpaper.sleep(120000);
				Principal.wallpaperfour();
				Wallpaper.sleep(120000);
				Principal.wallpaperfive();
				Wallpaper.sleep(120000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
