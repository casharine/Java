package jp.co.vsn.training.java.base;

import java.io.File;
import java.nio.file.Files;
import  java.util.*;

/**
 * ディレクトリ（フォルダ）のユーティリティクラスです。
 *
 * @author XXXXXXX
 */
public class tempo {

    /**
     * 指定パスのディレクトリを削除します。<br/>
     * ディレクトリの中に存在するファイルまたはディレクトリすべて削除します。<br/>
     * 指定パスがディレクトリでない場合、または存在しないパスの場合、またはnullが指定された場合、例外 java.lang.IllegalArgumentException をスローします。
     *
     * @param dir 削除対象ディレクトリパス
     * @throws IllegalArgumentException 指定パスがディレクトリでない場合、または存在しないパスの場合、またはnullが指定された場合
     */
	
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


		public static void remove (String dir) throws Exception {
			File file = new File(dir);
			recursiveRemove(file);
		}

	    /**
	     * 対象ファイルオブジェクトを削除します。<br/>
	     * 絵費r区と理の場合は再帰しょりを行いう削除します。
	     *
	     * @param file fileオブジェクト
	     * @throws IllegalArgumentException 指定パスがディレクトリでない場合、または存在しないパスの場合、またはnullが指定された場合
	     */
		public static void recursiveRemove(File file) throws Exception {
			//存在しない場合処理を終了
			if(!file.isDirectory()) {
				return;
			}
			// 存在する場合は再帰処理する
			if (file.isDirectory()) {
				for (File child : file.listFiles()) {
					recursiveRemove(child);
				}
			}
			//対象ファイルもしくは配下がからのディレクトリの場合は削除する
			file.delete();
		}


	    /**
	     * 動作確認用の実行メソッドです。
	     * @param args
	     */
	    public static void main(String[] args){
	    }
	}

	
}
	
	//不要
