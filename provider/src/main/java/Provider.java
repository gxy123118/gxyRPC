import com.gxy.protocol.HttpServer;
import com.gxy.register.LocalRegister;
import impl.HelloServiceImpl;
import service.HelloService;

public class Provider {


    public static void main(String[] args) {
        LocalRegister.register(HelloService.class, HelloServiceImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8181);
    }
}
