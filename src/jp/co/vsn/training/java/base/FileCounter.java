package jp.co.vsn.training.java.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    //FileRederを用いて行う基本的な手法（一つ下のメソッドでは簡略化）
    public FileCounter(File file) {
    	super();
    	this.file = file;
    	//存在する場合
    	if ( file.exists()) {
	    	load();
    	}
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

    //    perse

    public FileCounter(File file, boolean isAuto) {
    	super();
    	this.isAuto = true;
    	this.file = file;
    	//存在する場合
    	if ( file.exists()) {
	        // try with resource cath,close不要（try(resource1; 2;...) {処理}
	    	try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr))
	    		{String text;
	    		while((text = br.readLine()) != null) {
	    			String objString = text;
	    			super.parse(objString);
	    		}
	    	} catch (IOException e) {
				e.printStackTrace();
	    		throw new IllegalStateException();
	    	}
    	}
	}

    /**
     * 現在のカウント数に変化量分増やします。<br/>
     * ファイル自動保存設定ONのときカウント数を増やした後、すぐにファイル書き込みを行います。<br/>
     * ファイル自動保存設定OFFのときカウント数を増やした後、ファイルに書き込みを行いません。<br/>
     * ファイル書き込みに失敗したとき、例外 java.lang.IllegalStateException をスローします。
     *
     * @return 自分自身のインスタンス
     * @throws IllegalStateException ファイル書き込みに失敗したとき
     */
    @Override
    public Counter inc() {
		super.inc();
    	if (this.isAuto == true) {
    		try (FileWriter fw = new FileWriter(file)){
    			fw.write(super.toString());
	    	} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException();
	    	}
		}
        return this;
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
		super.dec();
    	if (this.isAuto == true) {
    		try (FileWriter fw = new FileWriter(file)){
    			fw.write(super.toString());
	    	} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException();
	    	}
		}
        return this;
    }
    /**
     * 現在のカウント数と変化量をファイルに書き込みを行います。<br/>
     * ファイル書き込みに失敗したとき、例外 java.lang.IllegalStateException をスローします。
     *
     * @throws IllegalStateException ファイル書き込みに失敗したとき
     */
    public void save() {
    	if ( !file.exists()) {
    		throw new IllegalArgumentException();
    	}
   		try (FileWriter fw = new FileWriter(file)){
			fw.write(super.toString());
    	} catch (IOException e) {
    		e.printStackTrace();
			throw new IllegalStateException();

    	} catch (IllegalStateException ise) {
    		ise.printStackTrace();
			throw new IllegalStateException();
    	}
    }

    /**
     * ファイルからカウント数と変化量を読み込み、設定します。<br/>
     * ファイル内容の解析に失敗した場合、例外 java.lang.IllegalStateException をスローします。
     *
     * @throws IllegalStateException ファイル内容の解析に失敗した場合
     */
    public void load() {
    	if ( file.exists()) {
	    	try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr))
    		{String text;
    		while((text = br.readLine()) != null) {
    			String objString = text;
    			super.parse(objString);
    		}
	    	} catch (IOException e) {
				e.printStackTrace();
				throw new IllegalStateException();
	    	}
    	}
    	else {
    		throw new IllegalStateException();
    	}
	}

    /**
     * 出力先または読込先のファイルパスを取得します。
     * @return 出力先または読込先のファイルパス
     */
    public File getFile() {
        return this.file;
    }

    /**
     * 出力先または読込先のファイルパスを設定します。
     * @param file 出力先または読込先のファイルパス
     */
    public void setFile(File file) {
    	this.file = file;
    }

    /**
     * 自動ファイル保存設定の値を取得します。</br>
     * true のとき自動ファイル保存する／false のとき自動ファイル保存しない。
     * @return ファイル自動保存設定
     */
    public boolean isAuto() {
        return this.isAuto;
    }

    /**
     * 自動ファイル保存設定の値を設定します。</br>
     * true のとき自動ファイル保存する／false のとき自動ファイル保存しない。
     * @param isAuto ファイル自動保存設定
     */
    public void setAuto(boolean isAuto) {
    	this.isAuto = isAuto;
    }

    /**
     * 動作確認のための実行メソッドです。
     * @param args
     */
    public static void main(String[] args) {
    	Counter h = new Counter(1,2);
    	String data = new String("sample.txt");
    	Boolean isAuto = new Boolean(true);
    	File file = new File("C:\\Users\\user01\\pleiades\\workspace\\DevJavaTraining\\res");
    }
}
