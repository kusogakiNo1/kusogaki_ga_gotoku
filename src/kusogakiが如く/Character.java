/*
 *   作成	Rhizome
 *------------------------------------------------------------
 * Copyright(c) Rhizome Inc. All Rights Reserved.
 */
package kusogakiが如く;

/**
 * 登場するキャラクターの情報とデフォルトの行動を設定したクラスです
 * @author rhizome
 *
 */
public class Character {
	/** 名前 */
	private String name = "";
	
	
	//キャラ紹介格納用変数
	public StringBuffer introduce = new StringBuffer();
	
	/** Lv */
	private int lv ;

	/** HP */
	private int hp;
	
	/** 攻撃力 */
	private int power;

	/** 防御力 */
	private int endurance;
	
	/** 素早さ */
	private int quickness;
	
	
	//↓の一時的な値は、たとえば攻撃されてHPが減ったりした時などに代入する所。
	/** 一時的なHP */
	private int nowHp;
	
	/** 一時的な攻撃力 */
	private int nowPower;

	/** 一時的な防御力 */
	private int nowEndurance;
	
	/** 一時的な素早さ */
	private int nowQuickness;
	
	/** クソガキゲージ */
	private int kGause = 10;//これがゲージの最大値。最大になれば、必殺技が使える。
	
	/** 現時点でのクソガキゲージ */
	private int nowKGause = 0;//これが現在のゲージの値。
	
	/** 現在の経験値 */
	private int nowExp;
	
	/** 現在のLvアップに必要な経験値 */
	private int nowNeedExp;         //allNeedExp - nowExp で求める。
	
	/** Lvアップに必要な経験値の一覧　*/
	public int[] needExp = new int[100];
	
	/** 現在のLvアップに必要な総経験値　*/
	private int allNeedExp;

	
	
	
	
	/**
	 * 体力、攻撃力、防御力、素早さ、経験値量などの初期値を設定しつつ、Characterインスタンスを生成します
	 * 	ようは、キャラ獲得時の初期設定です。
	 */
	public Character(int lv, int hp, int power, int endurance, int quickness) {
		this.lv = lv;
		this.hp = hp;
		this.power = power;
		this.endurance = endurance;
		this.quickness = quickness;
		this.nowHp = hp;
		this.nowPower = power;
		this.nowEndurance = endurance;
		this.nowQuickness = quickness;
		
		/*経験値の基準
		 * ・レベルアップのために同レベルの敵を倒す回数 K = 5
			・レベル差が１のときの倍率　　a = 1.4
			・レベル１から２にレベルアップするのに必要な経験値 I = 10
			・playerのLv pLv
			・敵のLv eLv
			・pLvと同じレベルの敵を倒したときにもらえる経験値　Exp(pLv) = { I * a^(pLv - 1) } / K
			・pLv + 1 レベルになるために必要な経験値　Next = I * a^(pLv - 1)
			
			・具体的な値を代入してみると...
			Exp(pLv) = { 10 * 1.4^(pLv - 1) } / 5
			Next = 10 * 1.4^(pLv - 1)
			
			・これを、配列に代入していく
		 * */
		for (int i = 0; i < 100; i++) {
			double a =  10 * Math.pow(1.4, i);
			int b = (int) a;
			needExp[i] = b;	
		}
		//上で求めた経験値一覧表を用いて、キャラ獲得時点でそのキャラが得ている経験値量を計算する
		for (int i = 0; i < lv; i++ ) {
			nowExp += needExp[i];
		}
		//最後に、現在のLvアップに必要な経験値を求める
		for (int i = 0; i < lv + 1; i++ ) {
			allNeedExp += needExp[i];
		}
		nowNeedExp = allNeedExp - nowExp;
		
		
		
		
	}

	
	//------------------setterとgetterの設定-------------------------------
	
	//名前
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	

	//Lv
	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	
	//HP
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	//Endurance
	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	//Quickness
	public int getQuickness() {
		return quickness;
	}

	public void setQuickness(int quickness) {
		this.quickness = quickness;
	}

