package models;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileWorker {
	
	public Employee readFile(String fileName) throws Exception {
		
		Employee employee = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream inputStream = null;
		
		try {
			fileInputStream = new FileInputStream(new File(fileName));
			inputStream = new ObjectInputStream(fileInputStream);
			
			// Read objects
			employee = (Employee) inputStream.readObject();

			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			} catch (IOException e) {
				System.out.println("Error initializing stream!");
			} catch (ClassNotFoundException e) {
				System.out.println("Class Employee is not found!");
			} finally {
				//Close streams
				inputStream.close();
				fileInputStream.close();
			}
		
		return employee;
		
	}
	
	public void writeFile(Employee employee , String fileName) throws Exception {
		
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream outputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(new File(fileName));
			outputStream = new ObjectOutputStream(fileOutputStream);

			// Write objects to file
			outputStream.writeObject(employee);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} finally {
			//Close streams
			outputStream.close();
			fileOutputStream.close();
		}
	}
}
