package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String name;
    private String surnames;
    private String phone;
    private String code;

    //Constructor


    public Contact(String name, String surname, String num) {
        this.name = name;
        this.surnames = surname;
        this.phone = num;
        this.code = generarNombre(name)+generarApellido(surname);
    }

    //Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String generarNombre(String name){



        String normalizado = removeDiacritics(name.toLowerCase());
       return normalizado.substring(0,1);
    }
    private String generarApellido(String surnames) {

        //Se eliminan signos diacriticos y se convierte la cadena a minusculas
        String normalizado = removeDiacritics(surnames.toLowerCase());

        //Se separa el apellido en partes y e almacena en un array
        String partes[] = normalizado.split(" ");

        //Si solo tiene 1 apellido lo retorna
        if (partes.length == 1) {

            return partes[0];

        } else {

            //En caso de que exista mas de un apellido se obtiene la primera letra del primer apellido
            String letra = partes[0].substring(0, 1);

            String resto = String.join("", partes).substring(partes[0].length());

            return letra + resto;
        }

    }

    // Método para eliminar signos diacríticos
    private String removeDiacritics(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }


    @Override
    public void callMyNumber() {
        System.out.println(this.getName());
        System.out.println(this.getSurnames());
        System.out.println(this.getPhone());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println(getName());
        System.out.println(getSurnames());
        System.out.println(number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: "+getName()+"\n" +
                "Apellidos: "+getSurnames()+"\n" +
                "Telefono: "+getPhone()+"\n" +
                "Codigo: "+getCode());

    }
}
