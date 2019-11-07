package br.com.unip.BiometricAPS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String username = "admin";
		String password = "admin";
		String mydatabase = "bancoAPS";
		String url = "jdbc:sqlserver://localhost:1433;databaseName="+mydatabase+";user="+username+";password="+password+";";
		
		System.out.println(url);
    }
}
