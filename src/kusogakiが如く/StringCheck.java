package kusogakiが如く;

 
public class StringCheck {

	
	 // 単文投稿を行うプログラムのメインです。
	 
	//戻り値である文字列を格納するStringの定義
	public String inputStr;
	//Yes or No の戻り値、booleanを定義。trueならYes,falseならNoという解釈
	public boolean yOrN; 
	
	
	
	//ただEnterを押してもらうだけのメソッド
	public void pushEnter() {
		inputStr = inputString();
	}
	
	
	
	
	
	
	
	
	
	//userNameをcheckするメソッド
	public String userNameCheck() {
		//下の変数がtrueなら、下のwhile文にて一生「いまなにしてる？」が繰り返される。
		//例えば、空欄でenterを押したときなどにtrueになったうえでcontinue;となる。
		boolean errorFlag = false;
		
		myLabel: while (!errorFlag){
			
			errorFlag = true;//性善説的に考え、いったん人間が正しく入力してくれると想定
			
			System.out.print("【あなたの名前】　：　");
			inputStr = inputString();
			System.out.println();
			if (inputStr.equals("")){
				//未入力：入力させなおす処理、「いまなにしてる？」に戻る
				System.out.println("何も入力されていません。再入力してください。");
				errorFlag = false;
				continue;
			}else{
				//両端のスペースを省く処理
				inputStr = inputStr.strip();
				
				//文字数の確認
				if (inputStr.length() > 10){
				//文字数超過：入力させなおす処理、「いまなにしてる？」に戻る
				System.out.println("名前が長すぎます。再入力してください。");
				errorFlag = false;
				continue;
				}
			}
		}
		//戻り値を出力
		return inputStr;	
	}
	
	
	
	
	//Yes or No をcheckするメソッド
		public Boolean yOrNoCheck() {
			//下の変数がtrueなら、下のwhile文にて一生「いまなにしてる？」が繰り返される。
			//例えば、空欄でenterを押したときなどにtrueになったうえでcontinue;となる。
			boolean errorFlag = false;
			
			myLabel: while (!errorFlag){
				
				errorFlag = true;//性善説的に考え、いったん人間が正しく入力してくれると想定
				
				System.out.print("【Yesなら\u001b[00;33my\u001b[00mを、Noなら\u001b[00;33mn\u001b[00mを入力してください。】　：　");
				inputStr = inputString();
				System.out.println();
				//両端のスペースを省く処理
				inputStr = inputStr.strip();
				if (inputStr.equals("y")){
					//YesS
					yOrN = true;
					
				}else if(inputStr.equals("n")){
					//No
					yOrN = false;
					
				}else {
					//yでもnでもねぇ！やり直し！
					System.out.println("yかnのどちらかで答えてください。再入力してください。");
					errorFlag = false;
					continue;
				}
			}
			//戻り値を出力
			return yOrN;	
		}
		
		
	
	
	
	//待機画面の入力処理を行うメソッド
		public int homeMenuCheck() {
			//下の変数がtrueなら、下のwhile文にて一生「いまなにしてる？」が繰り返される。
			//例えば、空欄でenterを押したときなどにtrueになったうえでcontinue;となる。
			boolean errorFlag = false;
			//戻り値intの定義
			int action = 0;
			
			
			myLabel: while (!errorFlag){
				
				errorFlag = true;//性善説的に考え、いったん人間が正しく入力してくれると想定
				
				System.out.print("【入力】　：　");
				inputStr = inputString();
				if (inputStr.equals("")){
					//未入力：入力させなおす処理、「いまなにしてる？」に戻る
					System.out.println("何も入力されていません。再入力してください。");
					errorFlag = false;
					continue;
				}else if(inputStr.equals("1")){
					action = 1;
				}else if(inputStr.equals("2")){
					action = 2;
				}else if(inputStr.equals("3")){
					action = 3;
				}else if(inputStr.equals("4")){
					action = 4;
				}else {
					//無効な入力：入力させなおす処理
					System.out.println("無効な入力です。再入力してください。");
					errorFlag = false;
					continue;
				}
			}
			//戻り値を出力
			return action;	
		}
	
		
		//ダンジョン内での入力処理を行うメソッド
				public int danjonCheck() {
					//下の変数がtrueなら、下のwhile文にて一生「いまなにしてる？」が繰り返される。
					//例えば、空欄でenterを押したときなどにtrueになったうえでcontinue;となる。
					boolean errorFlag = false;
					//戻り値intの定義
					int action = 0;
					
					
					myLabel: while (!errorFlag){
						
						errorFlag = true;//性善説的に考え、いったん人間が正しく入力してくれると想定
						
						System.out.print("【入力】　：　");
						inputStr = inputString();
						if (inputStr.equals("")){
							//未入力：入力させなおす処理、「いまなにしてる？」に戻る
							System.out.println("何も入力されていません。再入力してください。");
							errorFlag = false;
							continue;
						}else if(inputStr.equals("1")){
							action = 1;
						}else if(inputStr.equals("2")){
							action = 2;
						}else if(inputStr.equals("3")){
							action = 3;
						}else if(inputStr.equals("4")){
							action = 4;
						}else {
							//無効な入力：入力させなおす処理
							System.out.println("無効な入力です。再入力してください。");
							errorFlag = false;
							continue;
						}
					}
					//戻り値を出力
					return action;	
				}	

		
	
	
	

	/**
	 * 単文を入力させるメソッドです。
	 * @return
	 */
	public static String inputString() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String str = scanner.nextLine();
		return str;
	}
}
