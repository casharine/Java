package jp.co.vsn.training.java.base;

import java.io.File;

/**
 * ディレクトリ（フォルダ）のユーティリティクラスです。
 *
 * @author XXXXXXX
 */
public class DirUtil {

    /**
     * 指定パスのディレクトリを削除します。<br/>
     * ディレクトリの中に存在するファイルまたはディレクトリすべて削除します。<br/>
     * 指定パスがディレクトリでない場合、または存在しないパスの場合、またはnullが指定された場合、例外 java.lang.IllegalArgumentException をスローします。
     *
     * @param dir 削除対象ディレクトリパス
     * @throws IllegalArgumentException 指定パスがディレクトリでない場合、または存在しないパスの場合、またはnullが指定された場合
     */

    public static void remove(File dir) {
    	if (dir == null || !dir.isDirectory()) {
    		throw new IllegalArgumentException ();
    	}
    	// listFiles:フォルダの中に存在しているファイルやフォルダを一覧として取得できるメソッド
    	File[] list =  dir.listFiles();
    	for(File file : list) {
    		if(file.isDirectory()) {
    			remove(file);
    		}else {
    			//delete:メソッドディレクトリ削除、一つずつ削除できないので分割して
    			file.delete();
    			System.out.println("ファイルを削除しました");
    		}
    	}
    	dir.delete();
		System.out.println("フォルダを削除しました");
	}


    /**
     * 動作確認用の実行メソッドです。
     * @param args
     */
    public static void main(String[] args){
		try {
			File file = new File("C:\\Users\\user01\\pleiades\\workspace\\DevJavaTraining\\res\\test");
			remove(file);
		// Throwable：全てのエラーの親クラス
		}catch(Throwable thw) {
			// Throwableのメソッドスタックトレース（実行過程）を出力
			thw.printStackTrace();
    	}
    }
}
