import java.io.*;

public class BooksReaderWriter {
    public BooksReaderWriter(String fileName) {
        this.fileName = fileName;
    }

    private final String fileName;

    public Books readFromFile(){
        File fileWithBooks = new File(fileName);
        try (ObjectInputStream booksInputStream = new ObjectInputStream(
                new FileInputStream(fileWithBooks))) {
            return  (Books) booksInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error with reading from file:" + fileName +
                    "\nBooks should be added via keyboard" +
                    "\ncause: " + e);
            return new Books(0);
        }
    }

    public void writeToFile(Books books){
        File fileWithBooks = new File(fileName);
        try (ObjectOutputStream booksOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileWithBooks))) {
            booksOutputStream.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error with writing to file:" + fileName +
                    "\nBooks should be added via keyboard next time" +
                    "\ncause: " + e);

        }
    }
}
