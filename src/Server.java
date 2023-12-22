import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject
        implements IServer {
    private static final long serialVersionUID = 1L;

    protected Server() throws RemoteException {	}

    public void m(int len, int num1, int num2) throws RemoteException {
        int[] arr = new int[len];
        arr[0] = num1;
        arr[1] = num2;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 0; i < arr.length; ++i) {
            System.out.println((i+1) + " = " + arr[i]);
        }

        //System.out.println("Hey dude!");
    }

    public static void main(String[] args) throws RemoteException {
        System.out.println("Server started...");
        Server s = new Server();
        Registry re = LocateRegistry.createRegistry(9001);
        re.rebind("server", s);

    }



}
