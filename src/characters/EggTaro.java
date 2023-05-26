package characters;

//きちんと親クラスを継承
public class EggTaro extends kusogakiが如く.Character{
	//たまご太郎のコンストラクタを設定したい。
	//その際、親クラスであるCharacterクラスのコンストラクタも呼び出されるが、
	//Characterのコンストラクタが引数あり&デフォルトコンストラクタがないので、
	//1行目でしっかりと引数ありのsuperを書く必要がある。
	

	
	//コンストラクタ
	public EggTaro(){
		super(1,10,3,1,3);
		setName("\u001b[00;36m" + "たまご太郎" + "\u001b[00m");
		introduce.append("どこにでもいる普通の人。黄身と白身なら白身のほうが好き。");
		
	}
	
	
	

}
