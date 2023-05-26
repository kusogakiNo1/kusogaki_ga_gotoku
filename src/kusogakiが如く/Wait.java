package kusogakiが如く;

public class Wait {
	//文字表示の時間間隔を調節するメソッド+
	public void jikan(long l) {
		try { 
			Thread.sleep(l);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
	}

}
