public class icecream {
    enum flavour{chocolatey, mint, candy}


    public static void main(String[] args) {
        flavour cone1, cone2;
        cone1=flavour.chocolatey;
        System.out.println("cone1 value: "+cone1);
        System.out.println("cone 1 pos"+ cone1.ordinal());
        System.out.println("cone 1 name" + cone1.name());
}}