	//Gause
	public int getkGause() {
		return kGause;
	}

	public void setkGause(int kGause) {
		this.kGause = kGause;
	}

	//パワー
	public int getPower() {
		return this.power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	//現在の総獲得経験値
	public int getNowExp() {
		return nowExp;
	}
	
	public void setNowExp(int nowExp) {
		this.nowExp = nowExp;
	}

	//現在の、Lvアップに必要な経験値；つぎのLvまであと～で表示させるやつ。
	public int getNowNeedExp() {
		return nowNeedExp;
	}

	public void setNowNeedExp(int nowNeedExp) {
		this.nowNeedExp = nowNeedExp;
	}


	public int[] getNeedExp() {
		return needExp;
	}


	public void setNeedExp(int[] needExp) {
		this.needExp = needExp;
	}


	public int getAllNeedExp() {
		return allNeedExp;
	}


	public void setAllNeedExp(int allNeedExp) {
		this.allNeedExp = allNeedExp;
		
	}
	
	//キャラクター紹介
	//setterのほうは、もはやadder
	public StringBuffer getIntroduce() {
		return introduce;
	}
	
	public void addIntroduce() {
		//親密度やクソガキLvが上がると、キャラ紹介がどんどん深堀されていくぞ！
		// \nで改行してから追記したほうが見やすいかも？
		introduce.append("\n");
		
	}
	
	
	
	//後から追加した、now系のgetterやsetter
	
	public int getNowHp() {
		return nowHp;
	}


	public void setNowHp(int nowHp) {
		this.nowHp = nowHp;
	}


	public int getNowPower() {
		return nowPower;
	}


	public void setNowPower(int nowPower) {
		this.nowPower = nowPower;
	}


	public int getNowEndurance() {
		return nowEndurance;
	}


	public void setNowEndurance(int nowEndurance) {
		this.nowEndurance = nowEndurance;
	}


	public int getNowQuickness() {
		return nowQuickness;
	}


	public void setNowQuickness(int nowQuickness) {
		this.nowQuickness = nowQuickness;
	}


	public int getNowKGause() {
		return nowKGause;
	}


	public void setNowKGause(int nowKGause) {
		this.nowKGause = nowKGause;
	}
	
	
	
	//-----------------------------------------------------------------------------------
	
	
	
	
	




	/**
	 * 攻撃を行います
	 * @return 相手に与えるダメージを返します
	 */
	public int attack() {
		return this.power;
	}
	


	/**
	 * ダメージ判定を行います
	 * @param attack 攻撃値
	 * @return	体力が0になったらtrue、まだ体力が残っていたらfalse
	 */
	public boolean damage(int attack) {

		boolean deadFlg = false;

		// ダメージ計算
		int damage = attack - this.endurance;
		if (damage <= 0) {
			// 必ず1ダメージは入るようにする
			damage = 1;
		}

		// ダメージ分体力を減らす
		this.nowHp -= damage;

		// 体力がなくなったかどうかの判定
		if (this.nowHp <= 0) {

			// 体力が負の値になったら0に設定する
			this.nowHp = 0;

			deadFlg = true;
			System.out.println(this.name + "は" + damage + "のダメージを受けた。");
			System.out.println(this.name + "の残り体力は" + this.nowHp + "。");
			System.out.println(this.name + "は" + "ちからつきた。");
		} else {
			System.out.println(this.name + "は" + damage + "のダメージを受けた。");
			System.out.println(this.name + "の残り体力は" + this.nowHp + "。");
		}

		System.out.println("↓");


		return deadFlg;
	}

	/**
	 * キャラクター情報を表示します
	 * @return
	 */
	public String showParameter() {
		StringBuilder str = new StringBuilder();

		str.append("名　前：" + this.name);
		str.append("\n");
		str.append("体　力：" + this.hp);
		str.append("\n");
		str.append("　力　：" + this.power);
		str.append("\n");
		str.append("耐　久：" + this.endurance);

		return str.toString();
	}
}
