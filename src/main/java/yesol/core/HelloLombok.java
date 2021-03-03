package yesol.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class HelloLombok {

    private String name;
    private  int ahe;

    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hey");

        String name = helloLombok.getName();
        System.out.println("helloLombok = " + helloLombok);
    }
}
