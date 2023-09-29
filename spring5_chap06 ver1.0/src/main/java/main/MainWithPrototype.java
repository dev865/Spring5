package main;

import config.AppCtxWithPrototype;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring.Client;
import spring.Client2;

import java.io.IOException;

public class MainWithPrototype {

    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);
        // scope : prototype
        Client client = ctx.getBean(Client.class);
        Client clientClone = ctx.getBean(Client.class);
        // scope : singleton
        Client2 client2 = ctx.getBean(Client2.class);
        Client2 client2Clone = ctx.getBean(Client2.class);
        System.out.println("client == clientClone : " + (client == clientClone));
        System.out.println("client2 == client2Clone : " + (client2 == client2Clone));
        ctx.close();
    }

}
