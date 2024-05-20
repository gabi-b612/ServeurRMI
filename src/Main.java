import services.ChatServices;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);

        ChatServices skeleton = new ChatServices();
        Naming.rebind("rmi://localhost:1099/login",skeleton);
        System.out.println("Server running");
    }
}