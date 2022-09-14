package colgantes1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoColgantes {

    private String path;

    public ArchivoColgantes(String path) {
	this.path = path;
    }

    public int[] cargarColgantes() {
	File fp = null;
	Scanner sc = null;
	int[] r = null;

	try {
	    fp = new File(this.path);
	    sc = new Scanner(fp);
	    r = new int[sc.nextInt()];

	    for(int i = 0; i < r.length; i++) {
		r[i] = sc.nextInt();
	    }

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}

	return r;
    }

    public void grabarColgantes(int pesoTotal, int cantVarillas) {
	FileWriter fw = null;
	PrintWriter pw = null;

	try {
	    fw = new FileWriter(this.path);
	    pw = new PrintWriter(fw);

	    pw.printf("%d %d", pesoTotal, cantVarillas);
	    
	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		pw.close();
		fw.close();
	    } catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
