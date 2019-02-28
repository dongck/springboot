import com.dongck.impl.IHello;
import com.dongck.interceptor.MyInterceptor;
import com.dongck.proxy.ProxyBean;
import com.dongck.service.HelloService;

public class TestPorxy {

	public static void main(String[] args) {
		
		IHello helloService = new HelloService();
		
		IHello proxy = (IHello) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		
		proxy.sayHello("dongck");
		
		System.out.println("***************8");

		proxy.sayHello(null);
	}

}
