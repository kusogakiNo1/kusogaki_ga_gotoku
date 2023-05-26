package kusogakiが如く;

import java.util.*;
import characters.*;


public class Main {
	public static void main(String[] args) {
		//--------------------------------メソッドの利用にかかわるインスタンス------------------------------------------
		//文字の入力
		Scanner scan = new Scanner(System.in);
		//文字入力の判定
		StringCheck stringCheck = new StringCheck();
		//ウェイトの設置
		Wait wait = new Wait();
		//乱数の利用
		Random random = new Random();
				
		//----------------------------------Gameデータにかかわるインスタンス------------------------------------------
		//Userの情報を格納するインスタンス
		UserInformation userInformation = new UserInformation();
		
		
		//-----------------------------------よく使う変数の定義---------------------------------------------------
		//所持しているキャラの情報を格納するArrayList
		ArrayList<Character> whoIHave = new ArrayList<>();
		//使用中のキャラの情報を格納するCharacter型変数
		Character nowUsingChar;
		
		
		
		
		
		
		System.out.println("ゲームマスター(以下:GM)　：　初めまして！このゲームを手にとってくれてありがとう！");
		//文字表示の感覚調整。
		wait.jikan(3000);
		System.out.println("GM　：　ところで、君の名前はなんていうのかな？");
		//userName入力フェーズ。間違って入力してしまった場合はループ。
		boolean firstUserNameInput = true;
		while(firstUserNameInput) {
			firstUserNameInput = false;
			System.out.println("システム　：　あなたの名前を10文字以内で入力してください。\n　　　　　　　入力が完了したら、Enterを押してください。");
			//userName入力処理(仮)
			userInformation.userName = "\u001b[00;32m" + stringCheck.userNameCheck() + "\u001b[00m";
			
			System.out.println("GM　：　なるほど、君の名前は「" + userInformation.userName + "」というのだね？");
			//Yes or No
			boolean yOrN = stringCheck.yOrNoCheck();
			if(!yOrN) {  //No
				System.out.println("GM　：　いや、ちゃうんかい！ホンマの名前教えてくれや、頼むで...。");
				firstUserNameInput = true;
				continue;
			}else {  //Yes
				System.out.println("GM　：　うん、良い名前だね。\n　　　　これからよろしくね、" + userInformation.userName + "!");
				
			}
		}
		//userName入力完了
		//文字表示の感覚調整
		wait.jikan(3000);
		System.out.println("GM　：　さて、と...");
		wait.jikan(2000);
		System.out.println("GM　：　君にはこのキャラクターを授けよう");
		wait.jikan(2000);
		System.out.println("");
		System.out.print("システム　：　あなたは");
		System.out.print("\u001b[00;36m" + "【キャラクター】たまご太郎" + "\u001b[00m");
		System.out.println("を手に入れた！");
		System.out.println("");
		//たまご太郎をgetしたので、たまご太郎のインスタンスを作成し、所持キャラリストにぶちこむ
		EggTaro eggTaro = new EggTaro();
		whoIHave.add(eggTaro);
		nowUsingChar = (Character) eggTaro;
		wait.jikan(4000);
		System.out.println("GM　：　これから、君には" + eggTaro.getName() + "と一緒に近所のダンジョンに挑んでもらいたい。");
		wait.jikan(3000);
		System.out.println("GM　：　大丈夫。雑魚敵しかいないから、きっと" + userInformation.userName + "でもうまくやれると思いますよ！");
		wait.jikan(2000);
		System.out.println("GM　：　それでは、ご健闘を祈っております...。");
		wait.jikan(2000);
		System.out.println("システム　：　そう言うと、その男は一目散に去ってしまった。");
		wait.jikan(3000);
		System.out.println(userInformation.userName + "　：　まぁ、とりあえず自分なりに頑張ってみるか...。");
		System.out.println("");
		wait.jikan(3000);
		System.out.println("システム　：　【注意】造るのがめんどくさかったので、チュートリアルとかはないです。体で覚えてください。");
		wait.jikan(3000);
		
		Label :while(true) {
			//待機画面の描写
			System.out.println("");
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("ユーザー名 ： " + userInformation.userName + "     称号 ： " + userInformation.achievement + "     所持金 : \u001b[00;33m" + userInformation.money + "\u001b[00m円");
			System.out.println("使用中キャラ : " + nowUsingChar.getName());
			System.out.println("Lv : " + "\u001b[00;33m" + nowUsingChar.getLv() + "\u001b[00m" + "       つぎのLvまでの必要経験値 : \u001b[00;33m" + nowUsingChar.getNowNeedExp() + "\u001b[00m");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("システム　：　ここは待機画面です。何かアクションを起こしたい場合は、以下の指示に従って入力してください。隠しコマンドがあるかも？");
			System.out.print("【キャラのステータスを見る→");
			System.out.print("\u001b[00;33m" + "1" + "\u001b[00m");
			System.out.println("を入力してEnter】");
			System.out.print("【お金を払ってHPを回復→");
			System.out.print("\u001b[00;33m" + "2" + "\u001b[00m");
			System.out.println("を入力してEnter】");
			System.out.print("【近所のダンジョンに向かう→");
			System.out.print("\u001b[00;33m" + "3" + "\u001b[00m");
			System.out.println("を入力してEnter】");
			System.out.print("【ゲームをやめる(仕様的にデータリセットとなります)→");
			System.out.print("\u001b[00;33m" + "4" + "\u001b[00m");
			System.out.println("を入力してEnter】");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			int homeMenuChoice = stringCheck.homeMenuCheck();
			//入力内容で条件分岐
			if(homeMenuChoice == 1) {
				System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("<使用中キャラのステータス>");
				System.out.println("名前　:　" + "\u001b[00;33m" + nowUsingChar.getName() + "\u001b[00m");
				System.out.println("Lv　:　" + "\u001b[00;33m" + nowUsingChar.getLv() + "\u001b[00m");
				System.out.println("HP　:　" + "\u001b[00;33m" + nowUsingChar.getHp() + "\u001b[00m");
				System.out.println("攻撃力　:　" + "\u001b[00;33m" + nowUsingChar.getPower() + "\u001b[00m");
				System.out.println("防御力　:　" + "\u001b[00;33m" + nowUsingChar.getEndurance() + "\u001b[00m");
				System.out.println("素早さ　:　" +"\u001b[00;33m" + nowUsingChar.getQuickness() + "\u001b[00m");
				System.out.println("次のレベルまであと　:　" + "\u001b[00;33m" + nowUsingChar.getNowNeedExp() + "\u001b[00m");
				System.out.println("＜キャラの詳細＞");
				System.out.println(nowUsingChar.introduce);
				System.out.println("");
				System.out.println("");
				System.out.println("【ホームに戻りたい場合はEnterを入力】");
				System.out.println("--------------------------------------------------------------------------------------------------------");
				stringCheck.pushEnter();
				System.out.println("");
				continue Label;
				
			}else if(homeMenuChoice == 2) {
				System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("coming soon");
				System.out.println("【ホームに戻りたい場合はEnterを入力】");
				System.out.println("--------------------------------------------------------------------------------------------------------");
				stringCheck.pushEnter();
				System.out.println("");
				continue Label;	
			}else if(homeMenuChoice == 4) {
				System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("coming soon");
				System.out.println("【ホームに戻りたい場合はEnterを入力】");
				System.out.println("--------------------------------------------------------------------------------------------------------");
				stringCheck.pushEnter();
				System.out.println("");
				continue Label;
			}else if(homeMenuChoice == 3) {
				System.out.println("");
				System.out.println("");
				System.out.println("システム　：　\u001b[00;31m近所のダンジョン\u001b[00mへ行きますか？");
				//Yes or No
				boolean yOrN = stringCheck.yOrNoCheck();
				System.out.println("");
				if(!yOrN) {  //No
					System.out.println("システム　：　ビビってますね。お疲れ様です。");
					System.out.println("");
					wait.jikan(2000);
					continue Label;
				}else {  //Yes
					System.out.println(userInformation.userName + "　：　あまり気は進まないが、いってみるしかなさそうだな...");
					System.out.println("");
					System.out.println("");
					wait.jikan(4000);
					//ダンジョン内へ...
					
					
					
					
					
					
					
					
					
					
					
					//ダンジョン探索が始まる...。
					System.out.println("--------------------------------------------------------------------------------------------------------");
					System.out.println("ダンジョン名　：　\u001b[00;31m近所のダンジョン\u001b[00m");
					System.out.println("大きさ　：　\u001b[00;33m5\u001b[00m");
					System.out.println("難易度　：　\u001b[00;33m★☆☆☆☆\u001b[00m");
					System.out.println("--------------------------------------------------------------------------------------------------------");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					//ウェイトの設置
					wait.jikan(3000);
					//到達度合いを格納する変数
					int position = 0;
					//お金を拾えるチャンス
					int getMoneyChance = 0;
					//マップでのイベントを決める変数
					
					
					//到達度合いごとにマップの図を表示
					//ダンジョンをクリアするまで、探索をループ
					Label2 :while(true) {
						
						
						
						if(position == 0) {
							//まだスタート地点(1マス目)に滞在
							System.out.println("------\u001b[00;31m近所のダンジョン\u001b[00m--------------------------------------------------------------------------");
							System.out.println("　　　　　　　　　　　　　　　　探索者　:　" + "\u001b[00;36m" + nowUsingChar.getName() + "\u001b[00m　　　　　Lv　：　\u001b[00;33m" + nowUsingChar.getLv() + "\u001b[00m     HP　：　\u001b[00;33m" + nowUsingChar.getNowHp() + "\u001b[00m  / \u001b[00;33m" + nowUsingChar.getHp() + "\u001b[00m" + "     所持金 : \u001b[00;33m" + userInformation.money + "\u001b[00m円");
							System.out.println("");
							System.out.println("");
							System.out.println("　　　　　今ここ");
							System.out.println("        ○\r\n"
									+ "　　　　　／|＼\r\n"
									+ "　　　  　 ｜\r\n"
									+ "　　　　　／ ＼\r\n");
							System.out.println("    　　　□-----------□-----------□-----------□-----------□-----------□");
							System.out.println("　　　　　START                                                       GOAL");
							System.out.println("");
							System.out.println("");
							System.out.println("--------------------------------------------------------------------------------------------");
							System.out.println("システム　：　アクションを選択してください。");
							System.out.print("【その場で足踏みする】　→　");
							System.out.print("\u001b[00;33m" + "1" + "\u001b[00m");
							System.out.println("を入力してEnter");
							System.out.print("【一歩前進する】　→　");
							System.out.print("\u001b[00;33m" + "2" + "\u001b[00m");
							System.out.println("を入力してEnter");
							System.out.print("【Itemを使う】　→　");
							System.out.print("\u001b[00;33m" + "3" + "\u001b[00m");
							System.out.println("を入力してEnter");
							System.out.print("【ダンジョンから脱出する】　→　");
							System.out.print("\u001b[00;33m" + "4" + "\u001b[00m");
							System.out.println("を入力してEnter");
							//入力処理
int danjonChoice = stringCheck.homeMenuCheck();
							
							
							//選んだ選択肢ごとに分岐
							if (danjonChoice == 1) {
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println(nowUsingChar.getName() + "が起こした行動　：　その場で足踏みする");
								wait.jikan(3000);
								//乱数の設置
								int ransu = random.nextInt(100);
								//乱数ごとに起こるイベントが変化
								if(ransu >= 90 && getMoneyChance <3) {
									//お金を3回以上拾っていなければ、お金を拾うイベントが発生
									System.out.println("システム　：　おや、何かが落ちているようだ...");
									wait.jikan(3000);
									System.out.println("システム　：　\u001b[00;35m30円\u001b[00mを手に入れた!");
									System.out.println("");
									System.out.println("");
									System.out.println("");
									userInformation.money += 30;
									wait.jikan(3000);
									//お金を拾うイベント終了
									continue Label2;
								}else if (ransu >=31) {
									
									
									//敵とのバトルイベントが発生
									// 
									System.out.println("システム　：　あ！野生のスライムが現れた！");
									wait.jikan(3000);
									slime slime = new slime();
									//バトループ
									while(true) {
										int turnNumber = 1;
										System.out.println("");
										System.out.println("");
										System.out.println("------ ターン " + turnNumber +" -------------------------------------------------------------------------------------");
										System.out.println("\u001b[00;36m" + nowUsingChar.getName() + "\u001b[00m　　　　　Lv　：　\u001b[00;33m" + nowUsingChar.getLv() + "\u001b[00m　　　　　HP　：　\u001b[00;33m" + nowUsingChar.getNowHp() + "\u001b[00m  / \u001b[00;33m" + nowUsingChar.getHp() + "\u001b[00m");
										System.out.println("");
										System.out.println("スライム　　　　　　　Lv　：　\u001b[00;33m" + slime.getLv() + "\u001b[00m　　　　　HP　：　\u001b[00;33m" + slime.getNowHp() + "\u001b[00m  / \u001b[00;33m" + slime.getHp() + "\u001b[00m");
										System.out.println("---------------------------------------------------------------------------------------------------");
										System.out.println("");
										
										//探検者の攻撃
										int myAttack = eggTaro.attack();
										System.out.println(nowUsingChar.getName() +"の攻撃！");
										//slimeがダメージをくらう＆判定
										boolean slimeDead = slime.damage(myAttack);
										//slimeが力尽きていたら戦闘終了
										if (slimeDead) {
											System.out.println(nowUsingChar.getName() + "は、スライムとの戦闘に勝利した！");
											//経験値獲得の処理
											int newExp;
											newExp = (int) Math.pow(1.4, nowUsingChar.getLv() - 1 );
											newExp *= 10;
											newExp /= 5;
											System.out.println(nowUsingChar.getName() + "は、" + newExp + "の経験値を得た！！");
											int nowExp = nowUsingChar.getNowExp() + newExp;
											//レベルアップの条件分岐
											if (nowExp >= nowUsingChar.getAllNeedExp()) {
												//レベルアップに必要な経験値以上になってしまった！
												//現在レベル＋１の値を、nowUsingCharのLvにset！！！
												int lv = nowUsingChar.getLv() + 1;
												nowUsingChar.setLv(lv);
												System.out.println(nowUsingChar.getName() + "はLv" + nowUsingChar.getLv() + "になった！！");
												
												//Lvupに伴った、いろいろな値のアップグレード
												/** HP */
												int hp = (int) (nowUsingChar.getHp() * 1.1);
												nowUsingChar.setHp(hp);  //nowHpは増やさない
												
												/** 攻撃力 */
												int power = nowUsingChar.getPower() + 1;
												nowUsingChar.setPower(power);

												/** 防御力 */
												int endurance = nowUsingChar.getEndurance() ;
												//
												int ransu2 = random.nextInt(2);
												//防御力をアップさせるかどうか決める変数
												if(ransu2 == 0) {
													endurance += 1;
												}else {	
												}
												nowUsingChar.setEndurance(endurance);
												
												/** 素早さ */
												int quickness = nowUsingChar.getQuickness();
												int ransu3 = random.nextInt(2);
												if(ransu2 == 0) {
													quickness += 1;
												}else {	
												}
												nowUsingChar.setQuickness(quickness);
												
												
												//↓の一時的な値は、たとえば攻撃されてHPが減ったりした時などに代入する所。
												/** 一時的なHP */
												
												//↓明日は下の部分からやリンス！
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
												
												
											}
											
											
											
											break;
										}
										
										//slimeの攻撃
										int slimeAttack = slime.attack();
										System.out.println("スライムの攻撃！");
										//slimeがダメージをくらう＆判定
										boolean myDead = nowUsingChar.damage(slimeAttack);
										//勇者が力尽きていたら戦闘終了
										if (myDead) {
											System.out.println("スライムは、勇者との戦闘に勝利した！");
											break;
										}
										
										//この行に来ている時点で、break;は発生していない。
										//つまり、まだ勇者もスライムも力尽きていない。
										//どちらも力尽きていないので、このまま試合継続
										turnNumber += 1;
									}
									
									
									
									
									
									
									
									
									
									
									
								}else {
									//イベント特に起こらず
									System.out.println("システム　：　特に何も発生しなかったようだ...");
									System.out.println("");
									System.out.println("");
									System.out.println("");
									wait.jikan(3000);
									continue Label2;
									
								}
								
							}else if(danjonChoice == 2) {
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println(nowUsingChar.getName() + "が起こした行動　：　一歩前進する");
								//一歩進んだので、positionを+1する
								position += 1;
								wait.jikan(3000);
								//乱数の設置
								int ransu = random.nextInt(100);
								//乱数ごとに起こるイベントが変化
								if(ransu >= 95 && getMoneyChance <3) {
									//お金を3回以上拾っていなければ、お金を拾うイベントが発生
									System.out.println("システム　：　おや、何かが落ちているようだ...");
									wait.jikan(3000);
									System.out.println("システム　：　\u001b[00;35m30円\u001b[00mを手に入れた!");
									System.out.println("");
									System.out.println("");
									System.out.println("");
									userInformation.money += 30;
									wait.jikan(3000);
									//お金を拾うイベント終了
									continue Label2;
								}else if (ransu >=60) {
									//敵とのバトルイベントが発生
									System.out.println("システム　：　あ！野生のスライムが現れた！");
									wait.jikan(3000);
								}else {
									//イベント特に起こらず
									System.out.println("システム　：　特に何も発生しなかったようだ...");
									System.out.println("");
									System.out.println("");
									System.out.println("");
									wait.jikan(3000);
									continue Label2;
									
								}
								
							}else if(danjonChoice == 3) {
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println(nowUsingChar.getName() + "が起こした行動　：　Itemを使う");
								System.out.println("coming soon");
								wait.jikan(2000);
								continue Label2;
							}else if(danjonChoice == 4) {
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println(nowUsingChar.getName() + "が起こした行動　：　ダンジョンから脱出する");
								System.out.println("coming soon");
								wait.jikan(2000);
								continue Label2;
							}
							
						}else if(position == 1) {
							
							
						}
						
						
						
						
					}
					
					
				}
			
			}else {
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	//ダンジョンバトル
	public static void GoIntoDanjon() {
		
		
		
		
		
	}

	
	
	
	
}
