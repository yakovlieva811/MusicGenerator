import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        Model m = new Model();
        View v = new View();
        DataBase d= new DataBase();
        Controller c = new Controller(m, v,d);
        c.initController();
        d.getAllSongs(); // бд всей музыки


        }
}
