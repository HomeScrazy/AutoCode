package ren.zhaoruncheng.file.methods;

import java.io.File;

import ren.zhaoruncheng.read.ReadFile;
import ren.zhaoruncheng.write.WriteFile;

public class TextFileController implements FileCopyInterface{

	public void copyFiles(File copyFile, File pasteFile) {
		// TODO Auto-generated method stub
		ReadFile reader=new ReadFile(copyFile);
		WriteFile writer=new WriteFile(pasteFile);
		writer.Write(reader.getString());
	}
}
