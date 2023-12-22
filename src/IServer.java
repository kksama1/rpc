import java.rmi.Remote;
import java.rmi.RemoteException;


// Интерфейс — это контракт, который должен быть реализован конкретным классом.
// Т.е. Класс реализующий интерфейс обязан реализовывать функции объявленные в интерфейсе.
public interface IServer extends Remote {
    public void m(int len, int num1, int num2) throws RemoteException;
}
