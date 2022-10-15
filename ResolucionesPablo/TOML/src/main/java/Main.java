import java.io.File;

import org.tomlj.Toml;
import org.tomlj.TomlArray;
import org.tomlj.TomlParseResult;
import org.tomlj.TomlTable;

public class Main {

    public static void main(String[] args) {

	try {
	    File fp = new File("src/main/resources/nivel0.toml");
	    TomlParseResult tpr = Toml.parse(fp.toPath());

	    TomlTable terrenos = tpr.getTable("terrenos");

	    for(String terreno : terrenos.keySet()) {
		System.out.println(terreno);
		TomlArray datosTerrenos = terrenos.getArray(terreno);
		for(int i = 0; i < datosTerrenos.size(); i++) {
		    TomlArray datosTerreno = datosTerrenos.getArray(i);
		    System.out.println(datosTerreno.get(0));
		}
	    }



	} catch(Exception e) {
	    e.printStackTrace();
	}

    }

}
