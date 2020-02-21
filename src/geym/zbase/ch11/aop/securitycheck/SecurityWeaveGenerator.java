package geym.zbase.ch11.aop.securitycheck;

import java.io.File;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class SecurityWeaveGenerator{ 
	 public static void main(String args[]) throws Exception { 
	     String className=Account.class.getName();
		 ClassReader cr = new ClassReader(className); 
		 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES); 
		 AddSecurityCheckClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw); 
		 cr.accept(classAdapter, ClassReader.SKIP_DEBUG); 
		 byte[] data = cw.toByteArray(); 
		 File file = new File("bin/"+className.replaceAll("\\.", "/")+".class"); 
		 FileOutputStream fout = new FileOutputStream(file); 
		 fout.write(data); 
		 fout.close(); 
	 } 
}