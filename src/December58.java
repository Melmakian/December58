import java.io.*;

public class December58 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.tmp"));
        oos.writeObject(instance);
        oos.close();


        ObjectInputStream  ois = new ObjectInputStream(new FileInputStream("singleton.tmp"));
        Singleton singleton =(Singleton)  ois.readObject();
        ois.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("singleton.tmp"));
        Singleton singleton1=(Singleton) ois2.readObject();
        ois2.close();

        System.out.println("Instance reference check : "+singleton.getInstance());
        System.out.println("Instance reference check : "+singleton1.getInstance());
        System.out.println("================================================");
        System.out.println("Objet reference check : "+singleton);
        System.out.println("Objet reference check : "+singleton1);
    }
    public static class Singleton implements Serializable{
        private static Singleton ourInstance;

        public static Singleton getInstance(){
            if (ourInstance ==null){
                ourInstance = new Singleton();
            }
            return  ourInstance;
        }
        private Object readResolve(){
            return  ourInstance;
        }
    }
}
