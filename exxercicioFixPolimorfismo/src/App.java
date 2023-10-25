import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;


public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
        List<Product> list = new ArrayList<Product>();

        System.out.print("Informe a quantidade de produtos: ");
        int n = sc.nextInt();
        for(int i = 0; i<n;i++){
            System.out.print("Comum, usado ou importado (c,u,i?");
            char op = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if(op == 'i'){
                System.out.print("Custons fee: ");
                double custons = sc.nextDouble();
                list.add(new ImportedProduct(name, price, custons));
            }else if(op=='u'){
                System.out.print("Manufacture date(DD/MM/YYYY):");
                Date dateManufacture = sdf.parse(sc.next());
                 list.add(new UsedProduct(name, price, dateManufacture));
            }else{
                list.add(new Product(name, price));
            }
        }
        for (Product product : list) {
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
