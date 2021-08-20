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

    }

    /**
     * 動作確認用の実行メソッドです。
     * @param args
     */
    public static void main(String[] args) {
    }
}
