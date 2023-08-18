package study.javalang.ch09.patterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {

    public static Product createProduct(String name){
        switch(name){
            case "loan": return new Loan();
            case "stock": return new Stock();
            case "bond": return new Bond();
            default: throw new RuntimeException("No Such Product");
        }
    }

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static{
        map.put("loan",Loan::new);
        map.put("stock",Stock::new);
        map.put("bond",Bond::new);
    }
    public static Product createProduct2(String name){
        Supplier<Product> p = map.get(name);
        if(p != null)
            return map.get(name).get();
        throw new RuntimeException("No Such Product");
    }
}
