import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Hello implements HelloRemote {
    public Hello() {}
    @Override
    public String sayHello() {
        return "Hello world";
    }
}