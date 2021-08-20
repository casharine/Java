package jp.co.vsn.training.java.base;

import java.io.*;

/**
 * カウント数、変化量をファイルに書き込んだり、ファイルから読み込んだりするクラスです。<br/>
 * ファイルに書き込む内容は、Counter クラスのオブジェクトの文字列表現となります。
 *
 * @author XXXXXXX
 */
public class FileCounter extends Counter{

    // カウント数と変化量が記述されたファイルパス
    private File file;
    
    // ファイル自動保存設定（true - 有効、false - 無効）
    private boolean isAuto;

    /**
     * ファイルを指定し、ファイル自動保存設定をOFFにしてオブジェクトを構築します。<br/>
     * すでにファイルが存在する場合は、ファイルを読み込み、読み込んだ内容でカウント数と変化量を設定します。<br/>
     * ファイルが存在しない場合は、カウント数を 0、変化量を 1 に設定します。<br/>
     * ファイル内容の解析に失敗した場合、例外 java.lang.IllegalStateException をスローします。
     *
     * @param file ファイルパス
     * @throws IllegalStateException ファイル内容の解析に失敗した場合
     */
    public FileCounter(File file) {

    }

    /**
     * ファイルを指定し、ファイル自動保存設定を指定してオブジェクトを構築します。<br/>
     * すでにファイルが存在する場合は、ファイルを読み込み、読み込んだ内容でカウント数と変化量を設定します。<br/>
     * ファイルが存在しない場合は、カウント数を 0、変化量を 1 に設定します。<br/>
     * ファイル内容の解析にに失敗した場合、例外 java.lang.IllegalStateException をスローします。
     *
     * @param file ファイルパス
     * @param isAuto true のとき自動保存する、falseのとき自動保存しない
     * @throws IllegalStateException ファイル内容の解析にに失敗した場合
     */
    public FileCounter(File file, boolean isAuto) {

    }

    /**
     * 現在のカウント数に変化量分増やします。<br/>
     * ファイル自動保存設定ONのときカウント数を増やした後、すぐにファイル書き込みを行います。<br/>
     * ファイル自動保存設定OFFでないときカウント数を増やした後、ファイルに書き込みを行いません。<br/>
     * ファイル書き込みに失敗したとき、例外 java.lang.IllegalStateException をスローします。
     *
     * @return 自分自身のインスタンス
     * @throws IllegalStateException ファイル書き込みに失敗したとき
     */
    @Override
    public Counter inc() {
        return null;
    }

    /**
     * 現在のカウント数に変化量分減らします。<br/>
     * ファイル自動保存設定ONのときカウント数を減らした後、すぐにファイル書き込みを行います。<br/>
     * ファイル自動保存設定OFFのときカウント数を減らした後、ファイルに書き込みを行いません。<br/>
     * ファイル書き込みに失敗したとき、例外 java.lang.IllegalStateException をスローします。
     *
     * @return 自分自身のインスタンス
     * @throws IllegalStateException ファイル書き込みに失敗したとき
     */
    @Override
    public Counter dec() {
        return null;
    }

    /**
     * 現在のカウント数と変化量をファイルに書き込みを行います。<br/>
     * ファイル書き込みに失敗したとき、例外 java.lang.IllegalStateException をスローします。
     *
     * @throws IllegalStateException ファイル書き込みに失敗したとき
     */
    public void save() {

    }

    /**
     * ファイルからカウント数と変化量を読み込み、設定します。<br/>
     * ファイル内容の解析に失敗した場合、例外 java.lang.IllegalStateException をスローします。
     *
     * @throws IllegalStateException ファイル内容の解析に失敗した場合
     */
    public void load() {

    }

    /**
     * 出力先または読込先のファイルパスを取得します。
     * @return 出力先または読込先のファイルパス
     */
    public File getFile() {
        return null;
    }

    /**
     * 出力先または読込先のファイルパスを設定します。
     * @param file 出力先または読込先のファイルパス
     */
    public void setFile(File file) {

    }

    /**
     * 自動ファイル保存設定の値を取得します。</br>
     * true のとき自動ファイル保存する／false のとき自動ファイル保存しない。
     * @return ファイル自動保存設定
     */
    public boolean isAuto() {
        return false;
    }

    /**
     * 自動ファイル保存設定の値を設定します。</br>
     * true のとき自動ファイル保存する／false のとき自動ファイル保存しない。
     * @param isAuto ファイル自動保存設定
     */
    public void setAuto(boolean isAuto) {

    }

    /**
     * 動作確認のための実行メソッドです。
     * @param args
     */
    public static void main(String[] args) {

    }
}
